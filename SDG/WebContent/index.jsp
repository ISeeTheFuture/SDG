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


	<%
		if (memberLoggedIn != null) {
	%>
	<input type="button" value="이용후기 작성" id="btn-add" onclick="location.href='<%=request.getContextPath()%>/review/reviewForm'" />
	<a href="<%=request.getContextPath()%>/res/resMe">내예약</a>
	<%
		}
	%>
	
	
	<form action="<%=request.getContextPath()%>/review/reviewList"
		method="GET">
		<button id="reviewRpt">게시물 보기</button>
	</form>



	<%
		if (memberLoggedIn != null && ("1".equals(memberLoggedIn.getMemAdmin()))) {
	%>
	

	<a href="<%=request.getContextPath()%>/member/kimwonjae">관리자용 페이지</a>
	
<%
}
%>