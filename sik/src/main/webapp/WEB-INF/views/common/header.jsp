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
	
		
	<c:set var="loop_flag" value="false" />
	<c:set var="FranchiseManagement">브랜드관리, 브랜드공지, 매장요청사항,매장관리점검,매장상세조회</c:set>
	<c:set var="Stationery">출고요청,출고진행사항,생산업체관리,생산요청,발주</c:set>
	<c:set var="MenuDevelopment">메뉴관리,레시피관리</c:set>
	<c:set var="FranchiseSales">가맹계약현황</c:set>
	<c:set var="ProductManagement">상품관리,매장별재고,본사재고</c:set>
	<c:set var="AdvertisingPlanning">프로모션현황,마케팅현황</c:set>
	<c:set var="Sales">매출</c:set>
	<header class="p-3 mb-3 border-bottom small shadow">
		<div class="container">
			<div
				class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start"
				style="gap: 50px">
				<a href="main.do"
					class="d-flex align-items-center mb-2 mb-lg-0 link-body-emphasis text-decoration-none">
					<img src="/sik/resources/common/images/siklogo.png" width="40"
					style="magin-left: 30px">
				</a>
				<ul
					class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
					<c:set var="loop_flag" value="false" />
					<c:forEach var="board" items="${ FranchiseManagement }">
						<c:forEach var="hearder" items="${ sessionScope.board }">
							<c:if test="${ board eq hearder }">
								<c:if test="${ not loop_flag }">
									<li class="nav-item"><a class="nav-link" href="#"
										data-bs-toggle="offcanvas"
										data-bs-target="#FranchiseManagement">가맹관리</a></li>
									<c:set var="loop_flag" value="true" />
								</c:if>
							</c:if>
						</c:forEach>
					</c:forEach>
					<c:set var="loop_flag" value="false" />
					<c:forEach var="board" items="${ Stationery }">
						<c:forEach var="hearder" items="${ sessionScope.board }">
							<c:if test="${ board eq hearder }">
								<c:if test="${ not loop_flag }">
									<li class="nav-item"><a class="nav-link" href="#"
										data-bs-toggle="offcanvas" data-bs-target="#Stationery">물류</a></li>
									<c:set var="loop_flag" value="true" />
								</c:if>
							</c:if>
						</c:forEach>
					</c:forEach>
					<c:set var="loop_flag" value="false" />
					<c:forEach var="board" items="${ MenuDevelopment }">
						<c:forEach var="hearder" items="${ sessionScope.board }">
							<c:if test="${ board eq hearder }">
								<c:if test="${ not loop_flag }">

									<li class="nav-item"><a class="nav-link" href="#"
										data-bs-toggle="offcanvas" data-bs-target="#MenuDevelopment">메뉴개발</a>
									</li>
									<c:set var="loop_flag" value="true" />
								</c:if>
							</c:if>
						</c:forEach>
					</c:forEach>
					<c:set var="loop_flag" value="false" />
					<c:forEach var="board" items="${ FranchiseSales }">
						<c:forEach var="hearder" items="${ sessionScope.board }">
							<c:if test="${ board eq hearder }">
								<c:if test="${ not loop_flag }">

									<li class="nav-item"><a class="nav-link" href="#"
										data-bs-toggle="offcanvas" data-bs-target="#FranchiseSales">가맹영업</a>
									</li>
									<c:set var="loop_flag" value="true" />
								</c:if>
							</c:if>
						</c:forEach>
					</c:forEach>
					<c:set var="loop_flag" value="false" />
					<c:forEach var="board" items="${ ProductManagement }">
						<c:forEach var="hearder" items="${ sessionScope.board }">
							<c:if test="${ board eq hearder }">
								<c:if test="${ not loop_flag }">

									<li class="nav-item"><a class="nav-link" href="#"
										data-bs-toggle="offcanvas" data-bs-target="#ProductManagement">상품관리</a>
									</li>
									<c:set var="loop_flag" value="true" />
								</c:if>
							</c:if>
						</c:forEach>
					</c:forEach>
					<c:set var="loop_flag" value="false" />
					<c:forEach var="board" items="${ AdvertisingPlanning }">
						<c:forEach var="hearder" items="${ sessionScope.board }">
							<c:if test="${ board eq hearder }">
								<c:if test="${ not loop_flag }">
									<li class="nav-item"><a class="nav-link" href="#"
										data-bs-toggle="offcanvas"
										data-bs-target="#AdvertisingPlanning">광고기획</a></li>
									<c:set var="loop_flag" value="true" />
								</c:if>
							</c:if>
						</c:forEach>
					</c:forEach>
					<c:set var="loop_flag" value="false" />
					<c:forEach var="board" items="${ Sales }">
						<c:forEach var="hearder" items="${ sessionScope.board }">
							<c:if test="${ board eq hearder }">
								<c:if test="${ not loop_flag }">

									<li class="nav-item"><a class="nav-link" href="#"
										data-bs-toggle="offcanvas" data-bs-target="#Sales">매출</a></li>
									<c:set var="loop_flag" value="true" />
								</c:if>
							</c:if>
						</c:forEach>
					</c:forEach>
					<li><a class="nav-link" href="reportList.do">결재</a></li>
					<li><a class="nav-link" href="#">공지사항</a></li>
					<c:if
						test="${ !empty sessionScope.loginMember and sessionScope.loginMember.adminYn eq 'Y' }">
						<li class="nav-item"><a class="nav-link" href="#"
							data-bs-toggle="offcanvas" data-bs-target="#Admin">관리자</a></li>
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
	<!-- 가맹관리 FranchiseManagement -->
	<div class="offcanvas offcanvas-start small shadow"
		data-bs-scroll="true" data-bs-backdrop="false" tabindex="-1"
		id="FranchiseManagement" aria-labelledby="FranchiseManagementLabel">
		<div class="offcanvas-header">
			<h5 class="offcanvas-title" id="FranchiseManagementLabel">가맹관리</h5>
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
									<c:forEach var="board" items="${ sessionScope.board }">
										<c:if test="${ board eq '브랜드관리' }">
											<a href="/sik/views/main.jsp">브랜드관리</a>
											<br>
										</c:if>
									</c:forEach>
									<c:forEach var="board" items="${ sessionScope.board }">
										<c:if test="${ board eq '브랜드공지' }">
											<a href="brandNoticeListView.do?page=1&board=${ board }">브랜드공지</a>
											<br>
										</c:if>
									</c:forEach>
								</div>
							</div>
						</div>
						<!-- 2 -->
						<div class="accordion-item">
							<h2 class="accordion-header">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo"
									aria-expanded="true" aria-controls="flush-collapseTwo">
									매장관리</button>
							</h2>
							<div id="flush-collapseTwo" class="accordion-collapse collapse"
								data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<c:forEach var="board" items="${ sessionScope.board }">
										<c:if test="${ board eq '매장요청사항' }">
											<a href="/sik/views/main.jsp">매장요청사항</a>
											<br>
										</c:if>
									</c:forEach>
									<c:forEach var="board" items="${ sessionScope.board }">
										<c:if test="${board eq '매장관리점검' }">
											<a href="/sik/views/main.jsp">매장관리점검</a>
											<br>
										</c:if>
									</c:forEach>
									<c:forEach var="board" items="${ sessionScope.board }">
										<c:if test="${board eq '매장상세조회' }">
											<a href="/sik/views/main.jsp">매장상세조회</a>
											<br>
										</c:if>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- 물류  Stationery -->
	<div class="offcanvas offcanvas-start small shadow"
		data-bs-scroll="true" data-bs-backdrop="false" tabindex="-1"
		id="Stationery" aria-labelledby="StationeryLabel">
		<div class="offcanvas-header">
			<h5 class="offcanvas-title" id="StationeryLabel">물류</h5>
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
									출고</button>
							</h2>
							<div id="flush-collapseOne" class="accordion-collapse collapse"
								data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<c:forEach var="board" items="${ sessionScope.board }">
										<c:if test="${board eq '출고요청서' }">
											<a href="/sik/views/main.jsp">출고 요청</a>
										</c:if>
										<br>
									</c:forEach>
									<c:forEach var="board" items="${ sessionScope.board }">
										<c:if test="${board eq '출고진행사항' }">
											<a href="/sik/views/main.jsp">출고진행사항</a>
										</c:if>
									</c:forEach>
								</div>
							</div>
						</div>
						<!-- 2 -->
						<div class="accordion-item">
							<h2 class="accordion-header">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo"
									aria-expanded="true" aria-controls="flush-collapseTwo">
									생산</button>
							</h2>
							<div id="flush-collapseTwo" class="accordion-collapse collapse"
								data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<c:forEach var="board" items="${ sessionScope.board }">
										<c:if test="${board eq '생산업체' }">
											<a href="/sik/views/main.jsp">생산업체관리</a>
											<br>
										</c:if>
									</c:forEach>
									<c:forEach var="board" items="${ sessionScope.board }">
										<c:if test="${board eq '생산요청' }">
											<a href="/sik/views/main.jsp">생산요청</a>
										</c:if>
									</c:forEach>
								</div>
							</div>
							<!-- 3 -->
							<div class="accordion-item">
								<h2 class="accordion-header">
									<button class="accordion-button collapsed" type="button"
										data-bs-toggle="collapse"
										data-bs-target="#flush-collapseThree" aria-expanded="true"
										aria-controls="flush-collapseThree">발주</button>
								</h2>
								<div id="flush-collapseThree"
									class="accordion-collapse collapse"
									data-bs-parent="#accordionFlushExample">
									<div class="accordion-body">
										<c:forEach var="board" items="${ sessionScope.board }">
											<c:if test="${board eq '가맹점발주' }">
												<a href="/sik/views/main.jsp">발주</a>
												<br>
											</c:if>
										</c:forEach>
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
	<!-- 메뉴개발 MenuDevelopment -->
	<div class="offcanvas offcanvas-start small shadow"
		data-bs-scroll="true" data-bs-backdrop="false" tabindex="-1"
		id="MenuDevelopment" aria-labelledby="MenuDevelopmentLabel">
		<div class="offcanvas-header">
			<h5 class="offcanvas-title" id="MenuDevelopmentLabel">메뉴개발</h5>
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
									메뉴관리</button>
							</h2>
							<div id="flush-collapseOne" class="accordion-collapse collapse"
								data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<c:forEach var="board" items="${ sessionScope.board }">
										<c:if test="${board eq '레시피' }">
											<a href="brandNoticeList.do?page=1">메뉴관리</a>
											<br>
										</c:if>
									</c:forEach>
									<c:forEach var="board" items="${ sessionScope.board }">
										<c:if test="${board eq '레시피' }">
											<a href="/sik/views/main.jsp">레시피 관리</a>
										</c:if>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 가맹영업 FranchiseSales -->
	<div class="offcanvas offcanvas-start small shadow"
		data-bs-scroll="true" data-bs-backdrop="false" tabindex="-1"
		id="FranchiseSales" aria-labelledby="FranchiseSalesLabel">
		<div class="offcanvas-header">
			<h5 class="offcanvas-title" id="FranchiseSalesLabel">가맹영업</h5>
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
									가맹계약</button>
							</h2>
							<div id="flush-collapseOne" class="accordion-collapse collapse"
								data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<c:forEach var="board" items="${ sessionScope.board }">
										<c:if test="${board eq '계약현황' }">
											<a href="/sik/views/main.jsp">가맹계약현황</a>
										</c:if>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 상품관리 ProductManagement -->
	<div class="offcanvas offcanvas-start small shadow"
		data-bs-scroll="true" data-bs-backdrop="false" tabindex="-1"
		id="ProductManagement" aria-labelledby="ProductManagementLabel">
		<div class="offcanvas-header">
			<h5 class="offcanvas-title" id="ProductManagementLabel">상품관리</h5>
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
									상품현황</button>
							</h2>
							<div id="flush-collapseOne" class="accordion-collapse collapse"
								data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<c:forEach var="board" items="${ sessionScope.board }">
										<c:if test="${board eq '매장별재고현황' }">
											<a href="fcStock.do">매장별재고현황</a>
											<br>
										</c:if>
									</c:forEach>
									<c:forEach var="board" items="${ sessionScope.board }">
										<c:if test="${board eq '본사재고현황' }">
											<a href="brandStock.do">본사재고현황</a>
											<br>
										</c:if>
									</c:forEach>
									<c:forEach var="board" items="${ sessionScope.board }">
										<c:if test="${board eq '상품관리' }">
											<a href="/sik/views/main.jsp">상품관리</a>
											<br>
										</c:if>
									</c:forEach>
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 광고기획 AdvertisingPlanning -->
	<div class="offcanvas offcanvas-start small shadow"
		data-bs-scroll="true" data-bs-backdrop="false" tabindex="-1"
		id="AdvertisingPlanning" aria-labelledby="AdvertisingPlanningLabel">
		<div class="offcanvas-header">
			<h5 class="offcanvas-title" id="AdvertisingPlanningLabel">광고기획</h5>
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
									프로모션</button>
							</h2>
							<div id="flush-collapseOne" class="accordion-collapse collapse"
								data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<c:forEach var="board" items="${ sessionScope.board }">
										<c:if test="${board eq '프로모션' }">
											<a href="/sik/views/main.jsp">프로모션현황</a>
										</c:if>
									</c:forEach>
								</div>
							</div>
						</div>
						<!-- 2 -->
						<div class="accordion-item">
							<h2 class="accordion-header">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo"
									aria-expanded="true" aria-controls="flush-collapseTwo">
									마케팅</button>
							</h2>
							<div id="flush-collapseTwo" class="accordion-collapse collapse"
								data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<c:forEach var="board" items="${ sessionScope.board }">
										<c:if test="${board eq '프로모션' }">
											<a href="/sik/views/main.jsp">마케팅현황</a>
										</c:if>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 매출 Sales -->
	<div class="offcanvas offcanvas-start small shadow"
		data-bs-scroll="true" data-bs-backdrop="false" tabindex="-1"
		id="Sales" aria-labelledby="SalesLabel">
		<div class="offcanvas-header">
			<h5 class="offcanvas-title" id="SalesLabel">매출</h5>
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
									매출관리</button>
							</h2>
							<div id="flush-collapseOne" class="accordion-collapse collapse"
								data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<c:forEach var="board" items="${ sessionScope.board }">
										<c:if test="${board eq '매출' }">
											<a href="/sik/views/main.jsp">매출조회</a>
										</c:if>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<!-- 관리자 -->
	<div class="offcanvas offcanvas-start small shadow"
		data-bs-scroll="true" data-bs-backdrop="false" tabindex="-1"
		id="Admin" aria-labelledby="AdminAdminLabel">
		<div class="offcanvas-header">
			<h5 class="offcanvas-title" id="AdminLabel">관리자</h5>
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
									<a href="${ pageContext.servletContext.contextPath }/mlist.do">직원조회</a><br>
									<a
										href="${ pageContext.servletContext.contextPath }/mPositionList.do">직급별
										조회</a><br> <a
										href="${ pageContext.servletContext.contextPath }/mDeptList.do">부서별
										조회</a><br> <a href="#">메뉴4</a>
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
									<a
										href="${ pageContext.servletContext.contextPath }/minsert.do">직원
										정보 등록</a><br> <a
										href="${ pageContext.servletContext.contextPath }/mupdate.do">직원
										정보 수정</a><br> <a
										href="${ pageContext.servletContext.contextPath }/mdelete.do">직원
										정보 삭제</a><br> <a href="#">메뉴4</a>
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