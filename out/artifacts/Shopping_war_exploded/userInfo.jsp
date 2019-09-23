<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/10
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <link rel="stylesheet" type="text/css" href="res/static/css/main.css">
    <link rel="stylesheet" type="text/css" href="res/layui/css/layui.css">
    <script type="text/javascript" src="res/layui/layui.js"></script>

    <link href="img/favicon.ico" rel="icon stylesheet bookmark shortcut" type="image/x-icon"/>
    <link rel="shortcut icon stylesheet" href="img/favicon.ico">
    <link rel="bookmark stylesheet" href="img/favicon.ico">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <script src="js/jquery-1.12.4.js" type="text/javascript"></script>
</head>
<body>
<%@ include file="firstPage.jsp"%>
<div class="content content-nav-base  login-content">
    <div class="login-bg">
        <div class="login-cont w1200">
            <div class="form-box">
                    <legend>用户信息</legend>
                <form class="layui-form" action="EnterServlet?op=update" method="post">
                    <div class="layui-form-item">
                        <div class="layui-inline iphone">
                            <div class="layui-input-inline">
                                <input type="text"  name="user" id="user" value="${enter.enter_name}"  lay-verify="required" placeholder="用户名" autocomplete="off" class="layui-input"><span>&nbsp;</span>
                                <input type="text"  name="pwd" id="pwd" readonly  value="${enter.enter_type==1?'普通用户':'管理员'}" autocomplete="off" class="layui-input"><span>&nbsp;</span>
                                <input type="text"  name="sex" id="rpwd" lay-verify="required" value="${enter.enter_gender=='男'?'男':'女'}" autocomplete="off" class="layui-input"><span id="rpwdmsg">&nbsp;</span>
                                <input type="tel"  name="phone" id="phone" lay-verify="required|phone" value="${enter.enter_telephone}" placeholder="请输入手机号" autocomplete="off" class="layui-input"><span id="phonemsg"></span>
                            </div>
                        </div>
                        <input style="padding-left: 40px;" type="text"  name="name" id="name"  lay-verify="required" value="${enter.enter_truename}" placeholder="请输入真实姓名" autocomplete="off" class="layui-input"><span>&nbsp;</span>
                        <input style="padding-left: 40px;" type="pwd" maxlength="18" readonly name="code_id" id="code_id" value="${enter.enter_card_id}" lay-verify="required"  placeholder="请输入身份证号" autocomplete="off" class="layui-input"><span id="codemsg">&nbsp;&nbsp;&nbsp;</span><br/>
                    </div>
                    <div class="layui-form-item login-btn">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="footer">
    <div class="ng-promise-box">
        <div class="ng-promise w1200">
            <p class="text">
                <a class="icon1" href="javascript:;">7天无理由退换货</a>
                <a class="icon2" href="javascript:;">满99元全场免邮</a>
                <a class="icon3" style="margin-right: 0" href="javascript:;">100%品质保证</a>
            </p>
        </div>
    </div>
    <div class="mod_help w1200">
        <p>
            <a href="javascript:;">关于我们</a>
            <span>|</span>
            <a href="javascript:;">帮助中心</a>
            <span>|</span>
            <a href="javascript:;">售后服务</a>
            <span>|</span>
            <a href="javascript:;">母婴资讯</a>
            <span>|</span>
            <a href="javascript:;">关于货源</a>
        </p>
        <p class="coty">母婴商城版权所有 &copy; 2012-2020</p>
    </div>
</div>
</body>
</html>