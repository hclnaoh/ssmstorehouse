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
		<TITLE>修改货物信息</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="huowuxinxi_add.jsp?id=<%=id%>";
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
			<form action="updateHuowuxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改货物信息<input type="hidden" name="id" value="${huowuxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">货物编号：</td><td><input name='huowubianhao' type='text' id='huowubianhao' value='' onblur='hsgcheck()' class="form-control" />&nbsp;*<label id='clabelhuowubianhao' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">货物名称：</td><td><input name='huowumingcheng' type='text' id='huowumingcheng' value='' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">货物类型：</td><td><input name='huowuleixing' type='text' id='huowuleixing' value='' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">库存：</td><td><input name='kucun' type='text' id='kucun' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelkucun' style='margin-top:16px;' />必需数字型</td></tr>		<tr ><td width="200">价格：</td><td><input name='jiage' type='text' id='jiage' value='' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">实物图：</td><td><input name='shiwutu' type='text' id='shiwutu' size='50' value='' onblur=''  class="form-control" /><div style="margin-top:16px;">&nbsp;<input type='button' value='上传' onClick="up('shiwutu')"/></div></td></tr>		<tr ><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.huowubianhao.value='${huowuxinxi.huowubianhao}';</script>	<script language="javascript">document.form1.huowumingcheng.value='${huowuxinxi.huowumingcheng}';</script>	<script language="javascript">document.form1.huowuleixing.value='${huowuxinxi.huowuleixing}';</script>	<script language="javascript">document.form1.kucun.value='${huowuxinxi.kucun}';</script>	<script language="javascript">document.form1.jiage.value='${huowuxinxi.jiage}';</script>	<script language="javascript">document.form1.shiwutu.value='${huowuxinxi.shiwutu}';</script>	<script language="javascript">document.form1.beizhu.value='${huowuxinxi.beizhu}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var huowubianhaoobj = document.getElementById("huowubianhao"); if(huowubianhaoobj.value==""){document.getElementById("clabelhuowubianhao").innerHTML="&nbsp;&nbsp;<font color=red>请输入货物编号</font>";return false;}else{document.getElementById("clabelhuowubianhao").innerHTML="  "; } 	    


return true;   
}   
popheight=450;
</script>  
