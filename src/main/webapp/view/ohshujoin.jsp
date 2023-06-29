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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
        $(document).ready(function () {
            $("#check_id").click(function () {
                const userId = $("#user_id").val();

                if (userId === '') {
                    $("#result").text("아이디를 입력해주세요.");
                    return;
                }

                $.ajax({
                    url: "/OhShu_Team1/IdCheck", // 서블릿 주소, 여기서는 IdCheckServlet을 맵핑했습니다.
                    type: "POST",
                    data: { user_id: userId },
                    dataType: "json",
                    success: function (response) {
                        if (response.is_duplicate) {
                            $("#result").text("이미 사용 중인 아이디입니다. 다른 아이디를 입력해주세요.");
                        } else {
                            $("#result").text("사용 가능한 아이디입니다.");
                        }
                    },
                    error: function () {
                        $("#result").text("오류 발생: 아이디 중복 확인에 실패했습니다.");
                    }
                });
            });
        });
    </script>


</head>

<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<!-- Navbar Brand-->
		<a class="navbar-brand ps-3" href="view/main.jsp">충남오슈~</a>
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
	<div id="layoutSidenav_content">
		<main>
			<div class="container-fluid px-4">


				<div class="card mb-4"></div>
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-table me-1"></i> 회원가입
					</div>
					<div class="card-body"></div>

					<script>
					$(document).ready(function () {
						  $('form').submit(function (event) {
						    if ($('#result').text() === '') {
						      alert('아이디 중복확인을 해주세요.');
						      event.preventDefault();
						    }
						  });
						});
					</script>
					<form action="${ pageContext.servletContext.contextPath }/join"
						method="post">
						<div class="header"></div>
						<div class="box-input">


							<label for="user_id">아이디: </label> <input type="text"
								id="user_id" name="user_id" placeholder="아이디를 입력하세요">
							<button type="button" id="check_id">중복 확인</button>
							<p id="result"></p>
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
		<div class="container-fluid px-4"></div>
	</footer>
	</div>
	</div>

</body>

</html>