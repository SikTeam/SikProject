<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
	<div class="dropdown text-end">
		<!-- <a href="#"
			class="d-block link-body-emphasis text-decoration-none dropdown-toggle"
			data-bs-toggle="dropdown" aria-expanded="true"> <img
			src="/sik/resources/common/images/profile.png" alt="mdo" width="32"
			height="32" class="rounded-circle">
		</a> -->
		<button class="btn btn-secondary dropdown-toggle" type="button"
			data-bs-toggle="dropdown" aria-expanded="false">
			<img src="/sik/resources/common/images/profile.png" alt="mdo"
				width="32" height="32" class="rounded-circle" />
		</button>
		<ul class="dropdown-menu text-small">
			<li><a class="dropdown-item" href="#">Profile</a></li>
			<li><hr class="dropdown-divider" /></li>
			<li><a class="dropdown-item" href="/sik/login.jsp">Sign out</a></li>
		</ul>
	</div>

</body>
</html>