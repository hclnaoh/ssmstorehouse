<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>

<!doctype html>
<html>
<head>
    <title>????Ա??Ϣ</title>

<meta name="viewport" id="viewport" content="initial-scale=1, minimum-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<link href="qtimages/css/index.css" rel="stylesheet">
<link href="qtimages/css/responsive.css" rel="stylesheet">
<script type="text/javascript" src="qtimages/js/jquery-1.8.3.min.js"></script>
<script src="qtimages/js/common.js"></script>
<script src="qtimages/js/jquery.touchwipe.min.js"></script>
<script type="text/javascript" src="qtimages/js/jquery.banner.revolution.min.js"></script>
<script type="text/javascript" src="qtimages/js/banner.js"></script>
<script type="text/javascript" src="qtimages/js/swiper.scrollbar-1.2.js"></script>
<script type="text/javascript" src="qtimages/js/swiper-1.9.1.min.js"></script>
<script type="text/javascript" src="qtimages/js/jquery.fs.boxer.min.js"></script>
<script type="text/javascript" src="qtimages/js/jquery.slides.min.js"></script>
<script type="text/javascript" src="qtimages/js/customs.js"></script>
<script src="qtimages/js/jquery.isotope.min.js"></script>    
<script src="qtimages/js/custom.js"></script>  
<script src="qtimages/js/modernizr.custom.js"></script>
</head>
<script language=javascript src='js/popup.js'></script>
<script language=javascript> 
function hsgpinglun(nbiao,nid){ 
popheight=450;
pop('hsgpinglun.jsp?biao='+nbiao+'&id='+nid,'????????',550,250) ;
}
</script> 
<%
	String id=request.getParameter("id");
	
     %>
<body>
<jsp:include page="qttop.jsp"></jsp:include>
 <div  class="in_about">
		    <div class="container">
			   <div class="in_toptt">
				   <h1>????Ա??Ϣ</h1>
				   <h4>???????ص????????ý???????Ӵ˿?ʼ</h4>
			   </div>
			   <div class="in_aboutcon clearfix">
			      
				  
				  
				
   <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse"  class="newsline">  
      <tr>
		 <td width='11%' height=44>???ţ?</td><td width='39%'>${peisongyuanxinxi.gonghao}</td><td  rowspan=8 align=center><a href=${peisongyuanxinxi.zhaopian} target=_blank><img src=${peisongyuanxinxi.zhaopian}  width=228 height=215 border=0></a></td></tr><tr>         <td width='11%' height=44>???룺</td><td width='39%'>******</td></tr><tr>         <td width='11%' height=44>????Ա??????</td><td width='39%'>${peisongyuanxinxi.peisongyuanxingming}</td></tr><tr>         <td width='11%' height=44>?Ա???</td><td width='39%'>${peisongyuanxinxi.xingbie}</td></tr><tr>         <td width='11%' height=44>???䣺</td><td width='39%'>${peisongyuanxinxi.nianling}</td></tr><tr>         <td width='11%' height=44>??ϵ?绰??</td><td width='39%'>${peisongyuanxinxi.lianxidianhua}</td></tr><tr>         <td width='11%' height=44>????֤??</td><td width='39%'>******</td></tr><tr>         <td width='11%' height=44>״̬??</td><td width='39%'>${peisongyuanxinxi.zhuangtai}</td></tr><tr>                           <td width='11%' height=100  >??ע??</td><td width='39%' colspan=2 height=100 >${peisongyuanxinxi.beizhu}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=????  class='hsgqiehuanshitu' onClick="javascript:history.back()" /><input type=button name=Submit52 value=??ӡ class='hsgqiehuanshitu' onClick="javascript:window.print()" /> <!--jixaaxnnxiu--></td></tr>
    
  </table>
					  
						  
						  
						  
						  
			   </div>
		    </div>
        </div>
<jsp:include page="qtdown.jsp"></jsp:include>		
  
</body> 
</html>

