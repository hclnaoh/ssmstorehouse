<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>

<!doctype html>
<html>
<head>
    <title>出库订单</title>

    <meta name="viewport" id="viewport" content="initial-scale=1, minimum-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <link href="qtimages/css/index.css" rel="stylesheet">
    <link href="qtimages/css/responsive.css" rel="stylesheet">
    <script type="text/javascript" src="qtimages/js/jquery-1.8.3.min.js"></script>
    <script src="qtimages/js/common.js"></script>
    <script src="qtimages/js/jquery.touchwipe.min.js"></script>
    <script type="text/javascript" src="qtimages/js/jquery.banner.revolution.min.js"></script>
    <script type="text/javascript" src="qtimages/js/banner.js"></script>
    <script type="text/javascript" src="qtimages/js/swiper.scrollbar-1.2.js"></script>
    <script type="text/javascript" src="qtimages/js/swiper-1.9.1.min.js"></script>
    <script type="text/javascript" src="qtimages/js/jquery.fs.boxer.min.js"></script>
    <script type="text/javascript" src="qtimages/js/jquery.slides.min.js"></script>
    <script type="text/javascript" src="qtimages/js/customs.js"></script>
    <script src="qtimages/js/jquery.isotope.min.js"></script>
    <script src="qtimages/js/custom.js"></script>
    <script src="qtimages/js/modernizr.custom.js"></script>
</head>
<script language=javascript src='js/popup.js'></script>
<script language=javascript>
    function hsgpinglun(nbiao,nid){
        popheight=450;
        pop('hsgpinglun.jsp?biao='+nbiao+'&id='+nid,'在线评论',550,250) ;
    }
</script>
<%
    String id=request.getParameter("id");

%>
<body>
<jsp:include page="qttop.jsp"></jsp:include>
<div  class="in_about">
    <div class="container">
        <div class="in_toptt">
            <h1>出库订单</h1>
            <h4>开创独特的人类美好健康生活，从此开始</h4>
        </div>
        <div class="in_aboutcon clearfix">




            <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse"  class="newsline">
                <tr>
                    <td width='11%'>订单编号：</td><td width='39%'>${chukudingdan.dingdanbianhao}</td>
                    <td width='11%'>货物名称：</td><td width='39%'>${chukudingdan.huowumingcheng}</td></tr><tr>
                <td width='11%'>货物类型：</td><td width='39%'>${chukudingdan.huowuleixing}</td>
                <td width='11%'>库存：</td><td width='39%'>${chukudingdan.kucun}</td></tr><tr>
                <td width='11%'>价格：</td><td width='39%'>${chukudingdan.jiage}</td>
                <td width='11%'>购买数量：</td><td width='39%'>${chukudingdan.goumaishuliang}</td></tr><tr>
                <td width='11%'>金额：</td><td width='39%'>${chukudingdan.jine}</td>
                <td width='11%'>购买人：</td><td width='39%'>${chukudingdan.goumairen}</td>
            </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 class='hsgqiehuanshitu' onClick="javascript:history.back()" />
                <input type=button name=Submit52 value=打印 class='hsgqiehuanshitu' onClick="javascript:window.print()"  /> <!--jixaaxnnxiu-->
                <input type=button name=Submit52 value=收藏 class='hsgqiehuanshitu' onClick="javascript:location.href='jrsc.jsp?id=<%=id%>&biaoj=ckdd&biao=chukudingdan&ziduan=huowumingcheng';"  />
            </td></tr>

            </table>





        </div>
    </div>
</div>
<jsp:include page="qtdown.jsp"></jsp:include>

</body>
</html>

