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
    <div class="banner-bg w1200">
      <h3>夏季清仓</h3>
      <p>宝宝被子、宝宝衣服3折起</p>
    </div>
    <script type="text/javascript">
      function address(){
        location.href="address.jsp";
        <c:remove  var="addressPage"  scope="session"  />
        <c:set  var="addressPage"  value="addressout"  scope="session"  />
      }
    </script>
    <p align="center" style="font-size: 18px" onclick="address()">添加地址</a> </p>
    <div class="cart w1200">
      <div class="cart-table-th">
        <div class="th th-chk">
          <div class="select-all">
            <div class="cart-checkbox">
              <input class="check-all check" id="allCheckked" type="hidden" value="true">
            </div>
            <label>&nbsp;&nbsp;</label>
          </div>
        </div>
        <div class="th th-item">
          <div class="th-inner">
            地址
          </div>
        </div>
        <div class="th th-price">
          <div class="th-inner">
            姓名
          </div>
        </div>
        <div class="th th-amount">
          <div class="th-inner">
            手机
          </div>
        </div>
        <div class="th th-sum">
          <div class="th-inner">
            编号
          </div>
        </div>
        <div class="th th-op">
          <div class="th-inner">
            操作
          </div>
        </div>
      </div>
      <div class="OrderList">
        <div class="order-content" id="list-cont">
          <c:forEach var="i" items="${selAddress}" varStatus="in">
            <ul class="item-content layui-clear">
              <li class="th th-chk">
                <div class="select-all">
                  <div class="cart-checkbox">
<%--                    <input class="CheckBoxShop check"  type="hidden" num="all" name="select-all" value="${i.shopcart_id}">--%>
<%--                    <input type="hidden" value="${i.shopcart_id}" name="comm_id" />--%>
                  </div>
                </div>
              </li>
              <li class="th th-item">
                <div class="item-cont">
                  <div class="text">
                    <div class="title">${i.address_detalied}</div>
<%--                    <p>${i.abapt.abapt_name}</p>--%>
<%--                    <input type="hidden" value="${i.abapt.abapt_id}" name="bapt"/>--%>
<%--                    <input type="hidden" value="${in.index}" name="index"/>--%>
                  </div>
                </div>
              </li>
              <li class="th th-price">
                <span class="th-su">${i.address_name}</span>
              </li>
              <li class="th th-amount">
                <div class="box-btn layui-clear" id="xx">
                  <input class="Quantity-input" style="border: none;color: black;padding-left:30px" type="text" value="${i.address_telephone}" name="num" readonly>


                    <%--                    <input type="text" name='commMoney' value="" />--%>
                </div>
              </li>
              <li class="th th-sum">
                <c:if test="${i.address_postal==''}">
                  <span class="sum" style="color: black">  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                </c:if>
                <c:if test="${i.address_postal!=''}">
                  <span class="sum" style="color: black">${i.address_postal}</span>
                </c:if>

              </li>
              <li class="th th-op">
                <a href="AddressServlet?op=del&sid=${i.address_id}">删除</a>
                <a href="AddressServlet?op=update&sid=${i.address_id}">修改</a>
              </li>
            </ul>
          </c:forEach>
        </div>
    </div>
<script type="text/javascript">
  layui.config({
    base: 'res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
  }).use(['mm','jquery','element','car'],function(){
    var mm = layui.mm,$ = layui.$,element = layui.element,car = layui.car;
    car.init();
});
</script>
</body>
</html>