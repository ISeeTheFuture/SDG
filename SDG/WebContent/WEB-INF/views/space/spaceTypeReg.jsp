<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
div{
	position : relateive;
	border :1px solid black;
}
</style>
<!-- <script>
$(function (){ $("#button").click(function (){ $("#divToggle").toggle(); }); });

</script> -->
<body>

	<fieldset>
		<legend>공간유형</legend>
		<div class="outer">
		<div onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=1'">회의실</div>
		<div onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=2'">다목적홀</div>
		<div onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=3'">레저시설</div>
		<div onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=4'">파티룸</div>
		<div onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=5'">공연장</div>
		<div onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=6'">카페</div>
		<div onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=7'">스터디룸</div>
		</div>
	</fieldset>
	
		<fieldset>
		<legend>공유 오피스</legend>
		<div class="outer">
		<div onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=8'">독립오피스</div>
		<div onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=9'">코워킹오피스</div>
		<div onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=10'">일하기좋은카페</div>
		</div>
	</fieldset>


 <%-- <form action="<%=request.getContextPath()%>/space/spaceRegForm" method="GET">

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
	</form> --%>

</body>
</html>