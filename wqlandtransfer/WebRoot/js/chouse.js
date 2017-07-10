/*
*	选择js版
*/
function Dsy(){
	this.Items = {};
}
Dsy.prototype.add = function(id,iArray){
	this.Items[id] = iArray;
}
Dsy.prototype.Exists = function(id){
	if(typeof(this.Items[id]) == "undefined") return false;
	return true;
}

function change(v){
	var str="0";
	for(i=0;i<v;i++){
		str+=("_"+(document.getElementById(s[i]).selectedIndex-1));
	};
	var ss=document.getElementById(s[v]);
	with(ss){
		length = 0;
		options[0]=new Option(opt0[v],opt0[v]);
		if(v && document.getElementById(s[v-1]).selectedIndex>0 || !v){
			if(dsy.Exists(str)){
				ar = dsy.Items[str];
				for(i=0;i<ar.length;i++){
					options[length]=new Option(ar[i],ar[i]);
				}//end for
				if(v){ options[0].selected = true; }
			}
		}//end if v
		if(++v<s.length){change(v);}
	}//End with
}

var dsy = new Dsy();

dsy.add("0",["事业单位","社团","内资企业","联营企业","有限责任公司","私营企业","港、澳、台商投资企业","外商投资企业"]);
dsy.add("0_0_0",["--",]);
dsy.add("0_0",["--"]);
dsy.add("0_1_0",["--"]);
dsy.add("0_1",["村委会"]);
dsy.add("0_2_2",["--"]);
dsy.add("0_2_1",["--"]);
dsy.add("0_2_0",["--"]);
dsy.add("0_2",["国有企业","集体企业","股份合作企业"]);
dsy.add("0_3_0",["--"]);
dsy.add("0_3",["--"]);
dsy.add("0_4_1",["--"]);
dsy.add("0_4_0",["--"]);
dsy.add("0_4",["国有投资公司（股份有限公司）","其它有限责任公司（股份有限公司）"]);
dsy.add("0_5_1",["--"]);
dsy.add("0_5_0",["--"]);
dsy.add("0_5",["其它内资企业"]);
dsy.add("0_6_1",["--"]);
dsy.add("0_6_0",["--"]);
dsy.add("0_6",["合资经营企业（港或澳、台资）","合作经营企业（港或澳、台资）","港、澳、台商独资经营企业","港、澳、台商投资股份有限公司"]);
dsy.add("0_7_1",["--"]);
dsy.add("0_7_0",["--"]);
dsy.add("0_7",["中外合资经营企业","中外合作经营企业","外资企业","外商投资股份有限公司"]);


dsy.add("0",["事业单位","社团","内资企业","联营企业","有限责任公司","私营企业","港、澳、台商投资企业","外商投资企业"]);

var s=["s_province","s_city","s_county"];//三个select的name
var opt0 = ["选择","选择","选择"];//初始值
function _init_area(){  //初始化函数
	for(i=0;i<s.length-1;i++){
	  document.getElementById(s[i]).onchange=new Function("change("+(i+1)+")");
	}
	change(0);
}
