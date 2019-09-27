package servlet;

import dao.Show_InfoDaoL;
import entity.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import service.Commodity_infoServiceL;
import service.ShopcartServiceL;
import service.Show_InfoDaoServiceL;
import service.Show_InfoServiceL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "ShopcartServlet")
public class ShopcartServletL extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        String op = request.getParameter("op");
        if("addshop".equals(op)){
            Shopcart shopcart = new Shopcart();
            shopcart.setShopcart_num(Integer.parseInt(request.getParameter("num")));
            Abapt abapt = new Abapt();
            abapt.setAbapt_id(Integer.parseInt(request.getParameter("type")));
            shopcart.setAbapt(abapt);
            Enter enter = new Enter();
            enter.setEnter_id(((Enter)(request.getSession().getAttribute("e"))).getEnter_id());
            shopcart.setEnter(enter);
            Commodity_info commodity_info = new Commodity_info();
            commodity_info.setCommodity_info_id(Integer.parseInt(request.getParameter("shoid")));
            shopcart.setCommodity(commodity_info);
            int ret = new ShopcartServiceL().addShopcart(shopcart);
            System.out.println(ret);
        }else if("show".equals(op)){
            List<Shopcart> shopcarts = new ShopcartServiceL().getShopcart(((Enter)(request.getSession().getAttribute("e"))).getEnter_id());
            request.setAttribute("shop",shopcarts);
            request.getRequestDispatcher("shopcart.jsp").forward(request,response);
        }else if("del".equals(op)){
            int ret = new ShopcartServiceL().delShopcart(Integer.parseInt(request.getParameter("sid")));
            System.out.println(ret+"--------");
            if(ret>0){
                response.sendRedirect("ShopcartServlet?op=show");
            }
        }else if("delImg".equals(op)){
            String sid = request.getParameter("sid");
            String comm_id_id = request.getParameter("comm_id_id");
            int ret = new Show_InfoDaoServiceL().delImg(Integer.parseInt(sid));
            if(ret>0){
                request.getRequestDispatcher("Commodity_infoServlet2L?op=showImg&id="+comm_id_id).forward(request,response);
            }
        }else if("addImg".equals(op)){
            String name = request.getParameter("comm_id_idd");
            Show_info show_info = new Show_InfoDaoServiceL().getIdImg(Integer.parseInt(name));
//            表示没有一张图片
            if(show_info==null){
                System.out.println("执行");
                show_info = new Show_info();
                String title = new Commodity_infoServiceL().getTitleByid(Integer.parseInt(name));
                show_info.setShow_info_url("img/"+title+"/img.jpg");
                File file = new File( request.getSession().getServletContext()
                        .getRealPath("img/"+title+"/"));
                file.mkdirs();
                System.out.println("创建成功");
            }
            String [] arr = show_info.getShow_info_url().split("/");
            for(int i = 0 ; i < arr.length ; i ++ ){
                System.out.println(arr[i]);
            }
            boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
            String uploadPath = request.getSession().getServletContext()
                    .getRealPath("img/"+arr[1]+"/");
            if (isMultiPart) {
                DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
                try {
                    List<FileItem> list = upload.parseRequest(request);
                    int i = 0 ;
                    System.out.println(list.size()+"zzzzzzzzzzz");
                    for(FileItem item:list){
                        i += 1;
                        if(item.isFormField()){
//                            这个是普通的图片
                        }else {
                            if(item.getName()==null||item.getName()==""){

                            }else {
                                System.out.println("执行");
                                String fileName = arr[2].substring(0, arr[2].lastIndexOf(".")) + i + ".jpg";
                                File file = new File(uploadPath, fileName);
                                item.write(file);
                                Show_info show_info1 = new Show_info();
                                String xx = fileName.substring(fileName.lastIndexOf("Shopping_war_exploded") + 1);
                                System.out.println(xx + "目录名字");
                                show_info1.setShow_info_url("img/" + arr[1] + "/" + xx);
                                Commodity_info commodity_info = new Commodity_info();
                                commodity_info.setCommodity_info_id(Integer.parseInt(name));
                                show_info1.setCommodity(commodity_info);
                                int ret = new Show_InfoDaoServiceL().insert(show_info1);
                                System.out.println(show_info1.getShow_info_url());
                                System.out.println(show_info1.getCommodity().getCommodity_info_id());
                                System.out.println("受影响的行数" + ret);
                            }
                        }
                    }
                } catch (FileUploadException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            request.getRequestDispatcher("Commodity_infoServlet2L?op=showImg&id="+name).forward(request,response);
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
