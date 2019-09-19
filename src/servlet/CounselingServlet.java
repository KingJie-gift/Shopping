package servlet;

import entity.Counseling;
import service.CounselingService;
import service.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InformationServlet")
public class CounselingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        String op = request.getParameter("op");
        if("sel".equals(op)){
            String indexPage = request.getParameter("indexPage");
            if(indexPage==null){
                indexPage = "1";
            }
            Page pg = new Page();
            pg.setRow(16);
            pg.setSumCount(new CounselingService().getAllCount());
            pg.setIndexPage(Integer.parseInt(indexPage));
            pg.setList(new CounselingService().getAllContent((pg.getIndexPage()-1)*pg.getRow(),pg.getRow()));
            request.setAttribute("pgc",pg);
            request.getRequestDispatcher("information.jsp").forward(request,response);

        }else if("single".equals(op)){
            String sid = request.getParameter("sid");
            Counseling counseling = new CounselingService().getById(Integer.parseInt(sid));
            request.setAttribute("co",counseling);
            request.getRequestDispatcher("matter.jsp").forward(request,response);
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
