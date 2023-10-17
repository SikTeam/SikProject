<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
       <div class="d-grid gap-3" style="grid-template-columns: 0.3fr 1.4fr 0.3fr">
          <div class="bg-body-tertiary border rounded-3" style="visibility: hidden;">
            <br />
          </div>
          <div class="bg-body-tertiary border rounded-3">

          	<div class="table-responsive table-bordered" style="padding: 10px;">
				<table class="table table-hover border rounded-5">
					<a href="${ pageContext.servletContext.contextPath }/mlist.do?page=1">
					<h4 style="text-align: center; margin-top:10px; margin-bottom:15px;">
					직	원	조	회
					</h4></a>
				  <thead class="table-dark">
				    <tr>
				      <th scope="col">사번</th>
				      <th scope="col">이름</th>
				      <th scope="col">패스워드</th>
				      <th scope="col">입사일</th>
				      <th scope="col">관리자여부</th>
				      <th scope="col">상급자사번</th>
				      <th scope="col">부서</th>
				      <th scope="col">직책</th>
				    </tr>
				  </thead>
				  <tbody class="table-group-divider">
				  	<c:forEach items="${ requestScope.list }" var="m">
					    <tr>
					      <td>${ m.memberId }</td>
					      <td>${ m.memberName }</td>
					      <td>${ m.pw }</td>
					      <td>${ m.enrollDate }</td>
					      <td>${ m.adminYn }</td>
					      <td>${ m.superiorId }</td>
 					      <td>${ m.deptName }</td>
					      <td>${ m.positionName }</td>
					    </tr>
					</c:forEach>
				  </tbody>
				</table>
			</div>
          </div>
          
          <div class="bg-body-tertiary border rounded-3" style="visibility: hidden;">
            <br />
          </div>
        </div>
<c:import url="/WEB-INF/views/common/pagingView.jsp" />
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