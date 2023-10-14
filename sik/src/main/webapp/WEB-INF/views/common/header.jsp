<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko" data-bs-theme="white">
<head>
<meta charset="UTF-8">
<title>SIK</title>
<!-- js -->
<script src="/sik/resources/common/js/jquery-3.7.0.min.js"></script>
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
<link href="/sik/resources/common/css/font.css" rel="stylesheet">
<link href="/sik/resources/common/css/header.css" rel="stylesheet">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	width: 100%;
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}

.btn-bd-primary { -
	-bd-violet-bg: #712cf9; -
	-bd-violet-rgb: 112.520718, 44.062154, 249.437846; -
	-bs-btn-font-weight: 600; -
	-bs-btn-color: var(- -bs-white); -
	-bs-btn-bg: var(- -bd-violet-bg); -
	-bs-btn-border-color: var(- -bd-violet-bg); -
	-bs-btn-hover-color: var(- -bs-white); -
	-bs-btn-hover-bg: #6528e0; -
	-bs-btn-hover-border-color: #6528e0; -
	-bs-btn-focus-shadow-rgb: var(- -bd-violet-rgb); -
	-bs-btn-active-color: var(- -bs-btn-hover-color); -
	-bs-btn-active-bg: #5a23c8; -
	-bs-btn-active-border-color: #5a23c8;
}

.bd-mode-toggle {
	z-index: 1500;
}

.nav-link {
	text-decoration: none;
	color: black;
}

.dropdown-menu {
	position: absolute;
	z-index: 99;
}

.col {
	font-family: "NanumGothicB";
}

a {
	text-decoration: none;
	color: black;
}
</style>



</head>
<body>
	<c:if test="${ empty sessionScope.loginMember }">
		<jsp:forward page="loginMain.do" />
	</c:if>
	<header class="p-3 mb-3 border-bottom small shadow">
		<div class="container">
			<div
				class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start"
				style="gap: 50px">
				<a href="#"
					class="d-flex align-items-center mb-2 mb-lg-0 link-body-emphasis text-decoration-none">
					<img src="/sik/resources/common/images/siklogo.png" width="40"
					style="magin-left: 30px">
				</a>
				<ul
					class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
					<li class="nav-item"><a class="nav-link" href="#"
						data-bs-toggle="offcanvas" data-bs-target="#offcanvasSupport">지원</a>
					</li>

					<li class="nav-item"><a class="nav-link" href="#"
						data-bs-toggle="offcanvas" data-bs-target="#offcanvasInventory">재고</a>
					</li>

					<li class="nav-item"><a class="nav-link" href="#"
						data-bs-toggle="offcanvas" data-bs-target="#offcanvasFranchisee">관리</a>
					</li>

					<li class="nav-item"><a class="nav-link" href="#"
						data-bs-toggle="offcanvas" data-bs-target="#offcanvasPromotion">홍보</a>
					</li>
					<c:if
						test="${ !empty sessionScope.loginMember and sessionScope.loginMember.adminYn eq 'Y' }">
						<li class="nav-item"><a class="nav-link" href="#"
							data-bs-toggle="offcanvas" data-bs-target="#offcanvasAdmin">admin</a>
						</li>
					</c:if>
				</ul>
				<a href="/sik/views/common/profile.jsp"> <img
					src="/sik/resources/common/images/profile.png" alt="mdo" width="32"
					height="32" class="rounded-circle" />프로필
				</a>
				<%-- <c:import url="/views/common/profile.jsp" /> --%>
			</div>
		</div>
	</header>
	<!-- canvas 생성 -->
	<!-- 지원 -->
	<div class="offcanvas offcanvas-start small shadow"
		data-bs-scroll="true" data-bs-backdrop="false" tabindex="-1"
		id="offcanvasSupport" aria-labelledby="offcanvasSupportLabel">
		<div class="offcanvas-header">
			<h5 class="offcanvas-title" id="offcanvasSupportLabel">지원</h5>
			<button type="button" class="btn-close" data-bs-dismiss="offcanvas"
				aria-label="Close"></button>
		</div>
		<div class="offcanvas-body">
			<div class="dropdown mt-3">
				<%-- <c:import url="/views/common/sidebar-support.jsp" /> --%>


				<div class="col">
					<div class="accordion accordion-flush" id="accordionFlushExample">
						<!-- 1 -->
						<div class="accordion-item">
							<h2 class="accordion-header">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse" data-bs-target="#flush-collapseOne"
									aria-expanded="false" aria-controls="flush-collapseOne">
									브랜드 관리</button>
							</h2>
							<div id="flush-collapseOne" class="accordion-collapse collapse"
								data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<a href="/sik/views/main.jsp">브랜드 추가</a><br> <a
										href="/sik/views/main.jsp">브랜드 조회</a><br>
								</div>
							</div>
						</div>
						<!-- 2 -->
						<div class="accordion-item">
							<h2 class="accordion-header">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo"
									aria-expanded="true" aria-controls="flush-collapseTwo">
									메뉴 관리</button>
							</h2>
							<div id="flush-collapseTwo" class="accordion-collapse collapse"
								data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<a href="/sik/views/main.jsp">레시피 등록</a><br> <a
										href="/sik/views/main.jsp">레시피 조회</a><br> <a
										href="/sik/views/main.jsp">레시피 수정</a><br> <a
										href="/sik/views/main.jsp">레시피 삭제</a>
								</div>
							</div>
							<!-- 3 -->
							<div class="accordion-item">
								<h2 class="accordion-header">
									<button class="accordion-button collapsed" type="button"
										data-bs-toggle="collapse"
										data-bs-target="#flush-collapseThree" aria-expanded="true"
										aria-controls="flush-collapseThree">발주 확인</button>
								</h2>
								<div id="flush-collapseThree"
									class="accordion-collapse collapse"
									data-bs-parent="#accordionFlushExample">
									<div class="accordion-body">
										<a href="/sik/views/main.jsp">종합 발주 확인</a><br>
									</div>
								</div>
							</div>
							<!-- 4 -->
							<div class="accordion-item">
								<h2 class="accordion-header">
									<button class="accordion-button collapsed" type="button"
										data-bs-toggle="collapse" data-bs-target="#collapseFour"
										aria-expanded="true" aria-controls="collapseFour">생산업체
										관리</button>
								</h2>
								<div id="collapseFour" class="accordion-collapse collapse"
									data-bs-parent="#accordionFlushExample">
									<div class="accordion-body">
										<a href="/sik/views/main.jsp">생산업체 등록</a><br> <a
											href="/sik/views/main.jsp">생산업체 조회</a><br> <a
											href="/sik/views/main.jsp">생산요청 등록</a><br> <a
											href="/sik/views/main.jsp">생산요청 조회</a>
									</div>
								</div>
							</div>
							<!-- END -->
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- 재고 -->
	<div class="offcanvas offcanvas-start small shadow"
		data-bs-scroll="true" data-bs-backdrop="false" tabindex="-1"
		id="offcanvasInventory" aria-labelledby="offcanvasInventoryLabel">
		<div class="offcanvas-header">
			<h5 class="offcanvas-title" id="offcanvasInventoryLabel">재고</h5>
			<button type="button" class="btn-close" data-bs-dismiss="offcanvas"
				aria-label="Close"></button>
		</div>
		<div class="offcanvas-body">
			<div class="dropdown mt-3">
				<%-- <c:import url="/views/common/sidebar-inventory.jsp" /> --%>

				<div class="col">
					<div class="accordion accordion-flush" id="accordionFlushExample">
						<!-- 1 -->
						<div class="accordion-item">
							<h2 class="accordion-header">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse" data-bs-target="#flush-collapseOne"
									aria-expanded="false" aria-controls="flush-collapseOne">
									매장별 재고 관리</button>
							</h2>
							<div id="flush-collapseOne" class="accordion-collapse collapse"
								data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<a href="/sik/views/main.jsp">브랜드 재고 조회</a><br> <a
										href="/sik/views/main.jsp">매장별 재고 조회</a><br> <a
										href="/sik/views/main.jsp">상품별 재고 조회</a><br> <a
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
									본사 재고 관리</button>
							</h2>
							<div id="flush-collapseTwo" class="accordion-collapse collapse"
								data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<a href="/sik/views/main.jsp">브랜드 재고 조회</a><br> <a
										href="/sik/views/main.jsp">상품별 재고 조회</a><br> <a
										href="/sik/views/main.jsp">메뉴3</a><br> <a
										href="/sik/views/main.jsp">메뉴4</a>
								</div>
							</div>
							<!-- 3 -->
							<div class="accordion-item">
								<h2 class="accordion-header">
									<button class="accordion-button collapsed" type="button"
										data-bs-toggle="collapse"
										data-bs-target="#flush-collapseThree" aria-expanded="true"
										aria-controls="flush-collapseThree">메뉴3</button>
								</h2>
								<div id="flush-collapseThree"
									class="accordion-collapse collapse"
									data-bs-parent="#accordionFlushExample">
									<div class="accordion-body">
										<a href="/sik/views/main.jsp">메뉴1</a><br> <a
											href="/sik/views/main.jsp">메뉴2</a><br> <a
											href="/sik/views/main.jsp">메뉴3</a><br> <a
											href="/sik/views/main.jsp">메뉴4</a>
									</div>
								</div>
							</div>
							<!-- 4 -->
							<div class="accordion-item">
								<h2 class="accordion-header">
									<button class="accordion-button collapsed" type="button"
										data-bs-toggle="collapse" data-bs-target="#collapseFour"
										aria-expanded="true" aria-controls="collapseFour">메뉴4</button>
								</h2>
								<div id="collapseFour" class="accordion-collapse collapse"
									data-bs-parent="#accordionFlushExample">
									<div class="accordion-body">
										<a href="#">메뉴1</a><br> <a href="#">메뉴2</a><br> <a
											href="#">메뉴3</a><br> <a href="#">메뉴4</a>
									</div>
								</div>
							</div>
							<!-- END -->
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- 관리 -->
	<div class="offcanvas offcanvas-start small shadow"
		data-bs-scroll="true" data-bs-backdrop="false" tabindex="-1"
		id="offcanvasFranchisee" aria-labelledby="offcanvasFranchiseeLabel">
		<div class="offcanvas-header">
			<h5 class="offcanvas-title" id="offcanvasFranchiseeLabel">관리</h5>
			<button type="button" class="btn-close" data-bs-dismiss="offcanvas"
				aria-label="Close"></button>
		</div>
		<div class="offcanvas-body">
			<div class="dropdown mt-3">
				<%-- <c:import url="/views/common/sidebar-franchisee.jsp" /> --%>

				<div class="col">
					<div class="accordion accordion-flush" id="accordionFlushExample">
						<!-- 1 -->
						<div class="accordion-item">
							<h2 class="accordion-header">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse" data-bs-target="#flush-collapseOne"
									aria-expanded="false" aria-controls="flush-collapseOne">
									브랜드 관리</button>
							</h2>
							<div id="flush-collapseOne" class="accordion-collapse collapse"
								data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<a href="brandNoticeList.do?page=1">브랜드 공지 조회</a><br> <a
										href="/sik/views/main.jsp">브랜드 공지 관리</a><br> <a
										href="selectBrandList.do?page=1">브랜드 조회</a><br> <a
										href="/sik/views/main.jsp">브랜드 관리</a>
								</div>
							</div>
						</div>
						<!-- 2 -->
						<div class="accordion-item">
							<h2 class="accordion-header">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo"
									aria-expanded="true" aria-controls="flush-collapseTwo">
									계약관리</button>
							</h2>
							<div id="flush-collapseTwo" class="accordion-collapse collapse"
								data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<a href="/sik/views/main.jsp">계약현황조회</a><br> <a
										href="/sik/views/main.jsp">계약 수정</a><br> <a
										href="/sik/views/main.jsp">계약현황검색</a><br> <a
										href="/sik/views/main.jsp">계약등록</a>
								</div>
							</div>
							<!-- 3 -->
							<div class="accordion-item">
								<h2 class="accordion-header">
									<button class="accordion-button collapsed" type="button"
										data-bs-toggle="collapse"
										data-bs-target="#flush-collapseThree" aria-expanded="true"
										aria-controls="flush-collapseThree">매장현황</button>
								</h2>
								<div id="flush-collapseThree"
									class="accordion-collapse collapse"
									data-bs-parent="#accordionFlushExample">
									<div class="accordion-body">
										<a href="/sik/views/main.jsp">메출필터검색</a><br> <a
											href="/sik/views/main.jsp">매출조회</a><br> <a
											href="/sik/views/main.jsp">매출전표</a><br> <a
											href="/sik/views/main.jsp">전국매장</a><br> <a
											href="/sik/views/main.jsp">매장검색</a>
									</div>
								</div>
							</div>
							<!-- 4 -->
							<div class="accordion-item">
								<h2 class="accordion-header">
									<button class="accordion-button collapsed" type="button"
										data-bs-toggle="collapse" data-bs-target="#collapseFour"
										aria-expanded="true" aria-controls="collapseFour">가맹점관리
									</button>
								</h2>
								<div id="collapseFour" class="accordion-collapse collapse"
									data-bs-parent="#accordionFlushExample">
									<div class="accordion-body">
										<a href="/sik/views/main.jsp">매장상세</a><br> <a
											href="/sik/views/main.jsp">매장관리정검</a><br> <a
											href="/sik/views/main.jsp">매장요청사항</a><br> <a
											href="/sik/views/main.jsp">매장요청조회</a>
									</div>
								</div>
							</div>
							<!-- END -->
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- 홍보 -->
	<div class="offcanvas offcanvas-start small shadow"
		data-bs-scroll="true" data-bs-backdrop="false" tabindex="-1"
		id="offcanvasPromotion" aria-labelledby="offcanvasPromotionLabel">
		<div class="offcanvas-header">
			<h5 class="offcanvas-title" id="offcanvasPromotionLabel">홍보</h5>
			<button type="button" class="btn-close" data-bs-dismiss="offcanvas"
				aria-label="Close"></button>
		</div>
		<div class="offcanvas-body">
			<div class="dropdown mt-3">
				<%-- <c:import url="/views/common/sidebar-promotion.jsp" /> --%>

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
										data-bs-toggle="collapse"
										data-bs-target="#flush-collapseThree" aria-expanded="true"
										aria-controls="flush-collapseThree">광고 현황</button>
								</h2>
								<div id="flush-collapseThree"
									class="accordion-collapse collapse"
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

			</div>
		</div>
	</div>
	<!-- admin -->

	<div class="offcanvas offcanvas-start small shadow"
		data-bs-scroll="true" data-bs-backdrop="false" tabindex="-1"
		id="offcanvasAdmin" aria-labelledby="offcanvasAdminLabel">
		<div class="offcanvas-header">
			<h5 class="offcanvas-title" id="offcanvasAdminLabel">admin</h5>
			<button type="button" class="btn-close" data-bs-dismiss="offcanvas"
				aria-label="Close"></button>
		</div>
		<div class="offcanvas-body">
			<div class="dropdown mt-3">
				<%-- <c:import url="/views/common/sidebar-admin.jsp" /> --%>

				<div class="col">
					<div class="accordion accordion-flush" id="accordionFlushExample">
						<!-- 1 -->
						<div class="accordion-item">
							<h2 class="accordion-header">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse" data-bs-target="#flush-collapseOne"
									aria-expanded="false" aria-controls="flush-collapseOne">
									직원 조회</button>
							</h2>
							<div id="flush-collapseOne" class="accordion-collapse collapse"
								data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<a href="/sik/views/main.jsp">직원조회</a><br> <a
										href="/sik/views/main.jsp">직급별 조회</a><br> <a
										href="/sik/views/main.jsp">부서별 조회</a><br> <a
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
									직원 관리</button>
							</h2>
							<div id="flush-collapseTwo" class="accordion-collapse collapse"
								data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<a href="/sik/views/main.jsp">직원 정보 등록</a><br> <a
										href="/sik/views/main.jsp">직원 정보 수정</a><br> <a
										href="/sik/views/main.jsp">직원 정보 삭제</a><br> <a
										href="/sik/views/main.jsp">메뉴4</a>
								</div>
							</div>
							<!-- 3 -->
							<div class="accordion-item">
								<h2 class="accordion-header">
									<button class="accordion-button collapsed" type="button"
										data-bs-toggle="collapse"
										data-bs-target="#flush-collapseThree" aria-expanded="true"
										aria-controls="flush-collapseThree">메뉴3</button>
								</h2>
								<div id="flush-collapseThree"
									class="accordion-collapse collapse"
									data-bs-parent="#accordionFlushExample">
									<div class="accordion-body">
										<a href="/sik/views/main.jsp">메뉴1</a><br> <a
											href="/sik/views/main.jsp">메뉴2</a><br> <a
											href="/sik/views/main.jsp">메뉴3</a><br> <a
											href="/sik/views/main.jsp">메뉴4</a>
									</div>
								</div>
							</div>
							<!-- 4 -->
							<div class="accordion-item">
								<h2 class="accordion-header">
									<button class="accordion-button collapsed" type="button"
										data-bs-toggle="collapse" data-bs-target="#collapseFour"
										aria-expanded="true" aria-controls="collapseFour">메뉴4</button>
								</h2>
								<div id="collapseFour" class="accordion-collapse collapse"
									data-bs-parent="#accordionFlushExample">
									<div class="accordion-body">
										<a href="/sik/views/main.jsp">메뉴1</a><br> <a
											href="/sik/views/main.jsp">메뉴2</a><br> <a
											href="/sik/views/main.jsp">메뉴3</a><br> <a
											href="/sik/views/main.jsp">메뉴4</a>
									</div>
								</div>
							</div>
							<!-- END -->
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- admin -->

</body>
</html>