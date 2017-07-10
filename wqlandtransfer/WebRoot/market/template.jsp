<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>个人主页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    	
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">  
      
	<link rel="stylesheet" type="text/css" href="../css/common.css" />
	<link rel="stylesheet" type="text/css" href="../css/market.css" />
	<link rel="stylesheet" href="../bootstrap-3.3.7-dist/css/bootstrap.min.css"/>	
	
	<script language="javascript" type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
	<script language="javascript" type="text/javascript" src="../js/laydate/laydate.js"></script>
	<script language="javascript" type="text/javascript" src="../js/main.js"></script>
	<script src="../js/jquery-3.2.1.min.js"></script>
   	<script src="../bootstrap-3.3.7-dist/js\bootstrap.min.js"></script>
   	
	<script type="text/javascript">
	window.onload=function(){
	newdeal.onclick=function(){
		newdeal.style.color="rgb(15,141,255)";
		newdeal.style.fontWeight="bold";
		person.style.color="black";
		person.style.fontWeight="normal";
		dealcenter.style.color="black";
		dealcenter.style.fontWeight="normal";
	}
	person.onclick=function(){
		person.style.color="rgb(15,141,255)";
		person.style.fontWeight="bold";
		newdeal.style.color="black";
		newdeal.style.fontWeight="normal";
		dealcenter.style.color="black";
		dealcenter.style.fontWeight="normal";
		
	}
	dealcenter.onclick=function(){
		dealcenter.style.color="rgb(15,141,255)";
		dealcenter.style.fontWeight="bold";
		newdeal.style.color="black";
		newdeal.style.fontWeight="normal";
		person.style.color="black";
		person.style.fontWeight="normal";
	}
	wantbuy.onclick=function(){
		wantbuybody.style.display="block";
		wantsellbody.style.display="none";
	}
	wantsell.onclick=function(){
		wantsellbody.style.display="block";
		wantbuybody.style.display="none";
		
	}
	
}	
	</script>
	<style type="text/css">
	table{
		margin:20px auto;
		width:95%;
	}
	table,tr td{
		border:1px solid grey;	
	}
	td{
		padding:10px;
	}
	</style>	
	
  </head>
  
  
  <body>
    <div class="main">	
			<div class="top">
				<div class="back_home"><img src="../images/home.png"><a href="mainpage.jsp">首页</a>
				</div>
				<div class="back_personal"><a href="main.jsp">回到个人中心</a>
				</div>
				<div class="quit"><img src="../images/quit.png"><a href="exit.jsp">退出</a>
				</div>
			</div>	
			<div class="head">
				<img class="top_banner" src="../images/top_banner.png">
				<div class="logo"><img src="../images/logo.png">
				</div>
			<div class="platform_name"><img src="../images/name.png">
			</div>
			</div>
		</div>
	<div id="bodyshow">
		<div id="foot">
  			版权所属：武清区政府
  		</div>
  		
  		
<div class="menu">
  				<ul id="list">
  					<li id="dealcenter" class="dropdown">
  						<a href="javascript:void(0);" class="drop-down-toggle deal" data-toggle="dropdown">我要交易<b class="caret"></b></a>
  							<ul class="dropdown-menu">
  								<li id="wantbuy">
  									<a href="javascript:void(0);">查看土地转让信息</a>
  								</li>
  								<li id="wantsell">
  									<a href="javascript:alert('此功能还在开发中！');">查看土地需求信息</a>
  								</li>
  							</ul>
  					</li>
  					
  				<li id="newdeal" class="dropdown">
  					<a href="javascript:void(0);" class="drop-down-toggle deal" data-toggle="dropdown">
  						新建交易<b class="caret"></b>
  					</a>
  					<ul class="dropdown-menu">
  						<li>
  							<a href="../table/landTransferSupply.html">发布国有土地使用权转让供给信息</a>
  						</li>
  						<li>
  							<a href="../table/landTransferDemand.html">发布土地需求信息</a>
  						</li>
  					</ul>
  				</li> 
  				<li id="publish">
  					<a href="showMyTransferSupplyLandsAction.action">我发布的供给土地</a>
  				</li>
  				<li id="fitneed">
  					<a href="showConformTransferLandsAction.action">符合我需求的土地</a>
  				</li>
  				<li id="intention">
  					<a href="showMyTransferIntentionAction.action">意向交易</a>
  				</li>
  				<li id="contract">
  					<a href="showMyTransferContractAction.action">合同</a>
  				</li>		
  								
  				<li id="person" class="dropdown">
  					<a href="javascript:void(0);"class="drop-down-toggle deal"data-toggle="dropdown">
  						个人中心<b class="caret"></b>
  					</a>
  					<ul class="dropdown-menu">
  						<li>
  							<a href="javascript:alert('此功能还在开发中！');">信息修改</a>
  						</li>
  						<li>
  							<a href="javascript:alert('此功能还在开发中！');">密码修改</a>
  						</li>  					
  					</ul>
  				</li>  
  						
  			</ul>  			
  		</div>	
  		<div class="menubody">
  			<div id="wantbuybody">
  				<table>  					
  					<tr>
  						<td colspan="4" align="center"  style="border-right: #ffffff 1px solid; border-left: #ffffff 1px solid; border-top-color: #ffffff; ">土地转让信息</td>
  					</tr>					
  					<tr style="background:rgb(38,130,244);color:white;font-weight:bold;">
  						<td width="60px">编号</td>
  						<td width="120px">发布日期</td>
  						<td align="center">标题</td>
  						<td width="120px">详情</td>
  					</tr>
  					<tr>
  						<td>1</td>
  						<td>20160910</td>
  						<td>*********土地转让信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>2</td>
  						<td>20161003</td>
  						<td>*********土地转让信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>3</td>
  						<td>20161207</td>
  						<td>*********土地转让信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>4</td>
  						<td>20161225</td>
  						<td>*********土地转让信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>5</td>
  						<td>20170131</td>
  						<td>*********土地转让信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>6</td>
  						<td>20170222</td>
  						<td>*********土地转让信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>7</td>
  						<td>20170225</td>
  						<td>*********土地转让信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>8</td>
  						<td>20170225</td>
  						<td>*********土地转让信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>9</td>
  						<td>20170225</td>
  						<td>*********土地转让信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>10</td>
  						<td>20170225</td>
  						<td>*********土地转让信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>11</td>
  						<td>20170225</td>
  						<td>*********土地转让信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>12</td>
  						<td>20170225</td>
  						<td>*********土地转让信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>13</td>
  						<td>20170225</td>
  						<td>*********土地转让信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>14</td>
  						<td>20170225</td>
  						<td>*********土地转让信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>15</td>
  						<td>20170225</td>
  						<td>*********土地转让信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					
  				</table>
  			</div>
  			
  			<div id="wantsellbody">
  				<table>  					
  					<tr><td colspan="4" align="center"  style="border-right: #ffffff 1px solid; border-left: #ffffff 1px solid; border-top-color: #ffffff; ">土地需求信息</td></tr>  					
  					<tr style="background:rgb(38,130,244);color:white;font-weight:bold;">
  						<td width="60px">编号</td>
  						<td width="120px">发布日期</td>
  						<td align="center">标题</td>
  						<td width="120px">详情</td>
  					</tr>
  					<tr>
  						<td>1</td>
  						<td>20160910</td>
  						<td>*********土地需求信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>2</td>
  						<td>20161003</td>
  						<td>*********土地需求信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>3</td>
  						<td>20161207</td>
  						<td>*********土地需求信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>4</td>
  						<td>20161225</td>
  						<td>*********土地需求信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>5</td>
  						<td>20170131</td>
  						<td>*********土地需求信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>6</td>
  						<td>20170222</td>
  						<td>*********土地需求信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>7</td>
  						<td>20170225</td>
  						<td>*********土地需求信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>8</td>
  						<td>20170225</td>
  						<td>*********土地需求信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>9</td>
  						<td>20170225</td>
  						<td>*********土地需求信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>10</td>
  						<td>20170225</td>
  						<td>*********土地需求信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>11</td>
  						<td>20170225</td>
  						<td>*********土地需求信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>12</td>
  						<td>20170225</td>
  						<td>*********土地需求信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>13</td>
  						<td>20170225</td>
  						<td>*********土地需求信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>14</td>
  						<td>20170225</td>
  						<td>*********土地需求信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>15</td>
  						<td>20170225</td>
  						<td>*********土地需求信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>16</td>
  						<td>20170225</td>
  						<td>*********土地需求信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>17</td>
  						<td>20170225</td>
  						<td>*********土地需求信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>18</td>
  						<td>20170225</td>
  						<td>*********土地需求信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					<tr>
  						<td>19</td>
  						<td>20170225</td>
  						<td>*********土地需求信息</td>
  						<td><a href="">点击查看</a></td>
  					</tr>
  					
  				</table>
  			</div>
  		
  	</div>
  	</div> 
  </body>
</html>
