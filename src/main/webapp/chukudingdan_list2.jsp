<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>出库订单查询</TITLE>
	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">
	</head>
	   <script language="javascript">
		   function zhifu(id,biao)
           {
                   window.location.href="zhifu/index.jsp?id="+id+"&biao="+biao;
           }
       </script>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">出库订单列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="chukudingdanList2.do" name="myform" method="post">
									查询   货物名称：<input name="huowumingcheng" type="text" id="huowumingcheng" class="form-control2" />  货物类型：<input name="huowuleixing" type="text" id="huowuleixing" class="form-control2" />
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td width="30px" height="30" align="center" bgcolor="#ebf0f7">序号</td>
                            <td align='center' bgcolor='#ebf0f7'>订单编号</td>    <td align='center' bgcolor='#ebf0f7'>货物名称</td>    <td align='center' bgcolor='#ebf0f7'>货物类型</td>    <td align='center' bgcolor='#ebf0f7'>库存</td>    <td align='center' bgcolor='#ebf0f7'>价格</td>    <td align='center' bgcolor='#ebf0f7'>购买数量</td>    <td align='center' bgcolor='#ebf0f7'>金额</td>    <td align='center' bgcolor='#ebf0f7'>购买人</td>    
                            <td width="150px" height="30" align="center" bgcolor="#ebf0f7"> 添加时间 </td>
                            <td width="150px" height="30" align="center" bgcolor="#ebf0f7"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td height="45" align="center"><%=i%></td>
                             <td>${u.dingdanbianhao}</td>    <td>${u.huowumingcheng}</td>    <td>${u.huowuleixing}</td>    <td>${u.kucun}</td>    <td>${u.jiage}</td>    <td>${u.goumaishuliang}</td>    <td>${u.jine}</td>    <td>${u.goumairen}</td>    
                              <td height="45" align="center"> ${u.addtime } </td>
                              <td height="45" align="center"><a class="btn btn-info btn-small" href="doUpdateChukudingdan.do?id=${u.id }">编辑</a>  <a class="btn btn-info btn-small" href="deleteChukudingdan.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a class="btn btn-info btn-small" href="ckddDetail.do?id=${u.id }" target="_blank">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		 <%
			String sql="select * from chukudingdan where 1=1 ";
				if(request.getParameter("huowumingcheng")=="" ||request.getParameter("huowumingcheng")==null ){}else{String nhuowumingcheng=new String(request.getParameter("huowumingcheng").getBytes("8859_1"));if(nhuowumingcheng.contains("?")){nhuowumingcheng=request.getParameter("huowumingcheng");}sql=sql+" and huowumingcheng like '%"+nhuowumingcheng+"%'";}if(request.getParameter("huowuleixing")=="" ||request.getParameter("huowuleixing")==null ){}else{String nhuowuleixing=new String(request.getParameter("huowuleixing").getBytes("8859_1"));if(nhuowuleixing.contains("?")){nhuowuleixing=request.getParameter("huowuleixing");}sql=sql+" and huowuleixing like '%"+nhuowuleixing+"%'";}
			sql+=" order by id desc";
double jinez=0;
							
							
			ResultSet RS_result=connDbBean.executeQuery(sql);
while(RS_result.next()){
				
						
						jinez=jinez+Float.valueOf(RS_result.getString("jine")).floatValue();
						
						
			 }
			%>
		共计金额:<%=jinez%>； 
		
			<p align="center" class="fy"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="chukudingdanList2.do?page=1" >首页</a>
             <a href="chukudingdanList2.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="chukudingdanList2.do?page=${page.page+1 }">下一页</a>
			<a href="chukudingdanList2.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
