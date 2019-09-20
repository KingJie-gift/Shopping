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
<body>
<script src="js/jquery-1.12.4.js" type="text/javascript"></script>
<script src="back/js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
  $(function () {
    $(".color-cont span").click(function () {
      $(this).attr("class","btn active");
      $(this).siblings().removeAttr("class","btn active")
      $(this).siblings().attr("class","btn")
    });
    var flag = false;
    var type = "";
    $("#shopp").click(function () {
        $(".color-cont span").each(function (index,dom) {
            var cl = $(dom).attr("class");
            if(cl=="btn active"){
                type =  $(dom).attr("name");
                flag = true;
                return;
            }
        });
        if(flag == false){
            alert("请选择")
            return;
        }
        var num = $("#num").val();
        $.post("ShopcartServlet",{op:"addshop",shoid:${comm.commodity_info_id},type:type,num:num},function (data) {
            location.href = 'ShopcartServlet?op=show';
        });
    });
    $("#ok").click(function () {
        $(".color-cont span").each(function (index,dom) {
            var cl = $(dom).attr("class");
            if(cl=="btn active"){
                type =  $(dom).attr("name");
                flag = true;
                return;
            }
        });
        if(flag == false){
            alert("请选择")
            return;
        }
        var num = $("#num").val();
        $.post("BuyServlet",{op:"byShow",type:type,num:num,sid:${comm.commodity_info_id}},function (data) {
            if(data=="1"){
                location.href='login.jsp';
            }else {
                location.href = 'byShopping.jsp';
            }
        });
    });
  })

</script>
<%@ include file="firstPage.jsp"%>



<div class="content content-nav-base datails-content">
    <%@ include file="title.jsp"%>
    <div class="data-cont-wrap w1200">
        <div class="crumb">
            <a href="javascript:;">首页</a>
            <span>></span>
            <a href="javascript:;">所有商品</a>
            <span>></span>
            <a href="javascript:;">产品详情</a>
        </div>
        <div class="product-intro layui-clear">
            <div class="preview-wrap">
                <a href="javascript:;"><img width="375px" height="375px" src="${showImage[0].show_info_url}"></a>
            </div>
            <div class="itemInfo-wrap">
                <div class="itemInfo">
                    <div class="title">
                        <h4>${comm.commodity_info_name} </h4>
                        <c:choose>
                            <c:when test="${coll.enter.enter_id==e.enter_id&&coll.commodity.commodity_info_id==comm.commodity_info_id}">
                                <span onclick="location.href='CollectServlet?op=add&sid=${comm.commodity_info_id}&type=2&del=${coll.collect_id}'"><i class="i layui-icon layui-icon-rate-solid"></i>以收藏</span>
                            </c:when>
                            <c:otherwise>
                                <span onclick="location.href='CollectServlet?op=add&sid=${comm.commodity_info_id}&type=1'"><i class="layui-icon layui-icon-rate-solid"></i>收藏</span>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="summary">
                        <p class="reference"><span>参考价</span>
                            <del>${comm.commodity_info_Jmoney}</del>
                        </p>
                        <p class="activity"><span>活动价</span><strong class="price"><i>￥</i>${comm.commodity_info_money}</strong></p>
                        <p class="address-box"><span>商品总销量</span><strong class="address" style="font-size: 16px;">${comm.commodity_num}</strong>
                        </p>
                    </div>
<%--                    <script type="text/javascript">--%>
<%--                        $(function () {--%>
<%--                            $("#shopp").click(function () {--%>

<%--                            });--%>
<%--                        });--%>
<%--                    </script>--%>
                    <div>
                        <div class="choose-attrs">
                            <div class="color layui-clear"><span class="title">颜&nbsp;&nbsp;&nbsp;&nbsp;色</span>
                                <div class="color-cont">
                                    <c:forEach var="i" items="${applet}">
                                        <span name="${i.abapt_id}" class="btn" >${i.abapt_name}</span>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="number layui-clear"><span class="title">数&nbsp;&nbsp;&nbsp;&nbsp;量</span>
                                <div class="number-cont"><span class="cut btn">-</span><input
                                        onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"
                                        onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"
                                        maxlength="4" type="" name="num" id="num" value="1"><span class="add btn">+</span></div>
                            </div>
                        </div>
                        <div class="choose-btns">
                            <button  class="layui-btn layui-btn-primary purchase-btn" id="ok">立刻购买</button>
                            <button id="shopp" class="layui-btn  layui-btn-da       nger car-btn"><i
                                    class="layui-icon layui-icon-cart-simple"></i>加入购物车
                            </button>
                        </div>
                    </div>
            </div>
        </div>
        <div class="layui-clear">
            <div class="aside">
                <h4>热销推荐</h4>
                <div class="item-list">
                    <c:forEach varStatus="in" items="${shopping}" var="i">
                        <div class="item">
                            <a href="Commodity_infoServlet?op=show&sid=${i.commodity_info_id}"><img width="265px" height="265px" src="${shoppingImg[in.index].show_info_url}"></a>
                            <p><span>${i.commodity_info_name}</span><span class="pric">￥${i.commodity_info_money}</span></p>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="detail">
                <h4>详情</h4>
                <div class="item" style="width: 800px;">
                    <c:if test="${comm.commodity_show!=null}">
                        <p style="font-size: 18px;">宝贝详情</p>
                        <hr/>
                            <div style="font-size: 16px; padding-left: 20px;padding-top: 5px">${sb.toString()}</div>
                        <hr/>
                    </c:if>
                    <c:forEach var="i" items="${showImage}">
                        <img width="800px" src="${i.show_info_url}">
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    layui.config({
        base: 'res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
    }).use(['mm', 'jquery'], function () {
        var mm = layui.mm, $ = layui.$;
        var cur = $('.number-cont input').val();
        $('.number-cont .btn').on('click', function () {
            if ($(this).hasClass('add')) {
                cur++;

            } else {
                if (cur > 1) {
                    cur--;
                }
            }
            $('.number-cont input').val(cur)
        })

    });
</script>
</body>
</html>