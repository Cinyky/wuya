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
				"http://localhost/wuya/report/"+reportType+"/add",
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
  