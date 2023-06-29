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
<title>OhshuLoin</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
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
	text-align: center
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
		var msg = '<%= request.getParameter("msg")%>';
		
		window.onload = function(){
			showMsg();
		}
		
		function showMsg(){
			if(msg != null && msg !='null' && msg !=''){
			alert(msg);
			}
		}
		
		 function verifyField(){
	            
	            let element = document.getElementById("id");
	            let msg = 'id를 입력하세요';
	            if(!isValid (element,msg)){
	                return false;
	            }
	                
	            element = document.getElementById("pwd");
	            msg = "비밀번호 를 입력하세요.";
	            if(!isValid (element,msg)){
	                return false;
	            }
	            return true;

	  }
		 function isValid(element, msg, pwdc){
	            let result = false
	            if(element.value == ''){
	                alert(msg);
	                element.focus
	                result = false
	            }

	            else{
	                result = true;
	            }
	            return result;
	            
	        }
       
       
       
     
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
						<i class="fas fa-table me-1"></i> 로그인
					</div>
					<div class="card-body"></div>


					<form action="${ pageContext.servletContext.contextPath }/SignIn"
						method="post">
						<div class="header">
							<h3>로그인</h3>
						</div>
						<div class="box-input">
							<label for="name">아이디 : </label> <input type="text"
								name="user_id" id="user_id">
							<div class="box-line-height"></div>

							<label for="name">비밀번호 : </label> <input type="password"
								name="user_pwd" id="user_pwd">
							<div class="box-line-height"></div>


						</div>
						<div class="box-line-height"></div>
						<div class="box-sumbit" style="text-align: center;">
							<input type="submit" value="로그인" onclick="return verifyField();">
							<a href="<%=request.getContextPath()%>/join">회원가입</a>

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