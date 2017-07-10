$(function (){


	// 营销活动配置规则页面js
	// 展开收起js
	$('.IconSwitch').live('click',function(){
		var par = $(this).parent().parent('.activeWrap');
		$(par).toggleClass("packup");
		$(par).children('ul').stop(true,true).slideToggle(200);
		$(par).children('div').stop(true,true).slideToggle(200);
		$(par).children('p').stop(true,true).slideToggle(200);
	});
//关闭弹出层
	$('.next_btn').click(function(){
		$('.masking').show();
		$('.popWrap').show();
		$('body').css({
			overflow: 'auto'
		});
	});
	$('.back_btn').click(function(){
		$('.masking').hide();
		$('.popWrap').hide();
		$('body').css({
			overflow: 'auto'
		});
	});
	
//隐藏显示
	$(".warrant").click(function(){
		$(this).addClass("currentA");
		$(".estate").removeClass("currentA");
		$(".warrant-con").show();
		$(".estate-con").hide();
	});
	$(".estate").click(function(){
		$(this).addClass("currentA");
		$(".warrant").removeClass("currentA");
		$(".estate-con").show();
		$(".warrant-con").hide();
		
	});
	$(".use_btn01").click(function(){
		$(".checked_btn01").show();
		$(".use_btn01").hide();
		$(".use_inf").slideDown();
	});
	$(".checked_btn01").click(function(){
		$(".checked_btn01").hide();
		$(".use_btn01").show();
		$(".use_inf").slideUp();
	
	});
	$(".ownership_btn02").click(function(){
		$(".ownership_btn02").hide();
		$(".checked_btn02").show();
		$(".ownership_inf").slideDown();
	});
	$(".checked_btn02").click(function(){
		$(".ownership_btn02").show();
		$(".checked_btn02").hide();	
		$(".ownership_inf").slideUp();
	});
	$(".estate_btn03").click(function(){
		$(".checked_btn03").show();	
		$(".estate_btn03").hide();
		$(".estate_inf").slideDown();	
	});
	$(".checked_btn03").click(function(){
		$(".checked_btn03").hide();	
		$(".estate_btn03").show();
		$(".estate_inf").slideUp();
	});
	$(".immovable_btn04").click(function(){
		$(".immovable_btn04").hide();
		$(".checked_btn04").show();
		$(".immovable_inf").slideDown();	
	});
	$(".checked_btn04").click(function(){
		$(".immovable_btn04").show();
		$(".checked_btn04").hide();
		$(".immovable_inf").slideUp();	
	});
	$(".holder_icon").click(function(){
		$(".upload_att").slideUp();
	});
	$(".agent_icon").click(function(){
		$(".upload_att").slideDown();
	});
	$(".other_mat").click(function(){
		$(".checked_btn05").show();
		$(".other_mat").hide();
		$(".other_pic").show();
	});
	$(".checked_btn05").click(function(){
		$(".checked_btn05").hide();
		$(".other_mat").show();
		$(".other_pic").hide();
	});
});


// 判断是否需要添加展开收起按钮
function SwitchBtn(obj){
	var par = $(obj).parent("h1").parent(".activeWrap");
	var iconStr = "<i class='fr IconSwitch'><a href='javaScript:void(0);' class='fr mrgr_10 IconPackup' title='收起'><img src='../images/icon_packup.png'></a><a href='javaScript:void(0);' class='fr mrgr_10 IconUnfold' title='展开'><img src='../images/icon_unfold.png'></a></i>";
	if ( $(par).hasClass('packup') ){
		$(par).removeClass('packup');
		$(par).children('h1').children('span').after(iconStr);
	}
	else{
		return;
	}
}


