<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>天津市武清区土地二级市场交易信息平台</title>
<link rel="stylesheet" type="text/css" href="../css/common.css" />
<script language="javascript" type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<script language="javascript" type="text/javascript" src="../js/main.js"></script>
<SCRIPT language="javascript1.2">
function showsubmenu(sid)
{
    whichEl = eval("submenu" + sid);
    if (whichEl.style.display == "none")
    {
        eval("submenu" + sid + ".style.display=\"\";");
    }
    else
    {
        eval("submenu" + sid + ".style.display=\"none\";");
    }
}
</SCRIPT>
</head>

<body>
<c:if test="${param.flag == 0}">
	<script type="text/javascript">
		alert("success");
	</script>
</c:if>
<div class="main">
	<div class="top">
		<div class="back_home"><img src="../images/home.png"><a href="information-单位申请表.html">首页</a></div>
		<div class="back_personal"><a>回到个人中心</a></div>
		<div class="quit"><img src="../images/quit.png"><a href="register.html">退出</a></div>
	</div>	
	<div class="head">
	<img class="top_banner" src="../images/top_banner.png">
	<div class="logo"><img src="../images/logo.png"></div>
	<div class="platform_name"><img src="../images/name.png"></div>
	</div>
	<div class="content_box">
        <div class="menu">
        	<TABLE cellSpacing="0" cellPadding="0" width="158" align="center">
		
		<TR>
			<TD id="menuTitle4"  style="CURSOR: hand" onclick="showsubmenu(4)" height="25"><SPAN>交易信息上传</SPAN>
			</TD>
		</TR>
		<TR>
			<TD id="submenu4" >
				<DIV style="WIDTH: 158px">
					<TABLE cellSpacing="0" cellPadding="0" width="130" align="center">
						<TR>
							<TD height="20"><A href="">我要买地</A></TD>
						</TR>
						<TR>
							<TD height="20"><A href="transfersupply.html">我要卖地</A></TD>
						</TR>
						<TR>
							<TD height="20"><A href="showMyTransferSupplyLandsAction.action">我发布的供给土地</A></TD>
						</TR>
						<TR>
							<TD height="20"><A href="showConformTransferLandsAction.action">符合我需求的土地</A></TD>
						</TR>
						<TR>
							<TD height="20"><A href="showMyTransferIntentionAction.action">意向交易</A></TD>
						</TR>
						<TR>
							<TD height="20"><A href="showMyTransferContractAction.action">合同</A></TD>
						</TR>
					</TABLE>
				</DIV>

				<DIV style="WIDTH: 158px">
					<TABLE cellSpacing="0" cellPadding="0" width="130" align="center">
						<TR>
							<TD height="20"></TD>
						</TR>
					</TABLE>
				</DIV>
			</TD>
		</TR>
	</TABLE>
        </div>
        <div class="cont">
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
				<c:forEach var="land" items="${sessionScope.allLands}" varStatus="s">
					<tr>
						<td>
							${s.count }
						</td>
						<td>
							${land.contact }
						</td>
						<td>
							${land.holder.located}
						</td>
						<td>
							<c:choose>
								<c:when test="${land.status == 0}">
									待检查
								</c:when>
								<c:when test="${land.status == 1}">
									检查通过
								</c:when>
							</c:choose>
						</td>
						<td>
							<a href="landtransferdetail.jsp?id=${s.index }">查看</a>
						</td>
					</tr>
				</c:forEach>
			</table>
        </div>
	</div>
	<div class="next"><a class="next_btn">下一步</a></div>
</div>
<!--遮罩层-->
<div class="masking"></div>
<!--弹出层-->
<div class="popWrap">
	<p>确认保存以上填写的信息吗？</p>
	<div class="btn">
		<a class="back_btn" href="information-单位申请表.html">返回</a>
		<a class="sure_btn" href="information-土地出租供应表.html">确认</a>
	</div>
</div>

</body>
</html>
