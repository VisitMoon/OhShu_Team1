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
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>충남오슈에 오신걸 환영합니다</title>
<link href="../css/main.css" rel="stylesheet" type="text/css" />
</head>
<style>
.img-boxs{
   margin-left: 0;
   margin-right: 0;

}
.img-boxs > div {
   display: inline-block;
      margin-left: 0;
   margin-right: 0;
   
}

.img-boxs img {
   width: 400px;

}

</style>
<body>

   <header>
      <nav>
         <div class="nav">

            <a href="main.jsp">
               <h1>CHUNG! NAM! OH! SHU!</h1>
            </a>

           <div class="nav-items">
					<c:choose>
						<c:when
							test="${not empty sessionScope.SESS_AUTH and sessionScope.SESS_AUTH == true}">
							<a href="<%= request.getContextPath()%>/UserLogout">로그아웃</a>
							<div class="nav-item">
							<a href="myPage_info.jsp">마이페이지</a>
							</div>
							</c:when>
							<c:otherwise>	
							<a href="<%= request.getContextPath()%>/SignIn">로그인</a>
							<div class="nav-item">
						<a href="http://localhost:8080/OhShu_Team1/join">회원가입</a>
					</div>
					
						</c:otherwise>
					</c:choose>
					
				</div>
         </div>
      </nav>
   </header>


   <div class="container">

      <div class="lis">
         <ul class="lis">
            <li class="lis"><a href="introduction.jsp">개요</a></li>
            <li class="lis"><a href="stay_allCategory_page.jsp">숙박</a></li>
            <li class="lis"><a href="tour_allCategory_page.jsp">여행</a></li>
            <li class="lis"><a href="food_allCategory_page.jsp">음식</a></li>
         </ul>
      </div>

      <!-- Portfolio Item Heading -->
      <h1 class="my-4">! WELLCOME CHUNGMANOHSHU !</h1>

      <div class="row">

         <div class="col-md-8">
            <img class="img-fluid-main" src="img/shungman_slogan.jpg" alt="">

         </div>

         <div class="col-md-4">

            <h3 class="my-3">안녕하세요, 충남오슈입니다. 즐거운 여행되세요.</h3>
            <p>충청남도의 매력을 왕창 즐겨보시는 정보 가득한 충남오슈가 되겠습니다.</p>
            <br> <br>





         </div>
      </div>

   </div>
   
      <% FoodMainService food_sv = FoodMainServiceImpl.getInstance(); %>
      <% FoodMainVO food_vo = new FoodMainVO(); %>
      <% food_vo = food_sv.getFoodJoayoRanking(1); %>
      
      <% FoodService food_service = FoodServiceImpl.getInstance(); %>
        <% List<FoodVO> food_list = food_service.getFoodList(); %>
        <% int food_index=0; %>
       <% for (int i = 0; i < food_list.size(); i++) { %>   
       <% if (food_vo.getFood_img().equals(food_list.get(i).getFood_img())) { %>
       <% food_index = i;  %>
        <%} %>
      <%} %>



      <% TourMainService tour_sv = TourMainServiceImpl.getInstance(); %>
      <% TourMainVO tour_vo = new TourMainVO(); %>
      <% tour_vo = tour_sv.getTourJoayoRanking(1); %>
      <% TourService tour_service = TourServiceImpl.getInstance(); %>
        <% List<TourVO> tour_list = tour_service.getTourList(); %>
        <% int tour_index=0; %>
       <% for (int i = 0; i < tour_list.size(); i++) { %>   
       <% if (tour_vo.getTour_img().equals(tour_list.get(i).getTour_img())) { %>
       <% tour_index = i;  %>
        <%} %>
      <%} %>
      
      

      <% StayMainService stay_sv = StayMainServiceImpl.getInstance(); %>
      <% StayMainVO stay_vo = new StayMainVO(); %>
      <% stay_vo = stay_sv.getStayJoayoRanking(1); %>
      
      <% StayService stay_service = StayServiceImpl.getInstance(); %>
        <% List<StayVO> stay_list = stay_service.getStayList(); %>
        <% int stay_index=0; %>
       <% for (int i = 0; i < stay_list.size(); i++) { %>   
       <% if (stay_vo.getStay_img().equals(stay_list.get(i).getStay_img())) { %>
       <% stay_index = i;  %>
        <%} %>
      <%} %>
      
      
      
      
   
   <div style="text-align: center;" class="img-boxs">
      <div>
   `   <h3 style="text-align: center;">음식1위</h3>
      <a href="food_detail_page.jsp?foodNo=<%=food_index%>"><img style="text-align: center;" class="img-fluid" src="<%=food_vo.getFood_img()%>"></a>
      </div> 
      <div>
      <h3 style="text-align: center;">여행1위</h3>
      <a href="tour_detail_page.jsp?tourNo=<%=tour_index%>"><img style="text-align: center;" class="img-fluid" src="<%=tour_vo.getTour_img()%>"></a>
      </div>
      <div>
      <h3 style="text-align: center;">숙박1위</h3> 
      <a href="stay_detail_page.jsp?stayNo=<%=stay_index%>"><img style="text-align: center;"class="img-fluid" src="<%= stay_vo.getStay_img()%>"></a>
      </div>
   </div>

   

   <footer class="copyright">
      <div class="copyright_div">
         <p>저작권 : copyright ⓒ THE PROVINCE OF CHUNGCHEONGNAM-DO. All
            Rights Reserved.</p>
      </div>
   </footer>


<<<<<<< HEAD
	<br>
	<br>
	<br>
	<footer class="copyright">
		<div class="copyright_div">
			<p>저작권 : copyright ⓒ THE PROVINCE OF CHUNGCHEONGNAM-DO. All Rights Reserved.</p>
		</div>
	</footer>
=======
>>>>>>> 653144dce9cc3c688ace23e8d344f340445f7fb2

</body>
</html>