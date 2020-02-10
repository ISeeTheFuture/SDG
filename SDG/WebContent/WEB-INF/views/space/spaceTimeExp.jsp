<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
<title>사업장_예외스케쥴</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/space/spaceTimeExpEnd" method="post">
		
	<label for="spcPriNo">세부공간_NO</label>
	<input type="text" name="spcDetNo" id="spcDetNo" />
<%-- 	<input type="text" name="spcDetNo" id="spcDetNo" value="<%=사업자.getscpDetNo() %>"/>  --%>
	<br />
	
	<label for="spcExcDate">예외날짜</label>
	<input type="date" name="spcExcDate" id="spcExcDate" />
	<br />
	
	<label for="spcExcStart">예외시작시간</label>
	<input type="range" name="spcExcStart" id="spcExcStart" min="0" max="24" step="1" value="0"  />
	<br />
	
	<label for="spcExcEnd">예외종료시간</label>
	<input type="range" name="spcExcEnd" id="spcExcEnd" min="0" max="24" step="1" value="0"  />
	<br />
	
	<label for="spcAvail">가용여부</label>
	<input type="text" name="spcAvail" id="spcAvail" placeholder="해당사항 없으면 공백"/>
	<br />
	
	<button>전송</button>
	
	
	</form>
</body>


</html>
