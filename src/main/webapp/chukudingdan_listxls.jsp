<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=chukudingdan.xls");
%>
<html>
  <head>
    <title>出库订单</title>
  </head>

  <body >
 <%
			String sql="select * from chukudingdan  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>订单编号</td>
    <td align='center' bgcolor='#ebf0f7'>货物名称</td>
    <td align='center' bgcolor='#ebf0f7'>货物类型</td>
    <td align='center' bgcolor='#ebf0f7'>库存</td>
    <td align='center' bgcolor='#ebf0f7'>价格</td>
    <td align='center' bgcolor='#ebf0f7'>购买数量</td>
    <td align='center' bgcolor='#ebf0f7'>金额</td>
    <td align='center' bgcolor='#ebf0f7'>购买人</td>
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
  <tr>
    <td  align="center"></td>
    <td>${u.dingdanbianhao}</td>
    <td>${u.huowumingcheng}</td>
    <td>${u.huowuleixing}</td>
    <td>${u.kucun}</td>
    <td>${u.jiage}</td>
    <td>${u.goumaishuliang}</td>
    <td>${u.jine}</td>
    <td>${u.goumairen}</td>
    
	
	
   
  </tr>
   
</table>
<br>
  </body>
</html>

