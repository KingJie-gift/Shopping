<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
  <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
  <script type="text/javascript">
    function action(id) {
      location.href='CounselingServlet?op=single&sid='+id;
    }
  </script>
</head>
<body>

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


  <div class="content content-nav-base information-content">
    <div class="main-nav">
      <div class="inner-cont0">
        <div class="inner-cont1 w1200">
          <div class="inner-cont2">
            <a href="commodity.jsp">所有商品</a>
            <a href="buytoday.jsp">今日团购</a>
            <a href="information.jsp"  class="active">母婴资讯</a>
            <a href="about.jsp">关于我们</a>
          </div>
        </div>
      </div>
    </div>
    <div class="info-list-box">
      <div class="info-list w1200">
        <div class="item-box layui-clear" id="list-cont">
      <c:forEach items="${pgc.list}" var="i">
          <div class="item" onclick="action(${i.id})">
            <c:if test="${i.urlImg!=null}">
              <div class="img">
                <img width="260px" height="280px" src="${i.urlImg}" alt="">
              </div>
            </c:if>
            <div class="text">
              <h4>${i.title}</h4>
              <p class="data">${i.datetime}</p>
              <p class="info-cont">${i.content}</p>
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
          <a href="CounselingServlet?op=sel&indexPage=1">首页</a>
          <a href="CounselingServlet?op=sel&indexPage=${pgc.indexPage>1?pgc.indexPage-1:1}">上一页</a>
          <a href="CounselingServlet?op=sel&indexPage=${pgc.indexPage<pgc.sumPage?pgc.indexPage+1:pgc.sumPage}">下一页</a>
          <a href="CounselingServlet?op=sel&indexPage=${pgc.sumPage}">尾页</a>
          <span>当前是第${pgc.indexPage}页</span>
          <span>共${pgc.sumPage}页</span>
        </div>
      </div>
    </div>
  </div>
  <!-- 模版引擎导入 -->
  <!-- <script type="text/jsp" id="demo">
    {{# layui.each(d.listCont,function(index,item){}}
    <div class="item">
      <div class="img">
        <img src="res/img/new1.jpgc" alt="">
      </div>
      <div class="text">
        <h4>周岁内的宝宝消化不良拉肚子怎么办?</h4>
        <p class="data">2016-12-24 16:33:26</p>
        <p class="info-cont">宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子</p>
      </div>
    </div>
    {{# })}}
  </script> -->
<script>
  layui.config({
    base: 'res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
  }).use(['mm','laypage'],function(){
      var
      mm = layui.mm,laypage = layui.laypage;
      laypage.render({
        elem: 'demo0'
        ,count: 100 //数据总数
      });
    // 模版引擎导入
     // var jsp = demo.innerjsp;
     // var listCont = document.getElementById('list-cont');
     //  mm.request({
     //    url: 'json/information.json',
     //    success : function(res){
     //      console.log(res)
     //      listCont.innerjsp = mm.renderjsp(jsp,res)
     //    },
     //    error: function(res){
     //      console.log(res);
     //    }
     //  })   
});

</script>


</body>
</html>