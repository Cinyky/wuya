$(function() {
	<!--提示框组件-- >
	$("[data-toggle='share_tooltip']").tooltip();
	$("[data-toggle='showAll_tooltip']").tooltip();
	$("[data-toggle='shield_tooltip']").tooltip();
	<!--屏幕滚动条组件-- >
	num = 9;
	//滚动到页面底部时，自动加载更多  
	$(window).scroll(function() {
		var scrollh = $(document).height(); //页面总高度
		var scrollTop = $(document).scrollTop();//滚动条距离顶部
		var viewH = window.innerHeight;//可视窗口大小
		console.debug((viewH + scrollTop) == scrollh);
		if((viewH + scrollTop) == scrollh) {
			for(var i =1 ;i<=10;i++){
				num += 1;
				console.debug(num);
				var str = "<div class='piece' id='piece"+(num)+"'>";
				str	+="<ul class='media-list'>";
				str	+="	<li class='media'>";
				str	+="		<a href='#' class='pull-left'><img class='img-rounded media-object' src='topic/topic_1.jpg' height='42' width='42'></a>";
				str	+="		<div class='media-body'>";
				str	+="			<button type='button' class='close pull-right' id='close"+num+"'>×</button>";
				str	+="			<h7 class='media-heading'>来自话题：自然科学</h7>";
				str	+="			<h4 class='media-heading'>实验做不出结果是一种怎样的体验</h4>";
				str	+="			<h6 class='media-heading'>";
				str	+="			<span>我是一个大帅哥</span>&nbsp;";
				str	+="			<span>个性签名</span>";
				str	+="			</h6>";
				str	+="			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作为一只生物科研，这是再正常不过的了。实验做不出来是很正常的事情，谁都有不会的时候，对吧，谁怕谁？";
				str	+="				当一个人明白着一些的时候按时记得哈开始打哈卡仕达看卡收到货卡仕达卡还是的卡号多少卡号的卡号卡按时打卡hk...";
				str	+="				<a data-toggle='showAll_tooltip' data-placement='bottom' title='点击查看详细'>显示全部</a>";
				str	+="			</p>";
				str	+="		</div>";
				str	+="	</li>";
				str	+=" <li class='media'>";
				str	+="		<span class='pull-left'>";
				str	+="   		<a class='media-object badge alert-danger' style='width:64px;'>5&nbsp;<i class='fa fa-thumbs-up'></i></a>";
				str	+="  	</span>";
				str	+="  	<div class='media-body'>";
				str	+="  	  <a>分享</a>";
				str	+="       <a>收藏</a>";
				str	+="       <a class='shield' data-toggle='shield_tooltip' data-placement='top' title='不再显示在首页推荐中'>屏蔽</a>";
				str	+="       <a class='' data-toggle='modal' data-target='#report'>";
				str	+="			举报";
				str	+="	  	  </a>";
				str	+=" 	 </div>";
				str	+=" </li>";
				str	+="</ul>";
				str	+="</div>";
				str +="<script>$('#close"+num+"').click(function() {closePiece($(this));});</script>";
				console.debug("第"+i+"次");
			$('#wuya').append(str);
			}
			console.debug(scrollTop);
			$(document).scrollTop(scrollTop);	
			
		}
	});
	<!--屏蔽组件-- >
	$('.close').click(function() {
		closePiece($(this));
	});
	$('.shield').click(function() {
		closePiece($(this));
	});

});

function showReport() {
	$('#report').modal('toggle');
}

function closePiece(piece) {
	var id = piece.closest('.piece').attr('id');
	console.debug(id);
	piece.closest('.media-list').fadeOut(1000);
	var str = "<div class='undo'>此内容将不会在动态中再次显示 <a onclick='openPiece("+id+")'>撤销</a></div>";
	console.debug(str);
	piece.closest('.piece').append(str);
}

function openPiece(id) {
	console.debug(id);
	$(id).children('.media-list').fadeIn(1000);
	$(id).children('.undo').remove();
}

function init(){
	
}
