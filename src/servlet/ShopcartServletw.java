package servlet;

import dao.AddressDaow;
import dao.impl.AddressDaoImplw;
import entity.*;
import service.AddressServicew;
import service.Pagew;
import service.ShopcartServicew;
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

@WebServlet(name = "ShopcartServlet")
public class ShopcartServletw extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        String op = request.getParameter("op");
        if ("addshop".equals(op)) {
            if ((Enter) (request.getSession().getAttribute("e")) == null) {
                out.print("null");
                return;
            }
            Shopcart shopcart = new Shopcart();
            shopcart.setShopcart_num(Integer.parseInt(request.getParameter("num")));
            Abapt abapt = new Abapt();
            abapt.setAbapt_id(Integer.parseInt(request.getParameter("type")));
            shopcart.setAbapt(abapt);
            Enter enter = new Enter();
            enter.setEnter_id(((Enter) (request.getSession().getAttribute("e"))).getEnter_id());
            shopcart.setEnter(enter);
            Commodity_info commodity_info = new Commodity_info();
            commodity_info.setCommodity_info_id(Integer.parseInt(request.getParameter("shoid")));
            shopcart.setCommodity(commodity_info);
            int ret = new ShopcartServicew().addShopcart(shopcart);
            System.out.println(ret + "添加的收藏的行数");
        } else if ("show".equals(op)) {
            List<Shopcart> shopcarts = new ShopcartServicew().getShopcart(((Enter) (request.getSession().getAttribute("e"))).getEnter_id());
            request.setAttribute("shop", shopcarts);
            request.getRequestDispatcher("shopcart.jsp").forward(request, response);
        } else if ("del".equals(op)) {
            int ret = new ShopcartServicew().delShopcart(Integer.parseInt(request.getParameter("sid")));
            System.out.println(ret + "删除收藏");
            if (ret > 0) {
                response.sendRedirect("ShopcartServlet?op=show");
            }
        } else if ("car".equals(op)) {
            String name = request.getParameter("xx");
            if("5".equals(name)){
                request.getSession().removeAttribute("address");
                request.getSession().removeAttribute("pgx");
            }else {
//            这个是选中的编号
                String[] sel = request.getParameterValues("select-all");

//            String [] id = request.getParameterValues("id");
//            购买的数量
                String[] num = request.getParameterValues("num");
//            购买的商品的类型
//            String [] bapt = request.getParameterValues("bapt");
//            显示商品的下表
//            String  [] index = request.getParameterValues("index");
//            商品的id
//            String [] comm = request.getParameterValues("comm_id");
//            通过编号获取购买的信息

                System.out.println(sel.length + "\t" + num.length);
                List<Shopcart> shopcarts = new ArrayList<>();
                List<Show_info> list = new ArrayList<>();
                for (int i = 0; i < sel.length; i++) {
                    Shopcart shopcart = new ShopcartServicew().shById(Integer.parseInt(sel[i]));
                    shopcarts.add(shopcart);
                    System.out.println(shopcart.getCommodity().getCommodity_info_id());
                    list.add(new Show_InfoDaoServicew().listByIdImage(shopcart.getCommodity().getCommodity_info_id()));
                    System.out.println(list.get(i).getShow_info_url());
                }

                request.getSession().setAttribute("shopImgBy",list);
                request.getSession().setAttribute("shop_by", shopcarts);
                request.getSession().setAttribute("num", num);
//            Commodity_info comm = new Commodity_infoService().commById(Integer.parseInt(sid));
////            加载地址
//            request.getSession().setAttribute("comm", comm);
            }
            int id = ((Enter) (request.getSession().getAttribute("e"))).getEnter_id();
            Pagew pg = new Pagew();
            pg.setRow(3);
            String indexPage = request.getParameter("indexPage");
            if(indexPage==null){
                indexPage = "1";
            }
            pg.setIndexPage(Integer.parseInt(indexPage));
            pg.setSumCount(new AddressDaow().getListAddressCount(id));
//          分页查询地址
            List<Address> addresses = new AddressServicew().getListAddress(id,(pg.getIndexPage()-1)*pg.getRow(),pg.getRow());
            pg.setList(addresses);
            request.getSession().setAttribute("pgx",pg);
            request.getSession().setAttribute("address", addresses);
            response.sendRedirect("ShoppingCart.jsp");
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
