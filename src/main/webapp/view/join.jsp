<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join the membership Page</title>

<!-- 코드변경하기 -->

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
</head>

<body>
    <form action = "${ pageContext.servletContext.contextPath }/join" method="post">
        <div class="header">
            <h3>회원가입</h3>
        </div>
        <div class="box-input">
            <label for="id"> 아이디 : </label>
            <input type="text" id="id" name="id">
            <div class="box-line-height"></div>

            <label for="pw"> 비밀번호 : </label>
            <input type="password" id="pw" name="pw">
            <div class="box-line-height"></div>

            <label for="pw-double"> 비밀번호 확인 : </label>
            <input type="password" id="pw-double" onkeyup="double(this.value);">
            <span id="box-span" class="box-span-on">일치함</span>
            <div class="box-line-height"></div>

            <label for="name"> 이름 : </label>
            <input type="text" id="name" name="name">
            <div class="box-line-height"></div>

            <label for="jumin"> 주민번호 : </label>
            <input type="text" id="jumin" name="jumin">
            <div class="box-line-height"></div>
        </div>

        <div class="box-line-height"></div>
        <div class="box-submit">
            <input type="submit" value="전송" onclick="return verifyField();">
            <a href = "javascript:history.back();">돌아가기</a>
        </div>

    </form>
 
</body>
</html>