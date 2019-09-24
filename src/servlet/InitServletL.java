package servlet;

import dao.CommodityDaoL;
import dao.Commodity_smallDaoL;
import entity.*;
import service.BrandServiceL;
import service.Commodity_infoServiceL;
import service.ShopcartServiceL;
import service.Show_InfoDaoServiceL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "InitServlet")
public class InitServletL extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        String op = request.getParameter("op");
        if("findShow".equals(op)){

            //            显示奶粉品牌
            int ret = new BrandServiceL().listBrand();
            System.out.println(ret);
//            加载类别
            List<Commodity> comm = new CommodityDaoL().getListByAll();
            List<List<Commodity_small>> small = new ArrayList<List<Commodity_small>>();
            for(int i = 0 ; i < comm.size() ; i ++ ){
                List<Commodity_small> smalls = new Commodity_smallDaoL().commBySmall(comm.get(i).getCommodity_id());
                small.add(smalls);
            }
//            加载10点开抢活动
            List<Commodity_info> time = new Commodity_infoServiceL().getIndexTime();
            for(Commodity_info commodity_info : time){
                commodity_info.setCommodity_info_name(commodity_info.getCommodity_info_name().substring(0,8));
            }
//          展示推荐
            List<Commodity_info> recommend = new Commodity_infoServiceL().getRecommend();
            for(Commodity_info commodity_info : recommend){
                commodity_info.setCommodity_info_name(commodity_info.getCommodity_info_name().substring(0,18));
            }

            System.out.println(recommend.size());
//          显示10电推荐图片

            List<Show_info> timeImage = this.getImage(2);



//            显示推荐图片

            List<Show_info> recommendImage = this.getImage(1);




//            for(Commodity co : comm){
//                if(co.getCommodity_name().equals("儿童奶粉")){
//                    List<Commodity_small> commodity_small =  small.get(co.getCommodity_id());
//                    commodity_small.clear();
//                    for(Brand brand : brands){
//                        commodity_small.add();
//                    }
//                }
//            }
            List<Shopcart> shopcarts = null;
            if((Enter)(request.getSession().getAttribute("e"))!=null){
                shopcarts = new ShopcartServiceL().getShopcart(((Enter)(request.getSession().getAttribute("e"))).getEnter_id());
                System.out.println(shopcarts.size());
            }


            request.getSession().setAttribute("shop",shopcarts);
            request.getSession().setAttribute("timeImage",timeImage);
            request.getSession().setAttribute("recommendImage",recommendImage);
            request.getSession().setAttribute("recommend",recommend);
            request.getSession().setAttribute("time",time);
            request.getSession().setAttribute("comm",comm);
            request.getSession().setAttribute("small",small);

            String page = request.getParameter("pg");
            request.getRequestDispatcher(page).forward(request,response);

        }
        out.flush();
        out.close();
    }
    public List<Show_info> getImage(int type){
        List<Commodity_info> commodity_infos =  null;
        if(type == 1) {
            commodity_infos = new Commodity_infoServiceL().getRecommend();
        }else {
            commodity_infos = new Commodity_infoServiceL().getIndexTime();
        }
        List<Show_info> listTime = new ArrayList<Show_info>();
        for (Commodity_info commodity_info : commodity_infos){
            if(new Show_InfoDaoServiceL().listByIdImage(commodity_info.getCommodity_info_id())!=null){
                listTime.add(new Show_InfoDaoServiceL().listByIdImage(commodity_info.getCommodity_info_id()));
            }else {
                Show_info show_info = new Show_info();
                show_info.setShow_info_url("img/Aptamil 爱他美卓萃幼儿配方奶粉3段1-3岁 (白金版)宝宝牛奶粉/img1.png");
                Commodity_info commodity_info1 = new Commodity_info();
                commodity_info1.setCommodity_info_id(commodity_info.getCommodity_info_id());
                show_info.setCommodity(commodity_info1);
                listTime.add(show_info);
            }
        }
        return listTime;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
