<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/distpicker/2.0.3/distpicker.js"></script>
</head>
<body style="background:url(content/background.jpg)">
<div>
    <form method="post" action="AddressServlet?op=updateAddress&sid=${address.address_id}" style="margin-left: 230px" >
        <p>姓名<input name="name" type="text" value="${address.address_name}"/></p>
        <p>详细地址<input type="text" name="address" value="${address.address_detalied}"></p>
        <p>手机号<input name="phone" type="text" value="${address.address_telephone}"></p>
        <p>邮编<input type="number" name="code" value="${address.address_postal}"></p>
        <p><input type="submit" value="提交"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"/>
            <input type="reset" onclick="" value="取消"/></p></p>
    </form>
</div>
</body>
</html>
