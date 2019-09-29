package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.NTCredentials;

import service.CommodityServiceZ;
import entity.Commodity;

public class CommodityServletZ extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String op = request.getParameter("op");

		if (op == null) {
			List<Commodity> list = new CommodityServiceZ().getqcAll();
			request.setAttribute("comm", list);
			request.getRequestDispatcher("back/brand1.jsp").forward(request,
					response);
		} else if ("add".equals(op)) {

			String name = request.getParameter("name");

			Commodity c = new Commodity();
			c.setCommodity_name(name);

			int count = new CommodityServiceZ().CommodityAdd(c);

			if (count > 0) {
				out.print("<script>alert('一级分类添加成功');location.href='back/brand1.jsp';</script>");
			} else {
				out.print("<script>alert('一级分类添加失败');location.href='back/brand1.jsp';</script>");
			}	
			
		}else if ("fone".equals(op)) {
			int id = Integer.parseInt(request.getParameter("id"));
			Commodity c=new CommodityServiceZ().getfone(id);
			request.setAttribute("c",c );
		request.getRequestDispatcher("back/brandxgZ.jsp").forward(request, response);
		} else if ("update".equals(op)) {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			Commodity c = new Commodity();
			c.setCommodity_id(id);
			c.setCommodity_name(name);
			int count = new CommodityServiceZ().updateComm(c);

			if (count > 0) {
				out.print("<script>alert('修改成功');location.href='back/brand1.jsp';</script>");
			} else {
				out.print("<script>alert('修改失败');location.href='back/brand1.jsp';</script>");
			}
		}else if("find".equals(op)){
			String name=request.getParameter("name");
			int count=new CommodityServiceZ().getcount(name);
			out.print(count);
		}
		out.flush();
		out.close();
	}
}
