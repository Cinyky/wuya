<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8"%>
<!-- show question modal -->
<div class="fade modal" id="report">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title">无涯-举报系统</h4>
          </div>
          <div class="modal-body">
                <h4>举报</h4>
                <input type="hidden" id='reportId' val=''/>
                <input type="hidden" id='reportType' val=''/>
                <input type="text" class="form-control" placeholder="举报理由" id="reportInfo" >
          </div>
          <div class="modal-footer">
          	<a class="btn btn-primary" onclick="submitReport()">举报</a>
            <a class="btn btn-primary" data-dismiss="modal">关闭</a>
          </div>
        </div>
      </div>
    </div>