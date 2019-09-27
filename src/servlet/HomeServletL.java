package servlet;

import entity.Brand;
import entity.Commodity;
import service.BrandServiceL;
import service.CommodityServiceL;
import service.Commodity_infoServiceL;
import service.PageL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "HomeServlet")
public class HomeServletL extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        String op = request.getParameter("op");
        
        List<Brand> br=new BrandServiceL().selectAll();
        request.getSession().setAttribute("brand", br);
        List<Brand> sjbr=new BrandServiceL().selSJBrand();
        request.getSession().setAttribute("sjbr", sjbr);
        List<Commodity> co=new BrandServiceL().selectComm();
        request.getSession().setAttribute("co", co);
        List<Brand> blist = new BrandServiceL().getBrandAll();
        request.getSession().setAttribute("br1",blist );
        List<Brand> blist2 = new BrandServiceL().getBrandAll2();
        request.getSession().setAttribute("br2",blist2 );
        List<Brand> blist3 = new BrandServiceL().getBrandAll3();
        request.getSession().setAttribute("br3",blist3 );
        
        if (op == null||"first".equals(op)) {
            List<Brand> list = new BrandServiceL().getBrandAll();
            request.setAttribute("tempcommhome1", list);
            String type = request.getParameter("type");
            if("selAll".equals(type)){
                String indexPage=request.getParameter("indexPage");
                if(indexPage==null){
                    indexPage="1";
                }
                int id=Integer.parseInt(request.getParameter("ppid"));
                PageL pg=new PageL();
                pg.setIndexPage(Integer.parseInt(indexPage));
                pg.setRow(10);
                pg.setSumCount(new Commodity_infoServiceL().selectCount(id));
                pg.setList(new Commodity_infoServiceL().selectAll(pg.getIndexPage(), pg.getRow(), id));
                request.setAttribute("pg", pg);
                request.setAttribute("id", id);
                System.out.println(pg.getList().size());
            }
            request.getRequestDispatcher("back/home1.jsp").forward(request, response);
        } else if ("sel".equals(op)) {
            List<Brand> list2 = new BrandServiceL().getBrandAll2();
            request.setAttribute("tempcommhome2", list2);
            String type = request.getParameter("type");
            if("selAll2".equals(type)){
                content(request);
            }
            request.getRequestDispatcher("back/home.jsp").forward(request, response);
        } else if ("sell".equals(op)) {
            List<Brand> list3 = new BrandServiceL().getBrandAll3();
            request.setAttribute("tempcommhome3", list3);
            String type = request.getParameter("type");
            if("selAll3".equals(type)){
                content(request);
            }
            request.getRequestDispatcher("back/home2.jsp").forward(request, response);
        }else if("sellQT".equals(op)){
        	List<Commodity> list4 = new CommodityServiceL().getListByAll();
            request.setAttribute("tempcommhome4", list4);
                	String type = request.getParameter("type");
                    if("sell4".equals(type)){
                        String indexPage=request.getParameter("indexPage");
                        if(indexPage==null){
                            indexPage="1";
                        }
                        int id=Integer.parseInt(request.getParameter("ppid"));
                        PageL pg=new PageL();
                        pg.setIndexPage(Integer.parseInt(indexPage));
                        pg.setRow(10);
                        pg.setSumCount(new Commodity_infoServiceL().selectCount(id));
                        pg.setList(new Commodity_infoServiceL().selAll(pg.getIndexPage(), pg.getRow(), id));
                        request.setAttribute("pg", pg);
                        request.setAttribute("id", id);
                        System.out.println(pg.getList().size());
                    }

            request.getRequestDispatcher("back/home3.jsp").forward(request, response);
        }
        
        out.flush();
        out.close();
    }

    private void content(HttpServletRequest request) {
        String indexPage=request.getParameter("indexPage");
        if(indexPage==null){
            indexPage="1";
        }

        int id=Integer.parseInt(request.getParameter("ppid"));
        PageL pg=new PageL();
        pg.setIndexPage(Integer.parseInt(indexPage));
        pg.setRow(10);
        pg.setSumCount(new Commodity_infoServiceL().selectCount(id));
        pg.setList(new Commodity_infoServiceL().selectAll(pg.getIndexPage(), pg.getRow(), id));

        request.setAttribute("pg", pg);
        request.setAttribute("id", id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
