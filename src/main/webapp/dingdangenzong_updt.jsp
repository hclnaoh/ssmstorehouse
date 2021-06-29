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
		<TITLE>修改订单跟踪</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="dingdangenzong_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="updateDingdangenzong.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改订单跟踪<input type="hidden" name="id" value="${dingdangenzong.id}" /></td>
						</tr>
						<tr ><td width="200">订单编号：</td><td><input name='dingdanbianhao' type='text' id='dingdanbianhao' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr  ><td width="200">货物名称：</td><td><input name='huowumingcheng' type='text' id='huowumingcheng' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr ><td width="200">购买数量：</td><td><input name='goumaishuliang' type='text' id='goumaishuliang' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>
		<tr style="display:none" ><td width="200">购买人：</td><td><input name='goumairen' type='text' id='goumairen' value='' onblur='' class="form-control" /></td></tr>
		<tr  style="display:none" ><td width="200"><tr><td>车牌号：</td><td><select disabled="disabled" name='chepaihao' id='chepaihao' class="form-control"><%=connDbBean.hsggetoption("cheliangxinxi","chepaihao")%></select></td></tr>
		<tr style="display:none" ><td width="200">工号：</td><td><select name='gonghao' id='gonghao' class="form-control" onChange='gows();'><%=connDbBean.hsggetoption2("peisongyuanxinxi","gonghao")%></select></td></tr>
		<tr style="display:none" ><td width="200">配送员姓名：</td><td><input name='peisongyuanxingming' type='text' id='peisongyuanxingming'  class="form-control" ></td></tr>
		<tr style="display:none" ><td width="200">联系电话：</td><td><input name='lianxidianhua' type='text' id='lianxidianhua'  class="form-control" ></td></tr>
		<tr ><td width="200"><tr><td>订单状态：</td><td><select name='dingdanzhuangtai' id='dingdanzhuangtai' class="form-control"><option value="已签收">已签收</option></select></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.dingdanbianhao.value='${dingdangenzong.dingdanbianhao}';</script>
	<script language="javascript">document.form1.huowumingcheng.value='${dingdangenzong.huowumingcheng}';</script>
	<script language="javascript">document.form1.goumaishuliang.value='${dingdangenzong.goumaishuliang}';</script>
	<script language="javascript">document.form1.goumairen.value='${dingdangenzong.goumairen}';</script>
	<script language="javascript">document.form1.chepaihao.value='${dingdangenzong.chepaihao}';</script>
	<script language="javascript">document.form1.gonghao.value='${dingdangenzong.gonghao}';</script>
	<script language="javascript">document.form1.peisongyuanxingming.value='${dingdangenzong.peisongyuanxingming}';</script>
	<script language="javascript">document.form1.lianxidianhua.value='${dingdangenzong.lianxidianhua}';</script>
	<script language="javascript">document.form1.dingdanzhuangtai.value='${dingdangenzong.dingdanzhuangtai}';</script>
	
					 </table>
			</form>
   </body>
</html>






