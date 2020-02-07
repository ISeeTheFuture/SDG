<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
<title>사업장 운영 스케쥴</title>
</head>
<body>

<form action="<%=request.getContextPath() %>/space/spaceTimeTableEnd" method="post">

	<label for="spcPriNo">세부공간_NO</label>
	<input type="text" name="spcDetNo" id="spcDetNo" />
	<br />
	
	<label for="spcDetNo">요일</label>
	<input type="text" name="spcDay" id="spcDay" />
	<br />
	
	<label for="spcPriName">시작시간</label>
	<input type="text" name="spcHourStart" id="spcHourStart"/>
	<br />
	
	<label for="spcPriDay">종료시간</label>
	<input type="text" name="spcHourEnd" id="spcHourEnd" />
	<br />
	
	<label for="spcPriStart">가용여부</label>
	<input type="text" name="spcAvail" id="spcAvail" />
	<br />
	
	<button>전송</button>
</form>
</body>
</html>