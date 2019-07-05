/*var url=window.location.href;
var canshu=url.split("/")[3];
if(canshu=="index"){
	$("#index").css("display","block");
	$("#info").css("display","none");
}else if(canshu=="info"){
	$("#index").css("display","none");
	$("#info").css("display","block");
}*/
$("#1").click(function(){
	$("#index").css("display","block");
	$("#info").css("display","none");
	$("#add").css("display","none");
	$("#edit").css("display","none");
	$("#myinfo").css("display","none");
	$("#content").css("display","block");
})

$("#2").click(function(){
	$("#index").css("display","none");
	$("#info").css("display","block");
	$("#add").css("display","none");
	$("#edit").css("display","none");
	$("#myinfo").css("display","block");
	$("#content").css("display","none");
})

$("#3").click(function(){
	$("#index").css("display","none");
	$("#info").css("display","none");
	$("#add").css("display","block");
	$("#edit").css("display","block");
	$("#myinfo").css("display","none");
	$("#content").css("display","none");
})

$("#my").mouseover(function(){
	$("#bar").css("display","block");
})

$("#my").mouseout(function(){
	$("#bar").css("display","none");
})

$(function() {
    getSong();
})

//获取歌曲链接并插入dom中
function getSong() { 
    var audio = document.getElementById("audio");
    audio.src = "https://get-blog.oss-cn-shanghai.aliyuncs.com/wentaohome/徐秉龙-青柠.mp3";
    audio.loop = true; //歌曲循环
    playCotrol(); //播放控制函数

}

//点击播放/暂停
function clicks() {
    var audio = document.getElementById("audio");
    $("#control").click(function() {
        if ($("#control").hasClass("play")) {
            $("#control").addClass("pause").removeClass("play");
            audio.play();//开始播放
            //dragMove();//并且滚动条开始滑动
			$("#control").addClass("layui-icon-pause").removeClass("layui-icon-play");
        } else {
            $("#control").addClass("play").removeClass("pause");
			$("#control").addClass("layui-icon-play").removeClass("layui-icon-pause");
            //$("#control").html("点击播放");
            audio.pause();
        }
    })
}

//播放事件监听
function playCotrol() {
    audio.addEventListener("loadeddata", //歌曲一经完整的加载完毕( 也可以写成上面提到的那些事件类型)
        function() {
    	//alert(0);
            $("#control").addClass("play").removeClass("color_gray");
            clicks();
        }, false);

    audio.addEventListener("pause",
        function() { //监听暂停
    	//alert(1);
            $("#control").addClass("play").removeClass("pause");
            if (audio.currentTime == audio.duration) {
                audio.stop();
                audio.currentTime = 0;
            }
        }, false);
    audio.addEventListener("play",
        function() { //监听播放
    	//alert(2);
            $("#control").addClass("pause").removeClass("play");
        }, false);
    audio.addEventListener("ended", function() {
    }, false)
}
    