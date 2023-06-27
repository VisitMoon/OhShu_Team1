<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="OhShu.vo.*"%>
<%@ page import="OhShu.DAOImpl.*"%>
<%@ page import="OhShu.DAO.*"%>
<%@ page import="OhShu.ServiceImpl.*"%>
<%@ page import="OhShu.service.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Tour Category Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css"
	rel="stylesheet" />
<link href="../css/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	crossorigin="anonymous"></script>
<script src="../js/scripts.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
	crossorigin="anonymous"></script>
<script src="../js/datatables-simple-demo.js"></script>
<script
	src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=mn7cwsrvym"></script>

<style>
#nmap {
	height: 200px;
	margin: 0 auto;
	width: 300px;
	max-width: 100%;
	border: 2px black solid;
}

.top-menu>ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	margin-top: 10px;
	padding-top: 20px;
	padding-bottom: 20px;
}

.top-menu li {
	display: inline;
	margin-left: 0px;
	padding: 5px;
	border: 1px black solid;
	border-radius: 10px;
}

.contents ul {
	list-style-type: none;
}

#container {
	margin: 0 auto;
	width: 1200px;
	background-color: #fff;
}

.contents {
	width: 1000px;
	margin: 50px auto;
}

.detail {
	float: left;
	margin-right: 50px;
	border-radius: 20px;
}

main>section {
	margin-top: 60px;
}

footer {
	margin-top: 200px;
	border-top: 1px black solid;
}

* {
	box-sizing: border-box;
}

.column {
	float: left;
	width: 33.33%;
}

.column>img {
	border-radius: 20px;
}

.column>h5 {
	margin-top: 10px;
	text-align: center;
}

/* Clearfix (clear floats) */
.row::after {
	content: "";
	clear: both;
	display: table;
}

#logo>a>h1 {
	font-size: 50pt;
	margin-bottom: auto;
	color: black;
}

a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
}

body {
	font-family: "Lato", sans-serif;
}

.sidenav {
	height: 100%;
	width: 160px;
	position: absolute;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: white;
	overflow-x: hidden;
	margin-top: 290px;
	border-right: solid;
}

.sidenav a {
	padding: 6px 8px 6px 16px;
	text-decoration: none;
	font-size: 25px;
	color: black;
	display: block;
}

.sidenav a:hover {
	color: #f1f1f1;
}

.main {
	margin-left: 1px;
	/* Same as the width of the sidenav */
	font-size: 28px;
	/* Increased text to enable scrolling */
	padding: 0px 10px;
}

@media screen and (max-height: 450px) {
	.sidenav {
		padding-top: 15px;
	}
	.sidenav a {
		font-size: 18px;
	}
}



table {
	width: 100%;
	border:solid;
	border-radius: 20px;
	
}

th, td {
border-radius: 20px;
border:solid;
	font-size: 15pt;
	text-align: center;
}
</style>
</head>
<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<!-- Navbar Brand-->
		<a class="navbar-brand ps-3" href="메인페이지.html">충남오세유~</a>
		<!-- Sidebar Toggle-->
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
			id="sidebarToggle" href="#!">
			<i class="fas fa-bars"></i>
		</button>
		<!-- Navbar Search-->
		<!-- <form
			class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
			<div class="input-group">
				<input class="form-control" type="text" placeholder="Search for..."
					aria-label="Search for..." aria-describedby="btnNavbarSearch" />
				<button class="btn btn-primary" id="btnNavbarSearch" type="button">
					<i class="fas fa-search"></i>
				</button>
			</div>
		</form> -->
		<!-- Navbar-->
		<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
				role="button" data-bs-toggle="dropdown" aria-expanded="false"><i
					class="fas fa-user fa-fw"></i></a>
				<ul class="dropdown-menu dropdown-menu-end"
					aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="#!">로그인</a></li>
					<li><a class="dropdown-item" href="#!">회원가입</a></li>
					<li><a class="dropdown-item" href="#!">마이페이지</a></li>
					<li><hr class="dropdown-divider" /></li>
					<li><a class="dropdown-item" href="#!">로그아웃</a></li>
				</ul></li>
		</ul>
	</nav>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">
						<div class="sb-sidenav-menu-heading">소개</div>
						<a class="nav-link" href="#">

							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> 개요


						</a> <a class="nav-link" href="#">

							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> 역사

						</a>

						<div class="sb-sidenav-menu-heading">카테고리</div>
						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapseLayouts" aria-expanded="false"
							aria-controls="collapseLayouts"> <!-- 카테고리 한개씩 클릭해서 정상작동할려면 div박스안의 collapseLayouts의 3개가 동일해야함, ㅇㅋ임의로바꿔주면됌-->
							<div class="sb-nav-link-icon">
								<i class="fas fa-bars"></i>
								<!--박스-->
							</div> 숙박
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapseLayouts"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="음식점전체페이지.html">전체</a> <a
									class="nav-link" href="#">호텔</a> <a class="nav-link" href="#">모텔</a>
								<a class="nav-link" href="#">펜션</a> <a class="nav-link" href="#">콘도</a>
							</nav>
						</div>

						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapsePages" aria-expanded="false"
							aria-controls="collapsePages">
							<div class="sb-nav-link-icon">
								<i class="fas fa-bars"></i>
							</div> 여행
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapsePages"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="#">전체</a> <a class="nav-link" href="#">명산</a>
								<a class="nav-link" href="#">해변/섬</a> <a class="nav-link"
									href="#">항/포구</a> <a class="nav-link" href="#">강/계곡/호수</a> <a
									class="nav-link" href="#">캠핑/트레킹/체험</a> <a class="nav-link"
									href="#">풍경</a> <a class="nav-link" href="#">역사유적지</a> <a
									class="nav-link" href="#">종교/사찰/성지</a> <a class="nav-link"
									href="#">고택/민속마을</a> <a class="nav-link" href="#">전시/관람</a> <a
									class="nav-link" href="#">휴양/옹천</a> <a class="nav-link"
									href="#">특화관광지</a>

							</nav>
						</div>

						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapsetour" aria-expanded="false"
							aria-controls="collapsetour">
							<div class="sb-nav-link-icon">
								<i class="fas fa-bars"></i>
							</div> 음식점
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapsetour"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="음식점전체페이지.html">전체</a> <a
									class="nav-link" href="#">농가맛집</a> <a class="nav-link" href="#">맛을찾아떠나는충남여행</a>
								<a class="nav-link" href="#">미더유인증</a> <a class="nav-link"
									href="#">외국인편의음식점</a> <a class="nav-link" href="#">외부등록 음식점</a>
								<a class="nav-link" href="#">착한가격업소</a>
							</nav>
						</div>

						<div class="sb-sidenav-menu-heading">Addons</div>
						<a class="nav-link" href="#">
							<div class="sb-nav-link-icon">
								<i class="fas fa-chart-area"></i>
							</div> Charts
						</a> <a class="nav-link" href="#">
							<div class="sb-nav-link-icon">
								<i class="fas fa-table"></i>
							</div> Tables
						</a>
					</div>
				</div>
				<div class="sb-sidenav-footer">
					<div class="small">Logged in as:</div>
					CHUNG! NAM! OH! SHU~
				</div>
			</nav>
		</div>
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">


					<div class="card mb-4"></div>
					<div class="card mb-4">
						<div class="card-header">
						<% StayService service = StayServiceImpl.getInstance();  
							List<StayVO> stay_list = service.getStayList();
							String stayNo = request.getParameter("stayNo");
							int num = Integer.parseInt(stayNo);
							%>
							<p>
								<a>전체</a><a> > </a><a><%=stay_list.get(num).getStay_category()%></a><a>
									> </a> <a><%=stay_list.get(num).getStay_name()%></a>
							</p>
						</div>
						<div class="card-body">
							<div class="main">




								<div style="text-align: center;">
									<img src="<%=stay_list.get(num).getStay_img()%>"
										style="border-radius: 20px;">
								</div>
								
								<h1 style="font-weight: bold;">상세내용</h1>
								<div><%=stay_list.get(num).getStay_info()%></div>





								<script
									src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=mn7cwsrvym"></script>


								<!-- 지도가 생성될 div, id 속성값은 nmap -->
								<div id="nmap"></div>

								<script>
									// id 속성값 nmap 에 지도 생성
									var mapOptions = {
										center : new naver.maps.LatLng(
								<%=stay_list.get(num).getStay_x()%>
									,
								<%=stay_list.get(num).getStay_y()%>
									), // 서울의 좌표
										zoom : 10
									// 초기 줌 레벨 설정
									};

									// id 속성값 nmap에 지도 생성
									new naver.maps.Map('nmap', mapOptions);
								</script>

								<div style="margin-top: 60px;">
									추가정보
									<table>
										<tr>
											<th>이름</th>
											<th>지역</th>
											<th>주소</th>
											<th>전화번호</th>

										</tr>

										<tr>
											<td><%=stay_list.get(num).getStay_name()%></td>
											<td><%=stay_list.get(num).getStay_location()%></td>
											<td><%=stay_list.get(num).getStay_address()%></td>
											<td><%=stay_list.get(num).getStay_tel()%></td>

										</tr>
										<%

										%>


									</table>


								</div>

								<div style="margin-top: 20px;">
									<h5>댓글</h5>
									<input type="text">
									<button>등록</button>
									<input type="submit" value="등록">

								</div>


							</div>

						</div>
					</div>
				</div>
			</main>
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid px-4">
					<!-- <div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; Your Website 2023</div>
						<div>
							<a href="#">Privacy Policy</a> &middot; <a href="#">Terms
								&amp; Conditions</a>
						</div>
					</div> -->
				</div>
			</footer>
		</div>
	</div>

</body>
</html>