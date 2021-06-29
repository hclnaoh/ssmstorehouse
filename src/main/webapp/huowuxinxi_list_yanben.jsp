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
	<TITLE>货物信息查询</TITLE>
	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr valign="top">
		<td>
			<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
				<tr align="left" bgcolor="#F2FDFF">
					<td colspan="17" background="images/table_header.gif">货物信息列表</td>
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
									<form action="huowuxinxiList.do" name="myform" method="post">
										查询   货物编号：<input name="huowubianhao" type="text" id="huowubianhao" class="form-control2" />  货物名称：<input name="huowumingcheng" type="text" id="huowumingcheng" class="form-control2" />  货物类型：<input name="huowuleixing" type="text" id="huowuleixing" class="form-control2" />
										<input type="submit" value="查询" class="btn btn-info btn-small" />
									</form>								</td>
							</tr></table>
					</td>
				</tr>

				<tr align="center">
					<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bordercolor="#F3F3F3" bgcolor="#ebf0f7">
						<tr>
							<td width="30px" height="50" align="center" bgcolor="#ebf0f7">序号</td>
							<td align='center' bgcolor='#ebf0f7'>货物编号</td>
							<td align='center' bgcolor='#ebf0f7'>货物名称</td>
							<td align='center' bgcolor='#ebf0f7'>货物类型</td>
							<td align='center' bgcolor='#ebf0f7'>库存</td>
							<td align='center' bgcolor='#ebf0f7'>价格</td>
							<td  width='90' align='center' bgcolor='#ebf0f7'>实物图</td>


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
								<td>${u.huowubianhao}</td>
								<td>${u.huowumingcheng}</td>
								<td>${u.huowuleixing}</td>
								<td>${u.kucun}</td>
								<td>${u.jiage}</td>
								<td width='90' align='center' bgcolor='#ebf0f7'><a href='${u.shiwutu}' target='_blank'><img src='${u.shiwutu}' width=88 height=99 border=0 /></a></td>


								<td height="50" align="center"> ${u.addtime } </td>
								<td height="50" align="center"> <!--lianjie1--> <a class="btn btn-info btn-small" href="hwxxDetail.do?id=${u.id}" target="_blank">详细</a></td>
							</tr>
						</c:forEach>
					</table></td>
				</tr>
			</table>


		</td>
	</tr>
</table>

<%
	String sql="select * from huowuxinxi where 1=1 ";

	if(request.getParameter("huowubianhao")=="" ||request.getParameter("huowubianhao")==null ){}else{String nhuowubianhao=new String(request.getParameter("huowubianhao").getBytes("8859_1"));if(nhuowubianhao.contains("?")){nhuowubianhao=request.getParameter("huowubianhao");}sql=sql+" and huowubianhao like '%"+nhuowubianhao+"%'";}
	if(request.getParameter("huowumingcheng")=="" ||request.getParameter("huowumingcheng")==null ){}else{String nhuowumingcheng=new String(request.getParameter("huowumingcheng").getBytes("8859_1"));if(nhuowumingcheng.contains("?")){nhuowumingcheng=request.getParameter("huowumingcheng");}sql=sql+" and huowumingcheng like '%"+nhuowumingcheng+"%'";}
	if(request.getParameter("huowuleixing")=="" ||request.getParameter("huowuleixing")==null ){}else{String nhuowuleixing=new String(request.getParameter("huowuleixing").getBytes("8859_1"));if(nhuowuleixing.contains("?")){nhuowuleixing=request.getParameter("huowuleixing");}sql=sql+" and huowuleixing like '%"+nhuowuleixing+"%'";}
	sql+=" order by id desc";


	int kucuntx=0;
	ResultSet RS_result=connDbBean.executeQuery(sql);
	while(RS_result.next()){



		if(Float.valueOf(RS_result.getString("kucun")).floatValue()<50){kucuntx=kucuntx+1;}


	}
%>


<p align="center" class="fy"> <c:if test="${sessionScope.p==1 }">
	<c:if test="${page.page>1}">
		<a href="huowuxinxiList.do?page=1" >首页</a>
		<a href="huowuxinxiList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
	<c:if test="${page.page<page.totalPage}">
		<a href="huowuxinxiList.do?page=${page.page+1 }">下一页</a>
		<a href="huowuxinxiList.do?page=${page.totalPage }">末页</a>		    </c:if>
</c:if>
</p>





</body>
</html>
<%
	if(kucuntx>0)
	{
%>
<style>
	#winpop { width:200px; height:0px; position:absolute; right:0; bottom:0; border:1px solid #666; margin:0; padding:1px; overflow:hidden; display:none;}
	#winpop .title { width:100%; height:22px; line-height:20px; background:#FFCC00; font-weight:bold; text-align:center; font-size:12px;}
	#winpop .con { width:100%; height:90px; line-height:20px; font-weight:bold; font-size:12px; color:#FF0000; text-align:center}
	#silu { font-size:12px; color:#666; position:absolute; right:0; text-align:right; text-decoration:underline; line-height:22px;}
	.close { position:absolute; right:4px; top:-1px; color:#FFF; cursor:pointer}
</style>
<script type="text/javascript">
	function tips_pop(){
		var MsgPop=document.getElementById("winpop");
		var popH=parseInt(MsgPop.style.height);//将对象的高度转化为数字
		if (popH==0){
			MsgPop.style.display="block";//显示隐藏的窗口
			show=setInterval("changeH('up')",2);
		}
		else {
			hide=setInterval("changeH('down')",2);
		}
	}
	function changeH(str) {
		var MsgPop=document.getElementById("winpop");
		var popH=parseInt(MsgPop.style.height);
		if(str=="up"){
			if (popH <=100){
				MsgPop.style.height=(popH+4).toString()+"px";
			}
			else{
				clearInterval(show);
			}
		}
		if(str=="down"){
			if (popH>=4){
				MsgPop.style.height=(popH-4).toString()+"px";
			}
			else{
				clearInterval(hide);
				MsgPop.style.display="none"; //隐藏DIV
			}
		}
	}
	window.onload=function(){ //加载
		document.getElementById('winpop').style.height='0px';
		setTimeout("tips_pop()",500); //3秒后调用tips_pop()这个函数
	}
</script> <div id="silu">
	<body>
</div>
<div id="winpop">
	<div class="title">系统提醒！ <span class="close" onClick="tips_pop()">X </span> </div>
	<div class="con">当前有<%=kucuntx%>条库存值记录小于50，谢谢！</div>
		<%
}
%>
