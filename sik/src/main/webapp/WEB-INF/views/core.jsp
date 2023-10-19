<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>기본 파일</title>
<style type="text/css">
.text-center div {
	border: 1px solid #000;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<c:import url="/views/common/header.jsp" />
		<div class="row" style="margin-top: 20px;">
			<!-- 콘텐츠 영역 -->
			<div class="container-fluid pb-3" id="content-area"
				style="max-width: 100%;">
				<select class="form-select" aria-label="Default select example">
					<option selected>Open this select menu</option>
					<option value="1">One</option>
					<option value="2">Two</option>
					<option value="3">Three</option>
				</select>
				<div class="container text-center">
					<div class="row">
						<div class="col-1">번호</div>
						<div class="col-6">제목</div>
						<div class="col-2">글쓴이</div>
						<div class="col-2">게시날짜</div>
						<div class="col-1">조회수</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>