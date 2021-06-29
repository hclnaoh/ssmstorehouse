<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>

<!doctype html>
<html>
<head>
    <title>车辆信息</title>

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

<%

%>

<body>
<jsp:include page="qttop.jsp"></jsp:include>
<div class="in_about">
    <div class="container">
        <div class="in_toptt">
            <h1>车辆信息</h1>
            <h4>开创独特的人类美好健康生活，从此开始</h4>
        </div>
        <div class="in_aboutcon clearfix">


            <link rel="stylesheet" href="images/hsgcommon/divqt.css" type="text/css">
            <form action="clxxListtp.do" name="myform" method="post" style="width:100%">
                查询 车牌号：<input name="chepaihao" type="text" id="chepaihao" class="form-control2"/> 车辆品牌：<select
                    name='cheliangpinpai' id='cheliangpinpai' class="form-control2">
                <option value="">所有</option>
                <option value="宝马">宝马</option>
                <option value="奔驰">奔驰</option>
                <option value="奥迪">奥迪</option>
                <option value="现代">现代</option>
                <option value="本田">本田</option>
                <option value="丰田">丰田</option>
                <option value="路虎">路虎</option>
                <option value="吉利">吉利</option>
                <option value="法拉利">法拉利</option>
                <option value="奥拓">奥拓</option>
            </select> 车型：<select name='chexing' id='chexing' class="form-control2">
                <option value="">所有</option>
                <option value="轻卡">轻卡</option>
                <option value="大卡">大卡</option>
            </select>
                <input type="submit" value="查询" class='hsgqiehuanshitu'/> <input type="button" name="Submit2"
                                                                                 value="切换视图" class='hsgqiehuanshitu'
                                                                                 onClick="javascript:location.href='clxxList.do';"/>
            </form>
            <br/>

            <table width="100%" height="12%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <%
                        int i = 0;
                    %>
                    <c:forEach items="${list}" var="u">
                        <%
                            i++;
                        %>
                        <td height="316" align="center">
                            <table height="285" border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td height="250" align="center"><a href="clxxDetail.do?id=${u.id}"><img
                                            src="${u.tupian}" width="210" height="250" border="0"
                                            style="border-radius: 18px;"/></a></td>
                                </tr>
                                <tr>
                                    <td height="26" align="center">${u.chepaihao}</td>
                                </tr>
                            </table>
                        </td>
                        <%
                            if (i == 4) {
                                i = 0;
                                out.print("</tr><tr>");
                            }


                        %>
                    </c:forEach>


                </tr>
            </table>
            <br>

            <p align="center"><c:if test="${sessionScope.p==1}">
                <c:if test="${page.page>1}">
                    <a href="clxxListtp.do?page=1">首页</a>
                    <a href="clxxListtp.do?page=${page.page-1}"> 上一页</a> </c:if>
                <c:if test="${page.page<page.totalPage}">
                    <a href="clxxListtp.do?page=${page.page+1}">下一页</a>
                    <a href="clxxListtp.do?page=${page.totalPage}">末页</a> </c:if>
            </c:if>
            </p>


        </div>
    </div>
</div>
<jsp:include page="qtdown.jsp"></jsp:include>

</body>
</html>
