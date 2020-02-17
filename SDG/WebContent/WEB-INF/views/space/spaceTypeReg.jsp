<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
​
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
​
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
.btn-container {
    display: inline-block;
    padding: 16px 0px;
    margin: 0px 16px;
    overflow: hidden;
}
*, *:before, *:after {
    padding: 0px;
    margin: 0px;
    transition: 0.3s;
}
.standard-btn {
     color: #34495e;
    border: solid 1px #34495e;
    font-size: 1rem;
    position: relative;
    z-index: 1;
    padding: 15px 30px;
    cursor: pointer;
    font-size: 1.2rem;
    text-transform: uppercase;
    background: transparent;
    width:200px;
}
.standard-btn:before {
    display: block;
    position: absolute;
    top: 0px;
    left: 0px;
    width: 0px;
    height: 100%;
    z-index: -1;
    content: "";
    background: #34495e;
}
​
.standard-btn:hover {
      color: #fff;
      border: solid 1px #34495e;
}
.standard-btn:hover:before {
      width: 100%;
}
.row{
	padding-left: 72px;
}
</style>
​
​
<body>
​
	<div class="container">
		<br>
		<p class="text-center">등록공간 유형을 선택하세요</p>
		<hr>
	</div>
	
​
<p class="text-center">모임장소</p>
<div class="container">
	<div class="row">
		<div class="btn-container">
			<div class="btn standard-btn" onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=1&memberId=<%=memberLoggedIn.getMemId()%>'">회의실</div>
			<div class="btn standard-btn" onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=2&memberId=<%=memberLoggedIn.getMemId()%>'">다목적홀</div>
			<div class="btn standard-btn" onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=3&memberId=<%=memberLoggedIn.getMemId()%>'">레저시설</div>
			<div class="btn standard-btn" onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=4&memberId=<%=memberLoggedIn.getMemId()%>'">파티룸</div>
			<br /><br />
			<div class="btn standard-btn" onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=5&memberId=<%=memberLoggedIn.getMemId()%>'">공연장</div>
			<div class="btn standard-btn" onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=6&memberId=<%=memberLoggedIn.getMemId()%>'">카페</div>
			<div class="btn standard-btn" onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=7&memberId=<%=memberLoggedIn.getMemId()%>'">스터디룸</div>	
		</div>
	</div>
</div>
​
<br />
<br />
<p class="text-center">공유오피스</p>
<div class="container">
	<div class="row">
		<div class="btn-container">
			<div class="btn standard-btn" onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=8&memberId=<%=memberLoggedIn.getMemId()%>'">독립오피스</div>
			<div class="btn standard-btn" onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=9&memberId=<%=memberLoggedIn.getMemId()%>'">코워킹오피스</div>
			<div class="btn standard-btn" onclick="location.href='<%=request.getContextPath()%>/space/spaceRegForm?cat=10&memberId=<%=memberLoggedIn.getMemId()%>'">워킹카페</div>
			
		</div>
	</div>
</div>
​
<%@ include file="/WEB-INF/views/common/footer.jsp" %>