<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="site-nav-bg">
    <div class="site-nav w1200">
        <p class="sn-back-home">
            <i class="layui-icon layui-icon-home"></i>
            <a href="InitServlet?op=del">
                首页
            </a>
        </p>
        <div class="sn-quick-menu">
            <div class="login"><a href="logup.jsp">注册</a></div>
            <c:choose>
                <c:when test="${e==null}"><div class="login"><a href="login.jsp">登录</a></div></c:when>
                <c:when test="${e!=null}">欢迎你，<span style="color: red">${e.enter_name}</span>
                    <div class="sp-cart"><a href="shopcart.jsp">购物车</a><span>${shop.size()}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                    <div class="sp-cart"><a href="collect.jsp">收藏</a><span>${collects.size()}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                    <div class="sp-cart"><a href="byShow.jsp">已购买</a><span>${buy.size()}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                </c:when>
            </c:choose>

        </div>
    </div>
</div>
<div class="header">
    <div class="headerLayout w1200">
        <div class="headerCon">
            <h1 class="mallLogo">
                <a href="#" title="母婴商城">
                    <img src="res/static/img/logo.png">
                </a>
            </h1>
            <div class="mallSearch">

                <form action="Commodity_infoServlet?op=group&pgax=commodity.jsp" class="layui-form" novalidate method="post" >
                    <select name="commType" style="display: inline-block;position: absolute;padding: 5px;border: #CFB2F6 2px;margin-top:4px">
                        <option value="1">使用商品进行搜索</option>
                        <option value="2">使用品牌进行搜索</option>
                    </select>
                    <input type="text" name="title" required lay-verify="required" autocomplete="off"
                           class="layui-input" placeholder="请输入需要的商品" style="border-left: #CFB2F6 2px solid">
                    <input type="submit" value="提交" style="width: 60px;background:#CFB2F6" />
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
