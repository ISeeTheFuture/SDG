<%@page import="space.model.vo.SpacesPrice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	SpacesPrice spacePrice = (SpacesPrice)request.getAttribute("spacePrice");
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
<title>사업장 요금 변경</title>
</head>
<body>

</body>

<script>
$(function(){
	
});
	function updatePrice(){
		$("#priceFrm").attr("action","<%=request.getContextPath()%>/space/updaePrice")
		.submit()
	}
	function updateValidate(){
		return true;
	}
	
</script>

	<h2>사업장 요금 수정</h2>
	<form id="priceFrm" method="post" onsubmit="return updateValidate();">
	
	
	<label for="spcPriNo">요금제_NO</label>
	<input type="text" name="spcPriceNo" id="spcPriceNo" value="<%=spacePrice.getSpcPriceNo()%>"/>
	<br />
	
	<label for="spcDetNo">세부공간_NO</label>
	<input type="text" name="spcDetNo" id="spcDetNo" value="<%=spacePrice.getSpcDetNo()%>"/>
	<%-- 	<input type="text" name="spcDetNo" id="spcDetNo" value="<%=사업자.getscpDetNo() %>"/>  --%>
	<br />
	
	<label for="spcDetName">요금명</label>
	<input type="text" name="spcDetName" id="spcDetName" value="<%=spacePrice.getSpcDetName()%>"/>
	<br />
	
	<label for="spcPriDay">요일</label>
	<input type="text" name="spcPriceDay" id="spcPriceDay" />
	<br />
	
	<label for="spcPriStart">적용시작시간</label>
	<input type="range" name="spcPriceStart" id="spcPriceStart" min="0" max="24" step="1" value="0" value="<%=spacePrice.getSpcPriceStart()%>"/>
	<br />	

	<label for="spcPriEnd">적용종료시간</label>
	<input type="range" name="spcPriceEnd" id="spcPriceEnd" min="0" max="24" step="1" value="0"  value="<%=spacePrice.getSpcPriceEnd()%>"/>
	<br />	
	
	<label for="spcPrPeak">성수기여부</label>
	<input type="text" name="spcPricePeak" id="spcPricePeak" value="<%=spacePrice.getSpcPricePeak()%>"/>
	<br />	
	
	<label for="spcPriperMan">1인당여부</label>
	<input type="text" name="spcPriperMan" id="spcPriperMan" value="<%=spacePrice.getSpcPricePer()%>"/>
	<br />	
	
	<label for="spcPriDayBool">요일별여부</label>
	<input type="text" name="spcPriceDayBool" id="spcPriceDayBool" value="<%=spacePrice.getSpcPriceDayBool()%>" />
	<br />	

	<label for="spcPricePrice">가격</label>
	<input type="text" name="spcPricePrice" id="spcPricePrice" value="<%=spacePrice.getSpcPricePrice()%>"/>
	<br />
	
	<input type="button" onclick="updatePrice();" value="정보수정"/>
	
	</form>
</html>