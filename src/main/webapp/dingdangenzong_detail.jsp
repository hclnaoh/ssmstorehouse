<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>订单跟踪详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  订单跟踪详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>订单编号：</td><td width='39%'>${dingdangenzong.dingdanbianhao}</td>     <td width='11%'>货物名称：</td><td width='39%'>${dingdangenzong.huowumingcheng}</td></tr><tr>     <td width='11%'>购买数量：</td><td width='39%'>${dingdangenzong.goumaishuliang}</td>     <td width='11%'>购买人：</td><td width='39%'>${dingdangenzong.goumairen}</td></tr><tr>     <td width='11%'>车牌号：</td><td width='39%'>${dingdangenzong.chepaihao}</td>     <td width='11%'>工号：</td><td width='39%'>${dingdangenzong.gonghao}</td></tr><tr>     <td width='11%'>配送员姓名：</td><td width='39%'>${dingdangenzong.peisongyuanxingming}</td>     <td width='11%'>联系电话：</td><td width='39%'>${dingdangenzong.lianxidianhua}</td></tr><tr>     <td width='11%'>订单状态：</td><td width='39%'>${dingdangenzong.dingdanzhuangtai}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

