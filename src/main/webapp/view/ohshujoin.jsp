<%@page import="org.apache.catalina.connector.Request"%>
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
<title>OhshuJoin</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css"></link>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css"
	rel="stylesheet" type="text/css"></link>
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
<script>

        function verifyField() {
            let element = document.getElementById("user_id");
            let msg = 'id 입력';
            if (!isValid(element, msg)) {
                return false;
            }
            
            element = document.getElementById("user_pwd");
            msg = 'pw 입력';
            if (!isValid(element, msg)) {
                return false;
            }
			
            element = document.getElementById("pwd-double-check");
            msg = "비밀번호 확인을 입력하세요.";
            if(!isValid (element,msg)){
                return false;
            }

            element = document.getElementById("user_name");
            msg = 'name 입력';
            if (!isValid(element, msg)) {
                return false;
            }
            
            element = document.getElementById("user_age");
            msg = 'age 입력';
            if (!isValid(element, msg)) {
                return false;
            }


            element = document.getElementById("user_jumin");
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
            let origin = document.getElementById("user_pwd").value;
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

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
    $(function() {
        $('#check-btn').click(function() {
            var userId = $('#user_id').val();
           
            $.ajax({
                url: '/IdCheck',
                type: 'JSON',
                data: {
                	user_id: userId 
                },
                success: function(response) {
                    var result = response['result'];
                    var message = response['message'];
                    if (result === 'exist') {
                        alert(message);
                    } else if (result === 'not exist') {
                        alert(message);
                    } else {
                        alert('에러 발생: ' + message);
                    }
                },
                error: function(xhr, status, error) {
                    alert('서버 오류: ' + error);
                }
            });
        });
    });
</script>


</head>

<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<!-- Navbar Brand-->
		<a class="navbar-brand ps-3" href="/main.jsp">충남오세유~</a>
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
					<li><a class="dropdown-item" href="http://localhost:8080/OhShu_Team1/SignIn">로그인</a></li>
					<li><a class="dropdown-item" href="http://localhost:8080/OhShu_Team1/join">회원가입</a></li>
					<li><a class="dropdown-item" href="#!">마이페이지</a></li>
					<li>
						<hr class="dropdown-divider" />
					</li>
					<li><a class="dropdown-item" href="#!">로그아웃</a></li>
				</ul></li>
		</ul>
	</nav>
	<div id="layoutSidenav_content">
		<main>
			<div class="container-fluid px-4">


				<div class="card mb-4"></div>
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-table me-1"></i> 회원가입
					</div>
					<div class="card-body"></div>


					<form action="${ pageContext.servletContext.contextPath }/join"
						method="post">
						<div class="header"></div>
						<div class="box-input">


							<label for="user_id">아이디: </label> <input type="text"
								id="user_id" name="user_id" placeholder="아이디를 입력하세요">
							<button id="check-btn" type="button">중복확인</button>
							<div class="box-line-height"></div>
							
							<label for="pw"> 비밀번호 : </label> <input type="password"
								id="user_pwd" name="user_pwd" placeholder="비밀번호를 입력하세요">
							<div class="box-line-height"></div>

							<label for="pw-double"> 비밀번호 확인 : </label> <input type="password"
								id="pw-double" onkeyup="double(this.value);"
								placeholder="비밀번호 확인을 입력하세요"> <span id="box-span"
								class="box-span-on"></span>
							<div class="box-line-height"></div>

							<label for="name"> 이름 : </label> <input type="text"
								id="user_name" name="user_name" placeholder="이름을 입력하세요">
							<div class="box-line-height"></div>

							<label for="name"> 나이 : </label> <input type="text" id="user_age"
								name="user_age" placeholder=" 나이를 입력하세요">
							<div class="box-line-height"></div>

							<label for="jumin"> 주민번호 : </label> <input type="text"
								id="user_jumin" name="user_jumin" placeholder="주민번호를 입력하세요">
							<div class="box-line-height"></div>
						</div>

						<div class="box-line-height"></div>
						<div class="box-submit">
							<input type="submit" value="전송" onclick="return verifyField();">
							<a href="javascript:history.back();">돌아가기</a>
						</div>

					</form>
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