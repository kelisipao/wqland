<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta charset="utf-8">
<title>划拨建设用地使用管理系统</title>
</head>

<body>
<c:set var="index" value="${param.index}"/>
<c:set var="declare" value="${sessionScope.declares[index]}" scope="session"/>
<div id="box">
  <div id="head">&nbsp;划拨建设用地使用管理系统</div>
  <div id="main">
   <table width="800" border="0" cellspacing="2" cellpadding="0">
  <tbody>
  		<c:forEach var="pic" items="${sessionScope.declare.allPics}"
			varStatus="s" begin="1">
			${s.count } .<img src="../${pic }" width="50" height="50" />
			<br>			
			${fn:substring(pic,"21",fn:indexOf(pic,'.')) }
			<br>
		</c:forEach>
		<c:choose>
			<c:when test="${sessionScope.declare.status == 0 || sessionScope.declare.status == 1}">
				<a href="declarationPassAction.action?role=0"><input type="submit" value="通过" /> </a>
				<a href="declarationRejectAction.action?role=0"><input type="submit" value="驳回" /></a>
			</c:when>
		</c:choose>
  </tbody>
</table>
  </div>
</div>
</body>
</html>

