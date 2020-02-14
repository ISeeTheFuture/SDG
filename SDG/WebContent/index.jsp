<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>	






	<br>
	<br>
	<br>
	<form action="<%=request.getContextPath()%>/member/memberBusi"
		method="GET">
		<button id="memberBusi">사업자 정보 입력</button>
	</form>
	<br>
	<form action="<%=request.getContextPath()%>/review/reviewRpt"
		method="GET">
		<button id="reviewRpt">게시물신고</button>
	</form>

	<%
		if (memberLoggedIn != null) {
	%>
	<input type="button" value="이용후기 작성" id="btn-add"
		onclick="location.href='<%=request.getContextPath()%>/review/reviewForm'" />
	<%
		}
	%>
	<form action="<%=request.getContextPath()%>/review/reviewList"
		method="GET">
		<button id="reviewRpt">게시물 보기</button>
	</form>



	<form action="<%=request.getContextPath()%>/space/spaceSrchList" method="GET">
		<input type="text" name="spcSrch" id="spcSrch"/>
		<input type="submit" value="검색">
	</form>
	<a href="<%=request.getContextPath()%>/res/resUpdate">내예약</a>

	<%--membership의 role값이 1 (트루)인경우 사업자 정보 입력 페이지로 이동 가능하도록 함. --%>
	<%
		if (memberLoggedIn != null && ("1".equals(memberLoggedIn.getMemRole()))) {
	%>

	<input type="button" value="사업자 등록용 페이지"
		onclick="location.href='<%=request.getContextPath()%>/member/memberbusiupdate'" />

	<%
		}
	%>

