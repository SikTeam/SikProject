<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
$(funtion(){
	$('#addApproverBtn').on('click', function(){
		
	})
})
</script>

</head>

<body>
	<div class="container-fluid">
		<c:import url="/WEB-INF/views/common/header.jsp" />
		<div class="row" style="margin-top: 20px;">
			<!-- 콘텐츠 영역 -->
			<div class="table-responsive table-bordered" style="padding: 10px;">
				<div class="d-grid gap-3"
					style="grid-template-columns: 0.4fr 0.6fr 0.4fr">
					<div class="bg-body-tertiary border rounded-3" style="visibility: hidden;">
						<br />
					</div>
					<div class="container mt-4">
						<form action="insertReport.do" method="POST"
							enctype='multipart/form-data'>
							<div class="mb-3">
								결재자 정보 등록
								<button type="button" id="addApproverBtn" class="btn btn-dark mt-2 btn-sm"
								data-bs-toggle="modal" data-bs-target="#approverModal">
  									+
								</button>
								<div>
								<span>Date: 2023 - 10 - 15 &nbsp&nbsp&nbsp&nbsp&nbsp</span>
		
								<span>보고서 번호 : ${ reportId }</span>
								</div>
								<br>
								<br>
								<label for="proposalTitle" class="form-label">제목</label> <input
									type="text" class="form-control" id="proposalTitle"
									name="title" required>
							</div>

							<div class='mb - 3'>
								<label for='proposalContent' class='form-label'>내용 : </label>
								<textarea rows=10 cols=30 wrap=hard id='proposalContent'
									name='content' class='form-control'></textarea>
							</div>

							파일 첨부 :
							<div class='mb-3'>
								<input type='file' id='fileUpload' name='fileUpload' />
							</div>

							<button type="submit" class="btn btn-primary">등록</button>
						</form>
					</div>
					<div class="bg-body-tertiary border rounded-3" style="visibility: hidden;">
						<br />
					</div>
				</div>
			</div>
		</div>
	</div>

<!-- Modal -->
<div class="modal fade" id="approverModal" tabindex="-1" aria-labelledby="approverModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="approverModalLabel">결재라인 추가</h5>
        <button type='button' class='btn-close' data-bs-dismiss='modal' aria-label='Close'></button>
      </div>
      <div class='modal-body'>

          <ul id='memberList'></ul>
      </div>
      
    </div>
  </div>
</div>


</body>
</html>