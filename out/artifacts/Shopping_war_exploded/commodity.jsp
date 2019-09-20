<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:if test="${comm==null}">
  <script type="text/javascript">location.href='InitServlet?op=findShow&pg=commodity.jsp';</script>
</c:if>
<%@ include file="firstPage.jsp"%>

  <div class="content content-nav-base commodity-content">
    <%@ include file="title.jsp"%>
    <div class="commod-cont-wrap">
      <div class="commod-cont w1200 layui-clear">
        <div class="left-nav">
          <div class="title">所有分类</div>
          <div class="list-box">
            <c:forEach var="i" items="${comm}" varStatus="in">
              <dl>
                <dt><a href="Commodity_infoServlet?op=group&pgax=commodity.jsp&paent_id=${i.commodity_id}">${i.commodity_name}</a></dt>
                      <%--                    如果我们的下表使用[进行表示下标]--%>
                    <c:forEach var="j" items="${small[in.index]}">
                      <dd><a href="Commodity_infoServlet?op=group&pgax=commodity.jsp&comm_id=${j.commodity_small_id}">${j.commodity_small_name}</a></dd>
                    </c:forEach>
              </dl>
            </c:forEach>
          </div>
        </div>
        <div class="right-cont-wrap">
          <div class="right-cont">
            <div class="sort layui-clear">
              <c:if test="${type!=-1}">
                <a <c:if test="${type==1}">class="active"</c:if> href="Commodity_infoServlet?op=group&pgax=commodity.jsp&type=1" event = 'volume'>销量</a>
                <a <c:if test="${type==2}">class="active"</c:if> href="Commodity_infoServlet?op=group&pgax=commodity.jsp&type=2" event = 'price'>价格</a>
                <a <c:if test="${type==3}">class="active"</c:if> href="Commodity_infoServlet?op=group&pgax=commodity.jsp&type=3" event = 'newprod'>新品</a>
              </c:if>
            </div>
            <div class="prod-number">

            </div>
            <div class="cont-list layui-clear" id="list-cont">
              <c:forEach var="i" items="${pg.list}" varStatus="in" >
                <div class="item">
                  <div class="img">
                    <a href="Commodity_infoServlet?op=show&sid=${i.commodity_info_id}"><img width="270px" height="270px" src="${groupImage[in.index].show_info_url}"></a>
                  </div>
                  <div class="text">
                    <p class="title">${i.commodity_info_name}</p>
                    <p class="price">
                      <span class="pri">￥${i.commodity_info_money}</span>
                      <span class="nub">${i.commodity_num}付款</span>
                    </p>
                  </div>
                </div>
              </c:forEach>
            </div>
            <!-- 模版引擎导入 -->
            <!-- <script type="text/jsp" id="demo">
              {{# layui.each(d.menu.milk.content,function(index,item){}}    
                <div class="item">
                  <div class="img">
                    <a href="javascript:;"><img src="{{item.img}}"></a>
                  </div>
                  <div class="text">
                    <p class="title"></p>
                    <p class="price">
                      <span class="pri">{{item.pri}}</span>
                      <span class="nub">{{item.nub}}</span>
                    </p>
                  </div>
                </div>
              {{# }); }}
            </script> -->
            <style type="text/css">
              #comm a,#comm span{
                display: inline-block;
                padding: 5px 8px;
                margin: 0px 3px;
                background: beige;
                border-radius: 98%;
              }
            </style>
            <div id="comm" style="text-align: center;">
              <a href="Commodity_infoServlet?op=group&pgax=commodity.jsp&indexPage=1&comm_id=${comm_id}&paent_id=${paent_id}&title=${title}&commType=${commType}&type=${type}&day=${day}">首页</a>
              <a href="Commodity_infoServlet?op=group&pgax=commodity.jsp&indexPage=${pg.indexPage>1?pg.indexPage-1:1}&comm_id=${comm_id}&paent_id=${paent_id}&title=${title}&commType=${commType}&type=${type}&day=${day}">上一页</a>
              <a href="Commodity_infoServlet?op=group&pgax=commodity.jsp&indexPage=${pg.indexPage<pg.sumPage?pg.indexPage+1:pg.sumPage}&comm_id=${comm_id}&paent_id=${paent_id}&title=${title}&commType=${commType}&type=${type}&day=${day}">下一页</a>
              <a href="Commodity_infoServlet?op=group&pgax=commodity.jsp&indexPage=${pg.sumPage}&comm_id=${comm_id}&paent_id=${paent_id}&title=${title}&commType=${commType}&type=${type}&day=${day}">尾页</a>
              <span>当前是第${pg.indexPage}页</span>
              <span>共${pg.sumPage}页</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<script>

  layui.config({
    base: 'res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
  }).use(['mm','laypage','jquery'],function(){
      var laypage = layui.laypage,$ = layui.$,
     mm = layui.mm;
       laypage.render({
        elem: 'demo0'
        ,count: 100 //数据总数
      });


    // 模版引擎导入
    //  var jsp = demo.innerjsp;
    //  var listCont = document.getElementById('list-cont');
    //  // console.log(layui.router("#/about.jsp"))
    // mm.request({
    //     url: 'json/commodity.json',
    //     success : function(res){
    //       console.log(res)
    //       listCont.innerjsp = mm.renderjsp(jsp,res)
    //     },
    //     error: function(res){
    //       console.log(res);
    //     }
    //   })

    $('.sort a').on('click',function(){
      $(this).addClass('active').siblings().removeClass('active');
    })
    $('.list-box dt').on('click',function(){
      if($(this).attr('off')){
        $(this).removeClass('active').siblings('dd').show()
        $(this).attr('off','')
      }else{
        $(this).addClass('active').siblings('dd').hide()
        $(this).attr('off',true)
      }
    })

});
</script>
</body>
</html>