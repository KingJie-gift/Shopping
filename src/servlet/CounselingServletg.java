package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import service.CounselingServiceg;
import service.Pageg;
import entity.Counseling;

public class CounselingServletg extends HttpServlet {

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

			String index = request.getParameter("pageindex");
			System.out.print(index);
			if (index == null) {
				index = "1";
			}
			Pageg pg = new Pageg();
			pg.setPageindex(Integer.parseInt(index));
			pg.setPageSize(8);
			pg.setTotalCount(new CounselingServiceg().getCount());
			List<Counseling> list = new CounselingServiceg().getAll(
					pg.getPageindex(), pg.getPageSize());
			pg.setList(list);

			request.setAttribute("pg", pg);
			request.getRequestDispatcher("back/index.jsp").forward(request,
					response);
		} else if ("add".equals(op)) {
			String title= "";
			String content= "";
			String urlImg="";
			// 图片存放路径
			String relpath = "content";
			String path = request.getSession().getServletContext()
					.getRealPath(relpath);
			String fn = null;

			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(factory);
			sfu.setHeaderEncoding("UTF-8"); // 处理中文问题
			sfu.setSizeMax(1024 * 1024); // 限制文件大小

			try {
				List<FileItem> fileItems = sfu.parseRequest(request); // 解码请求
				System.out.print(fileItems.size()+"changdu");							// 得到所有表单元素
				for (FileItem fi : fileItems) {
					// 有可能是 文件，也可能是普通文字
					if (fi.isFormField()) { // 这个选项是 文字
//						String fieldName = fi.getFieldName();
//						String value = fi.getString();
//						title = fieldName.equals("title") ? value : "";
//						urlImg = fieldName.equals("urlImg") ? value : "";
							if(fi.getFieldName().equals("name")){
								title = fi.getString();
								System.out.println(title);
							}
							if(fi.getFieldName().equals("show")){
								content = fi.getString();
							}
//						}
						
					} else {
						// 是文件
						// 获取图片后缀名
						String format = fi.getName().substring(
								fi.getName().indexOf("."),
								fi.getName().length());
						// 图片命名
						fn = UUID.randomUUID().toString().replaceAll("-", "")
								+ format;
						System.out.println("路径" + path); // 文件名
						// fn 是可能是这样的 c:\abc\de\tt\fish.jpg
						fi.write(new File(path, fn));
						urlImg = "content/" + fn;
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			Counseling c = new Counseling();
			c.setTitle(title);
			c.setUrlImg(urlImg);
			c.setContent(content);
			int count = new CounselingServiceg().getAdd(c);
			if (count > 0) {
				out.print("<script>alert('新闻添加成功');location.href='back/home1.jsp';</script>");
			} else {
				out.print("<script>alert('新闻添加失败');location.href='back/home1.jsp';</script>");
			}

		} else if ("delete".equals(op)) {
			int id = Integer.parseInt(request.getParameter("id"));
			int count = new CounselingServiceg().getDelete(id);
			if (count > 0) {
				out.print("<script>alert('删除新闻成功');location.href='back/home1.jsp';</script>");
			} else {
				out.print("<script>alert('删除新闻失败');location.href='back/home1.jsp';</script>");
			}
		} else if ("fone".equals(op)) {
			int id = Integer.parseInt(request.getParameter("id"));
			Counseling c = new CounselingServiceg().getfone(id);
			request.setAttribute("c", c);
			request.getRequestDispatcher("back/Update1.jsp").forward(request,
					response);
		} else if ("Update".equals(op)) {

			int id = Integer.parseInt(request.getParameter("id"));
			String title = request.getParameter("name");
			String content = request.getParameter("show");
			Counseling c = new Counseling();
			c.setId(id);
			c.setTitle(title);
			c.setContent(content);
			int count = new CounselingServiceg().getUpdate(c);
			if (count > 0) {
				out.print("<script>alert('修改新闻成功');location.href='back/home1.jsp';</script>");
			} else {
				out.print("<script>alert('修改新闻失败');location.href='back/home1.jsp';</script>");
			}
		}
		out.flush();
		out.close();
	}

}
