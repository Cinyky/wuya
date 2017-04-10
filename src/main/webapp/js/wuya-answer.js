  // 阻止输出log
          // wangEditor.config.printLog = false;
  $(function(){
	  
//	  initAnswerNums();
//	  initFocusNums();
	  
	  $('#questionInfo').keyup(function(){
			var info =  $(this).val().trim();
			$("#searchQuestion").empty();
			if(info!=""){
			showQuestion(info);
			}
		});
	  
	  $('#submitQuestion').click(function(){
			var info =  $('#questionInfo').val().trim();
			var topicId = $('#topicId').val();
			if(info!=""){
				submitQuestion(info,topicId);
			}else{
				alert("问题不可为空");
			}
		});
  	  editor = new wangEditor('answer-editor');

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
           
//             var html = editor.$txt.html();
//
//              // 获取编辑器纯文本内容
//             var text = editor.$txt.text();
//
//              // 获取格式化后的纯文本
//             var formatText = editor.$txt.formatText();
//             var imgs = editor.$txt.find('img');
//             console.log("html:"+html);
//             console.log("text:"+text);
//             console.log("formatText:"+formatText);
//             console.log("imgs:"+imgs);
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
  
  function initAnswers(questionId,uid){
	  console.debug("function initAnswers questionId :"+questionId);
		$.post(
				"http://localhost:8080/wuya/answer/select",
				{
					"questionId":questionId
				},
				function(rs){
					console.debug("init answers :"+rs)
					
					if(rs=="empty"){
						$("#answers").append("<h1 id='noAnswer'>该问题还没有回答</h1>");
						return;
					}else{
						var answers = eval(rs);
						$("#answers").empty();
						for(var i=0;i<answers.length;i++){
							var answer = answers[i];
							var answer_user = eval(answer.user);
							var str = getAnswerStr(answer_user,answer,uid);
							$("#answers").append(str);
						}
						
					}
				}
			);
  }
  
  
  function getAnswerStr(answer_user,answer,uid){
	  	var str ="";
		str+="<div class='answer' id='"+answer.answerId+"'>";
		str+="  <div class='panel panel-default'>";
		str+="        <div class='panel-heading'>";
		str+="        	<a href='http://localhost:8080/wuya/user/"+answer_user.uid+"/personal'><img src='http://localhost:8080/wuya/img/"+answer_user.headPic+"' width='60px' height='60px'/></a>";
		str+="        	<div class='author-info' style='display:inline-block;'>";
		str+="        		<span class='nickname'>"+answer_user.nickName+"</span><br/>";
		str+="       		<span class='sign'>"+answer_user.signature+"</span>";
		str+="       	</div>";
		str+="       	<div style='color: grey' ><span id='upvoteCountTop"+answer.answerId+"'>"+answer.upvoteCount+"</span> 人赞同该回答</div>";
		str+="        </div>";
		str+="       <div class='panel-body'>";
		str+="               <p class='answer-info'>";
		str+=					answer.answerInfo;
		str+="               </p>";
		str+="               <hr>";
		str+="              <span class='answer-date'>发布于-"+getMyDate(answer.answerTime)+"</span>";
		str+="             <div>";
		if(answer.isUpvoted=="1"){
			str+="                 <a class='media-object badge alert-danger' id='upvoteBot"+answer.answerId+"' ";
		}else{
			str+="                 <a class='media-object badge alert-success' id='upvoteBot"+answer.answerId+"' ";
		}
		str+=		"style='width:64px;' onclick='upvote(\""+answer.answerId+"\")'>"+answer.upvoteCount;
		if(answer.isUpvoted=="1"){
			str+=					"&nbsp;<i class='fa fa-thumbs-down' id='upvoteIco"+answer.answerId+"'></i>";
		}else{
			str+=					"&nbsp;<i class='fa fa-thumbs-up' id='upvoteIco"+answer.answerId+"'></i>";
		}
		
		str+=		"</a>";
		str+="                 <a onclick='share(\""+answer.answerId+"\",\"1\")'>分享</a>";
		if(uid==answer.uid){
			str +="<span>来自我自己的回答</span>"
		}else{
			str+="                 <a class='' data-toggle='modal' data-target='#report' onclick='report(\""+answer.answerId+"\",\"1\")'>举报</a>";
		}
		str+="       	  </div>";
	    str+="     </div>";
		str+=" </div>";
		str+="</div>";
		return str;
  }
  
  function upvote(id){
	  console.debug("+++++++upvote id==>>"+id);
	  $.post(
				"http://localhost:8080/wuya/answer/"+id+"/upvote",
				{
					"answerId":id
				},
				function(rs){
					console.debug("upvote answer rs :"+rs);
					var strs = rs.split("|");
					var type = strs[0];
					var count = strs[1];
					$("#upvoteCountTop"+id).text(count);
					$("#upvoteBot"+id).text(count);
					var icoDown = "&nbsp;<i class='fa fa-thumbs-down' id='upvoteIco"+id+"'></i>";
					var icoUp = "&nbsp;<i class='fa fa-thumbs-up' id='upvoteIco"+id+"'></i>";
					if(type=="1"){
						$("#upvoteBot"+id).removeClass("alert-danger");
						$("#upvoteBot"+id).addClass("alert-success");
						$("#upvoteIco"+id).remove();
						$("#upvoteBot"+id).append(icoUp);
						alert("取消点赞成功");
					}else{
						$("#upvoteBot"+id).removeClass("alert-success");
						$("#upvoteBot"+id).addClass("alert-danger");
						$("#upvoteIco"+id).remove();
						$("#upvoteBot"+id).append(icoDown);
						alert("点赞成功");
					}
				}
			);
  }
  
  //加好友
  function changeFriend(uid){
	  console.debug("+++++++关注的uid==>>"+uid);
  }
  
  //分享
  function share(id,shareType){
	  console.debug("+++++++share id==>>"+id);
	  console.debug("+++++++share shareType==>>"+shareType);
	  $.post(
				"http://localhost:8080/wuya/share/"+shareType+"/add",
				{
					"shareId" :id
				},
				function(rs){
					console.debug("report  rs :"+rs);
					if(rs=="1"){
						alert("分享成功");
					}else{
						alert("分享失败");
					}
				}
			);
  }
  
  function report(id,reportType){
	  console.debug("+++++++report id==>>"+id);
	  console.debug("+++++++report reportType==>>"+reportType);
	  $("#reportId").val(id);
	  $("#reportType").val(reportType);
  }
  
  function submitReport(){
	  var reportId = $("#reportId").val();
	  var reportType = $("#reportType").val();
	  var reportInfo = $("#reportInfo").val().trim();
	  console.debug("+++submitReport()  reportId==>>"+reportId+"  reportType==>>"+reportType+"reportInfo==>>"+reportInfo);
	  $.post(
				"http://localhost:8080/wuya/report/"+reportType+"/add",
				{
					"reportId" :reportId,
					"reportInfo":reportInfo
				},
				function(rs){
					console.debug("report  rs :"+rs);
					if(rs=="1"){
						alert("举报成功");
						$("#reportInfo").val("");
						$('#report').modal('hide');
					}else{
						alert("举报失败");
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
	    console.debug(oDate);
	    return oTime;  
	};  
	//补0操作  
	function getzf(num){  
	    if(parseInt(num) < 10){  
	        num = '0'+num;  
	    }  
	    return num;  
	} 
	

	function submitAnswer(questionId){
		console.debug("submitAnswer start===== questionId==>"+questionId);
		var answerInfo=editor.$txt.html();
		console.debug("answerInfo:"+answerInfo);
		$.post(
				"http://localhost:8080/wuya/answer/add",
				{
					"answerInfo":answerInfo,
					"questionId":questionId
				},
				function(rs){
					if(rs=="fail"){
						alert("fail");
					}else{
						$("#noAnswer").fadeOut();
						console.debug("answer -- rs:"+rs);
						var answer = eval("("+rs+")");
						console.debug("answer -- user:"+answer.upvoteCount);
						var answer_user = eval(answer.user);
						var str = getAnswerStr(answer_user,answer);
						alert("success");
						editor.$txt.html('<p><br></p>');
						$('#answer').modal('hide')
						$("#answers").prepend(str);
					}
					
				}
			);
	}
	
	function showQuestion(info){
		console.debug("function showQuestion info :"+info);
		$.post(
				"http://localhost:8080/wuya/question/ajax",
				{
					"questionInfo":info
				},
				function(rs){
					console.debug("ajax:"+rs);
					var str = "";
					if(rs=="empty"){
						$("#searchQuestion").append("<span>该问题还没有被提问！！<span>")
						return;
					}else{
						var questions = eval(rs);
						str +="<table class='table table-hover table-condensed table-responsive'>";
						str +="<thead>";
						str +="<td>";
						str +="问题详情";
						str +="</td>";
						str +="<td>";
						str +="提问时间";
						str +="</td>";
						str +="</thead>";
						str +="<tbody>";
						for(var i=0;i<questions.length;i++){
							var question = questions[i];
							str +="<tr>";
							str +=" <td>";
							str +="  <a target='_blank' href='http://localhost:8080/wuya/question/"+question.questionId+"/detail'>";
							str +=    question.questionInfo;
							str +="  </a>";
							str +=" </td>";
							str +=" <td>";
							str +=   getMyDate(question.questionTime);
							str +=" </td>";
							str +="</tr>";
						}
						str +="		</tbody>";
						str +="</table>";
					}
					$("#searchQuestion").append(str);
				}
			)
	}
	
	function submitQuestion(info,topicId){
		console.debug("function submitQuestion info :"+info+" topic："+topicId);
		$.post(
				"http://localhost:8080/wuya/question/add",
				{
					"questionInfo":info,
					"topicId"     :topicId
				},
				function(rs){
					console.debug("rsrsrsrs:"+rs);
				}
			);
	}


     