package servlet;

import entity.Buy;
import entity.Buyshow;
import service.BackStatusServicew;
import service.Pagew;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "houtaibuyinfoServletw")
public class BackStatusServletw extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        String op = request.getParameter("op");
        if("sel".equals(op)){
            System.out.println("执行");
            String type = request.getParameter("type");
            String indexPage = request.getParameter("indexPage");
            if(type==null){
                type = "-1";
            }
            if(indexPage==null){
                indexPage = "1";
            }
            Pagew<Buy> buyPagew = new Pagew<>();
            buyPagew.setRow(10);
            System.out.println(Integer.parseInt(type));
            int row = new BackStatusServicew().sumPagexx(Integer.parseInt(type));
            System.out.println("java"+row);
            buyPagew.setSumCount(row);
            buyPagew.setIndexPage(Integer.parseInt(indexPage));
            buyPagew.setList(new BackStatusServicew().buyshows(((buyPagew.getIndexPage()-1)*buyPagew.getRow()),buyPagew.getRow(),Integer.parseInt(type)));
            request.setAttribute("pgax",buyPagew);
            request.setAttribute("type",type);
            request.getRequestDispatcher("back/BackStatus.jsp").forward(request,response);
        }else if("info".equals(op)){
            String sid = request.getParameter("sid");
            System.out.println(sid);
            List<Buyshow> buyshows = new BackStatusServicew().getBuyShowInfos(Integer.parseInt(sid));
            System.out.println(buyshows.size());
            request.setAttribute("buy",buyshows);
            request.getRequestDispatcher("back/BackStatusInfo.jsp").forward(request,response);
        }else if("update".equals(op)){
            String sid = request.getParameter("sid");
            String type = request.getParameter("selxx");
            int ret = new BackStatusServicew().updateBuyShowInfoxxx(Integer.parseInt(type),Integer.parseInt(sid));
            System.out.println(ret);
            if(ret>0){
                response.sendRedirect("BackStatusServletw?op=sel");
            }
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
