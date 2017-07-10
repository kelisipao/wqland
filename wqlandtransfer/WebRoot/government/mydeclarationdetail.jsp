<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>天津市武清区土地二级市场交易信息平台-土地使用权转让审批表
</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<script language="javascript" type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script language="javascript" type="text/javascript" src="js/laydate/laydate.js"></script>
<script language="javascript" type="text/javascript" src="js/main.js"></script>
</head>

<body>
<c:set var="index" value="${param.index}"/>
<c:set var="declare" value="${sessionScope.declares[index]}" scope="session"/>
<div class="main">
	<div class="top">
		<div class="back_home"><img src="images/home.png"><a href="information-单位申请表.html">首页</a></div>
		<div class="back_personal"><a>回到个人中心</a></div>
		<div class="quit"><img src="images/quit.png"><a href="register.html">退出</a></div>
	</div>	
	<div class="head">
	<img class="top_banner" src="images/top_banner.png">
	<div class="logo"><img src="images/logo.png"></div>
	<div class="platform_name"><img src="images/name.png"></div>
	</div>
	
	<div class="content_box">
		<div class="content">
			<p class="title">天津市武清区国有土地使用权转让审批表&nbsp;<span>(<e>*</e>为必填)<br></span><span>表单编号：009WDBGFYJ09187</span></p>
			<div class="form">
				<form action="declarationInputAction.action" method="post">
				<div class="activeWrap">
					 <h1>
						<p class="partial_information">申报单位（个人）——转让方信息</p>
						 <i class="fr IconSwitch" >
							<a href="javaScript:void(0);" class="fr mrgr_10 IconUnfold" title="展开"><img src="images/icon_packup.png" ></a>
							<a href="javaScript:void(0);" class="fr mrgr_10 IconPackup" title="收起"><img src="images/icon_unfold.png" ></a>
						</i>
					 </h1>
					<ul>
						<li ><a><span><e>*</e>单位名称（个人姓名）：</span></a><input class="w820" type="text" name="declaration.tname" value="${declare.tname}" disabled="disabled"></li>
						<li><a><span><e>*</e>法人代表（负责人）：</span></a><input class="w820" type="text" name="declaration.tlegalPerson" value="${declare.tlegalPerson}" disabled="disabled"></li>
						<li><a><span><e>*</e>身份证号码：</span></a><input class="w325" type="text" name="declaration.tid" value="${declare.tid}" disabled="disabled"></li>
						<li><a><span><e>*</e>联系电话：</span></a><input class="w325" type="text" name="declaration.tphone" value="${declare.tphone}" disabled="disabled"></li>
						<li ><a><span><e>*</e>委托代理人：</span></a><input class="w820" type="text" name="declaration.tagent" value="${declare.tagent}" disabled="disabled"></li>
						<li><a><span><e>*</e>身份证件号码：</span></a><input class="w325" type="text" name="declaration.tagentId" value="${declare.tagentId}" disabled="disabled"></li>
						<li><a><span><e>*</e>联系电话：</span></a><input class="w325" type="text" name="declaration.tagentPhone" value="${declare.tagentPhone}" disabled="disabled"></li>
						<li><a><span><e>*</e>电子邮箱：</span></a><input class="w325" type="text" name="declaration.tagentEmail" value="${declare.tagentEmail}" disabled="disabled"></li>
						<li><a><span><e>*</e>通讯地址：</span></a><input class="w325" type="text" name="declaration.tagentAddr" value="${declare.tagentAddr}" disabled="disabled"></li>
					</ul>
				</div>
				<div class="activeWrap">
					 <h1>
						<p class="partial_information">申报单位（个人）——受让方信息</p>
						 <i class="fr IconSwitch" >
							<a href="javaScript:void(0);" class="fr mrgr_10 IconUnfold" title="展开"><img src="images/icon_packup.png" ></a>
							<a href="javaScript:void(0);" class="fr mrgr_10 IconPackup" title="收起"><img src="images/icon_unfold.png" ></a>
						</i>
					 </h1>
					<ul>
						<li ><a><span><e>*</e>单位名称（个人姓名）：</span></a><input class="w820" name="declaration.aname"></li>
						<li><a><span><e>*</e>法人代表（负责人）：</span></a><input class="w820" name="declaration.alegalPerson"></li>
						<li><a><span><e>*</e>身份证号码：</span></a><input class="w325" name="declaration.aid"></li>
						<li><a><span><e>*</e>联系电话：</span></a><input class="w325" name="declaration.aphone"></li>
						<li ><a><span><e>*</e>委托代理人：</span></a><input class="w820" name="declaration.aagent"></li>
						<li><a><span><e>*</e>身份证件号码：</span></a><input class="w325" name="declaration.aagentId"></li>
						<li><a><span><e>*</e>联系电话：</span></a><input class="w325" name="declaration.aagentPhone"></li>
						<li><a><span><e>*</e>电子邮箱：</span></a><input class="w325" name="declaration.aagentEmail"></li>
						<li><a><span><e>*</e>通讯地址：</span></a><input class="w325" name="declaration.aagentAddr"></li>
					</ul>
				</div>
				<div class="activeWrap">
					 <h1>
						<p class="partial_information">申报单位（个人）——代理机构信息</p>
						 <i class="fr IconSwitch" >
							<a href="javaScript:void(0);" class="fr mrgr_10 IconUnfold" title="展开"><img src="images/icon_packup.png" ></a>
							<a href="javaScript:void(0);" class="fr mrgr_10 IconPackup" title="收起"><img src="images/icon_unfold.png" ></a>
						</i>
					 </h1>
					<ul>
						<li ><a><span><e>*</e>委托代理机构：</span></a><input class="w820" name="declaration.agentName"></li>
						<li><a><span><e>*</e>资质编号：</span></a><input class="w325" name="declaration.agentSerial"></li>
						<li><a><span><e>*</e>联系电话：</span></a><input class="w325"  name="declaration.agentPhone"></li>
					</ul>
				</div>

				<div class="activeWrap">
					 <h1>
						<p class="partial_information">拟抵押土地情况</p>
						 <i class="fr IconSwitch" >
							<a href="javaScript:void(0);" class="fr mrgr_10 IconUnfold" title="展开"><img src="images/icon_packup.png" ></a>
							<a href="javaScript:void(0);" class="fr mrgr_10 IconPackup" title="收起"><img src="images/icon_unfold.png" ></a>
						</i>
					 </h1>
					<ul>
						<li><a><span><e>*</e>土地坐落：</span></a><input class="w820" name="declaration.located"></li>
						<li><a><span><e>*</e>四至范围：</span></a><div class="area_direction"><p>东至：<input name="declaration.east"></p><p>西至：<input name="declaration.west"></p><p>南至：<input name="declaration.south"></p><p>北至：<input name="declaration.north"></p></div></li>
						<li><a><span><e>*</e>土地/房屋权属证明：</span></a>
							<div class="w820 Rights-information">
								<img src="images/check.png" class="use_btn01">
								<img src="images/checked_icon.png" class="dis_none checked_btn01">&nbsp;土地使用权证&nbsp;&nbsp;&nbsp;&nbsp;
								<img src="images/check.png" class="ownership_btn02">
								<img src="images/checked_icon.png" class="dis_none checked_btn02">&nbsp;房屋所有权证&nbsp;&nbsp;&nbsp;&nbsp;
								<img src="images/check.png" class="estate_btn03">
								<img src="images/checked_icon.png" class="dis_none checked_btn03">&nbsp;房地产权证&nbsp;&nbsp;&nbsp;&nbsp;
								<img src="images/check.png" class="immovable_btn04">
								<img src="images/checked_icon.png" class="dis_none checked_btn04">&nbsp;不动产权证
							</div>
						</li>
						<li class="dis_none use_inf"><a><span></span></a><div class="w820">土地使用权证信息</div></li>
						<li class="dis_none use_inf"><a><span><e>*</e>土地使用权证号：</span></a><input class="w325" name="holder.license"></li>
						<li class="dis_none use_inf"><a><span><e>*</e>土地使用权人：</span></a><input class="w325" name="holder.holder"></li>
						<li class="dis_none use_inf"><a><span><e>*</e>土地用途：</span></a><input class="w325" name="holder.purpose"></li>
						<li class="dis_none use_inf"><a><span><e>*</e>使用权类型：</span></a><input class="w325" name="holder.useType"></li>
						<li class="dis_none use_inf"><a><span><e>*</e>终止日期：</span></a>
							<div class="controls">
							<input name="holder.endTime" type="text" class="dateTime w325" onclick="laydate({format: 'YYYY-MM-DD'});">
							</div>
						</li>
						<li class="dis_none use_inf"><a><span><e>*</e>使用权面积：</span></a><input class="w248">&nbsp;（平方米）</li>
						
						<li class="dis_none ownership_inf"><a><span></span></a><div class="w820">房屋所有权证信息</div>
						<li class="dis_none ownership_inf"><a><span><e>*</e>房屋所有权证号：</span></a><input class="w820"></li>
						<li class="dis_none ownership_inf"><a><span><e>*</e>房屋所有权人：</span></a><input class="w325"></li>
						<li class="dis_none ownership_inf"><a><span>共有情况：</span></a><input placeholder="若没有，则不填" class="w325"></li>
						<li class="dis_none ownership_inf"><a><span><e>*</e>房屋坐落：</span></a><input class="w325"></li>
						<li class="dis_none ownership_inf"><a><span><e>*</e>登记时间：</span></a>
							<div class="controls">
							<input name="" type="text" class="dateTime w325" onclick="laydate({format: 'YYYY-MM-DD'});">
							</div>
						</li>
						<li class="dis_none ownership_inf"><a><span><e>*</e>规划用途：</span></a><input class="w325"></li>
						<li class="dis_none ownership_inf"><a><span><e>*</e>建筑面积：</span></a><input class="w248">&nbsp;（平方米）</li>
						
						<li class="dis_none estate_inf"><a><span></span></a><div class="w820">房地产权证信息</div>
						<li class="dis_none estate_inf"><a><span><e>*</e>房地产权证号：</span></a><input class="w820"></li>
						<li class="dis_none estate_inf"><a><span><e>*</e>权利人：</span></a><input class="w325"></li>
						<li class="dis_none estate_inf"><a><span>地号：</span></a><input placeholder="若没有，则不填" class="w325"></li>
						<li class="dis_none estate_inf"><a><span><e>*</e>用途：</span></a><input class="w325"></li>
						<li class="dis_none estate_inf"><a><span><e>*</e>图号：</span></a><input class="w325"></li>
						<li class="dis_none estate_inf"><a><span><e>*</e>使用权类型：</span></a><input class="w325"></li>
						<li class="dis_none estate_inf"><a><span><e>*</e>权属性质：</span></a><input class="w325"></li>
						<li class="dis_none estate_inf"><a><span><e>*</e>使用权面积：</span></a><input class="w248">&nbsp;（平方米）</li>
						<li class="dis_none estate_inf"><a><span><e>*</e>终止日期：</span></a>
							<div class="controls">
							<input name="" type="text" class="dateTime w325" onclick="laydate({format: 'YYYY-MM-DD'});">
							</div>
						</li>
						
						<li class="dis_none immovable_inf"><a><span></span></a><div class="w820">不动产权证信息</div>
						<li class="dis_none immovable_inf"><a><span><e>*</e>不动产权证号：</span></a><input class="w820"></li>
						<li class="dis_none immovable_inf"><a><span><e>*</e>共有情况：</span></a><input class="w325"></li>
						<li class="dis_none immovable_inf"><a><span>权利人：</span></a><input placeholder="若没有，则不填" class="w325"></li>
						<li class="dis_none immovable_inf"><a><span><e>*</e>不动产单元号：</span></a><input class="w325"></li>
						<li class="dis_none immovable_inf"><a><span><e>*</e>权利类型：</span></a><input class="w325"></li>
						<li class="dis_none immovable_inf"><a><span><e>*</e>权利性质：</span></a><input class="w325"></li>
						<li class="dis_none immovable_inf"><a><span><e>*</e>用途：</span></a><input class="w325"></li>
						<li class="dis_none immovable_inf"><a><span><e>*</e>面积：</span></a><input class="w248">&nbsp;（平方米）</li>
						<li class="dis_none immovable_inf"><a><span><e>*</e>终止日期：</span></a>
							<div class="controls">
							<input name="" type="text" class="dateTime w325" onclick="laydate({format: 'YYYY-MM-DD'});">
							</div>
						</li>
						
						<li><a><span>权利其他情况：</span></a><input class="w820"></li>
						<li><a><span><e>*</e>容积率：</span></a><input class="w325" name="declaration.plotRadio"></li>
						<li><a><span><e>*</e>建筑高度：</span></a><input class="w325" name="declaration.high"></li>
						<li><a><span><e>*</e>绿化率：</span></a><input class="w325" name="declaration.green"></li>
						<li><a><span><e>*</e>建筑密度：</span></a><input class="w325" name="declaration.buildDensity"></li>
						<li><a><span><e>*</e>产业类型：</span></a><input class="w325" name="declaration.industryType"></li>
						<li><a><span>投资强度：</span></a><input class="w248" name="declaration.investment">（万元/亩）</li>
						<li><a><span>土地产出：</span></a><input class="w248" name="declaration.overcome">（万元/亩）</li>
						<li><a><span>土地税收：</span></a><input class="w248" name="declaration.revenue">（万元/亩）</li>
						<li><a><span><e>*</e>土地是否有纠纷：</span></a><div class="w325">
						<input type="radio" name="declaration.dispute" checked="checked" value="0">&nbsp;是&nbsp;&nbsp;
						<input type="radio" name="declaration.dispute" value="1">&nbsp;否&nbsp;&nbsp;
						<input type="radio" name="declaration.dispute" value="2">&nbsp;其他&nbsp;&nbsp;</div>
						</li>
						<li><a><span><e>*</e>土地是否有抵押：</span></a><div class="w325">
						<input type="radio" name="declaration.pledge" checked="checked" value="0">&nbsp;是&nbsp;&nbsp;
						<input type="radio" name="declaration.pledge" value="1">&nbsp;否&nbsp;&nbsp;
						<input type="radio" name="declaration.pledge" value="2">&nbsp;其他&nbsp;&nbsp;</div>
						</li>
						<li><a><span><e>*</e>土地是否有出租：</span></a><div class="w325">
						<input type="radio" name="declaration.hire" checked="checked" value="0">&nbsp;是&nbsp;&nbsp;
						<input type="radio" name="declaration.hire" value="1">&nbsp;否&nbsp;&nbsp;
						<input type="radio" name="declaration.hire" value="2">&nbsp;其他&nbsp;&nbsp;</div>
						</li>
						<li><a><span><e>*</e>土地是否有查封：</span></a><div class="w325">
						<input type="radio" name="declaration.seal" checked="checked" value="0">&nbsp;是&nbsp;&nbsp;
						<input type="radio" name="declaration.seal" value="1">&nbsp;否&nbsp;&nbsp;
						<input type="radio" name="declaration.seal" value="2">&nbsp;其他&nbsp;&nbsp;</div>
						</li>
						<li><a><span><e>*</e>土地是否有闲置：</span></a><div class="w325">
						<input type="radio" name="declaration.idle" checked="checked" value="0">&nbsp;是&nbsp;&nbsp;
						<input type="radio" name="declaration.idle" value="1">&nbsp;否&nbsp;&nbsp;
						<input type="radio" name="declaration.idle" value="2">&nbsp;其他&nbsp;&nbsp;</div>
						</li>
						<li><a><span><e>*</e>土地是否有储备：</span></a><div class="w325">
						<input type="radio" name="declaration.store" checked="checked" value="0">&nbsp;是&nbsp;&nbsp;
						<input type="radio" name="declaration.store" value="1">&nbsp;否&nbsp;&nbsp;
						<input type="radio" name="declaration.store" value="2">&nbsp;其他&nbsp;&nbsp;</div>
						</li>
						<li><a><span><e>*</e>有无出让金缴清证明：</span></a><div class="w325">
						<input type="radio" name="declaration.payProof" checked="checked" value="0">&nbsp;是&nbsp;&nbsp;
						<input type="radio" name="declaration.payProof" value="1">&nbsp;否&nbsp;&nbsp;
						<input type="radio" name="declaration.payProof" value="2">&nbsp;其他&nbsp;&nbsp;</div>
						</li>
						<li><a><span><e>*</e>是有无有土地来源证明：</span></a><div class="w325">
						<input type="radio" name="declaration.source" checked="checked" value="0">&nbsp;是&nbsp;&nbsp;
						<input type="radio" name="declaration.source" value="1">&nbsp;否&nbsp;&nbsp;
						<input type="radio" name="declaration.source" value="2">&nbsp;其他&nbsp;&nbsp;</div>
						</li>
						<li><a><span><e>*</e>有无相关权利人同意书：</span></a><div class="w325">
						<input type="radio" name="declaration.consent" checked="checked" value="0">&nbsp;是&nbsp;&nbsp;
						<input type="radio" name="declaration.consent" value="1">&nbsp;否&nbsp;&nbsp;
						<input type="radio" name="declaration.consent" value="2">&nbsp;其他&nbsp;&nbsp;</div>
						</li>
						<li><a><span><e>*</e>是否有审计报告：</span></a><div class="w325">
						<input type="radio" name="declaration.audit" checked="checked" value="0">&nbsp;是&nbsp;&nbsp;
						<input type="radio" name="declaration.audit" value="1">&nbsp;否&nbsp;&nbsp;
						<input type="radio" name="declaration.audit" value="2">&nbsp;其他&nbsp;&nbsp;</div>
						</li>
						<li><a><span><e>*</e>土地转让面积：</span></a><input class="w248" name="declaration.transferLandArea">&nbsp;（平方米）</li>
						<li><a><span><e>*</e>转让建筑面积：</span></a><input class="w248" name="declaration.transferBuildArea">&nbsp;（平方米）</li>
						<li><a><span><e>*</e>交地方式：</span></a><input class="w325" name="declaration.payLandType"></li>
						<li><a><span><e>*</e>转让总金额：</span></a><input class="w248" name="declaration.transferAmount">&nbsp;（万元）</li>
						<li><a><span><e>*</e>转让年限（年）：</span></a><input class="w325" name="declaration.transferYear"></li>
						<li><a><span><e>*</e>付款方式：</span></a><input class="w325" name="declaration.payType"></li>
						<li><a><span><e>*</e>原批准土地用途：</span></a><input class="w325" name="declaration.originalUse"></li>
						<li><a><span><e>*</e>现申请土地用途：</span></a><input class="w325" name="declaration.currentUse"></li>
						<li><a><span><e>*</e>备注：</span></a><textarea class="w820" name="declaration.remark"></textarea></li>
					</ul>
					</div>
				<div class="activeWrap">
					 <h1>
						<p class="partial_information">窗口意见</p>
						 <i class="fr IconSwitch" >
							<a href="javaScript:void(0);" class="fr mrgr_10 IconPackup" title="收起"><img src="images/icon_packup.png" ></a>
							<a href="javaScript:void(0);" class="fr mrgr_10 IconUnfold" title="展开"><img src="images/icon_unfold.png" ></a>
						</i>
					 </h1>
					<ul class="dis_none">
						<li><a><span><e>*</e>窗口意见：</span></a><div class="area_direction"><p><textarea></textarea></p>
							<div class="signature">
								<p class="s_date">经办人：<input>日期：<input>&nbsp;年&nbsp;<input>&nbsp;月&nbsp;<input>&nbsp;日</p>
							</div></li><a class="verify_btn">确认提交意见</a>
					</ul>
				</div>		
				<div class="activeWrap">
					 <h1>
						<p class="partial_information">主办科室意见</p>
						 <i class="fr IconSwitch" >
							<a href="javaScript:void(0);" class="fr mrgr_10 IconPackup" title="收起"><img src="images/icon_packup.png" ></a>
							<a href="javaScript:void(0);" class="fr mrgr_10 IconUnfold" title="展开"><img src="images/icon_unfold.png" ></a>
						</i>
					 </h1>
					<ul class="dis_none">
						<li><a><span><e>*</e>经办人意见：</span></a><div class="area_direction"><p><textarea></textarea></p>
							<div class="signature">
								<p class="s_date">日期：<input>&nbsp;年&nbsp;<input>&nbsp;月&nbsp;<input>&nbsp;日</p>
							</div></li><a class="verify_btn">确认提交意见</a>
						<li><a><span><e>*</e>科长意见：</span></a><div class="area_direction"><p><textarea></textarea></p>
							<div class="signature">
								<p class="s_date">日期：<input>&nbsp;年&nbsp;<input>&nbsp;月&nbsp;<input>&nbsp;日</p>
							</div>
						</div></li><a class="verify_btn">确认提交意见</a>
					</ul>
				</div>
				<div class="activeWrap">
					 <h1>
						<p class="partial_information">局长审核意见</p>
						 <i class="fr IconSwitch" >
							<a href="javaScript:void(0);" class="fr mrgr_10 IconPackup" title="收起"><img src="images/icon_packup.png" ></a>
							<a href="javaScript:void(0);" class="fr mrgr_10 IconUnfold" title="展开"><img src="images/icon_unfold.png" ></a>
						</i>
					 </h1>
					<ul class="dis_none">
						<li><a><span><e>*</e>分管副局长审核意见：</span></a><div class="area_direction"><p><textarea></textarea></p>
							<div class="signature">
								<p class="s_date">日期：<input>&nbsp;年&nbsp;<input>&nbsp;月&nbsp;<input>&nbsp;日</p>
							</div>
						</div></li><a class="verify_btn">确认提交意见</a>
						<li><a><span><e>*</e>局长审核意见：</span></a><div class="area_direction"><p><textarea></textarea></p>
							<div class="signature">
								<p class="s_date">日期：<input>&nbsp;年&nbsp;<input>&nbsp;月&nbsp;<input>&nbsp;日</p>
							</div>
						</div></li>
						<a class="verify_btn">确认提交意见</a>
					</ul>
				</div>
						<p class="annotation"></p>
					</ul>
				</div>
			</div>
		</div></div>
	<!--<div class="next"><a href="information-国有土地使用权转让申报表.html">上一步</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="next_btn">下一步</a>
</div>
--><!--遮罩层-->
<div class="masking"></div>
<!--弹出层-->
<div class="popWrap">
	<p>确认保存以上填写的信息吗？</p>
	<div class="btn">
		<a class="back_btn" href="information-国有土地使用权转让审批表.html">返回</a>
		<a class="sure_btn" href="">确认</a>
	</div>
</div>
</body>
</html>
