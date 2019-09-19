<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" type="text/css" href="matter/reset.css">
<link rel="stylesheet" type="text/css" href="matter/main.css">
<body>
<dl class="clearfix g-box-1200">
    <dt class="f-fl m-mianleft">
        <h1>${co.title}</h1>
        <div class="m-mianjianjie ico2">
        </div>
        <dl class="clearfix">
            <dt class="f-fl m-mianfx">
            </dt>
            <dd class="f-fr m-maintxt htmlcontent"> <div>
            <c:if test="${co.urlImg!=null}">
                <div>
                    <img src="${co.urlImg}"></div>
                </div>
                </c:if>
                <div>
                   <p>
                       ${co.content}
                   </p>
                </div>
                <br>
            </dd>
        </dl>
    </dt>
    <dd class="f-fr m-mainright">
        </div>
        <div id="Qright" style="display: none;"><div class="side-catalog" style="display: none; height: 71px; position: fixed; bottom: 200px;"><div class="side-bar" style="height: 71px;"><em class="circle start"></em><em class="circle end"></em></div><div class="catalog-scroller"><dl class="catalog-list"><ul class="culist" qu-top="0"><dt class="catalog-title level1 on"><em class="pointer"></em><span class="text"><a href="javascript:void(0);" class="title-link" onclick="qnlk(&quot;.htmlcontent&quot;)">正文内容</a></span></dt><a class="arrow" href="javascript:void(0);" style="top: 6px;"></a></ul></dl></div><div class="right-wrap" style="display: none;"><a class="go-up disable"></a><a class="go-down"></a></div></div><div id="gotop" style="position: fixed; bottom: 90px;"><a class="nas">0</a><a class="got">1</a><div id="aaaa"></div></div></div></dd>
</dl>
</body>
</html>
