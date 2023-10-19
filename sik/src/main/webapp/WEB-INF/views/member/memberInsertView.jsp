<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>식플루언서</title>
<style>
.content-area {
  display: flex;
  justify-content: center;
}
</style>
</head>
<body>
<div class="container-fluid">
   <c:import url="/WEB-INF/views/common/header.jsp"/>
   <%-- <%@ include file="../views/common/header.jsp" %> --%>
     <div class="row" style="margin-top:20px;">
<!-- 콘텐츠 영역 -->
<!-- 메인 1열 -->
       <div class="container-fluid pb-3" id="content-area"style="max-width: 100%; max-height: 100%;">
       <div class="d-grid gap-3" style="grid-template-columns: 0.3fr 0.8fr 0.3fr">
          <div class="bg-body-tertiary border rounded-3" style="visibility: hidden;">
            <br />
          </div>
          <div class="bg-body-tertiary border rounded-3">

          	<div class="table-responsive table-bordered" style="padding: 10px;">
				<table class="table table-hover border rounded-5">
					<h4 style="text-align: center; margin-top:10px; margin-bottom:15px;">
					직	원	등	록
					</h4>
				</a>
					<div class="form-floating" style="width: 18rem;">
					  <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea"></textarea>
					  <label for="floatingTextarea">부여할 사번</label>
					  &nbsp;
					</div>
					
					<div class="form-floating" style="width: 18rem;">
					  <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea"></textarea>
					  <label for="floatingTextarea">이름</label>
					  &nbsp;
					</div>
					
					<div class="form-floating" style="width: 18rem;">
					  <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea"></textarea>
					  <label for="floatingTextarea">지정할 비밀번호</label>
					  &nbsp;
					</div>
					
					<div class="form-floating" style="width: 18rem;">
					  <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea"></textarea>
					  <label for="floatingTextarea">관리자 여부</label>
					  &nbsp;
					</div>
					
					<div class="form-floating" style="width: 18rem;">
					  <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea"></textarea>
					  <label for="floatingTextarea">부서 입력</label>
					  &nbsp;
					</div>
					
					<div class="form-floating" style="width: 18rem;">
					  <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea"></textarea>
					  <label for="floatingTextarea">직급 입력</label>
					  &nbsp;
					</div>
					
					<!-- 입사일 넣어야함-->
					
					<div class="input-group mb-3">
					  <label class="input-group-text" for="inputGroupFile01">프로필 사진</label>
					  <input type="file" class="form-control" id="inputGroupFile01">
					</div>
					
					<div class="input-group mb-3">
					  <label class="input-group-text" for="inputGroupFile01">사인 이미지</label>
					  <input type="file" class="form-control" id="inputGroupFile01">
					</div>
					
				</table>
			</div>
          </div>
          
          <div class="bg-body-tertiary border rounded-3" style="visibility: hidden;">
            <br />
          </div>
        </div>
        <br>
        <br>
        <br>
        <br>
<!-- 메인 2열 -->
         <div class="d-grid gap-3" style="grid-template-columns: 0.5fr 0.5fr 0.5fr">
          <div class="bg-body-tertiary border rounded-3" style="visibility: hidden;">
            <br />
          </div>
          <div class="bg-body-tertiary" style= "justify-self: center;">
             <img src = "/sik/resources/common/images/logo_dark.png" style="max-height:50px; background: white;"/>
          </div>
          <div class="bg-body-tertiary border rounded-3" style="visibility: hidden;">
            <br />
          </div>
        </div> 
      </div>
     </div>
</div>
</body>
</html>