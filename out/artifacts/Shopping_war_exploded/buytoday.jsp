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
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<body>
  <c:if test="${pg==null}">
    <script type="text/javascript">location.href='Commodity_infoServlet?op=group';</script>
  </c:if>
  <div class="site-nav-bg">
    <div class="site-nav w1200">
      <p class="sn-back-home">
        <i class="layui-icon layui-icon-home"></i>
        <a href="index.jsp">首页</a>
      </p>
      <div class="sn-quick-menu">
        <div class="login"><a href="logup.jsp">登录</a></div>
        <div class="sp-cart"><a href="shopcart.jsp">购物车</a><span>2</span></div>
      </div>
    </div>
  </div>



  <div class="header">
    <div class="headerLayout w1200">
      <div class="headerCon">
        <h1 class="mallLogo">
          <a href="#" title="母婴商城">
            <img src="res/static/img/logo.png">
          </a>
        </h1>
        <div class="mallSearch">
          <form action="" class="layui-form" novalidate>
            <input type="text" name="title" required  lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入需要的商品">
            <button class="layui-btn" lay-submit lay-filter="formDemo">
                <i class="layui-icon layui-icon-search"></i>
            </button>
            <input type="hidden" name="" value="">
          </form>
        </div>
      </div>
    </div>
  </div>


  <div class="content content-nav-base buytoday-content">
    <div id="list-cont">
      <div class="main-nav">
        <div class="inner-cont0">
          <div class="inner-cont1 w1200">
            <div class="inner-cont2">
              <a href="commodity.jsp">所有商品</a>
              <a href="buytoday.jsp" class="active">今日团购</a>
              <a href="information.jsp">母婴资讯</a>
              <a href="about.jsp">关于我们</a>
            </div>
          </div>
        </div>
      </div>
      <div class="banner-box">
        <div class="banner"></div>
      </div>
      <div class="product-list-box">
        <div class="product-list w1200">  
          <div class="tab-title">
            <a href="javascript:;" class="active tuang" data-content="tuangou">今日团购</a>
            <a href="javascript:;" data-content="yukao">明日预告</a>
          </div>
          <div class="list-cont" cont = 'tuangou'>
            <div class="item-box layui-clear">
              <c:forEach var="i" items="${pg.list}" varStatus="in" >
                <div class="item">
                  <a href="Commodity_infoServlet?op=show&sid=${i.commodity_info_id}"> <img style="width: 290px;height: 320px;" src="${groupImage[in.index].show_info_url}" alt=""></a>
                  <div class="text-box">
                    <p class="title">${i.commodity_info_name}</p>
                    <p class="plic">
                      <span class="ciur-pic">￥${i.commodity_info_money}</span>
                      <span class="Ori-pic">￥${i.commodity_info_Jmoney}</span>
                      <span class="discount">${code[in.index]}折</span>
                    </p>
                  </div>
                </div>
              </c:forEach>
            </div>
            <style type="text/css">
              #navigation a,#navigation span{
                display: inline-block;
                padding: 5px 8px;
                margin: 0px 3px;
                background: beige;
                border-radius: 98%;
              }
            </style>
            <div style="text-align: center;" id="navigation">
              <a href="Commodity_infoServlet?op=group&pgax=buytoday.jsp&indexPage=1&comm_id=${comm_id}&paent_id=${paent_id}&title=${title}&commType=${commType}&type=${type}&day=${day}">首页</a>
              <a href="Commodity_infoServlet?op=group&pgax=buytoday.jsp&indexPage=${pg.indexPage>1?pg.indexPage-1:1}&comm_id=${comm_id}&paent_id=${paent_id}&title=${title}&commType=${commType}&type=${type}&day=${day}">上一页</a>
              <a href="Commodity_infoServlet?op=group&pgax=buytoday.jsp&indexPage=${pg.indexPage<pg.sumPage?pg.indexPage+1:pg.sumPage}&comm_id=${comm_id}&paent_id=${paent_id}&title=${title}&commType=${commType}&type=${type}&day=${day}">下一页</a>
              <a href="Commodity_infoServlet?op=group&pgax=buytoday.jsp&indexPage=${pg.sumPage}&comm_id=${comm_id}&paent_id=${paent_id}&title=${title}&commType=${commType}&type=${type}&day=${day}">尾页</a>
              <span>当前是第${pg.indexPage}页</span>
              <span>共${pg.sumPage}页</span>
            </div>
          </div>
        </div>  
      </div>
      <div class="footer-wrap">
        <div class="footer w1200">
          <div class="title">
            <h3>明日预告</h3>
          </div>
          <div class="list-box layui-clear" id="footerList">
            <c:forEach var="i" items="${dayShow}" varStatus="in">
              <div class="item">
                <a href="Commodity_infoServlet?op=show&sid=${i.commodity_info_id}"><img style="width: 320px;height: 390px;" src="${dayShowImage[in.index].show_info_url}" alt=""></a>
                <div class="text">
                  <div class="right-title-number">${in.index+1}</div>
                  <div class="commod">
                    <p>${i.commodity_info_name}</p>
                    <span>￥${i.commodity_info_money}</span>
                  </div>
                </div>
              </div>
            </c:forEach>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- 模版引擎导入 -->
 <!--  <script type="text/jsp" id="demo">
    <div class="main-nav">
      <div class="inner-cont0">
        <div class="inner-cont1 w1200">
          <div class="inner-cont2">
            <a href="commodity.jsp">所有商品</a>
            <a href="buytoday.jsp" class="active">今日团购</a>
            <a href="information.jsp">母婴资讯</a>
            <a href="about.jsp">关于我们</a>
          </div>
        </div>
      </div>
    </div>
    <div class="banner-box">
      <div class="banner"></div>
    </div>
    <div class="product-list-box">
      <div class="product-list w1200">  
        <div class="tab-title">
          <a href="javascript:;" class="active tuang">今日团购</a>
          <a href="javascript:;">明日预告</a>
        </div>
        <div class="list-cont">
          <div class="item-box layui-clear">
              {{# layui.each(d.productList,function(index,item){}}
              <div class="item">
                <img src="{{item.img}}" alt="">
                <div class="text-box">
                  <p class="title">{{item.title}}</p>
                  <p class="plic">
                    <span class="ciur-pic">{{item.ciurPic}}</span>
                    <span class="Ori-pic">{{item.OriPic}}</span>
                    <span class="discount">{{item.discount}}</span>
                  </p>
                </div>
              </div>
              {{#})}}
          </div>
         <div id="demo0" style="text-align: center;"></div>
        </div>
      </div>  
    </div>
    <div class="footer-wrap">
      <div class="footer w1200">
        <div class="title">
          <h3>团购销量榜</h3>
        </div>
        <div class="list-box layui-clear" id="footerList">
             {{# layui.each(d.footerList,function(index,item){}}
              <div class="item">
                <img src="{{item.img}}" alt="">
                <div class="text">
                  <div class="right-title-number">1</div>
                  <div class="commod">
                    <p>{{item.title}}</p>
                    <span>{{item.price}}</span>
                  </div>
                </div>
              </div>
              {{# });}}
        </div>
      </div>
    </div>
  </script> -->
<script>

  layui.config({
    base: 'res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
  }).use(['mm','laypage','jquery'],function(){
      var laypage = layui.laypage,$ = layui.$;
     mm = layui.mm;
      laypage.render({
        elem: 'demo0'
        ,count: 100 //数据总数
      });


      $('body').on('click','*[data-content]',function(){
        $(this).addClass('active').siblings().removeClass('active')
        var dataConte = $(this).attr('data-content');
        $('*[cont]').each(function(i,item){
          var itemCont = $(item).attr('cont');
          console.log(item)
          if(dataConte === itemCont){
            $(item).removeClass('layui-hide');
          }else{
            $(item).addClass('layui-hide');
          }
        })
      })
    // 模版引擎导入
    //  var jsp = demo.innerjsp;
    //  var listCont = document.getElementById('list-cont');
    //  // console.log(layui.router("#/about.jsp"))
    // mm.request({
    //     url: 'json/buytoday.json',
    //     success : function(res){
    //       console.log(res)
    //       listCont.innerjsp = mm.renderjsp(jsp,res)
    //     },
    //     error: function(res){
    //       console.log(res);
    //     }
    //   })

});
</script>


</body>
</html>