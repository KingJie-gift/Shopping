package servlet;

import entity.Address;
import entity.Enter;
import service.AddressService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddressServlet")
public class AddressServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        String op = request.getParameter("op");
        if(op.equals("add")){
            String [] city = request.getParameterValues("city");
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String code = request.getParameter("code");
            String def = request.getParameter("default");
            System.out.println(phone);
            System.out.println(address);
            System.out.println(code);
            System.out.println(name);
            String add = "";
            for(String c:city){
                add+=c;
            }
            add+=address;
            int addType = 0 ;
            if("on".equals(def)){
                new AddressService().addressUpdate();
                addType = 1;

            }
            System.out.println(addType);
            Address address1 = new Address();
            address1.setAddress_default(addType);
            address1.setAddress_telephone(phone);
            address1.setAddress_postal(code);
            address1.setAddress_name(name);
            address1.setAddress_detalied(add);
            Enter e = new Enter();
            e.setEnter_id(((Enter)(request.getSession().getAttribute("e"))).getEnter_id());
            address1.setEnter(e);
            int ret = new AddressService().addAddress(address1);
            response.sendRedirect("byShopping.jsp");
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
