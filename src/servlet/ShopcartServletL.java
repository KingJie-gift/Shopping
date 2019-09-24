package servlet;

import entity.Abapt;
import entity.Commodity_info;
import entity.Enter;
import entity.Shopcart;
import service.ShopcartServiceL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ShopcartServlet")
public class ShopcartServletL extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        String op = request.getParameter("op");
        if("addshop".equals(op)){
            System.out.println("anroid");
            Shopcart shopcart = new Shopcart();
            shopcart.setShopcart_num(Integer.parseInt(request.getParameter("num")));
            Abapt abapt = new Abapt();
            abapt.setAbapt_id(Integer.parseInt(request.getParameter("type")));
            shopcart.setAbapt(abapt);
            Enter enter = new Enter();
            enter.setEnter_id(((Enter)(request.getSession().getAttribute("e"))).getEnter_id());
            shopcart.setEnter(enter);
            Commodity_info commodity_info = new Commodity_info();
            commodity_info.setCommodity_info_id(Integer.parseInt(request.getParameter("shoid")));
            shopcart.setCommodity(commodity_info);
            int ret = new ShopcartServiceL().addShopcart(shopcart);
            System.out.println(ret);
        }else if("show".equals(op)){
            List<Shopcart> shopcarts = new ShopcartServiceL().getShopcart(((Enter)(request.getSession().getAttribute("e"))).getEnter_id());
            request.setAttribute("shop",shopcarts);
            request.getRequestDispatcher("shopcart.jsp").forward(request,response);
        }else if("del".equals(op)){
            int ret = new ShopcartServiceL().delShopcart(Integer.parseInt(request.getParameter("sid")));
            System.out.println(ret+"--------");
            if(ret>0){
                response.sendRedirect("ShopcartServlet?op=show");
            }
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
