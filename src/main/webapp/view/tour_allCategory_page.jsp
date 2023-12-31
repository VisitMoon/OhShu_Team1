<%@page import="org.apache.catalina.connector.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="OhShu.vo.*"%>
<%@ page import="OhShu.DAOImpl.*"%>
<%@ page import="OhShu.DAO.*"%>
<%@ page import="OhShu.ServiceImpl.*"%>
<%@ page import="OhShu.service.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
.img_detail img {
	width: 300px;
	height: 167.250px;
}
</style>

</head>

<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<!-- Navbar Brand-->
		<a class="navbar-brand ps-3" href="main.jsp">충남오슈~</a>
		<!-- Sidebar Toggle-->
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
			id="sidebarToggle" href="#!">
			<i class="fas fa-bars"></i>
		</button>
		<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
				role="button" data-bs-toggle="dropdown" aria-expanded="false"><i
					class="fas fa-user fa-fw"></i></a>
				<ul class="dropdown-menu dropdown-menu-end"
					aria-labelledby="navbarDropdown">
					<c:choose>
						<c:when
							test="${not empty sessionScope.SESS_AUTH and sessionScope.SESS_AUTH == true}">
							<li><a class="dropdown-item"
								href="<%= request.getContextPath()%>/UserLogout">로그아웃</a></li>
							<li><a class="dropdown-item" href="myPage_info.jsp">마이페이지</a></li>
							<li>
								<hr class="dropdown-divider" />
							</li>
							<li><a class="dropdown-item">User:
									${sessionScope.SESS_ID}</a></li>
						</c:when>
						<c:otherwise>
							<li><a class="dropdown-item"
								href="<%= request.getContextPath()%>/SignIn">로그인</a></li>
               <li><a class="dropdown-item"
								href="http://localhost:8080/OhShu_Team1/join">회원가입</a>
						</c:otherwise>
					</c:choose>
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
						<a class="nav-link" href="introduction.jsp">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> 충청남도의 개요
						</a> <a class="nav-link" href="history.jsp">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> 충남오슈의 역사
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
								<a class="nav-link" href="stay_allCategory_page.jsp?stayCate=전체">전체</a>
								<a class="nav-link"
									href="stay_allCategory_page.jsp?stayCate=관광호텔">관광호텔</a> <a
									class="nav-link" href="stay_allCategory_page.jsp?stayCate=굿스테이">굿스테이</a>
								<a class="nav-link"
									href="stay_allCategory_page.jsp?stayCate=외부등록 숙박업소">외부등록
									숙박업소</a> <a class="nav-link"
									href="stay_allCategory_page.jsp?stayCate=콘도리조트">콘도&리조트</a> <a
									class="nav-link" href="stay_allCategory_page.jsp?stayCate=펜션">펜션</a>
								<a class="nav-link"
									href="stay_allCategory_page.jsp?stayCate=한옥스테이">한옥스테이</a>
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
								<a class="nav-link" href="tour_allCategory_page.jsp?tourCate=전체">전체</a>
								<a class="nav-link" href="tour_allCategory_page.jsp?tourCate=명산">명산</a>
								<a class="nav-link"
									href="tour_allCategory_page.jsp?tourCate=해변/섬">해변/섬</a> <a
									class="nav-link" href="tour_allCategory_page.jsp?tourCate=항/포구">항/포구</a>
								<a class="nav-link"
									href="tour_allCategory_page.jsp?tourCate=강/계곡/호수">강/계곡/호수</a> <a
									class="nav-link"
									href="tour_allCategory_page.jsp?tourCate=캠핑/트래킹/체험">캠핑/트래킹/체험</a>
								<a class="nav-link" href="tour_allCategory_page.jsp?tourCate=풍경">풍경</a>
								<a class="nav-link"
									href="tour_allCategory_page.jsp?tourCate=역사유적지">역사유적지</a> <a
									class="nav-link"
									href="tour_allCategory_page.jsp?tourCate=종교/사찰/성지">종교/사찰/성지</a>
								<a class="nav-link"
									href="tour_allCategory_page.jsp?tourCate=고택/민속마을">고택/민속마을</a> <a
									class="nav-link"
									href="tour_allCategory_page.jsp?tourCate=전시/관람">전시/관람</a> <a
									class="nav-link"
									href="tour_allCategory_page.jsp?tourCate=휴양/온천">휴양/온천</a> <a
									class="nav-link"
									href="tour_allCategory_page.jsp?tourCate=특화관광지">특화관광지</a>

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
								<a class="nav-link" href="food_allCategory_page.jsp?foodCate=전체">전체</a>
								<a class="nav-link"
									href="food_allCategory_page.jsp?foodCate=농가맛집">농가맛집</a> <a
									class="nav-link"
									href="food_allCategory_page.jsp?foodCate=맛을찾아떠나는충남여행">맛을찾아떠나는충남여행</a>
								<a class="nav-link"
									href="food_allCategory_page.jsp?foodCate=미더유인증">미더유인증</a> <a
									class="nav-link"
									href="food_allCategory_page.jsp?foodCate=외국인편의음식점">외국인편의음식점</a>
								<a class="nav-link"
									href="food_allCategory_page.jsp?foodCate=외부등록 음식점">외부등록 음식점</a>
								<a class="nav-link"
									href="food_allCategory_page.jsp?foodCate=착한가격업소">착한가격업소</a>
							</nav>
						</div>
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
							<i class="fas fa-table me-1"></i> 전체
						</div>
						<div class="card-body"></div>


						<table id="datatablesSimple">
							<thead>
								<tr>
									<th>사진</th>
									<th>여행지</th>
									<th>카테고리</th>
									<th>지역</th>
									<th>좋아요</th>
								</tr>
							</thead>
							<tbody>

								<% TourService service = TourServiceImpl.getInstance(); %>
								<% List<TourVO> list = service.getTourList();%>
								<% String tourCate = request.getParameter("tourCate"); %>
								<% String currentUser = (String) session.getAttribute("SESS_ID");%>
								<%String tour_no = request.getParameter("tourNo");%>
								<% if(tourCate==null || tourCate.equals("전체")){ %>
								<% for(int i =0; i<list.size(); i++){  %>
								<tr>
									<td><a href="tour_detail_page.jsp?tourNo=<%= i%>"> <img
											src="<%=list.get(i).getTour_img()%>"
											style="border-radius: 20px; width: 200px; height: 111px;"></a>
									</td>
									<td><%= list.get(i).getTour_name()%></td>
									<td><%= list.get(i).getTour_category()%></td>
									<td><%= list.get(i).getTour_location()%></td>
									<td>
									<c:choose>
									<c:when
										test="${not empty sessionScope.SESS_AUTH and sessionScope.SESS_AUTH == true}">
									<form action="/OhShu_Team1/ToggleTourJoayo" method="POST">
  										<input type="hidden" name="userId" value="<%=currentUser%>" />
 										 <input type="hidden" name="tourNo" value="<%=list.get(i).getTour_no()%>" />
 										 <input type="submit" value="좋아요" />
 										 </form>
 										  </c:when>
										<c:otherwise>
										<p>로그인이 필요한 서비스입니</p>
										</c:otherwise>
										</c:choose></td>
								</tr>

								<% }%>

								<% }else{%>
								<% for(int i =0; i<list.size(); i++){ %>
								<% if(list.get(i).getTour_category().equals(tourCate)){ %>
								<tr>
									<td><a href="tour_detail_page.jsp?tourNo=<%= i%>"> <img
											src="<%=list.get(i).getTour_img()%>"
											style="border-radius: 20px; width: 200px; height: 111px;"></a>
									</td>
									<td><%= list.get(i).getTour_name()%></td>
									<td><%= list.get(i).getTour_category()%></td>
									<td><%= list.get(i).getTour_location()%></td>
									<td>
									<c:choose>
									<c:when
										test="${not empty sessionScope.SESS_AUTH and sessionScope.SESS_AUTH == true}">
									<form action="/OhShu_Team1/ToggleTourJoayo" method="POST">
  										<input type="hidden" name="userId" value="<%=currentUser%>" />
 										 <input type="hidden" name="tourNo" value="<%=list.get(i).getTour_no()%>" />
 										 <input type="submit" value="좋아요" />
 										 </form>
 										  </c:when>
										<c:otherwise>
										<p>로그인이 필요한 서비스입니다</p>
										</c:otherwise>
										</c:choose>
										</td>
								</tr>
								<% }%>
								<% }%>
								<% }%>

							</tbody>
						</table>
					</div>
				</div>
			</main>
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid px-4"></div>
			</footer>
		</div>
	</div>

</body>

</html>