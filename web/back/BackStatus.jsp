<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="description" content="Reflect Template" />
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    <title>首页</title>
    <link rel="stylesheet" href="css/style_all.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="css/style8.css" type="text/css" media="screen" />

    <link rel="stylesheet" href="css/jquery-ui.css" type="text/css" media="screen" />

    <link rel="stylesheet" href="ueditor1_2_2_0-utf8-php/themes/default/ueditor.css" type="text/css" media="screen" />

    <script type='text/javascript' src='js/all-ck.js'></script>
    <script type='text/javascript' src='ueditor1_2_2_0-utf8-php/editor_config.js'></script>
    <script type='text/javascript' src='js/custom.js'></script>
</head>

<c:if test="${pgax==null}">
    <script>location.href="../BackStatusServletw?op=sel";</script>
</c:if>


<body style="height: 1693px; ">
<div id="top">
    <div id="head">
        <h1 class="logo">

        </h1>
        <div class="head_memberinfo">

                    <span class='memberinfo_span' style="font-size: 30px">
                       欢迎你，管理员
                   </span>

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
                <h2>商品详情</h2>
                <div>
                    <p style="text-align: center;font-size: 18px";>
                        <a href="BackStatusServletw?op=sel&type=0">未发货</a>
                        <a href="BackStatusServletw?op=sel&type=1">发货</a>
                        <a href="BackStatusServletw?op=sel&type=2">派送中</a>
                        <a href="BackStatusServletw?op=sel&type=3">未签收</a>
                        <a href="BackStatusServletw?op=sel&type=4">签收</a>
                        <span onclick="window.open('imgInfo.jsp','',' width = 800px,height = 700px,top = 200px , left = 400px ')" style="float:right;margin-right: 40px">查看详情</span>
                    </p>
                    <c:choose>
                        <c:when test="${pgax.sumPage==0}">
                            <p style="text-align: center;font-size: 18px"> 此商品以执行完毕</p>
                        </c:when>
                        <c:otherwise>
                            <table width="80%" border="1" align="center">
                                <tr align="center">
                                    <th>商品编号</th>
                                    <th>商品总价格</th>
                                    <th>发货状态</th>
                                    <th>购买时间</th>
                                    <th>购买地址</th>
                                    <th>购买详情</th>
                                    <th>商品状态</th>
                                    <th>修改</th>
                                </tr>
                                <c:forEach var="i" items="${pgax.list}">
                                    <tr align="center">
                                            <%--                                        private int buy_id;//购买记录编号--%>
                                            <%--                                        private Enter enter;//用户表(外键)--%>
                                            <%--                                        private double bug_money;//购买总金额--%>
                                            <%--                                        private int bug_type;//签收状态    0:未发货1:发货2:签收3:未签收4:派送中--%>
                                            <%--                                        private Date buy_date;//购买时间--%>
                                            <%--                                        private Address address;--%>
                                            <%--                                        private int address_id;//地址编号--%>
                                            <%--                                        private Enter enter;//关联用户编号（外键）--%>
                                            <%--                                        private String address_info;//省份/城市/区县/街道--%>
                                            <%--                                        private String address_detalied;//详细地址--%>
                                            <%--                                        private String address_postal;//邮政编码--%>
                                            <%--                                        private String address_name;//收件人姓名--%>
                                            <%--                                        private String address_telephone;//收件人手机号--%>
                                            <%--                                        private int address_default;//默--%>
                                        <td>${i.buy_id}</td>
                                        <td>${i.bug_money}(元)</td>
                                        <td><c:choose>
                                            <c:when test="${i.bug_type==0}">
                                                未发货
                                            </c:when>
                                            <c:when test="${i.bug_type==1}">
                                                发货
                                            </c:when>
                                            <c:when test="${i.bug_type==2}">
                                                派送中
                                            </c:when>
                                            <c:when test="${i.bug_type==3}">
                                                未签收
                                            </c:when>
                                            <c:when test="${i.bug_type==4}">
                                                签收
                                            </c:when>
                                        </c:choose>
                                        </td>
                                        <td>${i.buy_date}</td>
                                        <td>姓名${i.address.address_name}&nbsp;&nbsp;&nbsp;&nbsp;地址${i.address.address_detalied}&nbsp;&nbsp;&nbsp;&nbsp;手机号${i.address.address_telephone}</td>
                                        <td onclick="location.href='BackStatusServletw?op=info&sid=${i.buy_id}'">查看详情</td>
                                        <form action="BackStatusServletw?op=update&sid=${i.buy_id}" method="post">
                                            <td>
                                                <select id="pageSizeSelect" name="selxx" onclick="chengx(i.bug_type,this)">
                                                    <option value="0" <c:if test="${i.bug_type==0}">selected</c:if> >未发货</option>
                                                    <option value="1" <c:if test="${i.bug_type==1}">selected</c:if> >发货</option>
                                                    <option value="2" <c:if test="${i.bug_type==2}">selected</c:if> >派送中</option>
                                                    <option value="3" <c:if test="${i.bug_type==3}">selected</c:if> >未签收</option>
                                                    <option value="4" <c:if test="${i.bug_type==4}">selected</c:if> >签收</option>
                                                </select>
                                            </td>
                                            <td><button>修改</button></td>
                                        </form>
                                    </tr>
                                </c:forEach>
                            </table>
                            <p align="center" style="font-size: 18px">
                                <a href="BackStatusServletw?op=sel&indexPage=1&type=${type}">首页</a>
                                <a href="BackStatusServletw?op=sel&indexPage=${pgax.indexPage>1?pgax.indexPage-1:1}&type=${type}">上一页</a>
                                <a href="BackStatusServletw?op=sel&indexPage=${pgax.indexPage<pgax.sumPage?pgax.indexPage+1:pgax.sumPage}&type=${type}">下一页</a>
                                <a href="BackStatusServletw?op=sel&indexPage=${pgax.sumPage}&type=${type}">末页</a>
                                <span>当前是第${pgax.indexPage}</span><span>共${pgax.sumPage}</span>
                            </p>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>

            </div>
            <!--end content-->
        <div id="sidebar">
            <ul >
                <li><a class="headitem item1" href="#">商品管理</a>
                    <ul><!-- ul items without this class get hiddden by jquery-->
                        <li><a href="back/home1.jsp">奶粉管理</a></li>
                        <li><a href="back/home.jsp">玩具管理</a></li>
                        <li><a href="back/home2.jsp">童衣管理</a></li>
                        <li><a href="back/home3.jsp">其他管理</a></li>
                        <li><a href="back/home4.jsp">条件查询</a></li>
                        <li><a href="back/update.jsp">商品上架</a></li>
                    </ul>
                </li>
                <li><a class="headitem item2" href="#">商品添加</a>
                    <ul><!-- ul items without this class get hiddden by jquery-->
                        <li><a href="addSeervletL">商品添加</a></li>
                        <li><a href="back/brand.jsp">品牌添加</a></li>
                        <li><a href="back/sjupdate.jsp">品牌上架</a></li>
                        <li><a href="Commodity_smallServletL">种类添加</a></li>
                    </ul>
                </li>
                <li><a class="headitem item2" href="#">订单状态</a>
                    <ul><!-- ul items without this class get hiddden by jquery-->
                        <li><a href="back/BackStatus.jsp">订单查看</a></li>
                    </ul>
                </li>

            </ul><!--end subnav-->

            <div ></div>



        </div>
        </div><!--end main-->


        <!--end sidebar-->

    </div><!--end bg_wrapper-->

    <div id="footer" style="color: #fff;text-align: center">

    </div><!--end footer-->

</div><!-- end top -->

</body>

</html>




