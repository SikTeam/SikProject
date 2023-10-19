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
<title>상품 추가</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/font-nanum@1/css/nanumgothic/nanumgothic.min.css">

<script type="text/javascript"
	src="/sik/resources/js/jquery-3.7.0.min.js"></script>
<!-- <script type="text/javascript">
 	$(function() {
		var limit = "${ currentLimit }";
		document.getElementById("limit").value = limit;

		//input 태그의 name 이 item 의 값이 바뀌면(change) 작동되는 이벤트 핸들러 작성
		$('input[name=item]').on('change', function() {
			//여러 개의 태그 중에서 체크표시가 된 태그를 선택
			$('input[name=item]').each(function(index) {
				//선택된 radio 순번대로 하나씩 checked 인지 확인함
				if ($(this).is(':checked')) {
					//체크 표시된 아이템에 대한 폼이 보여지게 처리함
					$('form.sform').eq(index).css('display', 'block');
				} else {
					//체크 표시 안된 아이템의 폼은 안 보이게 처리함
					$('form.sform').eq(index).css('display', 'none');
				}
			}); //each
		}); //on
	}); //document ready
</script> -->
<!-- <script>
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
</script> -->
<style>
#main {
	font-family: "NanumGothicB", sans-serif;
}
</style>
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />
	<h1 align="center"> 상품 추가 </h1>
<form action="insert.do" method="post" enctype="multipart/form-data">
<table align="center" width="1000" border="1" cellspacing="5" cellpadding="5">
	<tr>
		<th>상품ID</th>
		<td><input type="text" name="itemId" size="100"  required></td>
	</tr>
	<tr>
		<th>상품명</th>
		<td><input type="text" name="itemName" size="100"  required></td>
	</tr>
	<tr>
		<th>상품가격</th>
		<td><input type="text" name="itemPrice" size="100"  required></td>
	</tr>
	<tr>
		<th>활성화여부</th>
		<td>
    		<input type="checkbox" name="itemYN" value="Y" checked  required> Yes
    		<input type="checkbox" name="itemYN" value="N"  required> No
		</td>
	</tr>
	<tr>
		<th>2차ID</th>
		<td><input type="text" name="secondCategoryId" size="100"  required></td>
	</tr>
	<tr>
	<c:url var="il" value="ilist.do">
	 	<c:param name="page" value="1" />
	 </c:url>
		<th colspan="2" >
			<input type="submit" value="등록하기" align="center"> &nbsp; 
			<input type="reset" value="작성취소" align="center"> &nbsp;
			<input type="button" value="목록" 
			onclick="javascript:location.href='${il}'; return false;" align="center">
		</th>		
	</tr>
</table>
</form>
	<br>
</body>
</html>