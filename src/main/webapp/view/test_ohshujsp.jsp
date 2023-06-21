<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tour</title>
<style>
#table_box {
   border: solid;
}

th, td {
   border: solid;
}
</style>
<script src="https://code.jquery.com/jquery-3.7.0.js"
   integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
   crossorigin="anonymous"></script>
<script>
   window.onload = function() {
      getPublicData();
   }
   function getPublicData() {

      const param = {
         func : "tour",
         start : 1,
         end : 460

      };

      $
            .ajax({
               url : "https://tour.chungnam.go.kr/_prog/openapi",
               async : true // 비동기 쓰레드,false : 동기식(응답 받을때까지 대기함)
               ,
               contentType : 'application/x-www-form-urlencoded; charset=UTF-8' // 전송타입
               ,
               type : "GET" //method
               ,
               data : param,
               dataType : "xml" // 수신타입
               ,
               success : function(data, textStatus) {
                  console.log("succese");
                  console.log(data);

                  // jsp 안에서 java for문 돌려서 모두 출력
<%for (int i = 0; i < 460; i++) {%>
   var tr_el = document.createElement("tr");
                  var td_el1 = document.createElement("td");
                  var td_el2 = document.createElement("td");
                  var td_el3 = document.createElement("td");
                  var td_el4 = document.createElement("td")

                  var local_nm = data.getElementsByTagName("local_nm")[
<%=i%>
   ].textContent;
                  var nm = data.getElementsByTagName("nm")[
<%=i%>
   ].textContent;
                  var addr = data.getElementsByTagName("addr")[
                     <%=i%>
                        ].textContent;
                  var tel = data.getElementsByTagName("tel")[
                     <%=i%>
                        ].textContent;

                  td_el1.textContent = local_nm;
                  td_el2.textContent = nm;
                  td_el3.textContent = addr;
                  td_el4.textContent = tel;

                  tr_el.appendChild(td_el1);
                  tr_el.appendChild(td_el2);
                  tr_el.appendChild(td_el3);
                  tr_el.appendChild(td_el4);

                  document.getElementById("table_box").appendChild(tr_el);
<%}%>
   },
               error : function(jqXHR, textStatus, errorThrown) {
                  console.log(jqXHR);
                  console.log(textStatus);
                  console.log(errorThrown);
               }
            });

   }
</script>
</head>
<body>
   <div id="test">
      <table id="table_box">
         <tr>
            <th>지역</th>
            <th>이름</th>
            <th>주소</th>
            <th>전화번호</th>
         </tr>

      </table>
   </div>
</body>
</html>