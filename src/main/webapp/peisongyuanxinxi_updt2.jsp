﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<TITLE>修改配送员信息</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>


	<body>
			<form action="updatePeisongyuanxinxi2.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改配送员信息<input type="hidden" name="id" value="${peisongyuanxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">工号：</td><td><input name='gonghao' type='text' id='gonghao' value='' onblur='hsgcheck()' class="form-control" />&nbsp;*<label id='clabelgonghao' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">密码：</td><td><input name='mima' type='text' id='mima' value='' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">配送员姓名：</td><td><input name='peisongyuanxingming' type='text' id='peisongyuanxingming' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelpeisongyuanxingming' style='margin-top:16px;' /></td></tr>		<tr ><td width="200"><tr><td>性别：</td><td><select name='xingbie' id='xingbie' class="form-control"><option value="男">男</option><option value="女">女</option></select></td></tr>		<tr ><td width="200">年龄：</td><td><input name='nianling' type='text' id='nianling' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelnianling' style='margin-top:16px;' />必需数字型</td></tr>		<tr ><td width="200">联系电话：</td><td><input name='lianxidianhua' type='text' id='lianxidianhua' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabellianxidianhua' style='margin-top:16px;' />必需电话格式[7或8位电话，或11位手机]</td></tr>		<tr ><td width="200">身份证：</td><td><input name='shenfenzheng' type='text' id='shenfenzheng' value='' onblur='checkform()' size='50' class="form-control" style="width:600px;" />&nbsp;<label id='clabelshenfenzheng' style='margin-top:16px;' />必需身份证格式</td></tr>		<tr ><td width="200"><tr><td>状态：</td><td><select name='zhuangtai' id='zhuangtai' class="form-control"><option value="配送中">配送中</option><option value="无任务">无任务</option></select></td></tr>		<tr ><td width="200">照片：</td><td><input name='zhaopian' type='text' id='zhaopian' size='50' value='' onblur=''  class="form-control" /><div style="margin-top:16px;">&nbsp;<input type='button' value='上传' onClick="up('zhaopian')"/></div></td></tr>		<tr 0><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.gonghao.value='${peisongyuanxinxi.gonghao}';</script>	<script language="javascript">document.form1.mima.value='${peisongyuanxinxi.mima}';</script>	<script language="javascript">document.form1.peisongyuanxingming.value='${peisongyuanxinxi.peisongyuanxingming}';</script>	<script language="javascript">document.form1.xingbie.value='${peisongyuanxinxi.xingbie}';</script>	<script language="javascript">document.form1.nianling.value='${peisongyuanxinxi.nianling}';</script>	<script language="javascript">document.form1.lianxidianhua.value='${peisongyuanxinxi.lianxidianhua}';</script>	<script language="javascript">document.form1.shenfenzheng.value='${peisongyuanxinxi.shenfenzheng}';</script>	<script language="javascript">document.form1.zhuangtai.value='${peisongyuanxinxi.zhuangtai}';</script>	<script language="javascript">document.form1.zhaopian.value='${peisongyuanxinxi.zhaopian}';</script>	<script language="javascript">document.form1.beizhu.value='${peisongyuanxinxi.beizhu}';</script>	
					 </table>
			</form>
   </body>
</html>



<!--hssgchesck-->


<script language=javascript >  
 
 function checkform(){  
 
	var gonghaoobj = document.getElementById("gonghao"); if(gonghaoobj.value==""){document.getElementById("clabelgonghao").innerHTML="&nbsp;&nbsp;<font color=red>请输入工号</font>";return false;}else{document.getElementById("clabelgonghao").innerHTML="  "; } 	var peisongyuanxingmingobj = document.getElementById("peisongyuanxingming"); if(peisongyuanxingmingobj.value==""){document.getElementById("clabelpeisongyuanxingming").innerHTML="&nbsp;&nbsp;<font color=red>请输入配送员姓名</font>";return false;}else{document.getElementById("clabelpeisongyuanxingming").innerHTML="  "; } 	    var lianxidianhuaobj = document.getElementById("lianxidianhua"); if(lianxidianhuaobj.value!=""){ if(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(lianxidianhuaobj.value) || /^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(lianxidianhuaobj.value)){document.getElementById("clabellianxidianhua").innerHTML=""; }else{document.getElementById("clabellianxidianhua").innerHTML="&nbsp;&nbsp;<font color=red>必需电话格式[7或8位电话，或11位手机]</font>"; return false;}}      var shenfenzhengobj = document.getElementById("shenfenzheng"); if(shenfenzhengobj.value!=""){ if(/^\d{15}$|^\d{18}$|^\d{17}[xX]$/.test(shenfenzhengobj.value)){document.getElementById("clabelshenfenzheng").innerHTML=""; }else{document.getElementById("clabelshenfenzheng").innerHTML="&nbsp;&nbsp;<font color=red>必需身份证格式</font>"; return false;}}      


return true;   
}   
popheight=450;
</script>  
