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
  <link href="img/favicon.ico" rel="icon stylesheet bookmark shortcut" type="image/x-icon"/>
  <link rel="shortcut icon stylesheet" href="img/favicon.ico">
  <link rel="bookmark stylesheet" href="img/favicon.ico">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<body>

<%@ include file="firstPage.jsp"%>

  <div class="content content-nav-base shopcart-content">
    <%@ include file="title.jsp"%>
    <div class="banner-bg w1200">
      <h3>夏季清仓</h3>
      <p>宝宝被子、宝宝衣服3折起</p>
    </div>

      <div class="OrderList">
        <c:choose>
          <c:when test="${shop.size()==0}">
            <p style="text-align: center;font-size: 26px;" onclick="location.href='index.jsp'">购物车没有商品快去看看</p>
            <p style="text-align: center;" onclick="location.href='index.jsp'">
              <img src="img/FFFFFFFF.png">
            </p>
          </c:when>
          <c:otherwise>
          <div class="cart w1200">
            <div class="cart-table-th">
              <div class="th th-chk">
                <div class="select-all">
                  <div class="cart-checkbox">
                    <input class="check-all check" id="allCheckked" type="checkbox" value="true">
                  </div>
                  <label>&nbsp;&nbsp;全选</label>
                </div>
              </div>
              <div class="th th-item">
                <div class="th-inner">
                  商品
                </div>
              </div>
              <div class="th th-price">
                <div class="th-inner">
                  单价
                </div>
              </div>
              <div class="th th-amount">
                <div class="th-inner">
                  数量
                </div>
              </div>
              <div class="th th-sum">
                <div class="th-inner">
                  小计
                </div>
              </div>
              <div class="th th-amount">
                <div class="th-inner">

                </div>
              </div>
              <div class="th th-amount">
                <div class="th-inner">

                </div>
              </div>
              <div class="th th-op">
                <div class="th-inner">
                  操作
                </div>
              </div>
            </div>
            <form action="ShopcartServlet?op=car" method="post">
              <div class="order-content" id="list-cont">
                <c:forEach var="i" items="${shop}" varStatus="in">
                  <ul class="item-content layui-clear">
                    <li class="th th-chk">
                      <div class="select-all">
                        <div class="cart-checkbox">
                          <input class="CheckBoxShop check"  type="checkbox" num="all" name="select-all" value="${i.shopcart_id}">
                          <input type="hidden" value="${i.shopcart_id}" name="comm_id" />
                        </div>
                      </div>
                    </li>
                    <li class="th th-item">
                      <div class="item-cont">
                        <a href="Commodity_infoServlet?op=show&sid=${i.commodity.commodity_info_id}"><img src="${shopImg[in.index].show_info_url}" alt=""></a>
                        <div class="text">
                          <div class="title"><a href="Commodity_infoServlet?op=show&sid=${i.commodity.commodity_info_id}">${i.commodity.commodity_info_name}</a></div>
                          <p>${i.abapt.abapt_name}</p>
                          <input type="hidden" value="${i.abapt.abapt_id}" name="bapt"/>
                          <input type="hidden" value="${in.index}" name="index"/>
                        </div>
                      </div>
                    </li>
                    <li class="th th-price">
                      <span class="th-su">${i.commodity.commodity_info_money}</span>
                    </li>
                    <li class="th th-amount">
                      <div class="box-btn layui-clear" id="xx">
                        <div class="less layui-btn">-</div>
                        <input class="Quantity-input" type="text" value="${i.shopcart_num}" name="num" readonly>
                        <div class="add layui-btn">+</div>


                          <%--                    <input type="text" name='commMoney' value="" />--%>
                      </div>
                    </li>
                    <li class="th th-sum">
                      <span class="sum">${i.commodity.commodity_info_money*i.shopcart_num}</span>
                    </li>
                    <li class="th th-op">
                      <a href="ShopcartServlet?op=del&sid=${i.shopcart_id}">删除</a>
                    </li>
                  </ul>
                </c:forEach>
              </div>
              <div class="FloatBarHolder layui-clear">
                <div class="th th-chk">
                  <div class="select-all">
                    <div class="cart-checkbox">
                      <input class="check-all check" id="" type="hidden"  value="true">
                    </div>
                    <label>&nbsp;&nbsp;已选<span class="Selected-pieces">0</span>件</label>
                  </div>
                </div>
                <div class="th batch-deletion">
                  <span class="batch-dele-btn">批量删除</span>
                </div>
                <div class="th Settlement">
                  <input type="submit" value="结算" style="display: inline-block;width: 160px;background: #ff5500;height: 84px"/>
                </div>
                <div class="th total">
                  <p>应付：<span class="pieces-total">0</span></p>
                </div>
              </div>
            </form>
          </c:otherwise>
        </c:choose>


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
    car.init()

    $("[name='select-all']").click(function () {
      if ($(this).get(0).checked){
        $(this).parents("li").next().find('[name="bapt"]').removeAttr("disabled");
        $(this).parents("li").next().next().next().find('[name="num"]').removeAttr("disabled");
      }else {
        $(this).parents("li").next().find('[name="bapt"]').attr("disabled","disabled");
        $(this).parents("li").next().next().next().find('[name="num"]').attr("disabled","disabled");
      }
    });
});
</script>
</body>
</html>