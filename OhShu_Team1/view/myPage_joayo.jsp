<%@page import="org.apache.catalina.connector.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
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
<title>My Page joayo Page</title>
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
<style>
  table {
    width: 100%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;
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
                        href="<%=request.getContextPath()%>/UserLogout">로그아웃</a></li>
                     <li><a class="dropdown-item" href="myPage_info.jsp">마이페이지</a></li>
                     <li>
                        <hr class="dropdown-divider" />
                     </li>
                     <li><a class="dropdown-item">User:
                           ${sessionScope.SESS_ID}</a></li>
                  </c:when>
                  <c:otherwise>
                     <li><a class="dropdown-item"
                        href="<%=request.getContextPath()%>/SignIn">로그인</a></li>
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



                  <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                     data-bs-target="#collapseLayouts" aria-expanded="false"
                     aria-controls="collapseLayouts"> <!-- 카테고리 한개씩 클릭해서 정상작동할려면 div박스안의 collapseLayouts의 3개가 동일해야함, ㅇㅋ임의로바꿔주면됌-->
                     <div class="sb-nav-link-icon">
                        <i class="fas fa-bars"></i>
                        <!--박스-->
                     </div> 마이페이지
                     <div class="sb-sidenav-collapse-arrow">
                        <i class="fas fa-angle-down"></i>
                     </div>
                  </a>
                  <div class="collapse" id="collapseLayouts"
                     aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                     <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="myPage_info.jsp">정보</a> <a
                           class="nav-link" href="myPage_pwdChange.jsp">비밀번호 변경</a> <a
                           class="nav-link" href="myPage_joayo.jsp">좋아요 목록</a> <a
                           class="nav-link" href="mYpage_회원탈퇴.jsp">회원탈퇴</a>
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
                  <div class="card-header">전체 > 정보</div>
                  <div class="card-body">
                     <div>음식점 좋아요</div>
                  <div>
                  <table id="foodJoayoTable">
                     <thead>
                        <tr>
                           <th>No.</th>
                           <th>지역</th>
                           <th>카테고리</th>
                           <th>음식점명</th>
                        </tr>
                     </thead>
                     <tbody>
                  <% String user_id = (String)session.getAttribute("SESS_ID"); %>                  
                  <% UserPageService service = UserPageServiceImpl.getInstance(); %>
                  
                        <% List<FoodVO> foodlist = service.getUserFoodJoayo(user_id);%>                               
                            <% for(int i =0; i<foodlist.size(); i++){  %>
                               <tr>
                                  <td><%=foodlist.get(i).getFood_no()%></td>
                                 <td><%= foodlist.get(i).getFood_location()%></td>
                                 <td><%= foodlist.get(i).getFood_source()%></td>
                                 <td><%= foodlist.get(i).getFood_name()%></td>
                               </tr>

                        <% }%>
                     </tbody>
                  </table>
                  <br><br>
                  </div>
                     <div>여행 좋아요</div>
                     <div>
                  <table id="stayJoayoTable">
                     <thead>
                        <tr>
                           <th>No.</th>
                           <th>지역</th>
                           <th>카테고리</th>
                           <th>여행지명</th>
                        </tr>
                     </thead>
                     <tbody>

                        <% List<TourVO> tourlist = service.getUserTourJoayo(user_id);%>                                 
                            <% for(int i =0; i<tourlist.size(); i++){  %>
                               <tr>
                                  <td><%=tourlist.get(i).getTour_no()%></td>
                                 <td><%= tourlist.get(i).getTour_location()%></td>
                                 <td><%= tourlist.get(i).getTour_category()%></td>
                                 <td><%= tourlist.get(i).getTour_name()%></td>
                               </tr>
                        <% }%>
                     </tbody>
                  </table>
                  </div>
                  <br><br>
                     <div>숙박업소 좋아요</div>
                  <div>
                  <table id="stayJoayoTable">
                     <thead>
                        <tr>
                           <th>No.</th>
                           <th>지역</th>
                           <th>카테고리</th>
                           <th>숙박업소명</th>
                        </tr>
                     </thead>
                     <tbody>

                        <% List<StayVO> staylist = service.getUserStayJoayo(user_id);%>                                 
                            <% for(int i =0; i<staylist.size(); i++){  %>
                               <tr>
                                  <td><%=staylist.get(i).getStay_no()%></td>
                                 <td><%= staylist.get(i).getStay_location()%></td>
                                 <td><%= staylist.get(i).getStay_category()%></td>
                                 <td><%= staylist.get(i).getStay_name()%></td>
                               </tr>

                        <% }%>
                     </tbody>
                  </table>
                  </div>
                  </div>
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