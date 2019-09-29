<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="Reflect Template" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>首页</title>
<link rel="stylesheet" href="css/style_all.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="css/style8.css" type="text/css"
	media="screen" />

<link rel="stylesheet" href="css/jquery-ui.css" type="text/css"
	media="screen" />

<link rel="stylesheet"
	href="ueditor1_2_2_0-utf8-php/themes/default/ueditor.css"
	type="text/css" media="screen" />

<script type='text/javascript' src='js/all-ck.js'></script>
<script type='text/javascript'
	src='ueditor1_2_2_0-utf8-php/editor_config.js'></script>
<script type='text/javascript' src='js/custom.js'></script>
</head>

<c:if test="${comm==null }">
	<script>
		location.href = "../CommodityServletZ";
	</script>
</c:if>
<script src="js/jquery-1.8.3.js"></script>
<script>
	$(function() {
	
		var flag = true;
		
		$("[name='name']").blur(function() {
			var name = $(this).val();
			$.post("CommodityServletZ", {
				op : "find",
				name : name
			}, function(data) {
				if (data != 0) {
					alert("该种类已存在");
					flag = false;
				} else {
					flag = true;
				}
			});
		});

		$("form").submit(function() {
				var name = $("[name='name']").val();
				if (name == "") {
					alert("商品种类不能为空");
					flag = false;
				}
				return flag;
			});
           
	});
</script>
<body>
	<div id="top">
		<div id="head">
			<h1 class="logo"></h1>
			<div class="head_memberinfo">

				<span class='memberinfo_span' style="font-size: 30px">
					欢迎你，管理员 </span>

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

					<h2 class="jquery_tab_title">种类</h2>
					<table align="center" width="80%">
						<tr>
							<th>编号</th>
							<th>种类名</th>
							<th>操作</th>
						</tr>
						<c:forEach var="l" items="${comm}">
							<tr>
								<td>${l.commodity_id }</td>
								<td>${l.commodity_name}</td>
								<td>
								<a href="CommodityServletZ?op=fone&id=${l.commodity_id}">修改</a>
								</td>
							</tr>
						</c:forEach>
					</table>

					<h2></h2>
					<div>
						<form action="../CommodityServletZ?op=add" method="post">
							<p>
								<span style="font-size: 14px;font-weight: bolder;">添加商品大种类：</span>
								<input type="text" name="name" style="width: 453px; height: 44px" />
							</p>
							<br />
							<br />
							<p>
								<input type="submit" value="添加种类"
									style="height: 48px; width: 115px" />
							</p>
						</form>

					</div>

				</div>
				<!--end content-->

			</div>
			<!--end main-->

			<div id="sidebar">
				<ul class="nav">
					<li><a class="headitem item1" href="#">商品管理</a>
						<ul>
							<li><a href="back/home1.jsp">首页</a></li>
							<!-- ul items without this class get hiddden by jquery-->
							<li><a href="#">奶粉管理</a></li>
							<li><a href="back/home.jsp">玩具管理</a></li>
							<li><a href="back/home2.jsp">童衣管理</a></li>
							<li><a href="back/home3.jsp">其他管理</a></li>
						</ul></li>
					<li><a class="headitem item2" href="#">商品添加</a>
						<ul>
							<!-- ul items without this class get hiddden by jquery-->
							<li><a href="addSeervlet">商品添加</a></li>

						</ul></li>


				</ul>
				<!--end subnav-->

				<div class="flexy_datepicker"></div>

				<ul>
					<li><a class="headitem item7" href="#">任务管理</a>
						<ul>
							<li><a href="#">写博客</a></li>
							<li><a href="#">脚本页</a></li>
							<li><a href="#">8:00和妹子约会</a></li>
						</ul></li>
				</ul>

			</div>
			<!--end sidebar-->

		</div>
		<!--end bg_wrapper-->

		<div id="footer" style="color: #fff;text-align: center"></div>
		<!--end footer-->

	</div>
	<!-- end top -->

</body>

</html>