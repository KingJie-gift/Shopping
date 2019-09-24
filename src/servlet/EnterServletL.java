package servlet;

import entity.Enter;
import service.EnterServiceL;
import util.PhonePatt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EnterServlet")
public class EnterServletL extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        String op = request.getParameter("op");
        if("add".equals(op)){
            String user = request.getParameter("user");
            String pwd = request.getParameter("pwd");
            String phone = request.getParameter("phone");
            String code_id = request.getParameter("code_id");
            String name = request.getParameter("name");
            String grend = request.getParameter("grend");

            Enter enter = new Enter();
            enter.setEnter_name(user);
            enter.setEnter_gender(grend);
            enter.setEnter_password(pwd);
            enter.setEnter_telephone(phone);
            enter.setEnter_card_id(code_id);
            enter.setEnter_truename(name);
            int ret = new EnterServiceL().addEnter(enter);
            if(ret>0){
                response.sendRedirect("index.jsp");
            }else {
                out.print("<script>alert('注册失败');location.href='logup.jsp';</script>");
            }
        }else if("patt".equals(op)){
//            这个是判断手机号是否重复
            String phone = request.getParameter("phone");
            int ret = new EnterServiceL().pattPhone(phone);
            out.print(ret);
        }else if("pattphone".equals(op)){
//            这个是发送验证码
            String phone = request.getParameter("phone");
            String rphone = new PhonePatt().phonePattNum(phone);
            System.out.println("验证码"+rphone);
            request.getSession().setAttribute("code",rphone);
        }else if("auth".equals(op)){
            System.out.println(request.getSession().getAttribute("code"));
            String stust = request.getParameter("stust");
            if(request.getSession().getAttribute("code").equals(stust)){
                out.print("true");
            }else {
                out.print("false");
            }
        }else if("code_id".equals(op)){
            String id = request.getParameter("id");
            int count = new EnterServiceL().codeId(id);
            out.print(count);
            System.out.println(count);
        }else if("sel".equals(op)){
            String name=request.getParameter("name");
            String pwd=request.getParameter("pwd");
            Enter e=new EnterServiceL().selectLogin(name, pwd);
            if(e!=null){
                request.getSession().setAttribute("e", e);
                HttpSession session = request.getSession();
                session.removeAttribute("comm");
                response.sendRedirect("index.jsp");
            }else{
                out.print("<script>alert('用户名或密码错误！');location.href='login.jsp';</script>");
            }
        }else if("log".equals(op)){
        	String name=request.getParameter("name");
        	String pwd=request.getParameter("pwd");
        	int count=new EnterServiceL().loginAdmin(name,pwd);
        	if(count>0){
        		out.print("<script>alert('登陆成功！');location.href='back/home1.jsp';</script>");
        	}else {
        		out.print("<script>alert('用户名或密码错误，或者您不是管理员！');location.href='back/login.jsp';</script>");
        	}
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
