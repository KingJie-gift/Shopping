package servlet;

import entity.*;
import service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.applet.Applet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Commodity_infoServlet")
public class Commodity_infoServletL extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        String op = request.getParameter("op");

        if("group".equals(op)){
            String index = request.getParameter("indexPage");
            if (index==null){
                index = "1";
            }
            PageL pg = new PageL();
            String page = request.getParameter("pgax");
            System.out.println(page);
            String type = request.getParameter("type");
            System.out.println(type);
            if(type==null&&page.equals("commodity.jsp")){
                type = "1";
                pg.setRow(15);
            }else if(type==null){
                type = "2";
                pg.setRow(20);
            }else {
                pg.setRow(15);
            }

            pg.setSumCount(new Commodity_infoServiceL().sumCountAll());
            pg.setIndexPage(Integer.parseInt(index));
            int id = 0 ;
            if(request.getParameter("sid")!=null){
                id = Integer.parseInt(request.getParameter("sid"));
            }else {
                id = -1;
            }

            List<Commodity_info> commodity_infos = new Commodity_infoServiceL().getByLimit(((pg.getIndexPage()-1)*pg.getRow()),pg.getRow(),Integer.parseInt(type),id);
            pg.setList(commodity_infos);
            List<Integer> code = new ArrayList<Integer>();
            for(Commodity_info commodity_info : commodity_infos){
                double count = (commodity_info.getCommodity_info_money()/commodity_info.getCommodity_info_Jmoney())*10;
                code.add((int)count);
            }
            List<Show_info> groupImage = new ArrayList<Show_info>();
            for (Commodity_info commodity_info : commodity_infos){
                if(new Show_InfoDaoServiceL().listByIdImage(commodity_info.getCommodity_info_id())!=null){
                    groupImage.add(new Show_InfoDaoServiceL().listByIdImage(commodity_info.getCommodity_info_id()));
                }else {
                    Show_info show_info = new Show_info();
                    show_info.setShow_info_url("img/Aptamil 爱他美卓萃幼儿配方奶粉3段1-3岁 (白金版)宝宝牛奶粉/img1.png");
                    Commodity_info commodity_info1 = new Commodity_info();
                    commodity_info1.setCommodity_info_id(commodity_info.getCommodity_info_id());
                    show_info.setCommodity(commodity_info1);
                    groupImage.add(show_info);
                }
            }



//            显示推荐
            List<Commodity_info> dayShow = new Commodity_infoServiceL().dayShow();

            List<Show_info> dayShowImage = new ArrayList<Show_info>();
            for (Commodity_info commodity_info : dayShow){
                if(new Show_InfoDaoServiceL().listByIdImage(commodity_info.getCommodity_info_id())!=null){
                    dayShowImage.add(new Show_InfoDaoServiceL().listByIdImage(commodity_info.getCommodity_info_id()));
                }else {
                    Show_info show_info = new Show_info();
                    show_info.setShow_info_url("img/Aptamil 爱他美卓萃幼儿配方奶粉3段1-3岁 (白金版)宝宝牛奶粉/img1.png");
                    Commodity_info commodity_info1 = new Commodity_info();
                    commodity_info1.setCommodity_info_id(commodity_info.getCommodity_info_id());
                    show_info.setCommodity(commodity_info1);
                    dayShowImage.add(show_info);
                }
            }
            request.getSession().setAttribute("type",type);
            request.getSession().setAttribute("dayShowImage",dayShowImage);
            request.getSession().setAttribute("dayShow",dayShow);
           request.getSession().setAttribute("groupImage",groupImage);
            request.getSession().setAttribute("code",code);
            request.getSession().setAttribute("pg",pg);
            request.getRequestDispatcher(page).forward(request,response);
        }else if("show".equals(op)){
            String sid = request.getParameter("sid");
            Commodity_info comm = new Commodity_infoServiceL().commById(Integer.parseInt(sid));

            String details = comm.getCommodity_show();

            String [] det = details.split("&nbsp;");

            List<String> sb = new ArrayList<String>();
            for(String deta : det){
                sb.add(deta);
                sb.add("<br/>");
            }

            String commshow = "";
            for(String s : sb){
                commshow += s;
            }
            commshow =  commshow.replaceAll(",","");
            System.out.println(commshow);

            List<Show_info> showImage = new Show_InfoServiceL().getShow_infoById(Integer.parseInt(sid));
            Collect collects = null;
            if((Enter)(request.getSession().getAttribute("e"))!=null){
                collects = new CollectServiceL().coll(((Enter)(request.getSession().getAttribute("e"))).getEnter_id(),Integer.parseInt(sid));
            }


            request.getSession().setAttribute("sb",commshow);
//            显示适用年龄
            List<Abapt> applets = new AbaptServiceL().getListAb(Integer.parseInt(sid));
            request.getSession().setAttribute("applet",applets);
            request.getSession().setAttribute("comm",comm);
            request.getSession().setAttribute("coll",collects);
            request.getSession().setAttribute("showImage",showImage);
            request.getRequestDispatcher("details.jsp").forward(request,response);
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
