package servlet;

import dao.Commodity_infoDao;
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
public class Commodity_infoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        String op = request.getParameter("op");
        if("group".equals(op)){
//使用类别进行所属
            String comm = request.getParameter("comm_id");
            if(comm==null){
//                -1表示没有，不是使用类别进行搜索
                comm = "-1";
            }
//            我们使用查询大类进行查询
            String paent_id = request.getParameter("paent_id");
            if(paent_id==null){
                paent_id = "-1";
            }


//            SELECT * FROM commodity_info WHERE commodity_small_id IN (
//                    SELECT commodity_small_id FROM `commodity_small` WHERE commodity_id IN (
//                    SELECT commodity_id FROM `commodity` WHERE commodity_id = 3)
//	)
//表示当前页数
            String index = request.getParameter("indexPage");
            if (index==null){
                index = "1";
            }
            Page pg = new Page();
            String page = request.getParameter("pgax");
            System.out.println(page+"当前页面向那个地方进行跳转");
//            -1表示不适用查询  1表示按照效率   2 表示价格   3 表示新品
            String type = request.getParameter("type");
            if(type==null){
                type="-1";
            }
            System.out.println(type+"类型类型进行查询");
//            if(type==null&&page.equals("commodity.jsp")){
//                type = "1";
//                pg.setRow(15);
//            }else if(type==null){
//                type = "2";
//                pg.setRow(20);
//            }else {
//                pg.setRow(15);
//            }
            String commType = request.getParameter("commType");
            if(commType==null){
                commType = "-1";
            }
            System.out.println("模糊查询的类型"+commType);
//            模糊查询
            String like = request.getParameter("title");
            System.out.println(like+"模糊查询的值");
            if(like==null){
                like = "-1";
            }
            String day = request.getParameter("day");
            if(day==null){
                day = "-1";
            }

//          如果是使用小类别进行查询
            if(!("-1".equals(comm))){
                pg.setRow(15);
            }else if(!"-1".equals(paent_id)){
                pg.setRow(15);
            }else if(!"-1".equals(like)){
                pg.setRow(15);
            }else if(!"-1".equals(type)){
                pg.setRow(15);
            }else if(!"-1".equals(day)){
                pg.setRow(20);
            }
//            查询是否是商品或者品牌进行查询


            System.out.println(type+"类型的值");
            int sum = new Commodity_infoService().sumCountAll(Integer.parseInt(comm),Integer.parseInt(paent_id),like,Integer.parseInt(commType),Integer.parseInt(type),Integer.parseInt(day));
            System.out.println(sum+"行数");
            pg.setSumCount(sum);
            pg.setIndexPage(Integer.parseInt(index));
//
            List<Commodity_info> commodity_infos = new Commodity_infoService().getByLimit(((pg.getIndexPage()-1)*pg.getRow()),pg.getRow(),Integer.parseInt(type),Integer.parseInt(comm),like,Integer.parseInt(paent_id),Integer.parseInt(commType),Integer.parseInt(day));
            pg.setList(commodity_infos);
            List<Integer> code = new ArrayList<>();
            for(Commodity_info commodity_info : commodity_infos){
                double count = (commodity_info.getCommodity_info_money()/commodity_info.getCommodity_info_Jmoney())*10;
                code.add((int)count);
            }
            List<Show_info> groupImage = new ArrayList<>();
            for (Commodity_info commodity_info : commodity_infos){
                if(new Show_InfoDaoService().listByIdImage(commodity_info.getCommodity_info_id())!=null){
                    groupImage.add(new Show_InfoDaoService().listByIdImage(commodity_info.getCommodity_info_id()));
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
            List<Commodity_info> dayShow = new Commodity_infoService().dayShow();

            List<Show_info> dayShowImage = new ArrayList<>();
            for (Commodity_info commodity_info : dayShow){
                if(new Show_InfoDaoService().listByIdImage(commodity_info.getCommodity_info_id())!=null){
                    dayShowImage.add(new Show_InfoDaoService().listByIdImage(commodity_info.getCommodity_info_id()));
                }else {
                    Show_info show_info = new Show_info();
                    show_info.setShow_info_url("img/Aptamil 爱他美卓萃幼儿配方奶粉3段1-3岁 (白金版)宝宝牛奶粉/img1.png");
                    Commodity_info commodity_info1 = new Commodity_info();
                    commodity_info1.setCommodity_info_id(commodity_info.getCommodity_info_id());
                    show_info.setCommodity(commodity_info1);
                    dayShowImage.add(show_info);
                }
            }

            System.out.println(pg.getList().size()+"显示查询的数据");
            System.out.println(pg.getRow()+"当前行");
            System.out.println(pg.getIndexPage()+"当前页");
            System.out.println(pg.getSumPage()+"总页数");
            System.out.println(pg.getSumCount()+"总行数");
//            返回查询类型分类类别子
            request.getSession().setAttribute("comm_id",comm);
//            使用大种类进行查询
            request.getSession().setAttribute("paent_id",paent_id);
//            模糊查询的值
            request.getSession().setAttribute("title",like);
//            设置模糊查询的类型
            request.getSession().setAttribute("commType",commType);
//            查看类型
            request.getSession().setAttribute("type",type);
//            显示明日
            request.getSession().setAttribute("day",day);
            request.getSession().setAttribute("dayShowImage",dayShowImage);
            request.getSession().setAttribute("dayShow",dayShow);
           request.getSession().setAttribute("groupImage",groupImage);
            request.getSession().setAttribute("code",code);
            request.getSession().setAttribute("pg",pg);
            request.getRequestDispatcher(page).forward(request,response);
        }else if("show".equals(op)){

//            显示商品
            String sid = request.getParameter("sid");
            Commodity_info comm = new Commodity_infoService().commById(Integer.parseInt(sid));

            String details = comm.getCommodity_show();
            System.out.println(details);
            if(details==null||details.equals("")){
                details = "";
            }
            String [] det = details.split("&nbsp;");

            List<String> sb = new ArrayList<>();
            for(String deta : det){
                sb.add(deta);
                sb.add("<br/>");
            }
            List<Commodity_info> shopping = new Commodity_infoService().getTShopping(Integer.parseInt(sid));
            String commshow = "";
            for(String s : sb){
                commshow += s;
            }
            commshow =  commshow.replaceAll(",","");
            List<Show_info> showImage = new Show_InfoService().getShow_infoById(Integer.parseInt(sid));
            Collect collects = null;
            if((Enter)(request.getSession().getAttribute("e"))!=null){
                collects = new CollectService().coll(((Enter)(request.getSession().getAttribute("e"))).getEnter_id(),Integer.parseInt(sid));
            }

            request.getSession().setAttribute("shopping",shopping);

            List<Show_info> shoppingImg = new ArrayList<>();

            for(Commodity_info commodity_info: shopping){
                shoppingImg.add(new Show_InfoService().listByIdImage(commodity_info.getCommodity_info_id()));
                commodity_info.setCommodity_info_name(commodity_info.getCommodity_info_name().substring(0,14)+"...");
            }

            request.getSession().setAttribute("shopping",shopping);


            request.getSession().setAttribute("shoppingImg",shoppingImg);

            request.getSession().setAttribute("sb",commshow);
//            显示适用年龄
            List<Abapt> applets = new AbaptService().getListAb(Integer.parseInt(sid));
            request.getSession().setAttribute("applet",applets);
            request.getSession().setAttribute("comm",comm);
            request.getSession().setAttribute("coll",collects);
            request.getSession().setAttribute("showImage",showImage);
            request.getRequestDispatcher("details.jsp").forward(request,response);
        }else if("small".equals(op)){
//            分类显示信息

        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
