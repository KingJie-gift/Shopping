<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="res/static/css/main.css">
    <link rel="stylesheet" type="text/css" href="res/layui/css/layui.css">
    <script type="text/javascript" src="res/layui/layui.js"></script>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<c:if test="${comm==null}">
    <script type="text/javascript">location.href = 'InitServlet?op=findShow&pg=index.jsp';</script>
</c:if>
<body id="list-cont">
<%--<div class="site-nav-bg">--%>
<%--    <div class="site-nav w1200">--%>
<%--        <p class="sn-back-home">--%>
<%--            <i class="layui-icon layui-icon-home"></i>--%>
<%--            <a href="index.jsp">首页</a>--%>
<%--        </p>--%>
<%--        <div class="sn-quick-menu">--%>
<%--            <div class="login"><a href="logup.jsp">注册</a></div>--%>
<%--            <c:choose>--%>
<%--                <c:when test="${e==null}"><div class="login"><a href="login.jsp">登录</a></div></c:when>--%>
<%--                <c:when test="${e!=null}">欢迎你，<span style="color: red">${e.enter_name}</span>--%>
<%--                    <div class="sp-cart"><a href="shopcart.jsp">购物车</a><span>${shop.size()}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>--%>
<%--                    <div class="sp-cart"><a href="collect.jsp">收藏</a><span>${collects.size()}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>--%>
<%--                    <div class="sp-cart"><a href="byShow.jsp">已购买</a><span>${buy.size()}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>--%>
<%--                </c:when>--%>
<%--            </c:choose>--%>

<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%@ include file="firstPage.jsp"%>
<div class="content">
    <%@ include file="title.jsp"%>
    <div class="category-con">
        <div class="category-inner-con w1200">
            <div class="category-type">
                <h3>全部分类</h3>
            </div>
            <div class="category-tab-content">
                <div class="nav-con">
                    <ul class="normal-nav layui-clear">
                        <c:forEach var="i" items="${comm}" varStatus="in">
                            <li class="nav-item">
                                <div class="title" onclick=""><a href="Commodity_infoServlet?op=group&pgax=commodity.jsp&paent_id=${i.commodity_id}">${i.commodity_name}</a></div>
                                <p>
                                        <%--                    如果我们的下表使用[进行表示下标]   如果是类型我们使用comm进行表示--%>

                                    <c:forEach var="j" items="${small[in.index]}">
                                        <a href="Commodity_infoServlet?op=group&pgax=commodity.jsp&comm_id=${j.commodity_small_id}">${j.commodity_small_name}</a>
                                    </c:forEach>
                                </p>
                                <i class="layui-icon layui-icon-right"></i>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <div class="category-banner">
            <div class="w1200">
                <img src="res/static/img/banner1.jpg">
            </div>
        </div>
    </div>
    <div class="floors">
        <div class="sk">
            <div class="sk_inner w1200">
                <div class="sk_hd">
                    <a href="javascript:;">
                        <img src="res/static/img/s_img1.jpg">
                    </a>
                </div>
                <div class="sk_bd">
                    <div class="layui-carousel" id="test1">
                        <div carousel-item>
                            <c:forEach var="i" items="${time}" varStatus="in">
                              <c:if test="${in.index%4==0}">
                                <div class="item-box">
                              </c:if>
                                    <div class="item">
                                        <a href="Commodity_infoServlet?op=show&sid=${i.commodity_info_id}"><img src="${timeImage[in.index].show_info_url}"></a>
                                        <div class="title">${i.commodity_info_name}...</div>
                                        <div class="price">
                                            <span>￥${i.commodity_info_money}</span>
                                            <del>￥${i.commodity_info_Jmoney}</del>
                                        </div>
                                    </div>
                              <c:if test="${(in.index+1)/4==1||(in.index+1)/4==2}">
                                  </div>
                              </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="hot-recommend-con">
        <div class="tlinks">Collect from <a href="http://www.cssmoban.com/">网页模板</a></div>
        <div class="hot-con1 w1200 layui-clear">
            <div class="item">
                <h4>热销推荐</h4>
                <div class="big-img">
                    <a href="Commodity_infoServlet?op=show&sid=${zong[0].commodity_info_id}"><img width="330px" height="260px" src="${zongImg[0].show_info_url}"></a>
                </div>
                <div class="small-img">
                    <a href="Commodity_infoServlet?op=show&sid=${zong[1].commodity_info_id}"><img width="330px" height="105px" src="${zongImg[1].show_info_url}" alt=""></a>
                </div>
            </div>
            <div class="item">
                <div class="top-img">
                    <a href="Commodity_infoServlet?op=show&sid=${zong[2].commodity_info_id}"><img width="330px" height="230px" src="${zongImg[2].show_info_url}"></a>
                </div>
                <div class="bottom-img">
                    <a href="Commodity_infoServlet?op=show&sid=${zong[3].commodity_info_id}"><img width="160px" height="190px" src="${zongImg[3].show_info_url}"></a>
                    <a class="baby-cream" href="Commodity_infoServlet?op=show&sid=${zong[4].commodity_info_id}"><img width="160px" height="190px" src="${zongImg[4].show_info_url}"></a>
                </div>
            </div>
            <div class="item item1 margin0 padding0">
                <a href="Commodity_infoServlet?op=show&sid=${zong[5].commodity_info_id}"><img width="370px" height="230px" src="${zongImg[5].show_info_url}"></a>
                <a href="Commodity_infoServlet?op=show&sid=${zong[6].commodity_info_id}"><img width="370px" height="230px" class="btm-img" src="${zongImg[6].show_info_url}"></a>
            </div>
        </div>
    </div>


    <div class="product-cont w1200" id="product-cont">
        <div class="product-item product-item1 layui-clear">
            <div class="left-title">
                <h4><i>1F</i></h4>
                <img src="res/static/img/icon_gou.png">
                <h5>儿童奶粉</h5>
            </div>
            <div class="right-cont">
                <a href="javascript:;" class="top-img"><img src="res/static/img/img12.jpg" alt=""></a>
                <div class="img-box">
                    <c:forEach var="i" items="${nai}" varStatus="in">
                        <a href="Commodity_infoServlet?op=show&sid=${i.commodity_info_id}"><img src="${naiImg[in.index].show_info_url}"></a>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="product-item product-item2 layui-clear">
            <div class="left-title">
                <h4><i>2F</i></h4>
                <img src="res/static/img/icon_gou.png">
                <h5>儿童玩具</h5>
            </div>
            <div class="right-cont">
                <a href="javascript:;" class="top-img"><img src="res/static/img/img12.jpg" alt=""></a>
                <div class="img-box">
                    <c:forEach var="i" items="${wan}" varStatus="in">
                        <a href="Commodity_infoServlet?op=show&sid=${i.commodity_info_id}"><img src="${wanImg[in.index].show_info_url}"></a>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="product-item product-item3 layui-clear">
            <div class="left-title">
                <h4><i>3F</i></h4>
                <img src="res/static/img/icon_gou.png">
                <h5>儿童童衣</h5>
            </div>
            <div class="right-cont">
                <a href="javascript:;" class="top-img"><img src="res/static/img/img12.jpg" alt=""></a>
                <div class="img-box">
                    <c:forEach var="i" items="${yi}" varStatus="in">
                        <a href="Commodity_infoServlet?op=show&sid=${i.commodity_info_id}"><img src="${yiImg[in.index].show_info_url}"></a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

    <div class="product-list-box" id="product-list-box">
        <div class="product-list-cont w1200">
            <h4>更多推荐</h4>
            <div class="product-item-box layui-clear">

                <%--   列    5
                行    6       --%>
                <c:forEach var="i" items="${recommend}" varStatus="in">
                    <div class="list-item">
                        <a href="Commodity_infoServlet?op=show&sid=${i.commodity_info_id}">
                        <img width="190px" height="190px" src="${recommendImage[in.index].show_info_url}"></a>
                        <p>${i.commodity_info_name}...</p>
                        <span>￥${i.commodity_info_money}</span>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<div class="footer">
    <div class="ng-promise-box">
        <div class="ng-promise w1200">
            <p class="text">
                <a class="icon1" href="javascript:;">7天无理由退换货</a>
                <a class="icon2" href="javascript:;">满99元全场免邮</a>
                <a class="icon3" style="margin-right: 0" href="javascript:;">100%品质保证</a>
            </p>
        </div>
    </div>
    <div class="mod_help w1200">
        <p>
            <a href="javascript:;">关于我们</a>
            <span>|</span>
            <a href="javascript:;">帮助中心</a>
            <span>|</span>
            <a href="javascript:;">售后服务</a>
            <span>|</span>
            <a href="javascript:;">母婴资讯</a>
            <span>|</span>
            <a href="javascript:;">关于货源</a>
        </p>
        <p class="coty">母婴商城版权所有 &copy; 2012-2020 More Templates <a href="http://www.cssmoban.com/" target="_blank"
                                                                    title="模板之家">模板之家</a> - Collect from <a
                href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
    </div>
</div>
<script type="text/javascript">

    layui.config({
        base: 'res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
    }).use(['mm', 'carousel'], function () {
        var carousel = layui.carousel,
            mm = layui.mm;
        var option = {
            elem: '#test1'
            , width: '100%' //设置容器宽度
            , arrow: 'always'
            , height: '298'
            , indicator: 'none'
        }
        carousel.render(option);
        // 模版引擎导入
        // var ins = carousel.render(option);
        // var jsp = demo.innerjsp;
        // var listCont = document.getElementById('list-cont');
        // // console.log(layui.router("#/about.jsp"))
        //  mm.request({
        //    url: 'json/index.json',
        //    success : function(res){
        //      console.log(res)
        //      listCont.innerjsp = mm.renderjsp(jsp,res)
        //      ins.reload(option);
        //    },
        //    error: function(res){
        //      console.log(res);
        //    }
        //  })
   });
</script>
</body>
</html>