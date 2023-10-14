<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="nowpage" value="1" /> 
<c:if test="${ !empty requestScope.currentPage }">
	<c:set var="nowpage" value="${ requestScope.currentPage }"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList</title>
<script type="text/javascript" src="/first/resources/js/jquery-3.7.0.min.js"></script>
<script>

</script>
</head>
<body>
	<div class="container-fluid">
		<c:import url="/WEB-INF/views/common/header.jsp" />
		<div class="row" style="margin-top: 20px;">
			<!-- 콘텐츠 영역 -->
			<div class="table-responsive table-bordered" style="padding: 10px;">
				<div class="d-grid gap-3" style="grid-template-columns: 0.4fr 0.6fr 0.4fr">
					<div class="bg-body-tertiary border rounded-3" style="visibility: hidden;">
						<br />
					</div>
					<div class="bg-body">
						<table class="table table-hover">
							<h1 style="text-align: center; margin-top: 10px; margin-bottom: 15px;">
								결&nbsp&nbsp&nbsp&nbsp&nbsp재</h1>
							<thead class="table-dark">
								<tr>
									<th scope="col">No</th>
									<th scope="col">제 목</th>
									<td align = "center">결재여부</td>
									<td align = "center">읽음여부</td>
								</tr>
							</thead>
							<c:set var="a" value="${ requestScope.list2 }" />
							<c:set var="b" value="${ requestScope.list }" />
							<c:forEach items="${ a }" var="reportList" varStatus="status">
							<tbody class="table-group-divider">
								<tr>
									<th scope="col">${ reportList.reportId }</th>
									<td>${ reportList.reTitle }</td>
									<td align = "center">${ b[status.index].reSign }</td>
									<td align = "center">${ b[status.index].reRead }</td>
								</tr>
							</tbody>
							</c:forEach>
						</table>
						
							<c:import url="/WEB-INF/views/common/pagingView.jsp" />
							<br>

						<div class="d-grid gap-3" style="grid-template-columns: 0.4fr 0.6fr 0.2fr; margin-bottom: 15px;">
							<div class="bg-body-tertiary">
		        				<form class="d-flex" role="search">
						          <input class="form-control me-1" type="search" placeholder="제목" aria-label="Search">
						          <button class="btn btn-outline-dark" type="submit">search</button>
						        </form>
							</div>
							<div class="bg-body-tertiary border rounded-3" style="visibility: hidden;">
							<br />
							</div>
							<div class="bg-body">
							<button class="btn btn-outline-dark" type="submit">등록</button>
							</div>
						</div>
					</div>
					<div class="bg-body-tertiary border rounded-3" style="visibility: hidden;">
						<br />
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>