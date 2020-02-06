<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약하기</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/custom.css">
</head>
<body>
	
	<form action="<%=request.getContextPath() %>/res/resForm"
		method="post">
		
		<label for="resGroupNo">그룹넘버</label>
		<input type="text" id="resGroupNo" name="resGroupNo" value="1"/>
		<br />
		<label for="memberId">아이디</label>
		<input type="text" id="memberId" name="memberId" value="testId" readonly/>
		<br />
		<label for="spcNo">공간넘버</label>
		<input type="text" id="spcNo" name="spcNo" value="1011" readonly/>
		<br />
		<label for="resMany">인원</label>
		<input type="text" id="resMany" name="resMany" value="10"/>
		<br />
		<label for="resName">신청자명</label>
		<input type="text" id="res_name" name="res_name" value="아무개"/>
		<br />
		<label for="resPhone">연락처</label>
		<input type="text" id="res_phone" name="res_phone" value="010-1234-1234"/>
		<br />
		<label for="resEmail">이메일</label>
		<input type="text" id="res_email" name="res_email" value="1234@mail.com"/>
		<br />
		<label for="resStartTime">시작시간</label>
		<input type="datetime-local" id="resStartTime" name="resStartTime"/>
		<br />
		<label for="resEndTime">종료시간</label>
		<input type="datetime-local" id="resEndTime" name="resEndTime"/>
		<br />
		
		<input type="submit" value="제출하기"/>
	</form>

</body>
</html>