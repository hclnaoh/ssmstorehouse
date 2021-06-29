<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="rukuguanlihsgb" scope="page" class="com.bean.RukuguanliBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=rukuguanli.xls");
%>
<html>
  <head>
    <title>入库管理</title>
  </head>

  <body >
 <%
			String sql="select * from rukuguanli  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>货物编号</td>    <td align='center' bgcolor='#ebf0f7'>货物名称</td>    <td align='center' bgcolor='#ebf0f7'>货物类型</td>    <td align='center' bgcolor='#ebf0f7'>库存</td>    <td align='center' bgcolor='#ebf0f7'>入库数量</td>    <td  width='95' align='center' bgcolor='#ebf0f7'>入库时间</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=rukuguanlihsgb.getAllRukuguanli(9);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.huowubianhao}</td>    <td>${u.huowumingcheng}</td>    <td>${u.huowuleixing}</td>    <td>${u.kucun}</td>    <td>${u.rukushuliang}</td>    <td>${u.rukushijian}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

