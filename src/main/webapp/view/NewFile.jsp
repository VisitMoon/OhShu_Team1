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
         <c:forEach var="StayVO" items="${ requestScope.StayList  }" varStatus="status">
											<tr>
												<td>${StayVO.stay_no}</td><!-- pageScope에 vo가 생성되었다.  -->
												
												<td>${StaydVO.stay_location}</td>
												<td>${StaydVO.stay_name}</td>
											</tr>
											</c:forEach>
         

      </table>
   </div>
</body>
</html>