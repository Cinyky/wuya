  // 阻止输出log
          // wangEditor.config.printLog = false;
  $(function(){
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


     