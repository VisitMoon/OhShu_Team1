package com.java.ohshu.servlet.dao;

public class OhShuDAO {
	
	/*
	
0. 메인 페이지

헤드 아래부분
-이번주 추천 명소

 !!! 고민이 필요 !!!


-여행명소 순위
 여행지 중에서 조아요가idx가 가장 높은 순으로 1,2 순위 select
>>1위
	SELECT * FROM (
    SELECT t.*, RANK() OVER (ORDER BY cnt DESC) AS rank
    FROM (
        SELECT *, COUNT(*) OVER (PARTITION BY joayo) AS cnt
        FROM tour_joayo
    ) t
) ranked
WHERE ranked.rank = 1
ORDER BY ranked.rank;

>>2위
SELECT * FROM (
    SELECT t.*, RANK() OVER (ORDER BY cnt DESC) AS rank
    FROM (
        SELECT *, COUNT(*) OVER (PARTITION BY joayo) AS cnt
        FROM tour_joayo
    ) t
) ranked
WHERE ranked.rank = 2
ORDER BY ranked.rank;

>>3위
SELECT * FROM (
    SELECT t.*, RANK() OVER (ORDER BY cnt DESC) AS rank
    FROM (
        SELECT *, COUNT(*) OVER (PARTITION BY joayo) AS cnt
        FROM tour_joayo
    ) t
) ranked
WHERE ranked.rank = 3
ORDER BY ranked.rank;
 


-음식점 순위
  음식점 중에서 조아요가idx가 가장 높은 순으로 1,2 순위 select
>>1위
	SELECT * FROM (
    SELECT t.*, RANK() OVER (ORDER BY cnt DESC) AS rank
    FROM (
        SELECT *, COUNT(*) OVER (PARTITION BY joayo) AS cnt
        FROM food_joayo
    ) t
) ranked
WHERE ranked.rank = 1
ORDER BY ranked.rank;

>>2위
SELECT * FROM (
    SELECT t.*, RANK() OVER (ORDER BY cnt DESC) AS rank
    FROM (
        SELECT *, COUNT(*) OVER (PARTITION BY joayo) AS cnt
        FROM food_joayo
    ) t
) ranked
WHERE ranked.rank = 2
ORDER BY ranked.rank;

>>3위
SELECT * FROM (
    SELECT t.*, RANK() OVER (ORDER BY cnt DESC) AS rank
    FROM (
        SELECT *, COUNT(*) OVER (PARTITION BY joayo) AS cnt
        FROM food_joayo
    ) t
) ranked
WHERE ranked.rank = 3
ORDER BY ranked.rank;
 



-숙박시설 순위
 숙박업소 중에서 조아요가 idx가 가장 높은 순으로 1,2 순위 select
>>1위
	SELECT * FROM (
    SELECT t.*, RANK() OVER (ORDER BY cnt DESC) AS rank
    FROM (
        SELECT *, COUNT(*) OVER (PARTITION BY joayo) AS cnt
        FROM stay_joayo
    ) t
) ranked
WHERE ranked.rank = 1
ORDER BY ranked.rank;

>>2위
SELECT * FROM (
    SELECT t.*, RANK() OVER (ORDER BY cnt DESC) AS rank
    FROM (
        SELECT *, COUNT(*) OVER (PARTITION BY joayo) AS cnt
        FROM stay_joayo
    ) t
) ranked
WHERE ranked.rank = 2
ORDER BY ranked.rank;

>>3위
SELECT * FROM (
    SELECT t.*, RANK() OVER (ORDER BY cnt DESC) AS rank
    FROM (
        SELECT *, COUNT(*) OVER (PARTITION BY joayo) AS cnt
        FROM stay_joayo
    ) t
) ranked
WHERE ranked.rank = 3
ORDER BY ranked.rank;
 


1. 로그인 페이지
입력받은 id, pwd 정보가 user테이블에 존재하는지 확인 (있으면 pass 없으면 재입력 alert)
select id,pwd from user where id = 아이디 AND pwd = 패스워드


2. 회원가입 페이지
정보를 입력받아 user테이블에 row 추가
insert into user values ( 아이디, 비밀번호, 이름, 주민번호 )


3. 아이디 찾기 페이지
이름과 주민번호를 입력받아 아이디를 출력
select id from user where name = 이름 AND jumin= 주민번호


4. 비밀번호 찾기 페이지
아이디, 이름, 주민번호를 입력받고 비밀번호를 출력
select pwd from user where id=아이디 AND name=이름 AND jumin = 주민번호


5. 마이 페이지
-정보 수정 : 로그인 한 회원이 자신의 등록 정보를 수정할 수 있음
마이페이지를 진입 시 입력칸에 기존의 정보가 출력 : select pwd from user where id = 아이디
수정 완료버튼 onclick : update user set pwd=패스워드

-좋아요 목록 : 자신이 좋아요를 누른 항목들을 모아볼 수 있음
select tour/stay/food_name from tour/stay/food_joayo where id=아이디


-회원 탈퇴 : 패스워드를 입력받고 일치할경우 회원을 탈퇴할 수 있음
delete user where id=아이디 AND pwd=패스워드
실행 후 메인페이지로 이동


6. 숙박 카테고리 페이지

-전체
-모텔
-호텔
-팬션
-콘도

- 회원이 숙박 업소에 조아요를 누르면 insert 문으로 joayo 테이블의 id, joayo=true,JOAYO_NAME=STAY_NAME 입력
- 회원이 숙박업소의 조아요를 한번 더 누르면 joayo=false가 되면 delete문으로
 joayo테이블의 d, joayo=true,JOAYO_NAME=STAY_NAME 삭제 
-selete WHERE STAY_LOCATION="" 문으로 STAY의 지역별 검색
-상세 페이지에서 INSERT문으로 REVIEW 테이블에 REVIEW_CONTENT 작성
-상세 페이지에서 DELETE문으로 REVIEW테이블의 ID가 동일한 사람은 자신이 작성한 REVIEW 삭제

MERGE INTO STAY_joayo tj
USING (
  SELECT 아이디 AS id, 숙소명 AS STAY_NAME, 1 AS joayo FROM dual
) new_data
ON (t.joayo = 1)
WHEN MATCHED THEN
  DELETE
WHEN NOT MATCHED THEN
  INSERT (id, STAY_NAME, joayo)
  VALUES (new_data.id, new_data.STAY_NAME, new_data.joayo);

7. 여행 카테고리 페이지

-전체
-명산
-해변/섬
-항/포구
-강/계곡/호수
-캠핑/트래킹/체험
-풍경
-역사유적지
-종교/성찰/성지
-고택/민속마을
-전시/관람
-휴양/온천
-특화관광지

- 회원이 여행지에 조아요를 누루면 insert 문으로 joayo테이블의 id, joayo=true,JOAYO_NAME=TOUR_NAME 입력
- 회원이 여행지의 조아요를 한번 더 누르면 joayo=false가 되면 delete문으로
 joayo테이블의 d, joayo=true,JOAYO_NAME=TOUR_NAME 삭제 
-select WHERE TOUR_LOCATION="" 문으로 TOUR의 지역별 검색
-상세 페이지에서 INSERT문으로 REVIEW 테이블에 REVIEW_CONTENT 작성
-상세 페이지에서 DELETE문으로 REVIEW테이블의 ID가 동일한 사람은 자신이 작성한 REVIEW 삭제

MERGE INTO tour_joayo tj
USING (
  SELECT 아이디 AS id, 여행지명 AS TOUR_NAME, 1 AS joayo FROM dual
) new_data
ON (t.joayo = 1)
WHEN MATCHED THEN
  DELETE
WHEN NOT MATCHED THEN
  INSERT (id, TOUR_NAME, joayo)
  VALUES (new_data.id, new_data.TOUR_NAME, new_data.joayo);

8. 음식점 카테고리 페이지

-전체
-한식
-중식
-양식
-일식
-분식

- 회원이 음식점에 조아요를 누루면 insert 문으로 joayo테이블의 id, joayo=true,JOAYO_NAME=FOOD_NAME 입력
- 회원이 음식점에 조아요를 한번 더 누르면 joayo=false가 되면 delete문으로
 joayo테이블의 d, joayo=true,JOAYO_NAME=FOOD_NAME 삭제 
-selete WHERE FOOD_LOCATION="" 문으로 FOOD의 지역별 검색
-상세 페이지에서 INSERT문으로 REVIEW 테이블에 REVIEW_CONTENT 작성
-상세 페이지에서 DELETE문으로 REVIEW테이블의 ID가 동일한 사람은 자신이 작성한 REVIEW 삭제

MERGE INTO food_joayo tj
USING (
  SELECT 아이디 AS id, 여행지명 AS FOOD_NAME, 1 AS joayo FROM dual
) new_data
ON (t.joayo = 1)
WHEN MATCHED THEN
  DELETE
WHEN NOT MATCHED THEN
  INSERT (id, FOOD_NAME, joayo)
  VALUES (new_data.id, new_data.FOOD_NAME, new_data.joayo);
	 * */
	
	
	

}
