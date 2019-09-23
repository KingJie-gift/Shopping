<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/distpicker/2.0.3/distpicker.js"></script>
    <link href="img/favicon.ico" rel="icon stylesheet bookmark shortcut" type="image/x-icon"/>
    <link rel="shortcut icon stylesheet" href="img/favicon.ico">
    <link rel="bookmark stylesheet" href="img/favicon.ico">
</head>
<body style="background:url(content/background.jpg)">
<div>
    <form method="post" action="AddressServlet?op=add&page=${addressPage}" style="margin-left: 230px" >
        <p>姓名<input name="name" type="text" /></p>
        <div data-toggle="distpicker" data-autoselect="3" data-province="江苏省">
            <select name="city"></select>
            <select name="city"></select>
            <select name="city"></select>
        </div>
        <p>详细地址<input type="text" name="address"></p>
        <p>手机号<input name="phone" type="text"></p>
        <p>邮编<input type="number" name="code"></p>
        <p><input type="checkbox" name="default"/>选择使用默认地址</p>
        <p><input type="submit" value="提交"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"/>
            <input type="reset" onclick="window.close()" value="取消"/></p></p>
    </form>
</div>
</body>
</html>
