<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>

  </head>
  
  <body>
    <form method="post" action="TestServlet">
    	<!-- 加载编辑器的容器 -->
	    <script id="container" name="content" type="text/plain">
        
    	</script>
	    <!-- 配置文件 -->
	    <script type="text/javascript" src="ueditor.config.js"></script>
	    <!-- 编辑器源码文件 -->
	    <script type="text/javascript" src="ueditor.all.js"></script>
	    <input type="submit" value="提交" />
    </form>
    <!-- 实例化编辑器 -->
    <script type="text/javascript">
        var ue = UE.getEditor('container');
    </script>
</body>
</html>
