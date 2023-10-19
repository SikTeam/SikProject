<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="nowpage" value="1" />
<c:if test="${ !empty requestScope.currentPage }">
	<c:set var="nowpage" value="${ requestScope.currentPage }" />
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
<script type="text/javascript"
	src="/sik/resources/js/jquery-3.7.0.min.js"></script>
<script type="text/javascript">
	function showWriteForm() {
		//요청사항 쓰기 페이지로 이동 요청
		location.href = "${ pageContext.servletContext.contextPath }/requestManageWriteForm.do";
	}
</script>
</head>
<body>
	<div class="container-fluid">
		<c:import url="/WEB-INF/views/franchisee/fr_header.jsp" />
		<div class="row" style="margin-top: 20px;">


			<!-- 콘텐츠 영역 -->
			<h3 align="center">가맹점 요청사항</h3>
			<br>


			<%-- 조회된 게시글 목록 출력 --%>
			<div class="table-responsive table-bordered" style="padding: 10px;">
				<div class="d-grid gap-3"
					style="grid-template-columns: 0.4fr 0.6fr 0.4fr">
					<div class="bg-body-tertiary border rounded-3">
						<br />


						<div class="requestListView">
							<table class="table table-sm custom-table table-hover">
								<thead class="table-secondary">
									<tr align="center">
										<th>요청내용</th>
										<th>날짜</th>
										<th>진행상태</th>
									</tr>
								</thead>
								<tbody class="table-group-divider">
									<c:forEach items="${ requestScope.list }" var="r">
										<c:url var="rd" value="rdetail.do">
											<c:param name="mgId" value="${ r.mgId }" />
											<c:param name="page" value="${ nowpage }" />
										</c:url>
										<tr>
											<td align="center"><a href="${ rd }"> ${ r.reqContent }</a>
											</td>
											<td align="center"><fmt:formatDate
													value="${ r.mgCdate }" pattern="yyyy-MM-dd" /></td>
											<td align="center">${ r.reqState }</td>
										</tr>

										<%-- <a href="${ rd }">${r.reqContent}</a> --%>
									</c:forEach>
							</table>
						</div>

						<br>
						<%-- <c:if test="${ !empty sessionScope.loginMember }"> --%>
						<!-- <div style="text-align:center;"> -->
						<button class="btn btn-dark btn-sm" onclick="showWriteForm();">글쓰기</button>
						<!-- </div> -->
						<%-- </c:if> --%>
					</div>
				</div>
			</div>
</body>
</html>