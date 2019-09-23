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
import java.util.List;

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
            String ye = request.getParameter("page");
            if(ye.equals("address")){
                response.sendRedirect("AddressServlet?op=sel");
            }else{
                response.sendRedirect("AddressServlet?op=gadd");
            }

        }else if("sel".equals(op)){
            if(((Enter)(request.getSession().getAttribute("e")))!=null){
                int id = ((Enter)(request.getSession().getAttribute("e"))).getEnter_id();
                List<Address> addresses = new AddressService().getListAddress(id);
                request.getSession().setAttribute("address",addresses);
                response.sendRedirect("byShopping.jsp");
            }
        }else if("gadd".equals(op)){
            response.sendRedirect("ShopcartServlet?op=car&xx=5");
        }else if("del".equals(op)){
            int id = Integer.parseInt(request.getParameter("sid"));
            int ret = new AddressService().getDelete(id);
            address(request, response, ret);
        }else if("update".equals(op)) {
//            根据编号查询addrss地址信息
            Address address = new AddressService().getAddressBuyId(Integer.parseInt(request.getParameter("sid")));
            request.setAttribute("address",address);
            request.getRequestDispatcher("updateAddress.jsp").forward(request,response);
        }else if("updateAddress".equals(op)){
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String code = request.getParameter("code");
            Address address1 = new Address();
            address1.setAddress_postal(code);
            address1.setAddress_detalied(address);
            address1.setAddress_telephone(phone);
            address1.setAddress_name(name);
            Enter e = new Enter();
            e.setEnter_id(((Enter)(request.getSession().getAttribute("e"))).getEnter_id());
            address1.setEnter(e);
            address1.setAddress_id(Integer.parseInt(request.getParameter("sid")));
            int ret = new AddressService().getUpdate(address1);
            address(request, response, ret);
        }
        out.flush();
        out.close();
    }

    private void address(HttpServletRequest request, HttpServletResponse response, int ret) throws IOException {
        if(ret>0) {
            if ((Enter) (request.getSession().getAttribute("e")) != null) {
                request.getSession().removeAttribute("selAddress");
                List<Address> selAddresses = new AddressService().getListAddress(((Enter) (request.getSession().getAttribute("e"))).getEnter_id());
                request.getSession().setAttribute("selAddress", selAddresses);
            }
            response.sendRedirect("showAddress.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
