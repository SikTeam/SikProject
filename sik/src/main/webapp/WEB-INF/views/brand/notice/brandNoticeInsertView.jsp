<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sik</title>
</head>
<body>
	<div class="container-fluid">
		<c:import url="/WEB-INF/views/common/header.jsp" />
		<form action="noticeInsert.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="board" value="${ requestScope.board }">
			<input type="hidden" name="memberId" value="${sessionScope.loginMember.memberId}">
			<select name="brandId">
				<c:forEach var="b" items="${ requestScope.brandList }">
					<option value="${b.brandId}">${ b.brandName}</option>
				</c:forEach>
			</select>
			제목 : <input type="text" name="noTitle">
			내용 : <textarea name="noCon"></textarea>
			첨부파일 : <input type="file" name="OriginalFile">
			<input type="submit" value="공지하기">
		</form>
	</div>
</body>
</html>