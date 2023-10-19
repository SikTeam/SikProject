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
<title>상품관리</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/font-nanum@1/css/nanumgothic/nanumgothic.min.css">

<script type="text/javascript"
	src="/sik/resources/js/jquery-3.7.0.min.js"></script>
<script type="text/javascript">
function insertItem(){
	location.href = "${ pageContext.servletContext.contextPath }/insertItem.do"
}
</script>
<script>
function saveSearch() {
    // 검색 상자의 값을 가져와서 로컬 스토리지에 저장
    var keyword = document.getElementById("searchBox").value;
    localStorage.setItem("searchKeyword", keyword);
}

// 페이지 로드 시, 저장된 검색어를 검색 상자에 채우기
window.onload = function() {
    var savedKeyword = localStorage.getItem("searchKeyword");
    if (savedKeyword) {
        document.getElementById("searchBox").value = savedKeyword;
    }
};
</script>
<style>
#main {
	font-family: "NanumGothicB", sans-serif;
}
</style>
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />
	<h1 align="center"> 상품 관리 </h1>
			<hr>
	<div style="align:center;text-align:center;">
	<button onclick="insertItem();">상품추가</button>
	</div>
	<table align="center" width="1000" border="1" cellspacing="0"
		cellpadding="3">
		<tr>
			<th align="center" width="200" bgcolor="#E7DAF9">상품ID</th>
			<th align="center" width="200" bgcolor="#E7DAF9">상품명</th>
			<th align="center" width="200" bgcolor="#E7DAF9">상품가격(원)</th>
			<th align="center" width="200" bgcolor="#E7DAF9">활성화여부</th>
			<th align="center" width="200" bgcolor="#E7DAF9">2차ID</th>
		</tr>

		<c:forEach items="${items}" var="item">
            <tr>
                <td>${item.itemId}</td>
                <td>${item.itemName}</td>
                <td>${item.itemPrice}</td>
                <td>${item.itemYn}</td>
                <td>${item.secondCategoryId}</td>
            </tr>
        </c:forEach>
	</table>
 <!-- 검색폼 입력 -->
	<form id="titleform" class="sform" action="searchItemName.do" method="post" align="center">
    <input type="hidden" name="page" value="${nowpage}">
    <fieldset>
        <select name="searchOption">
            <option value="itemId">상품ID</option>
            <option value="itemName">상품명</option>
        </select>
        <input type="search" name="keyword" size="50" id="searchBox" value="<%= request.getParameter("keyword") %>">
        <input type="submit" value="검색" onclick="saveSearch()">
    </fieldset>
</form>
	
	<c:import url="/WEB-INF/views/common/pagingView.jsp"></c:import>
	<br>
</body>
</html>