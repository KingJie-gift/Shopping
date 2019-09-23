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
    <script type="text/javascript">

        $(function () {
            var flag = true;
            function checkPwd(){
                var pwd = $("#pwd").val();
                var rpwd = $("#rpwd").val();
                if(pwd!=rpwd){
                    $("#rpwdmsg").html("两次密码不相同")
                    flag = false;
                }
                $("#rpwdmsg").html("&nbsp;&nbsp;")
                flag = true;
            }
            $("#rpwd").blur(checkPwd);

            //    发送验证手机号码是否重复
            $("#phone").blur(function () {
                var phone = $(this).val();
                $.post("EnterServlet",{op:"patt",phone:phone},function (data) {
                    if(data!="0"){
                        $("#phonemsg").html("此手机号码已注册");
                        flag = false;
                    }
                    $("#phonemsg").html("");
                    flag = true;
                })
            })
            $('[name="code_id"]').blur(function () {
                var code = $(this).val();
                $.post("EnterServlet",{op:"code_id",id:code},function (data) {
                    if(data!="0"){
                        $("#codemsg").html("已存在")
                        flag = false;
                    }else{
                        $("#codemsg").html("可以使用")
                        flag = true;
                    }
                })
            });
            //    发送手机号码
            //    返回验证码的状态
            $('[class="layui-btn"]').click(function () {
                var phone = $('[name="phone"]').val();
                $.post("EnterServlet",{op:"pattphone",phone:phone},function (data) {
                },"text");
            });
            $('[name="pnum"]').blur(function () {
                var stust = $(this).val();
                $.post("EnterServlet",{op:"auth",stust:stust},function (data) {
                    if(data=="true"){
                        $("#phonemge").html("验证码正确");
                        flag = true;
                    }else {
                        $("#phonemge").html("验证码不正确");
                        flag = false;
                    }
                });
            });
            $("#form").submit(function () {
                return flag;
            });
        })

    </script>


    <script type="text/javascript">
        var countdown = 60;
        function settime() {
            var obj = document.getElementById("find");
            if (countdown == 0) {
                obj.removeAttribute("disabled");
                obj.value = "获取验证码";
                countdown = 60;
                return;
            } else {
                obj.setAttribute("disabled", true);
                obj.value = "重新发送(" + countdown + ")";
                countdown--;
            }
            setTimeout(function () {
                    settime()
                }
                , 1000)
        }
    </script>
</head>
<body>
<%@ include file="firstPage.jsp"%>
<div class="content content-nav-base  login-content">
    <div class="login-bg">
        <div class="login-cont w1200">
            <div class="form-box">
                <form class="layui-form" action="EnterServlet?op=add" method="post">
                    <legend>用户注册</legend>
                    <div class="layui-form-item">
                        <div class="layui-inline iphone">
                            <div class="layui-input-inline">
                                <i class="layui-icon layui-icon-cellphone iphone-iconuser"></i>
                                <i class="layui-icon layui-icon-cellphone iphone-iconphone"></i>
                                <i class="layui-icon layui-icon-cellphone iphone-iconpwd"></i>
                                <i class="layui-icon layui-icon-cellphone iphone-iconrpwd"></i>
                                <input type="text"  name="user" id="user"  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input"><span>&nbsp;</span>
                                <input type="password"  name="pwd" id="pwd" lay-verify="required"  placeholder="请输入密码" autocomplete="off" class="layui-input"><span>&nbsp;</span>
                                <input type="password"  name="rpwd" id="rpwd" lay-verify="required" placeholder="请再次输入密码" autocomplete="off" class="layui-input"><span id="rpwdmsg">&nbsp;</span>
                                <input type="tel"  name="phone" id="phone" lay-verify="required|phone" placeholder="请输入手机号" autocomplete="off" class="layui-input"><span id="phonemsg"></span>
                            </div>
                        </div>
                        <div class="layui-inline veri-code">
                            <div class="layui-input-inline">
                                <input id="pnum" type="text" name="pnum" lay-verify="required" placeholder="请输入验证码" autocomplete="off" class="layui-input">
                                <input type="button" class="layui-btn" id="find"  value="验证码" onclick="settime()"/><span id="phonemge"></span><br/>
                            </div>
                        </div>
                        <input type="text"  name="name" id="name"  lay-verify="required" placeholder="请输入真实姓名" autocomplete="off" class="layui-input"><span>&nbsp;</span>
                        <input type="pwd" maxlength="18" name="code_id" id="code_id" lay-verify="required"  placeholder="请输入身份证号" autocomplete="off" class="layui-input"><span id="codemsg">&nbsp;&nbsp;&nbsp;</span><br/>
                        <input type="radio" name="grend" checked value="男" />男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="grend" value="女"/>女
                    </div>
                    <div class="layui-form-item login-btn">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit="" lay-filter="demo1">注册</button>
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