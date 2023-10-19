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
				<table class="table table-hover border rounded-5" style="color:black;">
					<h4 style="text-align: center; margin-top:10px; margin-bottom:15px;">
					직	원	등	록
					</h4>
				</a>
				  <form action="enroll.do" method="post">
					<div class="form-floating" style="width: 18rem;">
					  <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea" name="memberId"></textarea>
					  <label for="floatingTextarea">부여할 사번</label>
					  &nbsp;
					</div>
					
					<!-- <div id="myphoto" 
					style="margin:0;width:150px;height:160px;padding:0;border:1px solid navy;">
						<img src="/first/resources/member_photofiles/preview.jpg" id="photo" 				
						style="width:150px;height:160px;border:1px solid navy;display:block;"
						alt="사진을 드래그 드롭하세요." 
						style="padding:0;margin:0;"><br>				
					</div>
					 -->
					
					<div class="form-floating" style="width: 18rem;">
					  <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea" name="memberName"></textarea>
					  <label for="floatingTextarea">이름</label>
					  &nbsp;
					</div>
					
					<div class="form-floating" style="width: 18rem;">
					  <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea" name="pw"></textarea>
					  <label for="floatingTextarea">지정할 비밀번호</label>
					  &nbsp;
					</div>
					<br>
					<div class="dropdown">
						 <select id="dept" class="btn btn-secondary btn-sm dropdown-toggle" name="deptId">
						    <option class="dropdown-item" value="부서">부서</option>
						  	<option class="dropdown-item" value="D0001">가맹관리팀</option>
						  	<option class="dropdown-item" value="D0002">물류팀</option>
						  	<option class="dropdown-item" value="D0003">메뉴개발팀</option>
						  	<option class="dropdown-item" value="D0004">가맹영업팀</option>
						  	<option class="dropdown-item" value="D0005">상품관리팀</option>
						  	<option class="dropdown-item" value="D0006">광고기획팀</option>
						</select>
					    <select id="position" class="btn btn-secondary btn-sm dropdown-toggle" name="positionId">
					    	<option class="dropdown-item" value="직급">직급</option>
						    <option class="dropdown-item" value="P0001">사원</option>
						  	<option class="dropdown-item" value="P0002">대리</option>
						  	<option class="dropdown-item" value="P0003">주임</option>
						  	<option class="dropdown-item" value="P0004">과장</option>
						  	<option class="dropdown-item" value="P0005">팀장</option>
						  	<option class="dropdown-item" value="P0006">부장</option>
						  	<option class="dropdown-item" value="P0007">대표이사</option>
						 </select>
					</div>
					<br>
					<!-- 입사일 선택 -->
					<div class="bg-body-tertiary border rounded-4" style="width: 14rem;">
					  <div class="input-group flex-nowrap">
			  			  <span class="input-group-text" id="addon-wrapping">입사일</span>
							<fieldset>
					          <input type="date" style="margin-top:4px; margin-left:5px" name="enrollDate">
							</fieldset>
					  </div>
	  				</div>
					<br>
					<div class="input-group mb-3" style="width: 30rem;">
					  <label class="input-group-text" for="inputGroupFile01">프로필 사진</label>
					  <input type="file" class="form-control" id ="inputGroupFile01" name="profileImage">
					</div>
					
					<div class="input-group mb-3" style="width: 30rem;">
					  <label class="input-group-text" for="inputGroupFile01">사인 이미지</label>
					  <input type="file" class="form-control" id="inputGroupFile01" name="signImage">
					</div>
					<button class="btn btn-outline-success btn-sm" type="submit">등록</button>
				  </form>
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
             <img src ="/sik/resources/common/images/logo_dark.png" style="max-height:50px; background: white;"/>
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