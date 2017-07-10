<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>政府网站政府部门主页</title>
		<link href="bootstrap-3.3.7-dist\css\bootstrap.min.css"
			rel="stylesheet">
		<script src="js/jquery-3.2.1.min.js">
</script>
		<script src="bootstrap-3.3.7-dist\js\bootstrap.min.js">
</script>
		<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

.body {
	width: 1200px;
	height: 1000px;
	margin: 0px auto;
}

#log {
	width: 100%;
	height: 230px;
}

#topimg {
	width: 100%;
	heihgt: 230px;
}

#logoimg {
	position: absolute;
	top: 25px;
	left: 100px;
}

#logoname {
	position: absolute;
	top: 60px;
	left: 270px;
}

#bodyshow {
	width: 100%;
	height: 580px;
	margin: 20px 0px 20px 0px;
}

.menu {
	width: 200px;
	height: 550px;
	/*border:1px ridge grey;*/
	float: left;
	margin: 10px 5px 10px 10px;
}

.menubody {
	width: 960px;
	height: 550px;
	/*border:1px solid grey;*/
	float: left;
	margin: 10px 10px 10px 5px;
	overflow: scroll;
	position: relative;
}

#check {
	position: relative;
	top: -20px;
	display: none;
}

#apply {
	position: relative;
	top: -20px;
}

#list {
	text-align: center;
	float: right;
}

#list li {
	margin: 20px 0;
	width: 100%;
	height: 30px;
	text-align: left;
	font-size: 1.5em;
	list-style-image: url("../images/home.png");
}

table {
	margin: 20px auto;
	width: 95%;
}

table,tr,td {
	border: 1px solid grey;
}

td {
	padding: 10px;
}

#table1 {
	width: 95%;
}

a:link {
	color: #0000ff;
}  /* unvisited link */
a:visited {
	color: #ff00ff;
}  /* visited link */
a:hover {
	color: #ff0000;
}  /* mouse over link */
a:active {
	color: #ff00ff;
} /* selected link */
</style>
		<script type="text/javascript">
window.onload = function() {

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
	person.onclick = function() {
		person.style.fontWeight = "bold";
		person.style.color = "#0f8dff";
		task.style.fontWeight = "";
		task.style.color = "";
		back.style.fontWeight = "";
		back.style.color = "";
	}

	back.onclick = function() {
		back.style.fontWeight = "bold";
		back.style.color = "#0f8dff";
		task.style.fontWeight = "";
		task.style.color = "";
		person.style.fontWeight = "";
		person.style.color = "";
	}
	task.onclick = function() {
		task.style.fontWeight = "bold";
		task.style.color = "#0f8dff";
		back.style.fontWeight = "";
		back.style.color = "";
		person.style.fontWeight = "";
		person.style.color = "";
	}
}
</script>
	</head>
	<body>
		<c:set var="index" value="${param.index}" />
		<c:set var="declare" value="${sessionScope.declares[index]}"
			scope="session" />
		<div class="body">
			<div id="logo">
				<img id="topimg" src='../images/top_banner.png'>
				<img id="logoimg" src='../images/logo.png'>
				<img id="logoname" src="../images/name.png">
			</div>
			<div id="bodyshow">
				<div class="menu">
					<ul id="list">
						<li id="person">
							个人中心&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</li>
						<li id="back">
							返回主页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</li>
						<li id="task">
							任务&nbsp;&nbsp;&nbsp;&nbsp;
						</li>
					</ul>
				</div>
				<div class="menubody">
					<p>
						<div id="apply">
								<img src="../${sessionScope.declare.allPics[0] }" width="50" height="50" />
								<br>			
								${fn:substring(pic,"21",fn:indexOf(pic,'.')) }
							<c:choose>
								<c:when
									test="${sessionScope.declare.status == 2 || sessionScope.declare.status == 3}">
									<a href="declarationExamineSuccessAction.action?role=1"><input
											type="submit" value="通过" /> </a>
									<a href=""><input type="submit" value="驳回" />
									</a>
								</c:when>
							</c:choose>
						</div>
				</div>
			</div>
		</div>
	</body>
</html>