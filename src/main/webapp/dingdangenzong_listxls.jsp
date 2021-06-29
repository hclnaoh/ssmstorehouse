<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="dingdangenzonghsgb" scope="page" class="com.bean.DingdangenzongBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=dingdangenzong.xls");
%>
<html>
  <head>
    <title>订单跟踪</title>
  </head>

  <body >
 <%
			String sql="select * from dingdangenzong  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>订单编号</td>    <td align='center' bgcolor='#ebf0f7'>货物名称</td>    <td align='center' bgcolor='#ebf0f7'>购买数量</td>    <td align='center' bgcolor='#ebf0f7'>购买人</td>    <td align='center' bgcolor='#ebf0f7'>车牌号</td>    <td align='center' bgcolor='#ebf0f7'>工号</td>    <td align='center' bgcolor='#ebf0f7'>配送员姓名</td>    <td align='center' bgcolor='#ebf0f7'>联系电话</td>    <td align='center' bgcolor='#ebf0f7'>订单状态</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=dingdangenzonghsgb.getAllDingdangenzong(11);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.dingdanbianhao}</td>    <td>${u.huowumingcheng}</td>    <td>${u.goumaishuliang}</td>    <td>${u.goumairen}</td>    <td>${u.chepaihao}</td>    <td>${u.gonghao}</td>    <td>${u.peisongyuanxingming}</td>    <td>${u.lianxidianhua}</td>    <td>${u.dingdanzhuangtai}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

