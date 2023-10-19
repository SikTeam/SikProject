<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>식플루언서</title>
<!-- js -->
<script src="/sik/resources/common/js/jquery-3.7.0.min.js"></script>
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
<link href="/sik/resources/common/css/font.css" rel="stylesheet">
<link href="/sik/resources/common/css/header.css" rel="stylesheet">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	width: 100%;
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}

.btn-bd-primary { -
	-bd-violet-bg: #712cf9; -
	-bd-violet-rgb: 112.520718, 44.062154, 249.437846; -
	-bs-btn-font-weight: 600; -
	-bs-btn-color: var(- -bs-white); -
	-bs-btn-bg: var(- -bd-violet-bg); -
	-bs-btn-border-color: var(- -bd-violet-bg); -
	-bs-btn-hover-color: var(- -bs-white); -
	-bs-btn-hover-bg: #6528e0; -
	-bs-btn-hover-border-color: #6528e0; -
	-bs-btn-focus-shadow-rgb: var(- -bd-violet-rgb); -
	-bs-btn-active-color: var(- -bs-btn-hover-color); -
	-bs-btn-active-bg: #5a23c8; -
	-bs-btn-active-border-color: #5a23c8;
}

.bd-mode-toggle {
	z-index: 1500;
}

.nav-link {
	text-decoration: none;
	color: black;
}

.dropdown-menu {
	position: absolute;
	z-index: 99;
}

.col {
	font-family: "NanumGothicB";
}

a {
	text-decoration: none;
	color: black;
}
</style>
<style>
.content-area {
  display: flex;
  justify-content: center;
}
</style>
</head>

<body>
<!-- 헤더 영역 -->
<div class="container-fluid">
	<c:import url="/WEB-INF/views/franchisee/fr_header.jsp"/>
     <div class="row" style="margin-top:20px;">
  </div>
 </div>
<!-- 콘텐츠 영역 -->

<h5 align="center">요청사항 작성 페이지</h5>
<br>
<form action="requestinsert.do" method="get" >
<table align="center" width="500" border="1"  cellspacing="0" cellpadding="3">
	<tr>
		<th colspan="2" align="center"> 요청사항</th>
	
	</tr>
	
	<tr>
		<th align="center">작성자</th>
		
		<td><input type="text" readonly value="${ sessionScope.loginMember.fcOwner }" > </td>
	</tr>
	
	<tr>
		<th align="center">요청내용</th>
		<td>
		<textarea rows="5" cols="40" name="reqContent"></textarea>
		</td>
	</tr>
	<tr>
	<th colspan="2" align="center">
		<input class="btn btn-outline-dark btn-sm" type="submit" value="요청하기"> &nbsp; 
		<input class="btn btn-outline-dark btn-sm" type="reset" value="요청취소"> &nbsp;
		<input class="btn btn-outline-dark btn-sm" type="button" value="목록" onclick="javascript:location.href='${rl}'; return false;">
	</th>
	</tr>
</table>
</form>
<br>

</body>
</html>