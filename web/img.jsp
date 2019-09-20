<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- 加载编辑器的容器 -->
<script id="container" name="content" type="text/plain">

</script>
<!-- 配置文件 -->
<script type="text/javascript" src="ueditor1_4_3_3-utf8-jsp/utf8-jsp/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="ueditor1_4_3_3-utf8-jsp/utf8-jsp/ueditor.all.js"></script>
<input type="submit" value="提交" />
</form>
<!-- 实例化编辑器 -->
<script type="text/javascript">
    var ue = UE.getEditor('container');
</script>
</body>
</html>
