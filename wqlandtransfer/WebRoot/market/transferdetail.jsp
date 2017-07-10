<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>划拨建设用地使用管理系统</title>
<link rel="stylesheet" type="text/css" href="../css/common1.css" />
<script language="javascript" type="text/javascript" src="../js/jquery-1.8.3.min1.js"></script>
<script language="javascript" type="text/javascript" src="../js/laydate/laydate.js"></script>
<script language="javascript" type="text/javascript" src="../js/main1.js"></script>
</head>

<body>
<c:set var="index" value="${param.index}"/>
<c:set var="land" value="${sessionScope.allLands[index]}" scope="session"/>
<div id="box">
  
  <div id="main">
   <table width="800" border="0" cellspacing="2" cellpadding="0">
  <tbody>
  		<div class="content">
			<p class="title">天津市武清区国有土地使用权转让供给表&nbsp;<span>(<e>*</e>为必填)<br></span><span>表单编号：009WDBGFYJ09187</span></p>
			<div class="form">
				<ul>
					<li><a><span><e>*</e>填表人员：</span></a>
							<div class="w820">
								<input type="radio" name="land.preparer" class="holder_icon" value="0" checked="checked">&nbsp;土地使用权人&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="land.preparer" class="agent_icon" value="1">&nbsp;代理人
							</div></li>
					<li class="dis_none upload_att"><a><span><e>*</e>附件上传：</span></a><div >
						<span class="uploadWrap w820">
							<input type="file" class="fileWrap" name="allFiles">
							<input type="text" class="textWrap" id="textfield">
							<input type="button" class="btnWrap" value="选择上传...">
						</span>
						</div>
						<p>若为中介机构填写此表单，则必须为注册中介机构，且必须上传授权委托书；<br>或非土地使用权人本人填写，必须上传授权委托书和被委托人身份证！</p>
					</li>
					<li><a><span><e>*</e>联系方式：</span></a><input class="w820" type="text" name="land.contact" value="${land.contact}" disabled="disabled"/></li>
						<li><a><span><e>*</e>土地/房屋权属证明：</span></a>
							<div class="w820 Rights-information">
								<img src="../images/check.png" class="use_btn01">
								<img src="../images/checked_icon.png" class="dis_none checked_btn01">&nbsp;土地使用权证&nbsp;&nbsp;&nbsp;&nbsp;
								<img src="../images/check.png" class="ownership_btn02">
								<img src="../images/checked_icon.png" class="dis_none checked_btn02">&nbsp;房屋所有权证&nbsp;&nbsp;&nbsp;&nbsp;
								<img src="../images/check.png" class="estate_btn03">
								<img src="../images/checked_icon.png" class="dis_none checked_btn03">&nbsp;房地产权证&nbsp;&nbsp;&nbsp;&nbsp;
								<img src="../images/check.png" class="immovable_btn04">
								<img src="../images/checked_icon.png" class="dis_none checked_btn04">&nbsp;不动产权证
							</div>
						</li>
						<li class="dis_none use_inf"><a><span></span></a><div class="w820">土地使用权证信息</div></li>
						<li class="dis_none use_inf"><a><span><e>*</e>土地使用权证号：</span></a><input class="w820" type="text" name="holder.license" value="${land.holder.license}" disabled="disabled"></li>
						<li class="dis_none use_inf"><a><span><e>*</e>土地坐落：</span></a><input class="w325" type="text" name="holder.located" value="${land.holder.located}" disabled="disabled"></li>
						<li class="dis_none use_inf"><a><span><e>*</e>土地使用权人：</span></a><input class="w325" type="text" name="holder.holder" value="${land.holder.holder}" disabled="disabled"></li>
						<li class="dis_none use_inf"><a><span><e>*</e>土地用途：</span></a><input class="w325" type="text" name="holder.purpose" value="${land.holder.purpose}" disabled="disabled"></li>
						<li class="dis_none use_inf"><a><span><e>*</e>使用权类型：</span></a><input class="w325" type="text" name="holder.useType" value="${land.holder.useType}" disabled="disabled"></li>
						<li class="dis_none use_inf"><a><span><e>*</e>终止日期：</span></a>
							<div class="controls">
							<input name="holder.endTime" type="text" class="dateTime w325" onclick="laydate({format: 'YYYY-MM-DD'});">
							</div>
						</li>
						<li class="dis_none use_inf"><a><span><e>*</e>使用权面积：</span></a><input class="w248" type="text" name="holder.useArea">&nbsp;（平方米）</li>
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
						<li class="dis_none ownership_inf"><a><span><e>*</e>房屋所有权证信息：</span></a><div >
						<span class="uploadWrap w820">
							<input type="file" class="fileWrap">
							<input type="text" class="textWrap" id="textfield">
							<input type="button" class="btnWrap" value="选择上传...">
						</span>
						</div>
						<p>（扫描件或者拍摄照片，控制在1M以下）</p>
					</li>
						<li class="dis_none estate_inf"><a><span></span></a><div class="w820">房地产权证信息</div>
						<li class="dis_none estate_inf"><a><span><e>*</e>房地产权证号：</span></a><input class="w325"></li>
						<li class="dis_none estate_inf"><a><span><e>*</e>权利人：</span></a><input class="w325"></li><li class="dis_none estate_inf"><a><span><e>*</e>坐落：</span></a><input placeholder="" class="w325"></li>
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
						<li class="dis_none immovable_inf"><a><span><e>*</e>不动产权证号：</span></a><input class="w325"></li>
						<li class="dis_none immovable_inf"><a><span><e>*</e>权利人：</span></a><input placeholder="" class="w325"></li>
						<li class="dis_none immovable_inf"><a><span><e>*</e>共有情况：</span></a><input class="w325"></li>
						<li class="dis_none immovable_inf"><a><span><e>*</e>坐落：</span></a><input placeholder="" class="w325"></li>
						<li class="dis_none immovable_inf"><a><span><e>*</e>不动产单元号：</span></a><input class="w325"></li>
						<li class="dis_none immovable_inf"><a><span><e>*</e>权利类型：</span></a><input class="w325"></li>
						<li class="dis_none immovable_inf"><a><span><e>*</e>权利性质：</span></a><input class="w325"></li>
						<li class="dis_none immovable_inf"><a><span><e>*</e>用途：</span></a><input class="w325"></li>
						<li class="dis_none immovable_inf"><a><span><e>*</e>面积：</span></a><input class="w248">&nbsp;（平方米）</li>
						<li class="dis_none immovable_inf"><a><span><e>*</e>使用期限：</span></a>
							<input class="w325">
						</li>
				</ul>
				<div class="activeWrap">
					 <h1>
						<p class="partial_information">规划信息</p>
						 <i class="fr IconSwitch" >
							<a href="javaScript:void(0);" class="fr mrgr_10 IconPackup" title="收起"><img src="../images/icon_packup.png" ></a>
							<a href="javaScript:void(0);" class="fr mrgr_10 IconUnfold" title="展开"><img src="../images/icon_unfold.png" ></a>
						</i>
					 </h1>
					<ul class="dis_none">
						<li><a><span><e>*</e>容积率：</span></a><input class="w325" type="text" name="land.plotRadio"></li>
						<li><a><span><e>*</e>建筑高度：</span></a><input class="w325" type="text" name="land.high"></li>
						<li><a><span><e>*</e>绿化率：</span></a><input class="w325" type="text" name="land.green"></li>
						<li><a><span><e>*</e>建筑密度：</span></a><input class="w325" type="text" name="land.buildDensity"></li>
					</ul>
				</div>
				<div class="activeWrap">
					 <h1>
						<p class="partial_information">地块情况</p>
						 <i class="fr IconSwitch" >
							<a href="javaScript:void(0);" class="fr mrgr_10 IconPackup" title="展开"><img src="../images/icon_packup.png" ></a>
							<a href="javaScript:void(0);" class="fr mrgr_10 IconUnfold" title="收起"><img src="../images/icon_unfold.png" ></a>
						</i>
					 </h1>
					<ul class="dis_none">
						<li><a><span>拟转让土地面积：</span></a><input class="w248" type="text" name="situation.">&nbsp;（平方米）</li>
						<li><a><span>拟转让建筑面积：</span></a><input class="w248" type="text" name="situation.">&nbsp;（平方米）</li>
						<li><a><span>拟转让总金额：</span></a><input class="w248" type="text" name="situation.">&nbsp;&nbsp;&nbsp;&nbsp;（万元）</li>
						<li><a><span>转让年限：</span></a><input class="w248" type="text" name="situation.">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（年）</li>
						<li><a><span><e>*</e>拟付款方式：</span></a><div class="w820">
								<input type="radio" name="situation.payType" value="0" checked="checked">&nbsp;现金付款&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="situation.payType" value="1">&nbsp;支票付款&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="situation.payType" value="2">&nbsp;分期付款&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="situation.payType" value="3">&nbsp;延期付款
							</div></li>
						<li><a><span><e>*</e>四至范围：</span></a><div class="area_direction"><p>东至：<input type="text" name="situation.east"></p><p>西至：<input type="text" name="situation.west"></p><p>南至：<input type="text" name="situation.south"></p><p>北至：<input type="text" name="situation.north"></p></div></li>
						<li><a><span><e>*</e>备注：</span></a><textarea class="w820" name="situation.remark"></textarea></li>
					</ul>
				</div>
				<div class="activeWrap">
					 <h1>
						<p class="partial_information">土地开发情况</p>
						 <i class="fr IconSwitch" >
							<a href="javaScript:void(0);" class="fr mrgr_10 IconPackup" title="展开"><img src="../images/icon_packup.png" ></a>
							<a href="javaScript:void(0);" class="fr mrgr_10 IconUnfold" title="收起"><img src="../images/icon_unfold.png" ></a>
						</i>
					 </h1>
					<ul class="dis_none">
						<li><a><span>给水：</span></a><div class="w325">
						<input type="radio" name="land.heat" value="0" checked="checked">&nbsp;已接通&nbsp;&nbsp;
						<input type="radio" name="land.heat" value="1">&nbsp;暂未接通，但可接通&nbsp;&nbsp;
						<input type="radio" name="land.heat" value="2">&nbsp;难接通</div>
						</li>
						<li><a><span>排水：</span></a><div class="w325">
						<input type="radio" name="land.supplyWater" value="0" checked="checked">&nbsp;已接通&nbsp;&nbsp;
						<input type="radio" name="land.supplyWater" value="1">&nbsp;暂未接通，但可接通&nbsp;&nbsp;
						<input type="radio" name="land.supplyWater" value="0">&nbsp;难接通</div>
						</li>
						<li><a><span>通暖气：</span></a><div class="w325">
						<input type="radio" name="land.drainWater" value="0" checked="checked">&nbsp;已接通&nbsp;&nbsp;
						<input type="radio" name="land.drainWater" value="1">&nbsp;暂未接通，但可接通&nbsp;&nbsp;
						<input type="radio" name="land.drainWater" value="2">&nbsp;难接通</div>
						</li>
						<li><a><span>通天然气/煤气：</span></a><div class="w325">
						<input type="radio" name="land.gas" value="0" checked="checked">&nbsp;已接通&nbsp;&nbsp;
						<input type="radio" name="land.gas" value="1">&nbsp;暂未接通，但可接通&nbsp;&nbsp;
						<input type="radio" name="land.gas" value="2">&nbsp;难接通</div>
						</li>
						<li><a><span>通讯：</span></a><div class="w325">
						<input type="radio" name="land.communication" value="0" checked="checked">&nbsp;已接通&nbsp;&nbsp;
						<input type="radio" name="land.communication" value="1">&nbsp;暂未接通，但可接通&nbsp;&nbsp;
						<input type="radio" name="land.communication" value="2">&nbsp;难接通</div>
						</li>
						<li><a><span>通电：</span></a><div class="w325">
						<input type="radio" name="land.elec" value="0" checked="checked">&nbsp;已接通&nbsp;&nbsp;
						<input type="radio" name="land.elec" value="1">&nbsp;暂未接通，但可接通&nbsp;&nbsp;
						<input type="radio" name="land.elec" value="2">&nbsp;难接通</div>
						</li>
						<li><a><span>通路：</span></a><div class="w325">
						<input type="radio" name="land.passage" value="0" checked="checked">&nbsp;水泥（沥青）路&nbsp;&nbsp;
						<input type="radio" name="land.passage" value="1">&nbsp;机耕路&nbsp;&nbsp;
						<input type="radio" name="land.passage" value="2">&nbsp;土路</div>
						</li>
						<li><a><span>附属设施：</span></a><textarea class="w820" name="land.facilities"></textarea></li>
						<li><a><span>交通情况：</span></a><textarea class="w820" name="land.traffic"></textarea></li>
				</ul>
				</div>		
				<div class="activeWrap">
					 <h1>
						<p class="partial_information">利用情况信息</p>
						 <i class="fr IconSwitch" >
							<a href="javaScript:void(0);" class="fr mrgr_10 IconPackup" title="展开"><img src="../images/icon_packup.png" ></a>
							<a href="javaScript:void(0);" class="fr mrgr_10 IconUnfold" title="收起"><img src="../images/icon_unfold.png" ></a>
						</i>
					 </h1>
					<ul class="dis_none">
						<li><a><span><e>*</e>土地是否有纠纷：</span></a><div class="w325">
						<input type="radio" name="land.dispute" value="0" checked="checked">&nbsp;是&nbsp;&nbsp;
						<input type="radio" name="land.dispute" value="1">&nbsp;否&nbsp;&nbsp;
						<input type="radio" name="land.dispute" value="2">&nbsp;其他&nbsp;&nbsp;</div>
						</li>
						<li><a><span><e>*</e>土地是否有抵押：</span></a><div class="w325">
						<input type="radio" name="land.pledge" value="0" checked="checked">&nbsp;是&nbsp;&nbsp;
						<input type="radio" name="land.pledge" value="1">&nbsp;否&nbsp;&nbsp;
						<input type="radio" name="land.pledge" value="2">&nbsp;其他&nbsp;&nbsp;</div>
						</li>
						<li><a><span><e>*</e>土地是否有出租：</span></a><div class="w325">
						<input type="radio" name="land.hire" value="0" checked="checked">&nbsp;是&nbsp;&nbsp;
						<input type="radio" name="land.hire" value="1">&nbsp;否&nbsp;&nbsp;
						<input type="radio" name="land.hire" value="2">&nbsp;其他&nbsp;&nbsp;</div>
						</li>
						<li><a><span><e>*</e>土地是否有查封：</span></a><div class="w325">
						<input type="radio" name="land.seal" value="0" checked="checked">&nbsp;是&nbsp;&nbsp;
						<input type="radio" name="land.seal" value="1">&nbsp;否&nbsp;&nbsp;
						<input type="radio" name="land.seal" value="2">&nbsp;其他&nbsp;&nbsp;</div>
						</li>
						<li><a><span><e>*</e>土地是否有闲置：</span></a><div class="w325">
						<input type="radio" name="land.idle" value="0" checked="checked">&nbsp;是&nbsp;&nbsp;
						<input type="radio" name="land.idle" value="1">&nbsp;否&nbsp;&nbsp;
						<input type="radio" name="land.idle" value="2">&nbsp;其他&nbsp;&nbsp;</div>
						</li>
						<li><a><span><e>*</e>土地是否有储备：</span></a><div class="w325">
						<input type="radio" name="land.store" value="0" checked="checked">&nbsp;是&nbsp;&nbsp;
						<input type="radio" name="land.store" value="1">&nbsp;否&nbsp;&nbsp;
						<input type="radio" name="land.store" value="2">&nbsp;其他&nbsp;&nbsp;</div>
						</li>
						<li><a><span><e>*</e>有无出让金缴清证明：</span></a><div class="w325">
						<input type="radio" name="land.payProof" value="0" checked="checked">&nbsp;是&nbsp;&nbsp;
						<input type="radio" name="land.payProof" value="1">&nbsp;否&nbsp;&nbsp;
						<input type="radio" name="land.payProof" value="2">&nbsp;其他&nbsp;&nbsp;</div>
						</li>
						<li><a><span><e>*</e>是有无有土地来源证明：</span></a><div class="w325">
						<input type="radio" name="land.source" value="0" checked="checked">&nbsp;是&nbsp;&nbsp;
						<input type="radio" name="land.source" value="1">&nbsp;否&nbsp;&nbsp;
						<input type="radio" name="land.source" value="2">&nbsp;其他&nbsp;&nbsp;</div>
						</li>
						<li><a><span><e>*</e>有无相关权利人同意书：</span></a><div class="w325">
						<input type="radio" name="land.consent" value="0" checked="checked">&nbsp;是&nbsp;&nbsp;
						<input type="radio" name="land.consent" value="1">&nbsp;否&nbsp;&nbsp;
						<input type="radio" name="land.consent" value="2">&nbsp;其他&nbsp;&nbsp;</div>
						</li>
						<li><a><span><e>*</e>是否有审计报告：</span></a><div class="w325">
						<input type="radio" name="land.audit" value="0" checked="checked">&nbsp;是&nbsp;&nbsp;
						<input type="radio" name="land.audit" value="1">&nbsp;否&nbsp;&nbsp;
						<input type="radio" name="land.audit" value="2">&nbsp;其他&nbsp;&nbsp;</div>
						</li>
						<p class="annotation">注：土地纠纷主要有：<br>
 
  （1）用地单位遗失征用土地的凭据，造成无据可查，从而引起的土地争议。<br>
 
  （2）企业与企业之间因土地权属不清而引起的土地权属争议。</p>
					</ul>
				</div>
			</div>
		</div>
       <tr>
      <td height="60" colspan="6" align="center"><a href="transferfiles.jsp"><input type="submit" value="查看文件"></a></td>
      </tr>
  </tbody>
</table>
  </div>
  <div id="footer">版权信息</div>
</div>
</body>
</html>

