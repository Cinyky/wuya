  // 阻止输出log
          // wangEditor.config.printLog = false;
  $(function(){
	  
	  initAnswerNums();
	  initFocusNums
  	   var editor = new wangEditor('answer-editor');

         // 上传图片
       editor.config.uploadImgUrl = 'http://localhost:8080/wuya/upload/answer';
       editor.config.uploadParams = {
             token1: 'abcde',
             token2: '12345'
       };
       editor.config.uploadHeaders = {
             'Accept' : 'text/x-json'
       }
         editor.config.uploadImgFileName = 'myFileName';

         //隐藏网络图片
            editor.config.hideLinkImg = true;

           // 插入代码时的默认语言
           // editor.config.codeDefaultLang = 'html'

          //只粘贴纯文本
          editor.config.pasteText = true;

           // 跨域上传
//              editor.config.uploadImgUrl = 'http://localhost:8080/wuya/test/upload';

           //第三方上传
          // editor.config.customUpload = true;

           //普通菜单配置
          editor.config.menus = [
         	 'source',
              'bold',
              'underline',
              'italic',
              'strikethrough',
              '|',
              'forecolor',
              'bgcolor',
              '|',
              'link',
              'unlink',
              '|',
              'eraser',
              'undo',
              'redo',
              '|',
              'quote',
              'fontsize',
              'head',
              'unorderlist',
              'orderlist',
              '|',
              'insertcode',
               'img',
              'emotion',
               'location'
          ];
           //只排除某几个菜单（兼容IE低版本，不支持ES5的浏览器），支持ES5的浏览器可直接用 [].map 方法
           // editor.config.menus = $.map(wangEditor.config.menus, function(item, key) {
           //     if (item === 'insertcode') {
           //         return null;
           //     }
           //     if (item === 'fullscreen') {
           //         return null;
           //     }
           //     return item;
           // });

          // onchange 事件
         editor.onchange = function () {
           
             var html = editor.$txt.html();

              // 获取编辑器纯文本内容
             var text = editor.$txt.text();

              // 获取格式化后的纯文本
             var formatText = editor.$txt.formatText();
             var imgs = editor.$txt.find('img');
             console.log("html:"+html);
             console.log("text:"+text);
             console.log("formatText:"+formatText);
             console.log("imgs:"+imgs);
         };
		
         // editor.config.codeDefaultLang = 'javascript'
           // 取消过滤js
           // editor.config.jsFilter = false;

           // 取消粘贴过来
           // editor.config.pasteFilter = false;

           //设置 z-index
           // editor.config.zindex = 20000;

           //语言
           // editor.config.lang = wangEditor.langs['en'];

          // 自定义菜单UI
          // editor.UI.menus.bold = {
          //     normal: '<button style="font-size:20px; margin-top:5px;">B</button>',
          //     selected: '.selected'
          // };
          // editor.UI.menus.italic = {
          //     normal: '<button style="font-size:20px; margin-top:5px;">I</button>',
          //     selected: '<button style="font-size:20px; margin-top:5px;"><i>I</i></button>'
          // };
        editor.create();
//	  $("#answer-editor").removeAttr("style");
		// $("#answer-editor").attr("height","200px");
  		
  });
  
  function initAnswers(questionId){
	  console.debug("function initAnswers questionId :"+questionId);
		$.post(
				"http://localhost:8080/wuya/answer/select",
				{
					"questionId":questionId
				},
				function(rs){
					console.debug("init answers :"+rs)
					var str ="";
					if(rs=="empty"){
						$("#answers").append("<h1>该问题还没有回答</h1>");
						return;
					}else{
						var answers = eval(rs);
						$("#answers").empty();
						for(var i=0;i<answers.length-1;i++){
							var answer = answers[i];
							var user = eval(answer.user);
							str+="<div class='answer' id='answer1'>";
							str+="  <div class='panel panel-default'>";
							str+="        <div class='panel-heading'>";
							str+="        	<img src='http://localhost:8080/wuya/img/"+user.headPic+"' width='60px' height='60px'/>";
							str+="        	<div class='author-info' style='display:inline-block;'>";
							str+="        		<span class='nickname'>"+user.nickName+"</span><br/>";
							str+="       		<span class='sign'>"+user.signature+"</span>";
							str+="       	</div>";
							str+="       	<div style='color: grey'>"+answer.upvoteCount+" 人赞同该回答</div>";
							str+="        </div>";
							str+="       <div class='panel-body'>";
							str+="               <p class='answer-info'>";
							str+=					answer.answerInfo;
							str+="               </p>";
							str+="               <hr>";
							str+="              <span class='answer-date'>发布于-"+getMyDate(answer.answerTime)+"</span>";
							str+="             <div>";
							str+="                 <a class='media-object badge alert-danger' style='width:64px;'>"+answer.upvoteCount+"&nbsp;<i class='fa fa-thumbs-up'></i></a>";
							str+="                 <a>分享</a>";
							str+="                 <a>收藏</a>";
							str+="                 <a class='' data-toggle='modal' data-target='#report'>举报</a>";
							str+="       	  </div>";
						    str+="     </div>";
							str+=" </div>";
							str+="</div>";
						}
						$("#answers").append(str);
					}
				}
			);
  }
  
  
  function getMyDate(str){
	  	console.debug("start trans "+str);
	    var oDate = new Date(str),  
	    oYear = oDate.getFullYear(),  
	    oMonth = oDate.getMonth()+1,  
	    oDay = oDate.getDate(),  
	    oHour = oDate.getHours(),  
	    oMin = oDate.getMinutes(),  
	    oSen = oDate.getSeconds(),  
	    oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) +' '+ getzf(oHour) +':'+ getzf(oMin) +':'+getzf(oSen);//最后拼接时间  
	    return oTime;  
	};  
	//补0操作  
	function getzf(num){  
	    if(parseInt(num) < 10){  
	        num = '0'+num;  
	    }  
	    return num;  
	} 
	
	function initAnswerNums(){
		console.debug("====initAnswerNums====");
		$.post(
				"http://localhost:8080/wuya/answer/nums",
				{
					"method":"1"
				},
				function(rs){
					console.debug("initAnswerNums  rs:"+rs);
					$("#answerNum").html(rs);
				}
			);
	}

	function initFocusNums(){
		console.debug("====initFocusNums====");
		
	}



     