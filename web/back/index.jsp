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
<c:if test="${pg==null }">
	<script>
		location.href = "../CounselingServletg";
	</script>
</c:if>


<body>
<div id="top">
            
                <h1 class="logo">
                    
                </h1>
                <div class="head_memberinfo">
                     <div id="head">
                    <span class='memberinfo_span' style="font-size: 30px">
                       欢迎你，管理员
                   </span>
                   </div>
                   </div>
	<div style="height:150px"></div>
	
				
				<table align="center" width="80%" border="1">
					<tr align="center">
						<th>新闻编号</th>
						<th>新闻标题</th>
						<th>发布时间</th>
						<th>新闻画面</th>
						<th>详细内容</th>
						<th>商品操作</th>
					</tr>
					<c:forEach var="p" items="${pg.list}">
						<tr align="center">
							<td>${p.id}</td>
							<td>${p.title}</td>
							<td>${p.datetime}</td>
							<td><c:if test="${p.urlImg!=null}">
									<img src="${p.urlImg}" width="100px" heigth="80px" />
								</c:if></td>

							<td>${p.content}</td>
							<td><a href="CounselingServletg?op=fone&amp;id=${p.id}">修改</a>
								<a href="CounselingServletg?op=delete&amp;id=${p.id}">删除</a></td>
						</tr>
					</c:forEach>
				</table>
				<p align="center">
					<a href="back/add1.jsp">添加新闻信息</a>
					<a href="back/home1.jsp">返回</a><a href="back/home1.jsp">返回</a>
				</p>
				<p align="center">
					<a href="CounselingServletg?pageindex=1">首页</a>

					<a
						href="CounselingServletg?pageindex=${pg.pageindex>1?pg.pageindex-1:1}">上一页</a>
					<a
						href="CounselingServletg?pageindex=${pg.pageindex<pg.totalpage?pg.pageindex+1:pg.totalpage}">下一页</a>
					<a href="CounselingServletg?pageindex=${pg.totalpage}">末页</a> 当前第
					${pg.pageindex} 页/共 ${pg.totalpage} 页
				</p>
				</div>
</body>
</html>
