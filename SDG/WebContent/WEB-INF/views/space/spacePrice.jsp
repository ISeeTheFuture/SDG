<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사업장 요금</title>
</head>
<body>

	<form action="<%=request.getContextPath() %>/space/spacePrice" method="post">
	
	<label for="spcPriNo">요금제_NO</label>
	<input type="text" name="spcPriNo" id="spcPriNo" />
	<br />
	
	<label for="spcDetNo">세부공간_NO</label>
	<input type="text" name="spcDetNo" id="spcDetNo" />
	<br />
	
	<label for="spcPriName">요금명</label>
	<input type="text" name="spcPriName" id="spcPriName" value="요금제1"/>
	<br />
	
	<label for="spcPriDay">요일</label>
	<input type="text" name="spcPriDay" id="spcPriDay" />
	<br />
	
	<label for="spcPriStart">적용시작시간</label>
	<input type="text" name="spcPriStart" id="spcPriStart" />
	<br />
	
	<label for="spcPriEnd">적용종료시간</label>
	<input type="text" name="spcPriEnd" id="spcPriEnd" />
	<br />
	
	<label for="spcPrPeak">성수기여부</label>
	<input type="checkbox" name="spcPriPeak" id="spcPriPeak" />
	<br />
	
	
	
		
	</form>


	
</body>
</html>