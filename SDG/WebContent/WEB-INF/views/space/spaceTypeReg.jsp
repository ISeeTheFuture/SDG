<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/space/spaceRegForm" method="GET">
		<label for="spaceType">사업자 유형</label>
		<br />
		<select name="cat" id="cat">
			<option disabled selected value>모임 장소</option>
			<option disabled>-------</option>
			<option value="1">회의실</option>
			<option value="2">다목적홀</option>
			<option value="3">레저시절</option>
			<option value="4">파티룸</option>
			<option value="5">공연장</option>
			<option value="6">카페</option>
			<option value="7">스터디룸</option>
			<option disabled>공유 오피스</option>
			<option disabled>-------</option>
			<option value="8">독립 오피스</option>
			<option value="9">코워킹 오피스</option>
			<option value="10">일하기 좋은 카페</option>
		</select>
		<button>다음</button>
	</form>
</body>
</html>