<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>车辆信息详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  车辆信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>车牌号：</td><td width='39%'>${cheliangxinxi.chepaihao}</td><td  rowspan=4 align=center><a href=${cheliangxinxi.tupian} target=_blank><img src=${cheliangxinxi.tupian} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>车辆品牌：</td><td width='39%'>${cheliangxinxi.cheliangpinpai}</td></tr><tr><td width='11%' height=44>车型：</td><td width='39%'>${cheliangxinxi.chexing}</td></tr><tr><td width='11%' height=44>状态：</td><td width='39%'>${cheliangxinxi.zhuangtai}</td></tr><tr><td width='11%' height=100  >备注：</td><td width='39%' colspan=2 height=100 >${cheliangxinxi.beizhu}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

