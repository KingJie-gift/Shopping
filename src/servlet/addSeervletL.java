package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Commodity_infoServiceL;
import entity.Abapt;
import entity.Brand;
import entity.Commodity_info;
import entity.Commodity_small;

public class addSeervletL extends HttpServlet {

	
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
			List<Brand> list=new Commodity_infoServiceL().selectB();
			request.getSession().setAttribute("brand", list);
			
			List<Commodity_small> list2=new Commodity_infoServiceL().selectC();
			request.getSession().setAttribute("small", list2);

			List<Abapt> list3=new Commodity_infoServiceL().selectA();
			request.getSession().setAttribute("abap", list3);
			
			response.sendRedirect("back/add.jsp");
		}else if("add".equals(op)){
			
			String name=request.getParameter("name");
			double money=Double.parseDouble(request.getParameter("money"));
			double Jmoney=Double.parseDouble(request.getParameter("Jmoney"));
			String kg=request.getParameter("kg");
			String show=request.getParameter("show");
			String num=request.getParameter("num");
			Date date=Date.valueOf(request.getParameter("flexy_datepicker"));
			int brand=Integer.parseInt(request.getParameter("brand"));
			int comm=Integer.parseInt(request.getParameter("comm"));
			
			Brand b=new Brand();
			b.setBrand_id(brand);
			
			Commodity_small c=new Commodity_small();
			c.setCommodity_small_id(comm);
			
			Commodity_info comm2=new Commodity_info();
			comm2.setCommodity_info_name(name);
			comm2.setCommodity_info_money(money);
			comm2.setCommodity_info_Jmoney(Jmoney);
			comm2.setCommodity_info_KG(kg);
			comm2.setCommodity_show(show);
			comm2.setCommodity_num(num);
			comm2.setCommodity_millyield(date);
			comm2.setBrand(b);
			comm2.setCommodity_small(c);
			
			int count=new Commodity_infoServiceL().insert(comm2);
			if(count>0){
				
				String [] ye = request.getParameterValues("bc");
				
				for(int i = 0 ; i < ye.length ; i ++ ){
					System.out.println(new Commodity_infoServiceL().selectNewId());
					new Commodity_infoServiceL().insertAbapt(new Commodity_infoServiceL().selectNewId(),Integer.parseInt(ye[i]));
				}
				out.print("<script>alert('添加成功！');location.href='back/home1.jsp';</script>");
			}else{
				out.print("<script>alert('添加失败！');location.href='back/home1.jsp';</script>");
			}
		}
		
		out.flush();
		out.close();
	}

}
