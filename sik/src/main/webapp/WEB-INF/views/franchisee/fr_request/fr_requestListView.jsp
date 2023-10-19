<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>식플루언서</title>
<style>
.content-area {
  display: flex;
  justify-content: center;
}
</style>
<script type="text/javascript" 	src="/sik/resources/js/jquery-3.7.0.min.js"></script>
<script type="text/javascript">
function showWriteForm(){
	//요청사항 쓰기 페이지로 이동 요청
	location.href = "${ pageContext.servletContext.contextPath }/requestwriteform.do";
}
</script>
</head>
<body>
<div class="container-fluid">
	<c:import url="/WEB-INF/views/franchisee/fr_header.jsp"/>
     <div class="row" style="margin-top:20px;">
  </div>
 </div>
<!-- 콘텐츠 영역 -->
<h2 align="center" > 가맹점 요청사항 </h2>
<br> <br>



<%-- 조회된 게시글 목록 출력 --%>
<div class="requestlistview">
 <table align="center" border="1" cellspacing="0" width="700">
 	<tr align="center" >
		<th>작성자</th>
		<th>요청내용</th>
		<th>날짜</th>
		<th>진행상태</th>
	</tr>
	
 <c:forEach items="${ requestScope.list }" var="r">
   	<tr>
  		<td align="center"> ${ r.fcOwner } </td>
  		<td align="center"> ${ r.reqContent } </td>
  		<td align="center"> <fmt:formatDate value="${ r.mgCdate }" pattern="yyyy-MM-dd" /></td>
  		<td align="center"> ${ r.reqState } </td>
  		
  	</tr>

</c:forEach>
 </table>
</div>

<br>
<%-- <c:if test="${ !empty sessionScope.loginMember }"> --%>
<div style="align:center;text-align:center;">
	<button class="btn btn-dark btn-sm" onclick="showWriteForm();">글쓰기</button>
</div>
<%-- </c:if> --%>

     
</body>
</html>