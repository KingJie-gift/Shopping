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
    <script type="text/javascript">
      $(function () {
        $("form").submit(function () {
          var obj = document.getElementsByName("address");
          var flags = false;
          for(var i=0; i<obj.length; i ++){
            if(obj[i].checked==true){
              flags = true;
            }
          }
          if (flags == false)
          {
            alert("对不起，请选择地址")
            return false;
          }
        })
      })
    </script>
    <form action="BuyServlet?op=add&comm=${comm.commodity_info_id}" method="post">
    <div class="cart w1200">
      <div style="border: #3F3F3F">
        <p style="font-size: 18px">请选择地址</p>
        <hr/>
        <c:forEach var="i" items="${address}">
          <p style="border: red;margin-right: 10px"><input type="radio"  name="address" class="address" <c:if test="${i.address_default==1}">checked</c:if> value="${i.address_id}"/>${i.address_detalied}</p><br/>
        </c:forEach>
        <hr/>
        <script type="text/javascript">
          function address(){
            location.href="address.jsp";
            <c:remove  var="addressPage"  scope="session"  />
            <c:set  var="addressPage"  value="address"  scope="session"  />
          }
        </script>
        <p style="margin-bottom: 10px"><a href="#" onclick="address()">添加地址</a></p>
        <hr/>
      </div>
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
        <div class="th th-op">
          <div class="th-inner">

          </div>
        </div>  
      </div>

      <div class="OrderList">
        <div class="order-content" id="list-cont">
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
                  <a href="javascript:;"><img src="res/static/img/paging_img1.jpg" alt=""></a>
                  <div class="text">
                    <div class="title">${comm.commodity_info_name}</div>
                    <p>${ab.abapt_name}</p>
                    <input type="hidden" name="type" value="${ab.abapt_id}"/>
                  </div>
                </div>
              </li>
              <li class="th th-price">
                <span class="th-su">${comm.commodity_info_money}</span>
              </li>
              <li class="th th-amount">
                <div class="box-btn layui-clear">
                  <div class="less layui-btn">-</div>
                  <input class="Quantity-input" type="" name="" value="${num}" disabled="disabled">
                  <div class="add layui-btn">+</div>
                </div>
              </li>
              <li class="th th-sum">
                <span class="sum">${comm.commodity_info_money*num}</span>
              </li>
              <li class="th th-op">
                <a href="ShopcartServlet?op=del&sid="></a>
              </li>
            </ul>
        </div>
      </div>

      <div class="FloatBarHolder layui-clear">
        <div class="th th-chk">
          <div class="select-all">
            <div class="cart-checkbox">
              <input class="check-all check" id="" name="select-all" type="hidden"  value="true">
            </div>
            <label>&nbsp;&nbsp;已选<span  class="Selected-pieces">0</span>件</label>
              <input type="hidden" name="commSum" class="Selected-pieces" value="" />
          </div>
        </div>
        <div class="th batch-deletion">
          <span class="batch-dele-btn"></span>
        </div>
        <div class="th Settlement">
          <button class="layui-btn" id="bycomm">结算</button>
        </div>
        <div class="th total">
          <p>应付：<span class="pieces-total" id="money" name="money">0</span></p>
            <input type="hidden" name="commMoney" class="Selected-pieces" value="" />
        </div>
      </div>
    </div>
      </form>
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


});
</script>
</body>
</html>