<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="currentPage" value="${ requestScope.paging.currentPage }" />
<c:set var="urlMapping" value="${ requestScope.paging.urlMapping }" />
<c:set var="startPage" value="${ requestScope.paging.startPage }" />
<c:set var="endPage" value="${ requestScope.paging.endPage }" />
<c:set var="maxPage" value="${ requestScope.paging.maxPage }" />
<c:set var="board" value="${ requestScope.paging.board }"/>

<c:set var="action" value="${ requestScope.action }" />
<c:set var="keyword" value="${ requestScope.keyword }" />
<c:set var="begin" value="${ requestScope.begin }" />
<c:set var="end" value="${ requestScope.end }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<c:if test="${ empty action }">
		<div style="text-align: center;">
			<c:if test="${ currentPage eq 1 }">
		[맨처음] &nbsp;
	</c:if>
			<c:if test="${ currentPage gt 1 }">
				<a href="/sik/${ urlMapping }?page=1&board=${board}">[맨처음]</a> &nbsp;
	</c:if>
			<c:if
				test="${ (currentPage - 10) lt startPage and (currentPage - 10) gt 1 }">
				<a href="/sik/${ urlMapping }?page=${ startPage - 10 }&board=${board}">[이전그룹]</a> &nbsp;
	</c:if>

			<c:if
				test="${ !((currentPage - 10) lt startPage and (currentPage - 10) gt 1) }">
		[이전그룹] &nbsp;
	</c:if>

			<c:forEach var="p" begin="${ startPage }" end="${ endPage }" step="1">
				<c:if test="${ p eq currentPage }">
					<font color="blue" size="4"><b>${ p }</b></font>
				</c:if>

				<c:if test="${ p ne currentPage }">
					<a href="/sik/${ urlMapping }?page=${ p }&board=${board}">${ p }</a>
				</c:if>
			</c:forEach>

			<c:if
				test="${ (currentPage + 10) > endPage && (currentPage + 10) < maxPage }">
				<a href="/sik/${ urlMapping }?page=${ startPage + 10 }&board=${board}">[다음그룹]</a> &nbsp;
	</c:if>

			<c:if
				test="${ !((currentPage + 10) > endPage && (currentPage + 10) < maxPage) }">
		[다음그룹] &nbsp;
	</c:if>

			<c:if test="${ currentPage >= maxPage }">
		[맨끝] &nbsp;
	</c:if>

			<c:if test="${ !(currentPage >= maxPage) }">
				<a href="/sik/${ urlMapping }&page=${ maxPage }&board=${board}">[맨끝]</a> &nbsp;
	</c:if>

		</div>

	</c:if>

	<c:if test="${ !empty action and !empty keyword }">
		<div style="text-align: center;">

			<c:if test="${ currentPage eq 1 }">
		[맨처음] &nbsp;
	</c:if>

			<c:if test="${ currentPage gt 1 }">
				<a
					href="/sik/${ urlMapping }?page=1&action=${ action }&keyword=${ keyword }&board=${board}">[맨처음]</a> &nbsp;
	</c:if>

			<c:if
				test="${ (currentPage - 10) lt startPage and (currentPage - 10) gt 1 }">
				<c:url var="um1" value="${ urlMapping }">
					<c:param name="page" value="${ startPage - 10 }" />
					<c:param name="action" value="${ action }" />
					<c:param name="keyword" value="${ keyword }" />
					<c:param name="board" value="${ board }"/>
				</c:url>
				<a href="${ um1 }">[이전그룹]</a> &nbsp;
	</c:if>

			<c:if
				test="${ !((currentPage - 10) lt startPage and (currentPage - 10) gt 1) }">
		[이전그룹] &nbsp;
	</c:if>

			<c:forEach var="p" begin="${ startPage }" end="${ endPage }" step="1">
				<c:if test="${ p eq currentPage }">
					<font color="blue" size="4"><b>${ p }</b></font>
				</c:if>

				<c:if test="${ p ne currentPage }">
					<a
						href="/sik/${ urlMapping }?page=${ p }&action=${ action }&keyword=${ keyword }&board=${board}">${ p }</a>
				</c:if>
			</c:forEach>

			<c:if
				test="${ (currentPage + 10) > endPage && (currentPage + 10) < maxPage }">
				<a
					href="/sik/${ urlMapping }?page=${ startPage + 10 }&action=${ action }&keyword=${ keyword }&board=${board}">[다음그룹]</a> &nbsp;
	</c:if>

			<c:if
				test="${ !((currentPage + 10) > endPage && (currentPage + 10) < maxPage) }">
		[다음그룹] &nbsp;
	</c:if>

			<c:if test="${ currentPage >= maxPage }">
		[맨끝] &nbsp;
	</c:if>

			<c:if test="${ currentPage < maxPage }">
				<a
					href="/sik/${ urlMapping }?page=${ maxPage }&action=${ action }&keyword=${ keyword }&board=${board}">[맨끝]</a> &nbsp;
	</c:if>

		</div>

	</c:if>

	<c:if test="${ !empty action and action eq 'date' }">
		<div style="text-align: center;">

			<c:if test="${ currentPage eq 1 }">
		[맨처음] &nbsp;
	</c:if>

			<c:if test="${ currentPage gt 1 }">
				<a
					href="/sik/${ urlMapping }?page=1&action=${ action }&begin=${ begin }&end=${ end }&board=${board}">[맨처음]</a> &nbsp;
	</c:if>

			<c:if
				test="${ (currentPage - 10) < startPage && (currentPage - 10) > 1 }">
				<a
					href="/sik/${ urlMapping }?page=${ startPage - 10 }&action=${ action }&begin=${ begin }&end=${ end }&board=${board}">[이전그룹]</a> &nbsp;
	</c:if>

			<c:if
				test="${ !((currentPage - 10) < startPage && (currentPage - 10) > 1) }">
		[이전그룹] &nbsp;
	</c:if>

			<c:forEach var="p" begin="${ startPage }" end="${ endPage }" step="1">
				<c:if test="${ p eq currentPage }">
					<font color="blue" size="4"><b>${ p }</b></font>
				</c:if>

				<c:if test="${ p ne currentPage }">
					<a
						href="/sik/${ urlMapping }?page=${ p }&action=${ action }&begin=${ begin }&end=${ end }&board=${board}">${ p }</a>
				</c:if>

			</c:forEach>


			<c:if
				test="${ (currentPage + 10) > endPage && (currentPage + 10) < maxPage }">
				<a href="/sik/${ urlMapping }?page=${ startPage + 10 }&board=${board}">[다음그룹]</a> &nbsp;
	</c:if>

			<c:if
				test="${ !((currentPage + 10) > endPage && (currentPage + 10) < maxPage) }">
		[다음그룹] &nbsp;
	</c:if>

			<c:if test="${ currentPage >= maxPage }">
		[맨끝] &nbsp;
	</c:if>

			<c:if test="${ currentPage < maxPage }">
				<a
					href="/sik/${ urlMapping }?page=${ maxPage }&action=${ action }&begin=${ begin }&end=${ end }&board=${board}">[맨끝]</a> &nbsp;
	</c:if>

		</div>

	</c:if>

</body>
</html>