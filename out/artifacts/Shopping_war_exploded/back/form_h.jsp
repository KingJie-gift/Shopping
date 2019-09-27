<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="description" content="Reflect Template" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
        <title></title>
        <link rel="stylesheet" href="css/style_all.css" type="text/css" media="screen" />
        
        
        
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
       	<style type="text/css">
       		[type=text]
       		{
       		width:800px;
       		}
         </style>
    </head>
    
    <body style="height: 1077px; ">
        <div id="top">
        
            <div id="head">
            	<h1 class="logo">
                	
                </h1>
                
                <div class="head_memberinfo">
                	
                    
                    <span class='memberinfo_span' style="font-size: 30px">
                   		 欢迎您，管理员
                    </span>
                    
                   
                </div><!--end head_memberinfo-->
            
            </div><!--end head-->
           
            	<div id="bg_wrapper">
                
                    <div id="main">
                        <div id="content">
                            <h2 class="jquery_tab_title">商品详情</h2>
                            <form method="post" action="Commodity_infoServlet2L?op=update&id=${find.commodity_info_id }" style="height: 600px; ">
                                <!-- form_h类用于格式化水平排列的表单 -->
                                <table class="form_h">
                                    <tr>
                                        <th>
                                            <label for="name">商品名称</label>
                                        </th>
                                        <td>
                                            <input class="input-flex" type="text" value="${find.commodity_info_name }" name="name" id="name" pattern="[\u4E00-\u9FA5a-zA-Z0-9_]{18,}"/>
                                        </td>
                                    </tr>

                                    <tr>
                                        <th>
                                            <label for="mail">商品价格</label>
                                        </th>
                                        <td>
                                            <input class="input-flex" type="text" value="${find.commodity_info_money }" name="money" id="mail"/>/元
                                        </td>
                                    </tr>

                                    <tr>
                                        <th>
                                            <label for="url">进货价格</label>
                                        </th>
                                        <td>
                                            <input class="input-flex" type="text" value="${find.commodity_info_Jmoney }" name="Jmoney" id="url"/>/元
                                        </td>
                                    </tr>

                                    <tr>
                                        <th>
                                            <label for="flex">产品规格</label>
                                        </th>
                                        <td>
                                            <input class="input-flex" type="text" value="${find.commodity_info_KG }" name="kg" id="flex"/>
                                        </td>
                                    </tr>
				
									<tr>
                                       <th class="vat">
                                           <label for="textarea2">产品描述</label>
                                       </th>
                                       <td>
                                            <script type="text/javascript" charset="utf-8" src="utf8-jsp/ueditor.config.js"></script>
   											<script type="text/javascript" charset="utf-8" src="utf8-jsp/ueditor.all.min.js"></script>
	  										<script type="text/javascript" charset="utf-8" src="utf8-jsp/lang/zh-cn/zh-cn.js"></script>
	  										<script style="margin:0px;" id="showMgr" name="show" type="text/plain">${find.commodity_show}</script>
										    <script type="text/javascript">var ue = UE.getEditor('showMgr');</script>
                                       </td>
                                       
                                   </tr>

									<tr>
                                        <th>
                                            <label for="flex">销售数量</label>
                                        </th>
                                        <td>
                                            <input class="input-flex" type="text" value="${find.commodity_num }" name="num" id="flex"/>/件
                                        </td>
                                    </tr>
									
                                    <tr>
                                        <th>
                                            <label for="date">生产日期</label>
                                        </th>
                                        <td>
                                            <input  class="input-small flexy_datepicker_input" type="text" value="${find.commodity_millyield }" name="flexy_datepicker" id="date" style="width: 325px; "/>
                                        </td>
                                    </tr>
                                   
                                   
                                   
                                   
                                    
                                   <tr>
                                    <th></th>
                                    <td>
                                        <input class="button" name="submit" type="submit" value="确定"/>
                                    </td>
                                </tr>
                            </table>
                         
                        </form>
                        
						    
						    
                        </div>
                       
                        
                    </div><!--end main-->
                    
                    
                        
                     </div><!--end bg_wrapper-->
                     
                <div id="footer">
                
                </div><!--end footer-->
                
        </div><!-- end top -->
        
    </body>
    
</html>