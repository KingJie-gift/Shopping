<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="res/static/css/main.css">
    <link rel="stylesheet" type="text/css" href="res/layui/css/layui.css">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/distpicker/2.0.3/distpicker.js"></script>
    <link href="img/favicon.ico" rel="icon stylesheet bookmark shortcut" type="image/x-icon"/>
    <link rel="shortcut icon stylesheet" href="img/favicon.ico">
    <link rel="bookmark stylesheet" href="img/favicon.ico">
    <script type="text/javascript" src="res/layui/layui.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<body>
<%@ include file="firstPage.jsp"%>
<div class="content content-nav-base  login-content">
    <div class="login-bg">
        <div class="login-cont w1200">
            <style type="text/css">
                input{

                }
                p span{
                    display: inline-block;
                    width: 80px;
                    font-size: 16px;
                    padding-right: 16px;
                }
                #ye span{
                    display: inline-block;
                    width: 90px;
                    font-size: 16px;
                    padding-right: 16px;
                }
                p{
                    margin: 13px;
                }
                .i{
                    display: inline-block;

                    margin-top: 10px;
                    padding: 6px;
                }
                .city{
                    margin-left:80px;
                }
            </style>
            <div class="form-boxs">
                <form method="post" action="AddressServlet?op=add&page=${addressPage}" >
                    <p><span>姓名</span><input name="name" type="text" lay-verify="required" required/></p>
                        <div id="ye" data-toggle="distpicker" data-autoselect="3" data-province="江苏省">
                    <span> 请选择城市</span>
                            <select name="city" style="width: 178px;text-align: center"></select>
                            <select class="city" name="city"></select>
                            <select name="city"></select>
                        </div>
                    </p>
                    <p><span>详细地址</span><input required lay-verify="required" type="text" name="address"></p>
                    <p><span>手机号</span><input required lay-verify="required|phone" name="phone" type="text"></p>
                    <p><span>邮编</span><input type="number" name="code"></p>
                    <p style="color: red"><input  type="checkbox" name="default"/>选择使用默认地址</p>
                    <p><input  class="i" type="submit" value="保存"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="i" type="reset" value="清空"/>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" class="i" onclick="history.back(-1)" value="取消"/></p>
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
<script type="text/javascript">
    $("#find").click(function() {
        if(!/^1\d{10}$/.test($("#phone").val())){
            layer.msg("请输入正确的手机号");
            return false;
        }
        var obj=this;
        $.ajax({
            type:"get",
            url:"json/login.json",
            dataType:"json",//返回的
            success:function(data) {

                if(data.result){
                    $("#find").addClass(" layui-btn-disabled");
                    $('#find').attr('disabled',"true");
                    settime(obj);
                    $("#msg").text(data.msg);
                }else{
                    layer.msg(data.msg);
                }
            },
            error:function(msg) {
                console.log(msg);
            }
        });
    })
    var countdown=60;
    function settime(obj) {
        if (countdown == 0) {
            obj.removeAttribute("disabled");
            obj.classList.remove("layui-btn-disabled")
            obj.value="获取验证码";
            countdown = 60;
            return;
        } else {

            obj.value="重新发送(" + countdown + ")";
            countdown--;
        }
        setTimeout(function() {
                settime(obj) }
            ,1000)
    }
</script>
</body>
</html>