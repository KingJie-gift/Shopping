package servlet;

import entity.Collect;
import entity.Commodity;
import entity.Commodity_info;
import entity.Enter;
import service.BuyShowServiceL;
import service.CollectServiceL;
import service.MessageServiceL;
import service.ShopcartServiceL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CollectServlet")
public class CollectServletL extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        String op = request.getParameter("op");
        if("add".equals(op)){
            String sid = request.getParameter("sid");
            String type = request.getParameter("type");
            if("1".equals(type)){
                Collect collect = new Collect();
                Enter enter = new Enter();
                enter.setEnter_id(((Enter)(request.getSession().getAttribute("e"))).getEnter_id());
                collect.setEnter(enter);
                Commodity_info commodity_info = new Commodity_info();
                commodity_info.setCommodity_info_id(Integer.parseInt(sid));
                collect.setCommodity(commodity_info);
                int ret = new CollectServiceL().addCollect(collect);
                if(ret>0){
                    response.sendRedirect("Commodity_infoServlet?op=show&sid="+sid);
                }
            }else if("2".equals(type)) {
                String del = request.getParameter("del");
                int ret = new CollectServiceL().delColl(Integer.parseInt(del));
                if(ret>0){
                    response.sendRedirect("Commodity_infoServlet?op=show&sid="+sid);
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
