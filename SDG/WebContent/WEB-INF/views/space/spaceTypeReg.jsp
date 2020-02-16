<%@page import="member.model.vo.Member"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>	
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
.outermulti {
	width: 1200px;
}

.outeroffice {
	width: 1200px;
}

.fieldmulti {
	width: 1200px;
}

.fieloffice {
	width: 1200px;
}

.multiroom {
	display: inline-block;
	width: 500px;
	height: 300px;
	margin: 20px;
	font-size: 70px;
	overflow: hidden;
	text-align: center;
	background-color: #E2E2E2;
	border-radius: 40px/40px;
}

.officeroom {
	margin: 20px;
	font-size: 70px;
	text-align: center;
	display: inline-block;
	border-radius: 40px/40px;
	width: 500px;
	height: 300px;
	overflow: hidden;
	background-color: #E2E2E2;
}

.selectouter {
	display: block;
	width: 1100px;
	height: 340px;
}

.cat1 {
	background-color: #E2E2E2;
	border-radius: 20px/20px;
	font-size: 24px;
	text-align: center;
	margin: 10px;
	width: 150px;
	height: 100px;
	display: inline-block;
}

.cat2 {
	background-color: #E2E2E2;
	border-radius: 20px/20px;
	font-size: 24px;
	text-align: center;
	margin: 10px;
	width: 150px;
	height: 100px;
	display: inline-block;
}

.cat3 {
	background-color: #E2E2E2;
	border-radius: 20px/20px;
	font-size: 24px;
	text-align: center;
	margin: 10px;
	width: 150px;
	height: 100px;
	display: inline-block;
}

.cat4 {
	background-color: #E2E2E2;
	border-radius: 20px/20px;
	font-size: 24px;
	text-align: center;
	margin: 10px;
	width: 150px;
	height: 100px;
	display: inline-block;
}

.cat5 {
	background-color: #E2E2E2;
	border-radius: 20px/20px;
	font-size: 24px;
	text-align: center;
	margin: 10px;
	width: 150px;
	height: 100px;
	display: inline-block;
}

.cat6 {
	background-color: #E2E2E2;
	border-radius: 20px/20px;
	font-size: 24px;
	text-align: center;
	margin: 10px;
	width: 150px;
	height: 100px;
	display: inline-block;
}

.cat7 {
	background-color: #E2E2E2;
	border-radius: 20px/20px;
	font-size: 24px;
	text-align: center;
	margin: 10px;
	width: 150px;
	height: 100px;
	display: inline-block;
}

.cat8 {
	background-color: #E2E2E2;
	border-radius: 20px/20px;
	font-size: 24px;
	text-align: center;
	margin: 10px;
	width: 150px;
	height: 100px;
	display: inline-block;
}

.cat9 {
	background-color: #E2E2E2;
	border-radius: 20px/20px;
	font-size: 24px;
	text-align: center;
	margin: 10px;
	width: 150px;
	height: 100px;
	display: inline-block;
}

.cat10 {
	background-color: #E2E2E2;
	border-radius: 20px/20px;
	font-size: 24px;
	text-align: center;
	margin: 10px;
	width: 150px;
	height: 100px;
	display: inline-block;
}

.officetext {
	font-size: 50px;
}
</style>

<script>
	$(function() {
		$(".multiroom").click(function() {
			$(".outermulti").css("display", "block");
			$(".officeroom").css("display", "none");
			$(".fieloffice").css("display", "none");
			$(".multiroom").css("display", "none");
			$(".selectouter").css("display", "none");
			$(".fieldmulti").css("display", "block");
		});
	});

	$(function() {
		$(".officeroom").click(function() {
			$(".outeroffice").css("display", "block");
			$(".officeroom").css("display", "none");
			$(".fieldmulti").css("display", "none");
			$(".multiroom").css("display", "none");
			$(".selectouter").css("display", "none");
			$(".fieloffice").css("display", "block");
		});
	});
</script>
<style>
p.text-center {
	font-size: 2em;
}
</style>


<body>

	<div class="container">
		<br>
		<p class="text-center">등록공간 유형을 선택하세요</p>
		<hr>
	</div>
	


	<fieldset class="fieldmulti">
		<legend class="officetext">모임장소</legend>
		<div class="outermulti">
			<div class="cat1"
				onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=1&memberId=<%=memberLoggedIn.getMemId()%>'">
				<br />회의실
			</div>
			<div class="cat2"
				onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=2&memberId=<%=memberLoggedIn.getMemId()%>'">
				<br />다목적홀
			</div>
			<div class="cat3"
				onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=3&memberId=<%=memberLoggedIn.getMemId()%>'">
				<br />레저시설
			</div>
			<div class="cat4"
				onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=4&memberId=<%=memberLoggedIn.getMemId()%>'">
				<br />파티룸
			</div>
			<div class="cat5"
				onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=5&memberId=<%=memberLoggedIn.getMemId()%>'">
				<br />공연장
			</div>
			<div class="cat6"
				onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=6&memberId=<%=memberLoggedIn.getMemId()%>'">
				<br />카페
			</div>
			<div class="cat7"
				onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=7&memberId=<%=memberLoggedIn.getMemId()%>'">
				<br />스터디룸
			</div>
		</div>
	</fieldset>
	<br />
	<br />
	<fieldset class="fieloffice">
		<legend class="officetext">공유 오피스</legend>
		<div class="outeroffice">
			<div class="cat8"
				onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=8&memberId=<%=memberLoggedIn.getMemId()%>'">
				<br />독립오피스
			</div>
			<div class="cat9"
				onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=9&memberId=<%=memberLoggedIn.getMemId()%>'">
				<br />코워킹오피스
			</div>
			<div class="cat10"
				onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=10&memberId=<%=memberLoggedIn.getMemId() %>'">
				<br />워킹카페
			</div>
		</div>
	</fieldset>

</body>
</html>