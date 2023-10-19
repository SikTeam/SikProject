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
<title>매장별 재고 현황</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/font-nanum@1/css/nanumgothic/nanumgothic.min.css">

<script type="text/javascript"

	src="/sik/resources/js/jquery-3.7.0.min.js">
$(document).ready(function() {
    // 이전 선택을 저장하는 변수
    var previousSelectedOption = $('#searchOption').val();

    // 드롭다운 메뉴가 변경될 때 이벤트 핸들러
    $('#searchOption').change(function() {
        var selectedOption = $(this).val();

        // 서버로 Ajax 요청을 보냅니다.
        $.ajax({
            type: "GET",
            url: "/getDropdownOptions",
            data: { selectedOption: selectedOption },
            success: function(response) {
                // 서버에서 받은 응답을 처리하고 원하는 방식으로 드롭다운 메뉴를 업데이트합니다.
                // 예를 들어, 새로운 드롭다운 항목을 생성하거나 기존 항목을 변경할 수 있습니다.
            },
            error: function(xhr, status, error) {
                console.error("Ajax 요청 실패:", error);
            }
        });
    });

    // 검색 결과 창을 노출할 때 이전 선택을 복원
    // 이 코드는 검색 결과를 표시하는 방법에 따라 약간 다를 수 있습니다.
    // 예를 들어, 검색 결과를 동적으로 로드하는 경우, 이 코드를 로드 이후에 실행해야 합니다.
    $('#searchOption').val(previousSelectedOption);
});
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
	<h1 align="center" id="main"> 매장별 재고 현황 </h1>
			<hr>
	<table align="center" width="1000" border="1" cellspacing="0"
		cellpadding="3">
		<tr>
			<th align="center" width="100" bgcolor="#E7DAF9">가맹점ID</th>
			<th align="center" width="350" bgcolor="#E7DAF9">점포명</th>
			<th align="center" width="300" bgcolor="#E7DAF9">상품명</th>
			<th align="center" width="100" bgcolor="#E7DAF9">수량</th>
			<th align="center" width="150" bgcolor="#E7DAF9">비고</th>
		</tr>

		<c:forEach items="${ requestScope.list }" var="n">
			<tr>
				<td align="center">${ n.fcId }</td>
				<td align="center">${ n.fcName }</td>
				<td align="center">${ n.itemName }</td>
				<td align="center">${ n.fcStockQuan }</td>
				<td align="center">${ n.fcStockEtc }</td>
			</tr>
		</c:forEach>
	</table>
	<!-- 검색폼 입력 -->
	<form id="titleform" class="sform" action="searchFcName.do" method="post" align="center">
		<input type="hidden" name="page" value="${ nowpage }">
		<fieldset>
			<select name="searchOption">
            	<option value="fcName">점포명</option>
            	<option value="fcStockEtc">비고</option>
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