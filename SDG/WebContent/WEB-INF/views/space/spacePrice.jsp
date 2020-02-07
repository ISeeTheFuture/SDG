<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
<title>사업장 요금</title>
</head>
<body>

	<form action="<%=request.getContextPath() %>/space/spacePriceEnd" method="post">
	
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
	
	<label for="spcPriperMan">1인당여부</label>
	<input type="checkbox" name="spcPriperMan" id="spcPriPerMan" />
	<br />
	
	<label for="spcPriDayBool">요일별여부</label>
	<input type="checkbox" name="spcPriDayBool" id="spcPriDayBool" />
	<br />
	
	<label for="spcPriPrice">가격</label>
	<input type="checkbox" name="spcPriPrice" id="spcPriPrice" />
	<br />
	
	<button>제출</button>

		
	</form>


	
</body>
</html>