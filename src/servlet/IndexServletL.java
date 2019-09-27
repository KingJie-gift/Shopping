package servlet;

import dao.CommodityDaoL;
import dao.Commodity_smallDaoL;
import entity.Brand;
import entity.Commodity;
import entity.Commodity_small;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BrandServiceL;
import service.Commodity_infoServiceL;
import service.PageL;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "IndexServlet")
public class IndexServletL extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        
        List<Brand> list=new BrandServiceL().selectAll();
        request.getSession().setAttribute("br", list);
        
           String op=request.getParameter("op");
           if(op==null||"tjsel".equals(op)){
        	
        	String indexPage=request.getParameter("indexPage");
            if(indexPage==null){
                indexPage="1";
            }
            
            String sname=request.getParameter("sname");
            System.out.println(sname);
            if(sname==null){
            	sname="";
            }
            String sbrand=request.getParameter("sbrand");
            if(sbrand==null){
            	sbrand="-1";
            }
            
            PageL pg=new PageL();
            pg.setIndexPage(Integer.parseInt(indexPage));
            pg.setRow(10);
            pg.setSumCount(new Commodity_infoServiceL().selectTJCount(sname, Integer.parseInt(sbrand)));
            pg.setList(new Commodity_infoServiceL().selectTJAll(pg.getIndexPage(), pg.getRow(), sname, Integer.parseInt(sbrand)));
            
            request.setAttribute("pg", pg);
            request.setAttribute("sname", sname);
            request.setAttribute("sbrand", sbrand);
            request.getRequestDispatcher("back/home4.jsp").forward(request, response);
            
        }else if("sjsel".equals(op)){
        	
        	String indexPage=request.getParameter("indexPage");
            if(indexPage==null){
                indexPage="1";
            }
            
            String sname=request.getParameter("sname");
            System.out.println(sname);
            if(sname==null){
            	sname="";
            }
            String sbrand=request.getParameter("sbrand");
            if(sbrand==null){
            	sbrand="-1";
            }
            
            PageL pg=new PageL();
            pg.setIndexPage(Integer.parseInt(indexPage));
            pg.setRow(10);
            pg.setSumCount(new Commodity_infoServiceL().selectSJCount(sname, Integer.parseInt(sbrand)));
            pg.setList(new Commodity_infoServiceL().selectSJAll(pg.getIndexPage(), pg.getRow(), sname, Integer.parseInt(sbrand)));
            
            request.setAttribute("pg", pg);
            request.setAttribute("sname", sname);
            request.setAttribute("sbrand", sbrand);
            request.getRequestDispatcher("back/update.jsp").forward(request, response);
        	
        }
        

        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
