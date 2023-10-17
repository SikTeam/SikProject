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
<script type="text/javascript"
	src="/first/resources/js/jquery-3.7.0.min.js"></script>
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
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />
	<h1 align="center">${ listCount }개의 매장 </h1>
			<hr>
	<table align="center" width="1000" border="1" cellspacing="0"
		cellpadding="3">
		<tr>
			<th align="center" width="100">가맹점ID</th>
			<th align="center" width="350">점포명</th>
			<th align="center" width="300">상품명</th>
			<th align="center" width="100">수량</th>
			<th align="center" width="150">비고</th>
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
			<input type="search" name="keyword" size="50"> &nbsp;
			<input type="submit" value="검색">
		</fieldset>
	</form>
	
	<c:import url="/WEB-INF/views/common/pagingView.jsp"></c:import>
	<br>
</body>
</html>