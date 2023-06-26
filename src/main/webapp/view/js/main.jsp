<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>충남오슈에 오신걸 환영합니다</title>
    <link href="bootstrap/css/ohshu.css" rel="stylesheet" type="text/css" />
</head>
<body>

  <header>
        <nav>
            <div class="nav">

                <a href="view/js/main.jsp"> <h1>CHUNG! NAM! OH! SHU!</h1> </a>

                <div class="nav-items">
                    <div class="nav-item">
                        <a href="view/js/signin.jsp">SIGN_IN</a>
                    </div>
                    <div class="nav-item">
                        <a href="view/js/signup.jsp">SIGN_UP</a>
                    </div>
                    <div class="nav-item">
                        MY_PAGE
                    </div>
                </div>
            </div>
        </nav>
    </header>


    <div class="container">

        <div class="lis">
            <ul class="lis">
                <li class="lis">
                    <a href="view/js/page1.jsp">개요</a></li>
                <li class="lis">
                    <a href="view/js/page2.jsp">음식</a></li>
                <li class="lis">
                    <a href="view/js/page3.jsp">여행</a></li>
                <li class="lis">
                    <a href="view/js/page4.jsp">숙박</a></li>
            </ul>
        </div>

        <!-- Portfolio Item Heading -->
        <h1 class="my-4">! WELLCOME CHUNGMANOHSHU !</h1>

        <div class="row">

            <div class="col-md-8">
                <img class="img-fluid-main" src="https://via.placeholder.com/700x300" alt="">
            </div>

            <div class="col-md-4">
                <h3 class="my-3">안녕하세요, 충남오슈입니다. 즐거운 여행되세요.</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio</p>
                <br>2
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

                <img class="img-fluid" src="https://via.placeholder.com/450x250" alt="">
                <img class="img-fluid" src="https://via.placeholder.com/450x250" alt="">
                <img class="img-fluid" src="https://via.placeholder.com/450x250" alt="">

        </div>

    </div>




</body>
</html>