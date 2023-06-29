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
<title>My Page Change Page</title>
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


<script>

        function verifyField() {
            let element = document.getElementById("id");
            let msg = 'id 입력';
            if (!isValid(element, msg)) {
                return false;
            }
            
            element = document.getElementById("pw");
            msg = 'pw 입력';
            if (!isValid(element, msg)) {
                return false;
            }

            element = document.getElementById("pw-double");
            msg = 'pw 확인';
            if (!isValid(element, msg)) {
                return false;
            }

            element = document.getElementById("name");
            msg = 'name 입력';
            if (!isValid(element, msg)) {
                return false;
            }

            element = document.getElementById("jumin");
            msg = 'jumin 입력';
            if (!isValid(element, msg)) {
                return false;
            }

            let originObj = document.getElementById("pw");
            let checkObj = document.getElementById("pw-double");
            if(originObj.value != checkObj.value){
                alert("pw확인하기");
                checkObj.focus();
                return false;
            }
            return true;
        }

        function isValid(element, msg) {
            let result = false;
            if (element.value == '') {
                alert(msg);
                element.focus();
                result = false;
            } else {
                result = true;
            }
            return result;
        }

        function double(value) {
            let origin = document.getElementById("pw").value;
            let boxSpan = document.getElementById("box-span");

            if (origin == value) {
                boxSpan.className = "box-span-on";
                boxSpan.textContent = "일치";
            } else {
                boxSpan.className = "box-span-off";
                boxSpan.textContent = "불일치";
            }

        }

    </script>
<style>
.box-submit {
   text-align: center;
}

.box-input {
   text-align: center;
}

.box-line-height {
   margin-bottom: 10px;
}

.header>h3 {
   text-align: center;
}

.box-span-on {
   color: green;
}

.box-span-off {
   color: red;
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
               <<li><a class="dropdown-item"
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
                           class="nav-link" href="myPage_회원탈퇴.jsp">회원탈퇴</a>
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
                  <div class="card-header">전체 > 비밀번호 변경</div>
                  <div class="card-body">

                     <form action="${ pageContext.servletContext.contextPath }/join"
                        method="post">
                        <div class="header">
                           <h3>비밀번호 변경</h3>
                        </div>
                        <div class="box-input">
                           <label for="qq"> 현재 비번: </label> <input type="password" id="qq"
                              name="qq">
                           <div class="box-line-height"></div>

                           <label for="pw"> 변경 비밀번호 : </label> <input type="password"
                              id="pw" name="pw">
                           <div class="box-line-height"></div>

                           <label for="pw-double"> 변경 비밀번호 확인 : </label> <input
                              type="password" id="pw" onkeyup="double(this.value);">
                           <span id="box-span" class="box-span-on">일치함</span>
                           <div class="box-line-height"></div>


                        </div>

                        <div class="box-line-height"></div>
                        <div class="box-submit">
                           <input type="submit" value="전송" onclick="return verifyField();">

                        </div>

                     </form>

                  </div>
                  <div class="box-line-height"></div>
                  <div class="box-submit"></div>
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