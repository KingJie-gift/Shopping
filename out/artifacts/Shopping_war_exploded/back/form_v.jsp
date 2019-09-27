<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="description" content="Reflect Template" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
        <title></title>
        <script src="js/jquery-1.12.4.js"></script>
    </head>
    
    <body>
				                <form method="post" action="Commodity_infoServlet2L?op=updateShow&id=${comm_id}">
							    	<table>
							    	<tr>
							    		<td>
							    		  <!-- 配置文件 -->
										    <script type="text/javascript" src="utf8-jsp/ueditor.config.js"></script>
										    <!-- 编辑器源码文件 -->
										    <script type="text/javascript" src="utf8-jsp/ueditor.all.js"></script>
									    	<!-- 加载编辑器的容器 -->
										    <script id="contents" name="content" type="text/plain">
											  ${show.show_info_url}
											</script>
								 			<script type="text/javascript">var ue = UE.getEditor('contents');</script>

								   		</td>
								    </tr>
								    <tr>
									    <td>
									    <input type="submit" value="提交" />
									    </td>
								    </tr>
								    </table>
							    </form>
                        
                        
    </body>
    
</html>