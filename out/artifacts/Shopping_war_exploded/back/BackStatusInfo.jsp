<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="res/static/css/main.css">
    <link rel="stylesheet" type="text/css" href="res/layui/css/layui.css">
    <script type="text/javascript" src="res/layui/layui.js"></script>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <link href="../img/favicon.ico" rel="icon stylesheet bookmark shortcut" type="image/x-icon"/>
    <link rel="shortcut icon stylesheet" href="img/favicon.ico">
    <link rel="bookmark stylesheet" href="img/favicon.ico">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<body>

<div class="content content-nav-base shopcart-content">
    <div class="banner-bg w1200">
        <h3>夏季清仓</h3>
        <p>宝宝被子、宝宝衣服3折起</p>
    </div>
    <div class="cart w1200">
        <div class="cart-table-th">
            <div class="th th-chk">
                <div class="select-all">
                    <div class="cart-checkbox">
                        <input class="check-all check" id="allCheckked" type="hidden" value="true">
                    </div>
                    <label>&nbsp;</label>
                </div>
            </div>
            <div class="th th-item">
                <div class="th-inner">
                    商品
                </div>
            </div>
            <div class="th th-price">
                <div class="th-inner">
                    总价格
                </div>
            </div>
            <div class="th th-amount">
                <div class="th-inner">
                    数量
                </div>
            </div>
            <div class="th th-sum">
                <div class="th-inner">
                    地址
                </div>
            </div>
            <div class="th th-op">
                <div class="th-inner">
                    状态
                </div>
            </div>
        </div>
        <div class="OrderList">
            <div class="order-content" id="list-cont">
                <c:forEach var="i" items="${buy}" varStatus="in">
                    <ul class="item-content layui-clear">
                        <li class="th th-chk">
                            <div class="select-all">
                                <div class="cart-checkbox">
                                    <input class="CheckBoxShop check"  type="hidden" num="all" name="select-all" value="true">
                                </div>
                            </div>
                        </li>
                        <li class="th th-item">
                            <div class="item-cont">
                                <a href="javascript:;"><img src="${buyImg[in.index].show_info_url}" alt=""></a>
                                <div class="text">
                                    <div class="title">${i.commodity.commodity_info_name}</div>
                                    <p>${i.abapt_id.abapt_name}</p>
                                </div>
                            </div>
                        </li>
                        <li class="th th-price">
                            <span class="th-su">${i.buyshow_price}</span>
                        </li>
                        <li class="th th-amount">
                            <div class="box-btnx layui-clear">
                                <div  style="margin-right: 10px"></div>
                                &nbsp;&nbsp;&nbsp;&nbsp;<input class="Quantity-input"  style="border: none;color: black" type="" name="" value="${i.buyshow_count}" disabled="disabled">
                            </div>
                        </li>
                        <li class="th th-sum">
                            <span class="spanx">${i.buy.address.address_detalied}</span>
                        </li>
                        <li class="th th-op" style="color: red;font-size: 18px">
                            <c:choose>
                                <c:when test="${i.buy.bug_type==0}">
                                    未发货
                                </c:when>
                                <c:when test="${i.buy.bug_type==1}">
                                    发货
                                </c:when>
                                <c:when test="${i.buy.bug_type==2}">
                                    派送中
                                </c:when>
                                <c:when test="${i.buy.bug_type==3}">
                                    未签收
                                </c:when>
                                <c:when test="${i.buy.bug_type==4}">
                                    签收
                                </c:when>
                            </c:choose>

                        </li>
                    </ul>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    layui.config({
        base: 'res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
    }).use(['mm','jquery','element','car'],function(){
        var mm = layui.mm,$ = layui.$,element = layui.element,car = layui.car;

        // 模版导入数据
        // var jsp = demo.innerjsp,
        // listCont = document.getElementById('list-cont');
        // mm.request({
        //   url: 'json/shopcart.json',
        //   success : function(res){
        //     listCont.innerjsp = mm.renderjsp(jsp,res)
        //     element.render();
        //     car.init()
        //   },
        //   error: function(res){
        //     console.log(res);
        //   }
        // })
        //
        car.init();
    });
</script>
</body>
</html>