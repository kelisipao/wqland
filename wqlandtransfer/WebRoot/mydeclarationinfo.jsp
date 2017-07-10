<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>划拨建设用地使用管理系统</title>
	</head>
	<body>
		<div>
			<table width="800" cellspacing="0" cellpadding="0">
				<tr>
					<td width="65" align="center">
						<strong>序号</strong>
					</td>
					<td width="65" align="center">
						<strong>编号</strong>
					</td>
					<td width="65" align="center">
						<strong>单位</strong>
					</td>
					<td width="65" align="center">
						<strong>证号</strong>
					</td>
					<td width="131" align="center">
						<strong>使用权人名称</strong>
					</td>
					<td width="107" align="center">
						<strong>联系方式</strong>
					</td>
					<td width="74" align="center">
						<strong>联系人</strong>
					</td>
					<td width="138" align="center">
						<strong>电话</strong>
					</td>
					<td width="70" align="center">
						<strong>状态</strong>
					</td>
					<td width="70" align="center">
						<strong>操作</strong>
					</td>
				</tr>
				<c:forEach var="declare" items="${sessionScope.declares}"
					varStatus="s">
					<tr>
						<td>
							${s.count }
						</td>
						<td>
							${declare.tlegalPerson }
						</td>
						<td>
							${declare.alegalPerson}
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
									卖方已收到交易金,双方缴纳完毕
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
							<a href="mydeclarationdetail.jsp?index=${s.index }">查看</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>

