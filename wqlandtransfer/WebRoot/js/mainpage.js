

window.onload=function(){

//alert(aLi[0].currentStyle.width);
//document.getElementById("toleft").onclick=function(){
//speed=-2;

//};
//document.getElementById("toright").onclick=function(){
//speed=2;

//};

var showbox1=document.getElementById("imgbox1");

var oUl1=showbox1.getElementsByTagName("ul")[0];
var aLi1=oUl1.getElementsByTagName('li');

var showbox2=document.getElementById("imgbox2");

var oUl2=showbox2.getElementsByTagName("ul")[0];
var aLi2=oUl2.getElementsByTagName('li');


var speed=2;
oUl1.innerHTML=oUl1.innerHTML+oUl1.innerHTML+oUl1.innerHTML;
oUl1.style.width=aLi1[0].offsetWidth*aLi1.length+'px';

oUl2.innerHTML=oUl2.innerHTML+oUl2.innerHTML+oUl2.innerHTML;
oUl2.style.width=aLi2[0].offsetWidth*aLi2.length+'px';

function move1(){

if(oUl1.offsetLeft<-oUl1.offsetWidth/2){
		oUl1.style.left='0';
	}
	if(oUl1.offsetLeft>0){
		oUl1.style.left=-oUl1.offsetWidth/2+'px';
	
	}
	oUl1.style.left=oUl1.offsetLeft+speed+'px';
}
var timer1=setInterval(move1,50);
showbox1.onmouseover=function(){
	clearInterval(timer1);

}
showbox1.onmouseout=function(){

timer1=setInterval(move1,50);
}




function move2(){

if(oUl2.offsetLeft<-oUl2.offsetWidth/2){
		oUl2.style.left='0';
	}
	if(oUl2.offsetLeft>0){
		oUl2.style.left=-oUl2.offsetWidth/2+'px';
	
	}
	oUl2.style.left=oUl2.offsetLeft+speed+'px';
}
var timer2=setInterval(move2,50);
showbox2.onmouseover=function(){
	clearInterval(timer2);
}
showbox2.onmouseout=function(){

timer2=setInterval(move2,50);
}
};