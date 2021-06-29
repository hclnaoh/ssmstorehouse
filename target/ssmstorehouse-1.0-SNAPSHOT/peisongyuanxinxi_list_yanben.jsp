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
	<TITLE>配送员信息查询</TITLE>
	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr valign="top">
		<td>
			<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
				<tr align="left" bgcolor="#F2FDFF">
					<td colspan="17" background="images/table_header.gif">配送员信息列表</td>
				</tr>
			</table>
		</td>
	</tr>

	<tr valign="top">
		<td bgcolor="#FFFFFF">
			<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">

				<tr align="right" bgcolor="#ebf0f7">
					<td colspan="21">
						<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
							<tr align="left" >
								<td colspan="17">
									<form action="peisongyuanxinxiList.do" name="myform" method="post">
										查询   工号：<input name="gonghao" type="text" id="gonghao" class="form-control2" />  配送员姓名：<input name="peisongyuanxingming" type="text" id="peisongyuanxingming" class="form-control2" />  身份证：<input name="shenfenzheng" type="text" id="shenfenzheng" class="form-control2" />
										<input type="submit" value="查询" class="btn btn-info btn-small" />
									</form>								</td>
							</tr></table>
					</td>
				</tr>

				<tr align="center">
					<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bordercolor="#F3F3F3" bgcolor="#ebf0f7">
						<tr>
							<td width="30px" height="50" align="center" bgcolor="#ebf0f7">序号</td>
							<td align='center' bgcolor='#ebf0f7'>工号</td>
							<td align='center' bgcolor='#ebf0f7'>密码</td>
							<td align='center' bgcolor='#ebf0f7'>配送员姓名</td>
							<td  width='40' align='center' bgcolor='#ebf0f7'>性别</td>
							<td align='center' bgcolor='#ebf0f7'>年龄</td>
							<td align='center' bgcolor='#ebf0f7'>联系电话</td>
							<td align='center' bgcolor='#ebf0f7'>身份证</td>
							<td align='center' bgcolor='#ebf0f7'>状态</td>
							<td  width='90' align='center' bgcolor='#ebf0f7'>照片</td>

							<td  width='80' align='center' bgcolor='#ebf0f7'>是否审核</td>
							<td width="150px" height="50" align="center" bgcolor="#ebf0f7"> 添加时间 </td>
							<td width="150px" height="50" align="center" bgcolor="#ebf0f7"> 操作 </td>
						</tr>
						<%
							int i=0;
						%>
						<c:forEach items="${list }" var="u">
							<%
								i++;
							%>
							<tr align="center"  <%
								if((i % 2)==0)
								{
									out.print("bgcolor='#F0F0F0'");
								}
								else
								{
									out.print("bgcolor='#FFFFFF'");
								}

								if((i % 2)==0)
								{
							%> onmouseover="this.style.backgroundColor='#F9DFEB'" onmouseout="this.style.backgroundColor='#F0F0F0'" <%
							}
							else
							{
							%> onmouseover="this.style.backgroundColor='#F9DFEB'" onmouseout="this.style.backgroundColor='#FFFFFF'" <%
								}

							%>>
								<td height="50" align="center"><%=i%></td>
								<td>${u.gonghao}</td>
								<td>${u.mima}</td>
								<td>${u.peisongyuanxingming}</td>
								<td align='center' bgcolor='#ebf0f7'>${u.xingbie}</td>
								<td>${u.nianling}</td>
								<td>${u.lianxidianhua}</td>
								<td>${u.shenfenzheng}</td>
								<td>${u.zhuangtai}</td>
								<td width='90' align='center' bgcolor='#ebf0f7'><a href='${u.zhaopian}' target='_blank'><img src='${u.zhaopian}' width=88 height=99 border=0 /></a></td>

								<td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=peisongyuanxinxi'"/></td>
								<td height="50" align="center"> ${u.addtime } </td>
								<td height="50" align="center"> <!--lianjie1--> <a class="btn btn-info btn-small" href="psyxxDetail.do?id=${u.id}" target="_blank">详细</a></td>
							</tr>
						</c:forEach>
					</table></td>
				</tr>
			</table>


		</td>
	</tr>
</table>



<p align="center" class="fy"> <c:if test="${sessionScope.p==1 }">
	<c:if test="${page.page>1}">
		<a href="peisongyuanxinxiList.do?page=1" >首页</a>
		<a href="peisongyuanxinxiList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
	<c:if test="${page.page<page.totalPage}">
		<a href="peisongyuanxinxiList.do?page=${page.page+1 }">下一页</a>
		<a href="peisongyuanxinxiList.do?page=${page.totalPage }">末页</a>		    </c:if>
</c:if>
</p>





</body>
</html>

