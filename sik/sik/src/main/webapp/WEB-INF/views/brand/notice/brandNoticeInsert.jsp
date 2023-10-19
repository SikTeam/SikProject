<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sik</title>
</head>
<body>
	<div class="container-fluid">
		<c:import url="/WEB-INF/views/common/header.jsp" />
		
		<div class="input-group mb-3">
			<button class="btn btn-outline-secondary dropdown-toggle"
				type="button" data-bs-toggle="dropdown" aria-expanded="false">Dropdown</button>
			<ul class="dropdown-menu">
				<li><a class="dropdown-item" href="#">Action</a></li>
				<li><a class="dropdown-item" href="#">Another action</a></li>
				<li><a class="dropdown-item" href="#">Something else here</a></li>
				<li><hr class="dropdown-divider"></li>
				<li><a class="dropdown-item" href="#">Separated link</a></li>
			</ul>
			<input type="text" class="form-control"
				aria-label="Text input with dropdown button">
		</div>
		<c:import url="/WEB-INF/views/common/pagingView.jsp" />
	</div>
</body>
</html>