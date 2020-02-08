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
	<input type="text" name="spcPriceNo" id="spcPriceNo" />
	<br />
	
	<label for="spcDetNo">세부공간_NO</label>
	<input type="text" name="spcDetNo" id="spcDetNo" />
	<%-- 	<input type="text" name="spcDetNo" id="spcDetNo" value="<%=사업자.getscpDetNo() %>"/>  --%>
	<br />
	
	<label for="spcDetName">요금명</label>
	<input type="text" name="spcDetName" id="spcDetName" placeholder="오전요금제"/>
	<br />
	
	<label for="spcPriDay">요일</label>
	<input type="text" name="spcPriceDay" id="spcPriceDay" />
	<br />
	
	<label for="spcPriStart">적용시작시간</label>
	<input type="range" name="spcPriceStart" id="spcPriceStart" min="0" max="24" step="1" value="0"/>
	<br />
	
	<label for="spcPriEnd">적용종료시간</label>
	<input type="range" name="spcPriceEnd" id="spcPriceEnd" min="0" max="24" step="1" value="0" />
	<br />
	
	<label for="spcPrPeak">성수기여부</label>
	<input type="text" name="spcPricePeak" id="spcPricePeak" placeholder="해당사항 없으면 공백"/>
	<br />
	
	<label for="spcPriperMan">1인당여부</label>
	<input type="text" name="spcPriperMan" id="spcPriperMan" placeholder="해당사항 없으면 공백"/>
	<br />
	
	<label for="spcPriDayBool">요일별여부</label>
	<input type="text" name="spcPriceDayBool" id="spcPriceDayBool" placeholder="해당사항 없으면 공백" />
	<br />
	
	<label for="spcPricePrice">가격</label>
	<input type="text" name="spcPricePrice" id="spcPricePrice" />
	<br />
	
	<button>제출</button>


		
	</form>


	
</body>
</html>