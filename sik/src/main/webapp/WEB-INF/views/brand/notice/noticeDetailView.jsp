<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="nowpage" value="${ currentPage }" />
	<c:import url="/WEB-INF/views/common/header.jsp" />
	<div class="container-fluid">
		${ requestScope.notice.noId } <br> ${ requestScope.notice.memberName }
		<br> ${ requestScope.notice.brandName } <br> ${ requestScope.notice.noCdate }
		<br> ${ requestScope.notice.noUdate } <br> ${ requestScope.notice.noDdate }
		<br> ${ requestScope.notice.noVcount } <br> ${ requestScope.notice.noCon }
		<br> ${ requestScope.notice.noTitle } <br>

		<c:if test="${!empty requestScope.notice.noFile }">
			<img alt="${ requestScope.notice.noTitle }" src="${ pageContext.servletContext.contextPath }/resources/notice_upfiles/${requestScope.notice.noFile}" style="width: 200px;height: 200px">
		</c:if>


		<c:import url="/WEB-INF/views/common/pagingView.jsp" />
	</div>
</body>
</html>