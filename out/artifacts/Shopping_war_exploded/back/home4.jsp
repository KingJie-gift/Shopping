<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="description" content="Reflect Template" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
        <title>首页</title>
        <link rel="stylesheet" href="css/style_all.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="css/style8.css" type="text/css" media="screen" />
        
        <link rel="stylesheet" href="css/jquery-ui.css" type="text/css" media="screen" />
        
        <link rel="stylesheet" href="ueditor1_2_2_0-utf8-php/themes/default/ueditor.css" type="text/css" media="screen" />

        <script type='text/javascript' src='js/all-ck.js'></script>
        <script type='text/javascript' src='ueditor1_2_2_0-utf8-php/editor_config.js'></script>
        <script type='text/javascript' src='js/custom.js'></script>
    </head>
   
    <c:if test="${pg==null }">
    	<script>location.href="../IndexServletL";</script>
    </c:if>
     
    <body style="height: 1693px; ">
        <div id="top">
            <div id="head">
                <h1 class="logo">
                    
                </h1>
                <div class="head_memberinfo">
                   
                    <span class='memberinfo_span' style="font-size: 30px">
                       欢迎你，管理员
                   </span>

                   <!--<span class='memberinfo_span'>
                    <a href="../index.jsp">返回商城</a>
                </span>-->

               

                
            </div>
            <!--end head_memberinfo-->
            
        </div>
            <!--end head-->
           	
            	<div id="bg_wrapper">
                
                    <div id="main">
                        <div id="content">

                                    
                                    
                                    <h2>条件搜索</h2>
                                    <form action="../IndexServletL?op=tjsel" method="post">
                                    <span style="font-size: 20px">关键字：</span><input type="text" value="${sname}" name="sname" style="height: 25px; "/>&nbsp;&nbsp;
                                    <span style="font-size: 20px">商品品牌：</span>
                                    <select name="sbrand">
                                    	<option value="-1">请选择</option>
                                    	<c:forEach var="b" items="${br}">
                                    	<option value="${b.brand_id}" <c:if test="${b.brand_id==sbrand}">selected</c:if>>${b.brand_name}</option>
                                    	</c:forEach>
                                    </select>&nbsp;&nbsp;
                                    <input type="submit" value="搜索" style="width: 103px; height: 30px"/>
                                    </form>
                                    <br/>
                                    <table width="80%" border="1" align="center">
                                    	<tr align="center">
	                                		<th>商品名称</th>
	                                		<th>出售价格</th>
	                                		<th>购买数量</th>
	                                		<th>生产日期</th>
	                                		<th>商品操作</th>
	                                	</tr>
	                                	<c:forEach var="p" items="${pg.list}">
                                	<tr align="center">
                                		<td>${p.commodity_info_name}</td>
                                		<td>${p.commodity_info_money}(元)</td>
                                		<td>${p.commodity_num}(罐)</td>
                                		<td>${p.commodity_millyield}</td>
                                		<td>
                                		<a href="Commodity_infoServlet2L?op=findId&id=${p.commodity_info_id}">查看详情</a>
                                		<a href="Commodity_infoServlet2L?op=showImg&id=${p.commodity_info_id}">图片管理</a>
                                		<a href="Commodity_infoServlet2L?op=delete&id=${p.commodity_info_id}">删除</a>
                                		</td>
                                	</tr>
                                	</c:forEach>
                                    </table>
                            	<p align="center">
                                <a href="IndexServletL?indexPage=1&sname=${sname }&sbrand=${sbrand}">首页</a>
                                <a href="IndexServletL?indexPage=${pg.indexPage>1?pg.indexPage-1:1}&sname=${sname }&sbrand=${sbrand}">上一页</a>
                                <a href="IndexServletL?indexPage=${pg.indexPage<pg.sumPage?pg.indexPage+1:pg.sumPage}&sname=${sname }&sbrand=${sbrand}">下一页</a>
                                <a href="IndexServletL?indexPage=${pg.sumPage}&sname=${sname }&sbrand=${sbrand}">末页</a>
                                	第 ${pg.indexPage} 页/共 ${pg.sumPage} 页
                                </p>
                        </div>
                        <!--end content-->
                        
                    </div><!--end main-->
                    
                    <div id="sidebar">
                        <ul >
                            <li><a class="headitem item1" href="#">商品管理</a>
                                <ul><!-- ul items without this class get hiddden by jquery-->
                                    <li><a href="back/home1.jsp">奶粉管理</a></li>
                                    <li><a href="back/home.jsp">玩具管理</a></li>
                                    <li><a href="back/home2.jsp">童衣管理</a></li>
                                    <li><a href="back/home3.jsp">其他管理</a></li>
                                    <li><a href="back/home4.jsp">条件查询</a></li>
                                    <li><a href="back/update.jsp">商品上架</a></li>
                                </ul>
                            </li>
                            <li><a class="headitem item2" href="#">商品添加</a>
                                  <ul><!-- ul items without this class get hiddden by jquery-->
                                    <li><a href="addSeervletL">商品添加</a></li>
                                    <li><a href="back/brand.jsp">品牌添加</a></li>
                                    <li><a href="Commodity_smallServletL">种类添加</a></li>
                                  </ul>                      
                            </li>
                            
                            
                        </ul><!--end subnav-->

                        

                           

                </div>
                    <!--end sidebar-->
                        
                     </div><!--end bg_wrapper-->
                     
                <div id="footer" style="color: #fff;text-align: center">
               
                </div><!--end footer-->
                
        </div><!-- end top -->
        
    </body>
    
</html>