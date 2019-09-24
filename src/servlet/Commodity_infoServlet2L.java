package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Commodity_infoServiceL;
import entity.Brand;
import entity.Commodity_info;
import entity.Commodity_small;
import entity.Show_info;

public class Commodity_infoServlet2L extends HttpServlet {

	
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
			
		
		
		if(op==null||"findId".equals(op)){
	       	int id2=Integer.parseInt(request.getParameter("id"));
	        Commodity_info c=new Commodity_infoServiceL().selFindId(id2);
	        String details = c.getCommodity_show();

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
	        c.setCommodity_show(commshow);
	        request.setAttribute("find", c);
	        request.getRequestDispatcher("back/form_h.jsp").forward(request, response);
		}else if("del".equals(op)){
			int id3=Integer.parseInt(request.getParameter("sid"));
			int count=new Commodity_infoServiceL().deleteShow(id3);
			if(count>0){
			    String pageend = "Commodity_infoServlet2?op=findId&id="+request.getSession().getAttribute("comm_id")+"&page=fh";
				out.print("<script>alert('删除成功！');location.href='"+pageend+"';</script>");
			}else{
				out.print("<script>alert('删除失败！');location.href='back/form_h.jsp';</script>");
			}
		}else if("update".equals(op)){
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			double money=Double.parseDouble(request.getParameter("money"));
			double Jmoney=Double.parseDouble(request.getParameter("Jmoney"));
			String kg=request.getParameter("kg");
			String show=request.getParameter("show");
			String num=request.getParameter("num");
			Date date=Date.valueOf(request.getParameter("flexy_datepicker"));
			
			Commodity_info comm2=new Commodity_info();
			comm2.setCommodity_info_id(id);
			comm2.setCommodity_info_name(name);
			comm2.setCommodity_info_money(money);
			comm2.setCommodity_info_Jmoney(Jmoney);
			comm2.setCommodity_info_KG(kg);
			comm2.setCommodity_show(show);
			comm2.setCommodity_num(num);
			comm2.setCommodity_millyield(date);
			
			int count=new Commodity_infoServiceL().update(comm2);
			if(count>0){
				out.print("<script>alert('修改成功！');location.href='back/home1.jsp';</script>");
			}else{
				out.print("<script>alert('修改失败！');location.href='back/home1.jsp';</script>");
			}
		}else if("show".equals(op)){
				int id=Integer.parseInt(request.getParameter("id"));
				request.getSession().setAttribute("comm_id",id);
				Show_info show=new Commodity_infoServiceL().selectShow(id);
				
				request.setAttribute("show", show);
				request.getRequestDispatcher("back/form_v.jsp").forward(request, response);	
		}else if("delete".equals(op)){
			
			int id=Integer.parseInt(request.getParameter("id"));
			int count=new Commodity_infoServiceL().delShowInfo(id);
			int count2=new Commodity_infoServiceL().delCommodity(id);
			if(count>0&&count2>0){
				out.print("<script>alert('商品删除成功！');location.href='back/home1.jsp';</script>");
			}else{
				out.print("<script>alert('商品删除失败！');location.href='back/home1.jsp';</script>");
			}
			
		}
		
		out.flush();
		out.close();
	}

}
