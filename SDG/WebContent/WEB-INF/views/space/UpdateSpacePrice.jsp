<%@page import="space.model.vo.SpacesPrice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	SpacesPrice spaceprice = (SpacesPrice)request.getAttribute("spaceprice");
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
	function updatePrice(){
		$("#priceFrm").attr("action","<%=request.getContextPath()%>/space/updaePr;ice").submit()
	}
	function updateValidate(){
		return true;
	}
	
</script>

	<h2>사업장 요금 수정</h2>
	<form id="priceFrm" method="post" onsubmit="return updateValidate();">
	
	
	<label for="spcPriNo">요금제_NO</label>
	<input type="text" name="spcPriceNo" id="spcPriceNo" value="<%=spaceprice.getSpcPriceNo()%>"/>
	<br />
	
	<label for="spcDetNo">세부공간_NO</label>
	<input type="text" name="spcDetNo" id="spcDetNo" value="<%=spaceprice.getSpcDetNo()%>"/>
	<%-- 	<input type="text" name="spcDetNo" id="spcDetNo" value="<%=사업자.getscpDetNo() %>"/>  --%>
	<br />
	
	
	
	
	
	</form>
</html>