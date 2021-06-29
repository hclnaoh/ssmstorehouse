<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="huowuxinxihsgb" scope="page" class="com.bean.HuowuxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=huowuxinxi.xls");
%>
<html>
  <head>
    <title>货物信息</title>
  </head>

  <body >
 <%
			String sql="select * from huowuxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>货物编号</td>    <td align='center' bgcolor='#ebf0f7'>货物名称</td>    <td align='center' bgcolor='#ebf0f7'>货物类型</td>    <td align='center' bgcolor='#ebf0f7'>库存</td>    <td align='center' bgcolor='#ebf0f7'>价格</td>    <td  width='90' align='center' bgcolor='#ebf0f7'>实物图</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=huowuxinxihsgb.getAllHuowuxinxi(9);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.huowubianhao}</td>    <td>${u.huowumingcheng}</td>    <td>${u.huowuleixing}</td>    <td>${u.kucun}</td>    <td>${u.jiage}</td>    <td width='90' align='center' bgcolor='#ebf0f7'><a href='${u.shiwutu}' target='_blank'><img src='${u.shiwutu}' width=88 height=99 border=0 /></a></td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

