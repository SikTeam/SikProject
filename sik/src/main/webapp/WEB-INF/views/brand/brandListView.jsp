<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="currentLimit" value="${ requestScope.limit }" />
<c:set var="nowpage" value="1" />
<c:if test="${ !empty requestScope.currentPage }">
	<c:set var="nowpage" value="${ requestScope.currentPage }" />
</c:if>
<c:set var="listCount" value="${ requestScope.listCount }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />
	<h1 align="center">${ listCount }개의브랜드 list</h1>
			<hr>
	<table align="center" width="500" border="1" cellspacing="0"
		cellpadding="0">
		<tr>
			<th align="center">브랜드ID</th>
			<th align="center">브랜드 이름</th>
			<th align="center">생성일</th>
			<th align="center">수정일</th>
			<th align="center">활성화 여부</th>
		</tr>

		<c:forEach items="${ requestScope.list }" var="n">
			<tr>
				<td align="center">${ n.brandId }</td>
				<td>${ n.brandName }</td>
				<td align="center"><fmt:formatDate value="${ n.brandBir }"
						pattern="yyyy-MM-dd" /></td>
				<td align="center"><fmt:formatDate value="${ n.brandUp }"
						pattern="yyyy-MM-dd" /></td>
				<td align="center">${ n.brandYn }</td>
			</tr>
		</c:forEach>
	</table>
	<!-- 검색폼 입력 -->
	<form id="titleform" class="sform" action="searchName.do" method="post" align="center">
		<input type="hidden" name="page" value="${ nowpage }">
		<fieldset>
			<input type="search" name="keyword" size="50"> &nbsp;
			<input type="submit" value="검색">
		</fieldset>
	</form>
	
	<c:import url="/WEB-INF/views/common/pagingView.jsp"/>
	<br>
</body>
</html>