<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>入库管理详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  入库管理详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>货物编号：</td><td width='39%'>${rukuguanli.huowubianhao}</td>     <td width='11%'>货物名称：</td><td width='39%'>${rukuguanli.huowumingcheng}</td></tr><tr>     <td width='11%'>货物类型：</td><td width='39%'>${rukuguanli.huowuleixing}</td>     <td width='11%'>库存：</td><td width='39%'>${rukuguanli.kucun}</td></tr><tr>     <td width='11%'>入库数量：</td><td width='39%'>${rukuguanli.rukushuliang}</td>     <td width='11%'>入库时间：</td><td width='39%'>${rukuguanli.rukushijian}</td></tr><tr>     <td width='11%'>备注：</td><td width='39%'>${rukuguanli.beizhu}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

