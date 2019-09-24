package servlet;

import dao.BuyShowDaow;
import dao.CommodityDaow;
import dao.Commodity_smallDaow;
import entity.*;
import service.*;

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
public class InitServletw extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        String op = request.getParameter("op");
        if("findShow".equals(op)){

            //            显示奶粉品牌
            int ret = new BrandServicew().listBrand();
//            加载类别
            List<Commodity> comm = new CommodityDaow().getListByAll();
            List<List<Commodity_small>> small = new ArrayList<>();
            for(int i = 0 ; i < comm.size() ; i ++ ){
                List<Commodity_small> smalls = new Commodity_smallDaow().commBySmall(comm.get(i).getCommodity_id());
                small.add(smalls);
            }
//            加载10点开抢活动
            List<Commodity_info> time = new Commodity_infoServicew().getIndexTime();
            for(Commodity_info commodity_info : time){
                commodity_info.setCommodity_info_name(commodity_info.getCommodity_info_name().substring(0,8));
            }
//          展示推荐
            List<Commodity_info> recommend = new Commodity_infoServicew().getRecommend();
            for(Commodity_info commodity_info : recommend){
                commodity_info.setCommodity_info_name(commodity_info.getCommodity_info_name().substring(0,18));
            }
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
                shopcarts = new ShopcartServicew().getShopcart(((Enter)(request.getSession().getAttribute("e"))).getEnter_id());
            }


            List<Commodity_info> yi = new Commodity_infoServicew().getListComm("儿童童衣");
            List<Show_info> yiImg = new ArrayList<>();
            for(Commodity_info commodity_info: yi){
                yiImg.add(new Show_InfoServicew().listByIdImage(commodity_info.getCommodity_info_id()));
            }

            List<Commodity_info> wan = new Commodity_infoServicew().getListComm("儿童玩具");
            List<Show_info> wanImg = new ArrayList<>();
            for(Commodity_info commodity_info: wan){
                wanImg.add(new Show_InfoServicew().listByIdImage(commodity_info.getCommodity_info_id()));
            }
            List<Commodity_info> nai = new Commodity_infoServicew().getListComm("儿童奶粉");
            List<Show_info> naiImg = new ArrayList<>();
            for(Commodity_info commodity_info: nai){
                naiImg.add(new Show_InfoServicew().listByIdImage(commodity_info.getCommodity_info_id()));
            }


            List<Commodity_info> zong = new ArrayList<>();
            List<Show_info> zongIma = new ArrayList<>();

            for(int i = 0 ; i < 2 ; i ++ ){
                zong.add(wan.get(i));
                zong.add(yi.get(i));
                zong.add(nai.get(i));
                zongIma.add(wanImg.get(i));
                zongIma.add(yiImg.get(i));
                zongIma.add(naiImg.get(i));
            }
            zong.add(wan.get(2));
            zongIma.add(wanImg.get(2));
            List<Collect> collects = null;
            List<Buyshow> buyshows = null;
            if((Enter)(request.getSession().getAttribute("e"))!=null){
                collects = new CollectServicew().getEnterAllById(((Enter)(request.getSession().getAttribute("e"))).getEnter_id());
                buyshows = new BuyShowDaow().byShowInfo(((Enter)(request.getSession().getAttribute("e"))).getEnter_id());
            }
//            显示有多个是收藏

            if((Enter)(request.getSession().getAttribute("e"))!=null){
                List<Address> selAddresses = new AddressServicew().getListAddress(((Enter)(request.getSession().getAttribute("e"))).getEnter_id());
                request.getSession().setAttribute("selAddress",selAddresses);
            }

//            保存用户信息
            if((Enter)(request.getSession().getAttribute("e"))!=null){
                List<Address> selAddresses = new AddressServicew().getListAddress(((Enter)(request.getSession().getAttribute("e"))).getEnter_id());
                request.getSession().setAttribute("selAddress",selAddresses);
            }

//            加载用户信息
            if((Enter)(request.getSession().getAttribute("e"))!=null){
                Enter e = new EnterServicew().showBy(((Enter)(request.getSession().getAttribute("e"))).getEnter_id());
                request.getSession().setAttribute("enter",e);
            }



//            request.getSession().setAttribute("");
            request.getSession().setAttribute("buy",buyshows);
            request.getSession().setAttribute("collects",collects);
            request.getSession().setAttribute("zong",zong);
            request.getSession().setAttribute("zongImg",zongIma);

            request.getSession().setAttribute("yi",yi);
            request.getSession().setAttribute("yiImg",yiImg);
            request.getSession().setAttribute("wan",wan);
            request.getSession().setAttribute("wanImg",wanImg);
            request.getSession().setAttribute("nai",nai);
            request.getSession().setAttribute("naiImg",naiImg);


            request.getSession().setAttribute("shop",shopcarts);
            request.getSession().setAttribute("timeImage",timeImage);
            request.getSession().setAttribute("recommendImage",recommendImage);
            request.getSession().setAttribute("recommend",recommend);
            request.getSession().setAttribute("time",time);
            request.getSession().setAttribute("comm",comm);
            request.getSession().setAttribute("small",small);

            String page = request.getParameter("pg");
            request.getRequestDispatcher(page).forward(request,response);

        }else if("del".equals(op)){
            request.getSession().removeAttribute("comm");
            response.sendRedirect("index.jsp");
        }
        out.flush();
        out.close();
    }
    public List<Show_info> getImage(int type){
        List<Commodity_info> commodity_infos =  null;
        if(type == 1) {
            commodity_infos = new Commodity_infoServicew().getRecommend();
        }else {
            commodity_infos = new Commodity_infoServicew().getIndexTime();
        }
        List<Show_info> listTime = new ArrayList<>();
        for (Commodity_info commodity_info : commodity_infos){
            if(new Show_InfoDaoServicew().listByIdImage(commodity_info.getCommodity_info_id())!=null){
                listTime.add(new Show_InfoDaoServicew().listByIdImage(commodity_info.getCommodity_info_id()));
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
