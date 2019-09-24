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
public class BuyServletw extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        String op = request.getParameter("op");
        if("byShow".equals(op)) {
            if (((Enter) (request.getSession().getAttribute("e"))) == null) {
                out.print("1");
                return;
            }
            String page = request.getParameter("page");
            if ("details".equals(page)) {
                String sid = request.getParameter("sid");
                String type = request.getParameter("type");
                String num = request.getParameter("num");
                Commodity_info comm = new Commodity_infoServicew().commById(Integer.parseInt(sid));
                Abapt ab = new AbaptServicew().getAbapt(Integer.parseInt(type));
//            加载地址
                request.getSession().setAttribute("comm",comm);
                request.getSession().setAttribute("ab",ab);
                request.getSession().setAttribute("num",num);
            }
            int id = ((Enter)(request.getSession().getAttribute("e"))).getEnter_id();
            List<Address> addresses = new AddressServicew().getListAddress(id);
            request.getSession().setAttribute("address",addresses);

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
            Commodity_info commodity = new Commodity_infoServicew().commById(Integer.parseInt(comm_id));
            buy.setBug_money(Double.parseDouble(money));
            Enter enter = new Enter();
            enter.setEnter_id(((Enter)(request.getSession().getAttribute("e"))).getEnter_id());
            buy.setEnter(enter);
            int ret = new BuyServicew().addByComm(buy);
            if(ret>0){
                int row = new BuyServicew().selByShow();
                Buyshow buyshow =  new Buyshow();
                buyshow.setCommodity(commodity);
                Buy buy1 = new Buy();
                buy1.setBuy_id(row);
                buyshow.setBuy(buy1);
                buyshow.setBuyshow_count(Integer.parseInt(sum));
                buyshow.setBuyshow_price(commodity.getCommodity_info_money());
                buyshow.setSum_money(Double.parseDouble(money));
                Abapt a = new Abapt();
                a.setAbapt_id(Integer.parseInt(type));
                buyshow.setAbapt_id(a);
                ret = new ByShowServicew().byShow(buyshow);
                if(ret>0){
                    new Commodity_infoServicew().rowById(commodity.getCommodity_info_id());
                    request.getSession().removeAttribute("comm");
                    response.sendRedirect("index.jsp");
                }
            }
        }else if("shopc".equals(op)){
            String[] sel = request.getParameterValues("select-all");

//            String [] id = request.getParameterValues("id");
//            购买的数量

//            获取总价格
            String money = request.getParameter("commMoney");


            String[] num = request.getParameterValues("num");

            String address = request.getParameter("address");



            Buy buy = new Buy();
            Address address1 = new Address();
            address1.setAddress_id(Integer.parseInt(address));
            buy.setAddress(address1);
//            Commodity_info commodity = new Commodity_infoService().commById(Integer.parseInt(comm_id));
            buy.setBug_money(Double.parseDouble(money));
            Enter enter = new Enter();
            enter.setEnter_id(((Enter)(request.getSession().getAttribute("e"))).getEnter_id());
            buy.setEnter(enter);
            int ret = new BuyServicew().addByComm(buy);
            System.out.println(ret);

            for(int i = 0 ; i< sel.length ; i ++ ){
                int row = new BuyServicew().selByShow();
                Shopcart shopcart = new ShopcartServicew().shById(Integer.parseInt(sel[i]));
                int comm_id = shopcart.getCommodity().getCommodity_info_id();
                System.out.println(num[i]);
                double price = shopcart.getCommodity().getCommodity_info_money();
                double priceSum = price*Integer.parseInt(num[i]);
                Buyshow buyshow = new Buyshow();
                buyshow.setAbapt_id(shopcart.getAbapt());
                buyshow.setSum_money(priceSum);
                Buy buy1 = new Buy();
                buy1.setBuy_id(row);
                buyshow.setBuy(buy1);
                buyshow.setBuyshow_count(Integer.parseInt(num[i]));
                buyshow.setBuyshow_price(price);
                buyshow.setCommodity(shopcart.getCommodity());
                ret = new ByShowServicew().byShow(buyshow);
                System.out.println(ret+"受影响的的行数");
                ret = new ShopcartServicew().delShopcart(Integer.parseInt(sel[i]));
                System.out.println(ret+"受影响的的行数");
                new Commodity_infoServicew().rowById(shopcart.getCommodity().getCommodity_info_id());
            }
            request.getSession().removeAttribute("comm");
            response.sendRedirect("index.jsp");


        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
