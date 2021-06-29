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
		<TITLE>修改车辆信息</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="cheliangxinxi_add.jsp?id=<%=id%>";
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
			<form action="updateCheliangxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改车辆信息<input type="hidden" name="id" value="${cheliangxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">车牌号：</td><td><input name='chepaihao' type='text' id='chepaihao' value='' onblur='hsgcheck()' class="form-control" />&nbsp;*<label id='clabelchepaihao' style='margin-top:16px;' /></td></tr>		<tr ><td width="200"><tr><td>车辆品牌：</td><td><select name='cheliangpinpai' id='cheliangpinpai' class="form-control"><option value="宝马">宝马</option><option value="奔驰">奔驰</option><option value="奥迪">奥迪</option><option value="现代">现代</option><option value="本田">本田</option><option value="丰田">丰田</option><option value="路虎">路虎</option><option value="吉利">吉利</option><option value="法拉利">法拉利</option><option value="奥拓">奥拓</option></select>&nbsp;*<label id='clabelcheliangpinpai' style='margin-top:16px;' /></td></tr>		<tr ><td width="200"><tr><td>车型：</td><td><select name='chexing' id='chexing' class="form-control"><option value="轻卡">轻卡</option><option value="大卡">大卡</option></select></td></tr>		<tr ><td width="200"><tr><td>状态：</td><td><select name='zhuangtai' id='zhuangtai' class="form-control"><option value="闲置">闲置</option><option value="在用">在用</option></select></td></tr>		<tr ><td width="200">图片：</td><td><input name='tupian' type='text' id='tupian' size='50' value='' onblur=''  class="form-control" /><div style="margin-top:16px;">&nbsp;<input type='button' value='上传' onClick="up('tupian')"/></div></td></tr>		<tr ><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.chepaihao.value='${cheliangxinxi.chepaihao}';</script>	<script language="javascript">document.form1.cheliangpinpai.value='${cheliangxinxi.cheliangpinpai}';</script>	<script language="javascript">document.form1.chexing.value='${cheliangxinxi.chexing}';</script>	<script language="javascript">document.form1.zhuangtai.value='${cheliangxinxi.zhuangtai}';</script>	<script language="javascript">document.form1.tupian.value='${cheliangxinxi.tupian}';</script>	<script language="javascript">document.form1.beizhu.value='${cheliangxinxi.beizhu}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var chepaihaoobj = document.getElementById("chepaihao"); if(chepaihaoobj.value==""){document.getElementById("clabelchepaihao").innerHTML="&nbsp;&nbsp;<font color=red>请输入车牌号</font>";return false;}else{document.getElementById("clabelchepaihao").innerHTML="  "; } 	var cheliangpinpaiobj = document.getElementById("cheliangpinpai"); if(cheliangpinpaiobj.value==""){document.getElementById("clabelcheliangpinpai").innerHTML="&nbsp;&nbsp;<font color=red>请输入车辆品牌</font>";return false;}else{document.getElementById("clabelcheliangpinpai").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
