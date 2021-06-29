<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="cheliangxinxihsgb" scope="page" class="com.bean.CheliangxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=cheliangxinxi.xls");
%>
<html>
  <head>
    <title>车辆信息</title>
  </head>

  <body >
 <%
			String sql="select * from cheliangxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>车牌号</td>    <td align='center' bgcolor='#ebf0f7'>车辆品牌</td>    <td align='center' bgcolor='#ebf0f7'>车型</td>    <td align='center' bgcolor='#ebf0f7'>状态</td>    <td  width='90' align='center' bgcolor='#ebf0f7'>图片</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=cheliangxinxihsgb.getAllCheliangxinxi(8);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.chepaihao}</td>    <td>${u.cheliangpinpai}</td>    <td>${u.chexing}</td>    <td>${u.zhuangtai}</td>    <td width='90' align='center' bgcolor='#ebf0f7'><a href='${u.tupian}' target='_blank'><img src='${u.tupian}' width=88 height=99 border=0 /></a></td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

