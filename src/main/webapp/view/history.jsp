<%@page import="org.apache.catalina.connector.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="OhShu.vo.*"%>
<%@ page import="OhShu.DAOImpl.*"%>
<%@ page import="OhShu.DAO.*"%>
<%@ page import="OhShu.ServiceImpl.*"%>
<%@ page import="OhShu.service.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.net.*"%>
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
<title>History Category Page</title>
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

</head>

<body class="sb-nav-fixed">
   <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
      <!-- Navbar Brand-->
      <a class="navbar-brand ps-3" href="main.jsp">충남오세유~</a>
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
                <c:choose>
                <c:when	test="${not empty sessionScope.SESS_AUTH and sessionScope.SESS_AUTH == true}">
         <li><a class="dropdown-item" href="<%= request.getContextPath()%>/UserLogout">로그아웃</a></li>
               <li><a class="dropdown-item"  href="myPage_info.jsp">마이페이지</a></li>
               <li>
                  <hr class="dropdown-divider" />
               </li>
               <li><a class="dropdown-item">User: ${sessionScope.SESS_ID}</a></li>
               </c:when>
               <c:otherwise>	
               <li><a class="dropdown-item"href="<%= request.getContextPath()%>/SignIn">로그인</a></li>
               <<li><a class="dropdown-item"  href="http://localhost:8080/OhShu_Team1/join">회원가입</a>
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
                       	 <i class="fas fa-tachometer-alt"></i></div> 충청남도의 개요 </a>
                       	  	 
                      <a class="nav-link" href="history.jsp">
                     	<div class="sb-nav-link-icon">
                       	 <i class="fas fa-tachometer-alt"></i></div> 충남오슈의 역사 </a> 
	
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



                  <!--    <div class="sb-sidenav-menu-heading">Addons</div>
                  <a class="nav-link" href="#">
                     <div class="sb-nav-link-icon">
                        <i class="fas fa-chart-area"></i>
                     </div> Charts
                  </a> <a class="nav-link" href="#">
                     <div class="sb-nav-link-icon">
                        <i class="fas fa-table"></i>
                     </div> Tables
                  </a>
                      -->
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
                  <div class="card-header">충님오슈의 이야기</div>
                  <div class="card-body">              
                        <h3>안녕하세요, 충남오슈입니다. 즐거운 여행되세요.</h3>
                        <p>충청남도의 매력을 왕창 즐겨보시는 정보 가득한 충남오슈가 되겠습니다.</p>
                           <br>
                           <br>
	                        <div>
	                           <p>충청남도의 역사 고대에는 마한의 중심지였으나, 마한이 백제에 병합된 이후 백제 후기의 도읍이 웅진과 사비에 있었다. 
	                              이후 통일신라 시대에 9주 5소경 중 9주의 하나인 웅주가 있었으며, 고려 시대에 오늘날 경기도, 충청북도 지역과 
	                              함께 양광도로 편제되었다가, 조선이 건국되면서 양광도가 경기도와 충청도로 분리되었다. 
	                              도의 명칭이 오늘날 충청북도에 해당되는 충주와 청주에서 따왔기 때문에 현 충청남도 지역은 소외된 것
	                              같지만, 홍주와 공주의 파워도 만만치 않았고, 충주와 청주가 반역향으로 강등될 때마다 청홍도, 충홍도, 공충도,
	                              홍공도 등의 다양한 이름으로 존재감이 없지 않았다. 임진왜란 이후 구한말 충청도가 남북도로 분리될 때까지 충청도
	                              감영 소재지는 바로 공주였다 이후 1896년 8월 4일 충청북도와 분리되고 진위군이 경기도에 편입되었다.
	                              1914년 문의군이 충청북도에 편입되고 평택군(팽성 한정)이 경기도에 편입되었다. 1932년 공주에 있었던
	                              충남도청이 대전으로 이전되었다. 이후 도청 소재지는 1935년 대전부로 승격하고 1949년 8월 15일 대전시로
	                              개칭되었다. 1962년 12월 12일 전라북도 금산군을 편입하고, 1963년 천안시, 1986년 온양시,
	                              공주시, 대천시가 설치되었다. 1989년 서산군 서산읍이 서산시로 승격됨과 동시에 태안군이 분군되었고, 대전시와
	                              대덕군이 통합 이후 대전직할시로 분리승격했으며, 1995년 천안, 아산, 공주, 보령, 서산의 도농통합시 출범과
	                              아산시, 보령시로 명칭 변경, 이듬해인 1996년 논산시 승격으로 첫 도농복합시가 생성되었다. 2003년 9월
	                              19일 충청남도 산하 계룡출장소를 계룡시로 분리됐다. 2012년 1월 1일 당진시 승격과 동년 7월 1일
	                              세종특별자치시가 출범되면서 현행 기초자치단체로 재편되었다. 2013년 충청남도청을 비롯한 도 산하 기관이 홍성군
	                              및 예산군의 경계에 조성된 내포신도시로 이전되었다.</p>
	                        </div>
					   </div>
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