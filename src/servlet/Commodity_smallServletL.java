package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Commodity;
import entity.Commodity_small;
import service.BrandServiceL;
import service.Commodity_smallServiceL;

public class Commodity_smallServletL extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String op=request.getParameter("op");
		if(op==null){
			
			List<Commodity_small> list=new Commodity_smallServiceL().selectComm();
			request.getSession().setAttribute("small", list);
			List<Commodity> co=new BrandServiceL().selectComm();
	        request.getSession().setAttribute("co", co);
	        response.sendRedirect("back/small.jsp");
		}else if("add".equals(op)){
			String commodity_small_name=request.getParameter("name");
			int id=Integer.parseInt(request.getParameter("comm"));
			Commodity c=new Commodity();
			c.setCommodity_id(id);
			Commodity_small m=new Commodity_small();
			m.setCommodity_small_name(commodity_small_name);
			m.setCommodity(c);
			int count=new Commodity_smallServiceL().getaddzl(m);
			if(count>0){
				out.print("<script>alert('添加小品牌成功');location.href='back/home1.jsp';</script>");
			}else{
				out.print("<script>alert('添加小品牌成功');location.href='back/home1.jsp';</script>");
			}
			}else if("del".equals(op)){
				int id=Integer.parseInt(request.getParameter("id"));
				new Commodity_smallServiceL().getdel(id);
				int count=new Commodity_smallServiceL().getDelete(id);
				if(count>0){
					out.print("<script>alert('删除小种类成功');location.href='back/home1.jsp';</script>");
				}else{
					out.print("<script>alert('删除小种类失败');location.href='back/home1.jsp';</script>");
				}
				
			}
		
		out.flush();
		out.close();
	}

}
