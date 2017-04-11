$(function() {
	path = "http://localhost:8080/wuya";
	$("#changeHeadPic").change(function(){
		var formData = new FormData();
		formData.append('file', $('#changeHeadPic')[0].files[0]);
		$.ajax({
		    url: path+'/upload/headpic',
		    type: 'POST',
		    cache: false,
		    data: formData,
		    processData: false,
		    contentType: false
		}).done(function(res) {
			console.debug(res);
			$("#prePic").attr('src',res);
		}).fail(function(res) {
			alert("上传失败")
		});
	});
	});


