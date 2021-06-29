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
		<TITLE>修改出库订单</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="chukudingdan_add.jsp?id=<%=id%>";
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
			<form action="updateChukudingdan.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改出库订单<input type="hidden" name="id" value="${chukudingdan.id}" /></td>
						</tr>
						<tr ><td width="200">订单编号：</td><td><input name='dingdanbianhao' type='text' id='dingdanbianhao' value='<%=connDbBean.getID()%>' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">货物名称：</td><td><input name='huowumingcheng' type='text' id='huowumingcheng' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">货物类型：</td><td><input name='huowuleixing' type='text' id='huowuleixing' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">库存：</td><td><input name='kucun' type='text' id='kucun' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">价格：</td><td><input name='jiage' type='text' id='jiage' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">购买数量：</td><td><input name='goumaishuliang' type='text' id='goumaishuliang' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelgoumaishuliang' style='margin-top:16px;' />必需数字型</td></tr>		<tr ><td width="200">金额：</td><td><input name='jine' type='text' id='jine' value='' onblur='' class="form-control" readonly='readonly' /> 此项不必填写，系统自动计算</td></tr>		<tr ><td width="200">购买人：</td><td><input name='goumairen' type='text' id='goumairen' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.dingdanbianhao.value='${chukudingdan.dingdanbianhao}';</script>	<script language="javascript">document.form1.huowumingcheng.value='${chukudingdan.huowumingcheng}';</script>	<script language="javascript">document.form1.huowuleixing.value='${chukudingdan.huowuleixing}';</script>	<script language="javascript">document.form1.kucun.value='${chukudingdan.kucun}';</script>	<script language="javascript">document.form1.jiage.value='${chukudingdan.jiage}';</script>	<script language="javascript">document.form1.goumaishuliang.value='${chukudingdan.goumaishuliang}';</script>	<script language="javascript">document.form1.jine.value='${chukudingdan.jine}';</script>	<script language="javascript">document.form1.goumairen.value='${chukudingdan.goumairen}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	    if(parseInt(document.form1.kucun.value)<parseInt(document.form1.goumaishuliang.value)){alert("对不起，库存必需大于购买数量");return false;}	var jinej=1;if(document.getElementById("jiage").value!=""){jinej=jinej*parseFloat(document.getElementById("jiage").value);}if(document.getElementById("goumaishuliang").value!=""){jinej=jinej*parseFloat(document.getElementById("goumaishuliang").value);}document.getElementById("jine").value=jinej;	


return true;   
}   
popheight=450;
</script>  
