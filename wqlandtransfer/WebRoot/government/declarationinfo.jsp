<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml" > 
<head>     
<title>政府网站政府部门主页</title> 
 <link href="bootstrap-3.3.7-dist\css\bootstrap.min.css" rel="stylesheet">
   <script src="js/jquery-3.2.1.min.js"></script>
   <script src="bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>
<style type="text/css">
*{
		margin:0;
		padding:0;
}
.body{
		width:1200px;
		height:1000px;
		margin:0px auto;

}
#log{
		width:100%;
		height:230px;
}
#topimg{

		width:100%;
		heihgt:230px;

}
#logoimg{

		position:absolute;

		top:25px;
		left:100px;
}

#logoname{

		position:absolute;
		top:60px;
		left:270px;

}
#bodyshow{

		width:100%;
		
		height:580px;
		margin:20px 0px 20px 0px;

}

.menu{

		width:200px;
		height:550px;
		/*border:1px ridge grey;*/
		
		float:left;
		margin:10px 5px 10px 10px;
}
.menubody{
		width:960px;
		height:550px;
		/*border:1px solid grey;*/
		
		float:left;
		margin:10px 10px 10px 5px;
		overflow:scroll;
		position:relative;
}
#check{
		position:relative;
		top:-20px;
		display:none;
}
#apply{
		position:relative;
		top:-20px;
		
}
#list{
		
		text-align:center;
		float:right;
}

#list li{
		margin:20px 0;
		width:100%;
		height:30px;
		text-align:left;
		
		font-size:1.5em;
		list-style-image:url("../images/home.png");
}

table{
		margin:20px auto;
		width:95%;
}
table,tr,td{
		border:1px solid grey;
	
}
td{
		padding:10px;

}
#table1{

width:95%;

}

a:link {color:#0000ff;}      /* unvisited link */
a:visited {color:#ff00ff;}  /* visited link */
a:hover {color:#ff0000;}  /* mouse over link */
a:active {color:#ff00ff;}  /* selected link */
</style>
<script type="text/javascript">
window.onload=function(){
	
/*var tr2=check.getElementsByTagName("tr");
	for(var i=1;i<tr2.length;i++){
		if(i%2==0){
		tr2[i].style.background="#e2e3e4";
		}else{
		
		tr2[i].style.background="white";
		}
	
	}

var tr1=table1.getElementsByTagName('tr');
	for(var j=1;j<tr1.length;j++){
		if(j%2==0){
			tr1[j].style.background="rgb(220,238,248)";
		}else{
		
			tr1[j].style.background="rgb(241,248,254)";
		}
	
	
	}
*/
	//var aapply=document.getElementById("aapply");
	//var acheck=document.getElementById("acheck");

	person.onclick=function(){
		person.style.fontWeight="bold";
		person.style.color="#0f8dff";
		task.style.fontWeight="";
		task.style.color="";
		back.style.fontWeight="";
		back.style.color="";
	}

	back.onclick=function(){
		back.style.fontWeight="bold";
		back.style.color="#0f8dff";
		task.style.fontWeight="";
		task.style.color="";
		person.style.fontWeight="";
		person.style.color="";
	}
	task.onclick=function(){
		task.style.fontWeight="bold";
		task.style.color="#0f8dff";
		back.style.fontWeight="";
		back.style.color="";
		person.style.fontWeight="";
		person.style.color="";
	}
}
</script>     
</head>     
	<body>
	<div class="body">
		<div id="logo">
			<br><img id="topimg" src='../images/top_banner.png'>
			<img id="logoimg" src='../images/logo.png'>
			<img id="logoname" src="../images/name.png">
		</div>
		<div id="bodyshow">
			<div class="menu">
				<ul id="list">
					<li id="person">个人中心&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
					<li id="back">返回主页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
					<li id="task">任务&nbsp;&nbsp;&nbsp;&nbsp;</li>
				 </ul>
			</div>
				<div class="menubody">
					<div id="apply">
						 <table id="table1">
							<tr>
								<thead>
									<tr style="background:rgb(38,130,244);color:white;font-weight:bold;">
										<td>编号</td>
										<td>转让方</td>
										<td>委托代理人</td>
										<td>联系电话</td>
										<td>受让方</td>
										<td>委托代理人</td>
										<td>联系电话</td>
										<td>代理人机构</td>
										<td>状态</td>
										<td>操作</td>
									</tr>
								</thead>
								<tbody>
								<c:choose>
									<c:when test="${sessionScope.declares.size() != 0}">
									<c:forEach var="declare" items="${sessionScope.declares}" varStatus="s">
					<tr>
						<td>
							${s.count }
						</td>
						<td>
							${declare.tname }
						</td>
						<td>
							${declare.tagent }
						</td>
						<td>
							${declare.tagentPhone }
						</td>
						<td>
							${declare.aname }
						</td>
						<td>
							${declare.aagent}
						</td>
						<td>
							${declare.aagentPhone}
						</td>
						<td>
							${declare.agentName}
						</td>
						<td>
							<c:choose>
								<c:when test="${declare.status == 0}">
									等待受理
								</c:when>
								<c:when test="${declare.status == 1}">
									受理未通过
								</c:when>
								<c:when test="${declare.status == 2}">
									受理通过，进入审查
								</c:when>
								<c:when test="${declare.status == 3}">
									审查未通过,等待提交补充文件
								</c:when>
								<c:when test="${declare.status == 4}">
									审查通过
								</c:when>
								<c:when test="${declare.status == 5}">
									审核决定书生成
								</c:when>
								<c:when test="${declare.status == 6}">
									买方已缴纳交易金
								</c:when>
								<c:when test="${declare.status == 7}">
									卖方已收到交易金,交易完毕
								</c:when>
								<c:when test="${declare.status == 8}">
									公示中
								</c:when>
								<c:when test="${declare.status == 9}">
									备案，交易已结束
								</c:when>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${sessionScope.role == 0}">
									<a href="declarationfilelist.jsp?index=${s.index }">查看</a>
								</c:when>
								<c:when	test="${sessionScope.role == 1}">
									<a href="declarationcontract.jsp?index=${s.index }">查看合同</a>
								</c:when>
								<c:when test="${declare.status == 4}">
									<a href="declarationReleaseExamineAction.action?index=${s.index }&role=1">生成审核决定书</a>
								</c:when>
								<c:when test="${declare.status == 5}">
									<a href="auditletter.html">查看审核决定书</a>
								</c:when>
								<c:when test="${declare.status == 6}">
									准备公示
								</c:when>
								<c:when test="${declare.status == 7}">
									<a href="declarationPublicityAction.action?index=${s.index }&role=2">公示</a>
								</c:when>
								<c:when test="${declare.status == 8}">
									<a href="declarationRecordAction.action?index=${s.index }&role=2">备案</a>
								</c:when>
								<c:when test="${declare.status == 9}">
									已备案，交易结束
								</c:when>
							</c:choose>

						</td>
					</tr>
				</c:forEach>
				</c:when>
				<c:otherwise>
					无数据
				</c:otherwise>
								</c:choose>
								</tbody>
							</tr>
						 </table>
					</div>
				
				</div>
			</div>   
		</div>    
	</body>     
</html>