<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="img/favicon.ico" rel="icon stylesheet bookmark shortcut" type="image/x-icon"/>
    <link rel="shortcut icon stylesheet" href="img/favicon.ico">
    <link rel="bookmark stylesheet" href="img/favicon.ico">
</head>
<body>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
    $("inner-cont2 a").click(
        function () {
            $(this).attr("class","active");
            $(this).siblings().removeAttr("class","active");
        }
    );
</script>
<div class="main-nav">
    <div class="inner-cont0">
        <div class="inner-cont1 w1200">
            <div class="inner-cont2">
                <a href="Commodity_infoServlet?op=group&pgax=commodity.jsp&type=1">所有商品</a>
                <a href="Commodity_infoServlet?op=group&pgax=buytoday.jsp&day=1">今日团购</a>
                <a href="CounselingServlet?op=sel">母婴资讯</a>
                <a href="about.jsp">关于我们</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
