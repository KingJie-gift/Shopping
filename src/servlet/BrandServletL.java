package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BrandServiceL;
import entity.Brand;
import entity.Commodity;

public class BrandServletL extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	System.out.println("android");
        doPost(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String op=request.getParameter("op");
        if(op==null||"add".equals(op)){
        	String Brand_name=request.getParameter("name");
        	int id=Integer.parseInt(request.getParameter("comm"));
        	
        	Commodity c=new Commodity();
        	c.setCommodity_id(id);
        	
        	Brand b=new Brand();
        	b.setBrand_name(Brand_name);
        	b.setComm(c);
        	
        	int count=new BrandServiceL().getBrandAdd(b);
        	if(count>0){
        		out.print("<script>alert('添加品牌成功');location.href='back/home1.jsp';</script>");
        	}else{
        		out.print("<script>alert('添加品牌失败');location.href='back/home1.jsp';</script>");
        	}
        	
        }else if("del".equals(op)){
        	int id=Integer.parseInt(request.getParameter("id"));
        	new BrandServiceL().getdeletesp(id);
        	int count=new BrandServiceL().getdelete(id);
        	if(count>0){
        		out.print("<script>alert('删除品牌成功');location.href='back/home1.jsp';</script>");
        	}else{
        		out.print("<script>alert('删除品牌失败');location.href='back/home1.jsp';</script>");
        	}
        }
        
       
        
        out.flush();
        out.close();
    }

}
