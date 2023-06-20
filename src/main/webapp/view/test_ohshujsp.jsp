<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tour</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"
        integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script>
window.onload = function(){
   getPublicData();
}
function getPublicData() {
            // const url = {
            //     href: "https://api.odcloud.kr/api/15083016/v1/uddi:c22897a2-7de7-4dcd-8955-d7ba5e13b4cd_201911190936?page=1&perPage=10"
            // };

            // const decoded = "XKL1GkKtwYuho4vgELMsHwLJu1cEuZFc2YKWsqSlNEIumOcQnDtstUKKhsDGNQ9o4v3bg4HIy9TBQs47uLnJDw==";
            // const encoded = encodeURI("XKL1GkKtwYuho4vgELMsHwLJu1cEuZFc2YKWsqSlNEIumOcQnDtstUKKhsDGNQ9o4v3bg4HIy9TBQs47uLnJDw==");

            // System.out.println(decoded);
            // System.out.println(encoded);

            // const param = {
            //     start: start
            //     , end: end
            
            // 인증키는 없을시 
            const param = {
                func : "tour"
                ,start : 1
                ,end : 460
                
              
            };

            $.ajax(
                {
                    url: "https://tour.chungnam.go.kr/_prog/openapi"
                    , async: true // 비동기 쓰레드,false : 동기식(응답 받을때까지 대기함)
                    , contentType: 'application/x-www-form-urlencoded; charset=UTF-8' // 전송타입
                    , type: "GET" //method
                    , data: param
                    , dataType: "xml" // 수신타입
                    , success: function (data, textStatus) {
                        console.log("succese");
                        console.log(data);
                        
                                             
                       
                        console.log(data.getElementsByTagName("mng_no")[0].textContent);
                        console.log(data.getElementsByTagName("mng_no")[1].textContent);

                        console.log(data.getElementsByTagName("local_nm")[0].textContent);
                        
                        console.log(data.getElementsByTagName("list_img")[0].textContent);  //api 그 요소 불러오기
                        let data_img = data.getElementsByTagName("list_img")[0].textContent;
                        console.log(data_img);
                        
                        document.getElementById("test").innerText = data_img;   
                        var img_el = document.createElement("img");    // <img> 태그 만들기
                        
                        //document.createElement("img").src = data_img;
                        
                        img_el.src = data_img;   // img태그에 src 넣기
                        document.body.appendChild(img_el);   // 바디에 바로 나오게끔
                        
                        var img_el2 = document.createElement("img");  // 같은링크 다시할려면 다시 img태그 생성후 하면됌
                        img_el2.src = data_img;
                        document.getElementById("test").appendChild(img_el2);  //test id의 안에 img태그 생성후 어펜드 
                         
                        
                        
                     
                       
                    
                    
                        // let array = data.data;
                        // display(array);
                    }
                    , error: function (jqXHR, textStatus, errorThrown) {
                        console.log(jqXHR);
                        console.log(textStatus);
                        console.log(errorThrown);
                    }
                }
            );

        }
</script>
</head>
<body>
   <div id="test">
    
   </div>
</body>
</html>