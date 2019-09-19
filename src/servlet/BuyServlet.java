package servlet;

import entity.*;
import service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ByServlet")
public class BuyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        String op = request.getParameter("op");
        if("byShow".equals(op)){
            if(((Enter)(request.getSession().getAttribute("e")))!=null){
                int id = ((Enter)(request.getSession().getAttribute("e"))).getEnter_id();
                List<Address> addresses = new AddressService().getListAddress(id);
                request.getSession().setAttribute("address",addresses);
            }else{
                out.print("1");
            }
            String sid = request.getParameter("sid");
            String type = request.getParameter("type");
            String num = request.getParameter("num");
            Commodity_info comm = new Commodity_infoService().commById(Integer.parseInt(sid));
            Abapt ab = new AbaptService().getAbapt(Integer.parseInt(type));

//            加载地址
            request.getSession().setAttribute("comm",comm);
            request.getSession().setAttribute("ab",ab);
            request.getSession().setAttribute("num",num);
        }else if("add".equals(op)){
            String comm_id = request.getParameter("comm");
            String address = request.getParameter("address");
            String sum = request.getParameter("commSum");
            String money = request.getParameter("commMoney");
            String type = request.getParameter("type");
            System.out.println(type);
            Buy buy = new Buy();
            Address address1 = new Address();
            address1.setAddress_id(Integer.parseInt(address));
            buy.setAddress(address1);
            Commodity_info commodity = new Commodity_infoService().commById(Integer.parseInt(comm_id));
            buy.setBug_money(commodity.getCommodity_info_money());
            Enter enter = new Enter();
            enter.setEnter_id(((Enter)(request.getSession().getAttribute("e"))).getEnter_id());
            buy.setEnter(enter);
            int ret = new BuyService().addByComm(buy);
            if(ret>0){
                int row = new BuyService().selByShow();
                Buyshow buyshow =  new Buyshow();
                buyshow.setCommodity(commodity);
                Buy buy1 = new Buy();
                buy1.setBuy_id(row);
                buyshow.setBuy(buy1);
                buyshow.setBuyshow_count(Integer.parseInt(sum));
                buyshow.setBuyshow_price(Double.parseDouble(money));
                Abapt a = new Abapt();
                a.setAbapt_id(Integer.parseInt(type));
                buyshow.setAbapt_id(a);
                ret = new ByShowService().byShow(buyshow);
                if(ret>0){
                    request.getSession().removeAttribute("comm");
                    response.sendRedirect("index.jsp");
                }
            }
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
