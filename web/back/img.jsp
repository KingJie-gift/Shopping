<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/24
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="description" content="Reflect Template" />
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    <title>表单-字段名水平</title>
    <link rel="stylesheet" href="css/style_all.css" type="text/css" media="screen" />
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>

    <!-- to choose another color scheme uncomment one of the foloowing stylesheets and wrap styl1.css into a comment -->
    <link rel="stylesheet" href="css/style8.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="css/jquery-ui.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="ueditor1_2_2_0-utf8-php/themes/default/ueditor.css" type="text/css" media="screen" />

    <!--Internet Explorer Trancparency fix-->
    <!--[if IE 6]>
    <script src="js/ie6pngfix.js"></script>
    <script>
        DD_belatedPNG.fix('#head, a, a span, img, .message p, .click_to_close, .ie6fix');
    </script>
    <![endif]-->

    <script type='text/javascript' src='js/all-ck.js'></script>
    <script type='text/javascript' src='ueditor1_2_2_0-utf8-php/editor_config.js'></script>
    <script type='text/javascript' src='js/custom.js'></script>
</head>

<body>
<div id="top">

    <div id="head">
        <h1 class="logo">
            <a href=""></a>
        </h1>

        <div class="head_memberinfo">
            <div class="head_memberinfo_logo">
                <span>1</span>
                <img src="images/unreadmail.png" alt=""/>
            </div>

            <span class='memberinfo_span'>
                   		 欢迎 <a href="">管理员</a>
                    </span>

            <span class='memberinfo_span'>
                    	<a href="">设置</a>
                    </span>

            <span>
                    	<a href="login.html">登出</a>
                    </span>

            <span class='memberinfo_span2'>
                    	<a href="">1 条私信</a>
                    </span>
        </div><!--end head_memberinfo-->

    </div><!--end head-->

    <div id="bg_wrapper">

        <div id="main">
            <div id="content">
                <h2 class="jquery_tab_title">水平状的表单</h2>
                <form enctype="multipart/form-data" method="post" action="ShopcartServletL?op=addImg&comm_id_idd=${comm_id_id}">
                    <!-- form_h类用于格式化水平排列的表单 -->
                    <table class="form_h">
                        <tr>
                            <th class="vat">图片</th>
                            <td class="imgUploadManager">
                                <input type="file"  name="xx" id = "update" property="uploadFile" styleClass="upload" multiple="multiple" accept="image/gif, image/jpeg"/>
                                <ul class="imgManage">
                                    <style type="text/css">
                                        img:hover{
                                            transform: scale(2.2);
                                            transition: all 0.6s;
                                        }
                                    </style>
                                    <c:forEach varStatus="in" items="${show}" var="i">
                                        <li style="padding:0px 30px">
                                            <img src="${i.show_info_url}" alt="" width="40px"/>
                                            <a id="del" href="ShopcartServletL?op=delImg&sid=${i.show_info_id}&comm_id_id=${comm_id_id}">删除</a>
                                        </li>
                                    </c:forEach>
                            </td>
                        </tr>
                        <tr>
                            <th></th>
                            <td>
                            </td>
                        </tr>
                    </table>
                    <input type="submit" value="提交"/>
                </form>
            </div>
            <!--end content-->

        </div><!--end main-->


    </div>
</div>
</body>

</html>