﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
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
    <title>订单跟踪</title>

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
    if (request.getSession().getAttribute("username") == null) {
        out.print("<script>alert('对不起,请您先登陆!');location.href='index.do';</script>");
        return;
    }
    String id = "";


%>


<script language="javascript">
    function checkform() {

    }

    function gow() {
        document.location.href = "dingdangenzongadd.jsp?id=<%=id%>&gonghao=" + document.form1.gonghao.value;
    }
</script>


<body>
<jsp:include page="qttop.jsp"></jsp:include>
<div class="in_about">
    <div class="container">
        <div class="in_toptt">
            <h1>订单跟踪</h1>
            <h4>开创独特的人类美好健康生活，从此开始</h4>
        </div>
        <div class="in_aboutcon clearfix">


            <link rel="stylesheet" href="images/hsgcommon/divqt.css" type="text/css">
            <link rel="stylesheet" href="images/hsgcommon/commonqt.css" type="text/css">
            <script src="images/hsgcommon/common.js"></script>
            <script src="images/hsgcommon/bootbox.js"></script>
            <%


            %>


            <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC"
                   style="border-collapse:collapse" class="newsline">
                <form action="addDingdangenzong.do" name="form1" method="post">
                    <tr>
                        <td width="200">订单编号：</td>
                        <td><input name='dingdanbianhao' type='text' id='dingdanbianhao' value='' onblur=''
                                   class="form-control" readonly='readonly'/></td>
                    </tr>
                    <script language="javascript">document.form1.dingdanbianhao.value = '<%=connDbBean.readzd("chukudingdan","dingdanbianhao","id",request.getParameter("id"))%>';
                    document.form1.dingdanbianhao.setAttribute("readOnly", 'true');</script>
                    <tr>
                        <td width="200">货物名称：</td>
                        <td><input name='huowumingcheng' type='text' id='huowumingcheng' value='' onblur=''
                                   class="form-control" readonly='readonly'/></td>
                    </tr>
                    <script language="javascript">document.form1.huowumingcheng.value = '<%=connDbBean.readzd("chukudingdan","huowumingcheng","id",request.getParameter("id"))%>';
                    document.form1.huowumingcheng.setAttribute("readOnly", 'true');</script>
                    <tr>
                        <td width="200">购买数量：</td>
                        <td><input name='goumaishuliang' type='text' id='goumaishuliang' value='' onblur=''
                                   class="form-control" readonly='readonly'/></td>
                    </tr>
                    <script language="javascript">document.form1.goumaishuliang.value = '<%=connDbBean.readzd("chukudingdan","goumaishuliang","id",request.getParameter("id"))%>';
                    document.form1.goumaishuliang.setAttribute("readOnly", 'true');</script>
                    <tr>
                        <td width="200">购买人：</td>
                        <td><input name='goumairen' type='text' id='goumairen' value='' onblur='' class="form-control"/>
                        </td>
                    </tr>
                    <tr>
                        <td width="200">
                    <tr>
                        <td>车牌号：</td>
                        <td><select name='chepaihao' id='chepaihao'
                                    class="form-control"><%=connDbBean.hsggetoption("cheliangxinxi", "chepaihao")%>
                        </select></td>
                    </tr>
                    <tr>
                        <td width="200">工号：</td>
                        <td><select name='gonghao' id='gonghao' class="form-control"
                                    onChange='gows();'><%=connDbBean.hsggetoption2("peisongyuanxinxi", "gonghao")%>
                        </select></td>
                    </tr>
                    <tr>
                        <td width="200">配送员姓名：</td>
                        <td><input name='peisongyuanxingming' type='text' id='peisongyuanxingming' class="form-control">
                        </td>
                    </tr>
                    <tr>
                        <td width="200">联系电话：</td>
                        <td><input name='lianxidianhua' type='text' id='lianxidianhua' class="form-control"></td>
                    </tr>
                    <tr style='display:none'>
                        <td width="200">
                    <tr>
                        <td>订单状态：</td>
                        <td><select name='dingdanzhuangtai' id='dingdanzhuangtai' class="form-control">
                            <option value="待确认">待确认</option>
                            <option value="待发货">待发货</option>
                            <option value="已发货">已发货</option>
                        </select></td>
                    </tr>


                    <tr align='center' height="22">
                        <td width="25%" align="right">&nbsp;

                        </td>
                        <td width="75%" align="left">
                            <input type="submit" name="querenzhuce" id="querenzhuce" value="提交"
                                   onClick="return checkform();"/>
                            <input type="reset" value="重置"/>&nbsp;
                        </td>
                    </tr>
                </form>
            </table>

            <script language="javascript">popheight = 450;</script>


        </div>
    </div>
</div>
<jsp:include page="qtdown.jsp"></jsp:include>

</body>
</html>
<%
    if (request.getParameter("gonghao") == null || request.getParameter("gonghao").equals("")) {
    } else {
%>
<script language="javascript">
    document.form1.gonghao.value = "<%=connDbBean.readzd("peisongyuanxinxi","gonghao","gonghao",request.getParameter("gonghao"))%>";
    document.form1.peisongyuanxingming.value = "<%=connDbBean.readzd("peisongyuanxinxi","peisongyuanxingming","gonghao",request.getParameter("gonghao"))%>";
    document.form1.lianxidianhua.value = "<%=connDbBean.readzd("peisongyuanxinxi","lianxidianhua","gonghao",request.getParameter("gonghao"))%>";
    //suilafuzhi

</script>
<%
    }
%>
