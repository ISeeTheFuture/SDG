<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>예약하기</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/custom.css">
</head>
<body>
	
	<form action="<%=request.getContextPath()%>/res/resForm" method="post">		
		<label for="resGroupNo">그룹넘버</label>
		<input type="text" id="resGroupNo" name="resGroupNo" value="1"/>
		<br />
		<label for="memberId">아이디</label>
		<input type="text" id="memberId" name="memberId" value="testid" readonly/>
		<br />
		<label for="spcNo">공간넘버</label>
		<input type="text" id="spcNo" name="spcNo" value="1011" readonly/>
		<br />
		<label for="resMany">인원</label>
		<input type="text" id="resMany" name="resMany" value="10"/>
		<br />
		<label for="resName">신청자명</label>
		<input type="text" id="resName" name="resName" value="아무개"/>
		<br />
		<label for="resPhone">연락처</label>
		<input type="text" id="resPhone" name="resPhone" value="010-1234-1234"/>
		<br />
		<label for="resEmail">이메일</label>
		<input type="text" id="resEmail" name="resEmail" value="1234@mail.com"/>
		<br />
		<label for="resStartDate">시작날짜</label>
		<input type="date" id="resStartDate" name="resStartDate"/>
		<label for="resStartTime">시작시간</label>
		<select name="resStartTime" id="resStartTime">
			<option value="00">00시</option>
			<option value="01">01시</option>
			<option value="02">02시</option>
			<option value="03">03시</option>
			<option value="04">04시</option>
			<option value="05">05시</option>
			<option value="06">06시</option>
			<option value="07">07시</option>
			<option value="08">08시</option>
			<option value="09">09시</option>
			<option value="10">10시</option>
			<option value="11">11시</option>
			<option value="12">12시</option>
			<option value="13">13시</option>
			<option value="14">14시</option>
			<option value="15">15시</option>
			<option value="16">16시</option>
			<option value="17">17시</option>
			<option value="18">18시</option>
			<option value="19">19시</option>
			<option value="20">20시</option>
			<option value="21">21시</option>
			<option value="22">22시</option>
			<option value="23">23시</option>
		</select>
		<br />
		<label for="resEndDate">종료시간</label>
		<input type="date" id="resEndDate" name="resEndDate"/>
		<label for="resEndTime">종료시간</label>
		<select name="resEndTime" id="resEndTime">
			<option value="00">00시</option>
			<option value="01">01시</option>
			<option value="02">02시</option>
			<option value="03">03시</option>
			<option value="04">04시</option>
			<option value="05">05시</option>
			<option value="06">06시</option>
			<option value="07">07시</option>
			<option value="08">08시</option>
			<option value="09">09시</option>
			<option value="10">10시</option>
			<option value="11">11시</option>
			<option value="12">12시</option>
			<option value="13">13시</option>
			<option value="14">14시</option>
			<option value="15">15시</option>
			<option value="16">16시</option>
			<option value="17">17시</option>
			<option value="18">18시</option>
			<option value="19">19시</option>
			<option value="20">20시</option>
			<option value="21">21시</option>
			<option value="22">22시</option>
			<option value="23">23시</option>
		</select>
		<br />
		<label for="resContent">요청사항</label>
		<textarea name="resContent" id="resContent" cols="30" rows="10"></textarea>
		<br />

		<input type="submit" value="제출하기"/>
	</form>

</body>
</html>