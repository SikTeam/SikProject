<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>sikfluencer</title>
<link href="/sik/resources/common/css/font.css" rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"></script>
<style>
body {
	font-family: "NanumGothicB";
}

a {
	text-decoration: none;
	color: black;
}
</style>
</head>
<body>
	<div class="col">
		<div class="accordion accordion-flush" id="accordionFlushExample">
			<!-- 1 -->
			<div class="accordion-item">
				<h2 class="accordion-header">
					<button class="accordion-button collapsed" type="button"
						data-bs-toggle="collapse" data-bs-target="#flush-collapseOne"
						aria-expanded="false" aria-controls="flush-collapseOne">
						메뉴반응</button>
				</h2>
				<div id="flush-collapseOne" class="accordion-collapse collapse"
					data-bs-parent="#accordionFlushExample">
					<div class="accordion-body">
						<a href="/sik/views/main.jsp">브랜드 메뉴 반응</a><br> <a
							href="/sik/views/main.jsp">메뉴 반응</a><br> <a
							href="/sik/views/main.jsp">메뉴3</a><br> <a
							href="/sik/views/main.jsp">메뉴4</a>
					</div>
				</div>
			</div>
			<!-- 2 -->
			<div class="accordion-item">
				<h2 class="accordion-header">
					<button class="accordion-button collapsed" type="button"
						data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo"
						aria-expanded="true" aria-controls="flush-collapseTwo">
						프로모션 현황</button>
				</h2>
				<div id="flush-collapseTwo" class="accordion-collapse collapse"
					data-bs-parent="#accordionFlushExample">
					<div class="accordion-body">
						<a href="/sik/views/main.jsp">프로모션 조회</a><br> <a
							href="/sik/views/main.jsp">프로모션 등록</a><br> <a
							href="/sik/views/main.jsp">프로모션 수정</a><br> <a
							href="/sik/views/main.jsp">메뉴4</a>
					</div>
				</div>
				<!-- 3 -->
				<div class="accordion-item">
					<h2 class="accordion-header">
						<button class="accordion-button collapsed" type="button"
							data-bs-toggle="collapse" data-bs-target="#flush-collapseThree"
							aria-expanded="true" aria-controls="flush-collapseThree">
							광고 현황</button>
					</h2>
					<div id="flush-collapseThree" class="accordion-collapse collapse"
						data-bs-parent="#accordionFlushExample">
						<div class="accordion-body">
							<a href="/sik/views/main.jsp">광고 조회</a><br> <a
								href="/sik/views/main.jsp">광고 등록</a><br> <a
								href="/sik/views/main.jsp">광고 수정</a><br> <a
								href="/sik/views/main.jsp">메뉴4</a>
						</div>
					</div>
				</div>
				<!-- 4 -->
				<div class="accordion-item">
					<h2 class="accordion-header">
						<button class="accordion-button collapsed" type="button"
							data-bs-toggle="collapse" data-bs-target="#collapseFour"
							aria-expanded="true" aria-controls="collapseFour">평판</button>
					</h2>
					<div id="collapseFour" class="accordion-collapse collapse"
						data-bs-parent="#accordionFlushExample">
						<div class="accordion-body">
							<a href="/sik/views/main.jsp">브랜드 평판</a><br> <a
								href="/sik/views/main.jsp">메뉴 평판</a><br> <a
								href="/sik/views/main.jsp">메뉴3</a><br> <a
								href="/sik/views/main.jsp">메뉴4</a>
						</div>
					</div>
				</div>
				<!-- END -->
			</div>
		</div>
	</div>
</body>
</html>