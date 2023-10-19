<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<c:set var="nowpage" value="1" /> 
<c:if test="${ !empty requestScope.currentPage }">
	<c:set var="nowpage" value="${ requestScope.currentPage }"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식플루언서</title>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>

<!-- css -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css"
	rel="stylesheet">
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.3/examples/headers/">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">

<style>
.content-area {
  display: flex;
  justify-content: center;
}
</style>
<script type="text/javascript" 	src="/sik/resources/js/jquery-3.7.0.min.js"></script>
</head>
<body>
<div class="container-fluid">
	<c:import url="/WEB-INF/views/franchisee/fr_header.jsp"/>
     <div class="row" style="margin-top:20px;">
 
 
<!-- 콘텐츠 영역 -->
<h5 align="center"> ${requestScope.management.mgId }번 글 상세보기</h5>
<br>

<div class="table-responsive table-bordered" style="padding: 10px;">
<div class="d-grid gap-3"
					style="grid-template-columns: 0.4fr 0.6fr 0.4fr">
					<div class="bg-body-tertiary border rounded-3"
						style="visibility: hidden;">
						<br />
					</div>
<table class="table" >
	<thead class="table-secondary">
	<tr>
		<th scope="col">No</th> </thead>
		<td> ${requestScope.management.mgId }</td>
	</tr>
	<tr>
	<thead class="table-secondary">
		<th align = "center">작성일</th> </thead>
		<td>${requestScope.management.mgCdate }</td>
		</tr>
	<tr>
	<thead class="table-secondary">
		<th align = "center">내용</th> </thead>
		<td>${requestScope.management.reqContent }</td>
	</tr>
	</thead>


</table>
</div>
</div>
</div>

</body>
</html>