<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="dingdangenzonghsgb" scope="page" class="com.bean.DingdangenzongBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=dingdangenzong.xls");
%>
<html>
  <head>
    <title>��������</title>
  </head>

  <body >
 <%
			String sql="select * from dingdangenzong  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center' bgcolor='#ebf0f7'>�������</td>    <td align='center' bgcolor='#ebf0f7'>��������</td>    <td align='center' bgcolor='#ebf0f7'>��������</td>    <td align='center' bgcolor='#ebf0f7'>������</td>    <td align='center' bgcolor='#ebf0f7'>���ƺ�</td>    <td align='center' bgcolor='#ebf0f7'>����</td>    <td align='center' bgcolor='#ebf0f7'>����Ա����</td>    <td align='center' bgcolor='#ebf0f7'>��ϵ�绰</td>    <td align='center' bgcolor='#ebf0f7'>����״̬</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
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

