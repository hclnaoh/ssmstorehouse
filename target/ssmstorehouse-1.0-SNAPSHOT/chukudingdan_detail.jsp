<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>出库订单详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  出库订单详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>订单编号：</td><td width='39%'>${chukudingdan.dingdanbianhao}</td>     <td width='11%'>货物名称：</td><td width='39%'>${chukudingdan.huowumingcheng}</td></tr><tr>     <td width='11%'>货物类型：</td><td width='39%'>${chukudingdan.huowuleixing}</td>     <td width='11%'>库存：</td><td width='39%'>${chukudingdan.kucun}</td></tr><tr>     <td width='11%'>价格：</td><td width='39%'>${chukudingdan.jiage}</td>     <td width='11%'>购买数量：</td><td width='39%'>${chukudingdan.goumaishuliang}</td></tr><tr>     <td width='11%'>金额：</td><td width='39%'>${chukudingdan.jine}</td>     <td width='11%'>购买人：</td><td width='39%'>${chukudingdan.goumairen}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

