package servlet;

import entity.Abapt;
import entity.Commodity_info;
import entity.Enter;
import entity.Shopcart;
import service.ShopcartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ShopcartServlet")
public class ShopcartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        String op = request.getParameter("op");
        if("addshop".equals(op)){
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
            int ret = new ShopcartService().addShopcart(shopcart);
            System.out.println(ret+"添加的收藏的行数");
        }else if("show".equals(op)){
            List<Shopcart> shopcarts = new ShopcartService().getShopcart(((Enter)(request.getSession().getAttribute("e"))).getEnter_id());
            request.setAttribute("shop",shopcarts);
            request.getRequestDispatcher("shopcart.jsp").forward(request,response);
        }else if("del".equals(op)){
            int ret = new ShopcartService().delShopcart(Integer.parseInt(request.getParameter("sid")));
            System.out.println(ret+"删除收藏");
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
