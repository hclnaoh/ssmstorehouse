﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>货物信息详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  货物信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>货物编号：</td><td width='39%'>${huowuxinxi.huowubianhao}</td><td  rowspan=5 align=center><a href=${huowuxinxi.shiwutu} target=_blank><img src=${huowuxinxi.shiwutu} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>货物名称：</td><td width='39%'>${huowuxinxi.huowumingcheng}</td></tr><tr><td width='11%' height=44>货物类型：</td><td width='39%'>${huowuxinxi.huowuleixing}</td></tr><tr><td width='11%' height=44>库存：</td><td width='39%'>${huowuxinxi.kucun}</td></tr><tr><td width='11%' height=44>价格：</td><td width='39%'>${huowuxinxi.jiage}</td></tr><tr><td width='11%' height=100  >备注：</td><td width='39%' colspan=2 height=100 >${huowuxinxi.beizhu}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

