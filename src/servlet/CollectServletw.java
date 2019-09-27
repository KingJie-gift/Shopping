package servlet;

import dao.BuyShowDaow;
import entity.*;
import service.CollectServicew;
import service.Show_InfoDaoServiceL;
import service.Show_InfoDaoServicew;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CollectServlet")
public class CollectServletw extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        String op = request.getParameter("op");
        if("add".equals(op)){
            if((Enter)(request.getSession().getAttribute("e"))==null){
                response.sendRedirect("login.jsp");
                return;
            }
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
                int ret = new CollectServicew().addCollect(collect);
                if(ret>0){
                    response.sendRedirect("Commodity_infoServlet?op=show&sid="+sid);
                }
            }else if("2".equals(type)) {
//                这个是取消收藏
                String del = request.getParameter("del");
                int ret = new CollectServicew().delColl(Integer.parseInt(del));
                if(ret>0){
                    response.sendRedirect("Commodity_infoServlet?op=show&sid="+sid);
                }
            }

            }else if("del".equals(op)){
//            删除之后进行刷新
            String del = request.getParameter("sid");
            int ret = new CollectServicew().delColl(Integer.parseInt(del));
            if(ret>0){
                List<Collect> collects = new ArrayList<>();
                List<Buyshow> buyshows = new ArrayList<>();
                if((Enter)(request.getSession().getAttribute("e"))!=null){
                    collects = new CollectServicew().getEnterAllById(((Enter)(request.getSession().getAttribute("e"))).getEnter_id());
                    buyshows = new BuyShowDaow().byShowInfo(((Enter)(request.getSession().getAttribute("e"))).getEnter_id());
                    List<Show_info> list = new ArrayList<>();
                    for(Buyshow buyshow : buyshows){
                        list.add(new Show_InfoDaoServicew().listByIdImage(buyshow.getCommodity().getCommodity_info_id()));
                    }

                    List<Show_info> coll = new ArrayList<>();
                    for(Collect collect : collects){
                        coll.add(new Show_InfoDaoServiceL().listByIdImage(collect.getCommodity().getCommodity_info_id()));
                    }
                    request.getSession().removeAttribute("collects");
                    request.getSession().removeAttribute("buyImg");
                    request.getSession().removeAttribute("collImg");
                    request.getSession().setAttribute("collects",collects);
                    request.getSession().setAttribute("buyImg",list);
                    request.getSession().setAttribute("collImg",coll);
                }
                response.sendRedirect("collect.jsp");
            }
        }
        out.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
