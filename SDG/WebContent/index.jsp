<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	Member memberLoggedIn = (Member) session.getAttribute("memberLoggedIn");
	MemberBusi memberBusiIn = (MemberBusi) session.getAttribute("memberBusiIn");
	// /mvc/index.jsp => memberLoggedIn = null;
	// /mvc/member/login => memberLoggedIn = member객체

			
		//System.out.println("cookies@header.jsp"+memberBusiIn);
			
	//쿠키확인
	Cookie[] cookies = request.getCookies();
	boolean saveIdChecked = false;
	String memberId = "";

	if (cookies != null) {
		//System.out.println("cookies@header.jsp");
		//System.out.println("===================================");
		for (Cookie c : cookies) {
			String name = c.getName();
			String value = c.getValue();
			//System.out.println(name + " = " + value);

			if ("saveId".equals(name)) {
				saveIdChecked = true;
				memberId = value;
			}
		}
		//System.out.println("===================================");

	}
%>

<html>
<head>
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav>
		<%if (memberLoggedIn != null) { %>
		<form action="<%=request.getContextPath() %>/space/spaceTypeReg?memberId=<%=memberLoggedIn.getMemId() %>" method="GET">
			<button id="spaceReg">공간 등록</button>
		</form>
		<%} %>
	</nav>

    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>		
>>>>>>> branch 'master' of https://github.com/ISeeTheFuture/SDG.git




		<%
			}
		%>

	</div>


	<ul class="main-nav">


		<li><a href="<%=request.getContextPath()%>/board/boardList">이용후기</a></li>

	</ul>

	<form action="<%=request.getContextPath()%>/space/spacePrice"
		method="GET">
		<button id="spacePriceReg">사업장 요금</button>
	</form>

	<form action="<%=request.getContextPath()%>/space/spaceTimeTable"
		method="GET">
		<button id="spaceReg">사업자 운영스케쥴</button>
	</form>
	<form action="<%=request.getContextPath()%>/space/spaceTimeExp"
		method="GET">
		<button id="spaceExp">사업자 예외스케쥴</button>
	</form>
	<form action="<%=request.getContextPath()%>/space/UpdateSpacePrice"
		method="GET">
		<button id="spaceExp">사업자 요금 수정</button>
	</form>


	<a href="<%=request.getContextPath()%>/board/boardList">이용후기</a>
	<a href="<%=request.getContextPath()%>/board/boardForm">이용후기작성</a>
	<a href="<%=request.getContextPath()%>/res/resView">예약</a>
	<a href="<%=request.getContextPath()%>/res/resUpdate">예약수정하기</a>

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
<form action="<%=request.getContextPath()%>/review/reviewList" method="GET">
			<button id="reviewRpt">게시물 보기</button>
		</form>
	<a href="<%=request.getContextPath()%>/member/kimwonjae">테스트페이지</a>


	<form action="<%=request.getContextPath()%>/space/spaceSrchList" method="GET">
		<input type="text" name="spcSrch" id="spcSrch"/>
		<input type="submit" value="검색">
	</form>		
			
	<%--membership의 role값이 1 (트루)인경우 사업자 정보 입력 페이지로 이동 가능하도록 함. --%>
	<%
		if (memberLoggedIn != null && ("1".equals(memberLoggedIn.getMemRole()))) {
	%>

	<input type="button" value="사업자 등록용 페이지"
		onclick="location.href='<%=request.getContextPath()%>/member/memberbusiupdate'" />

	<%
		}
	%>


</body>
</html>

