<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>충남오슈에 오신걸 환영합니다</title>
    <link href="../css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>

  <header>
        <nav>
            <div class="nav">
                <a href="main.jsp"> <h1>CHUNG! NAM! OH! SHU!</h1> </a>
                <div class="nav-items">
                    <div class="nav-item">
                        <a href="http://localhost:8080/OhShu_Team1/SignIn">로그인</a>
                    </div>
                    <div class="nav-item">
                        <a href="http://localhost:8080/OhShu_Team1/join">회원가입</a>
                    </div>
                    <div class="nav-item">
                    <a href="myPage_info.jsp">마이페이지</a>
                    </div>
                </div>
            </div>
        </nav>
    </header>


    <div class="container">

        <div class="lis">
            <ul class="lis">
                <li class="lis">
                    <a href="introduction.jsp">개요</a></li>
                <li class="lis">
                    <a href="stay_allCategory_page.jsp">숙박</a></li>
                <li class="lis">
                    <a href="tour_allCategory_page.jsp">여행</a></li>
                <li class="lis">
                    <a href="food_allCategory_page.jsp">음식</a></li>
            </ul>
        </div>

        <!-- Portfolio Item Heading -->
        <h1 class="my-4">! WELLCOME CHUNGMANOHSHU !</h1>

        <div class="row">
            <div class="col-md-8">
                <img src="<%= request.getContextPath()%>/img/resoure/chungman_slogan.jpg">       
            </div>

            <div class="col-md-4">
                <h3 class="my-3">안녕하세요, 충남오슈입니다. 즐거운 여행되세요.</h3>
                <p>충청남도의 매력을 왕창 즐겨보시는 정보 가득한 충남오슈가 되겠습니다.</p>
                <br>
                <br>

                <div class = "div-li">
                    <ul class="lis">
                        <li class="lis">음.식.랭.킹.1.위</li>
                        <li class="lis">여.행.랭.킹.1.위</li>
                        <li class="lis">숙.박.랭.킹.1.위</li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="img-boxs">
           
                <img class="img-fluid" src="https://via.placeholder.com/350x300" alt="">
                <img class="img-fluid" src="https://via.placeholder.com/350x300" alt="">
                <img class="img-fluid" src="https://via.placeholder.com/350x300" alt="">
        </div>
        <br>
        <br>
        <div class="row-main">
            <div class="col-md-8">
                <img class ="img-main" src="<%= request.getContextPath()%>/img/resoure/mascot.JPG">
                <img class ="img-main" src="<%= request.getContextPath()%>/img/resoure/mascot.JPG">          
            </div>        
        </div>
    </div>

	<br>
	<br>
	<br>
    <footer class="copyright">
      <div class="copyright_div">
            <p>저작권 : copyright ⓒ THE PROVINCE OF CHUNGCHEONGNAM-DO. All Rights Reserved.</p>
        </div>
   </footer>
   
</body>
</html>