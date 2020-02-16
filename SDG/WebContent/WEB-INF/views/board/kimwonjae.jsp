<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	Member memberLoggedIn = (Member) session.getAttribute("memberLoggedIn");
	// /mvc/index.jsp => memberLoggedIn = null;
	// /mvc/member/login => memberLoggedIn = member객체

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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="login-container">
		<%
			if (memberLoggedIn != null) {
		%>
		<%--로그인한 경우 --%>
		<table id="logged-in">
			<tr>
				<td><%=memberLoggedIn.getMemName()%>님, 안녕하세요.</td>
			</tr>
			<tr>
				<td>
					<button
						onclick="location.href='<%=request.getContextPath()%>/member/memberView?memberId=<%=memberLoggedIn.getMemId()%>'">내정보보기</button>
					<button
						onclick="location.href='<%=request.getContextPath()%>/member/logout'">로그아웃</button>
				</td>
			</tr>
		</table>
		<%
			} else {
		%>
		<%--로그인하지 않은 경우 --%>
		<form action="<%=request.getContextPath()%>/member/login"
			id="loginFrm" method="POST" onsubmit="return loginValidate();">
			<table>
				<tr>
					<td><input type="text" name="memberId" id="login-memberId"
						placeholder="아이디" value="<%=saveIdChecked ? memberId : ""%>"
						tabindex="1" /></td>
					<td><input type="submit" value="로그인" tabindex="3" /></td>
				</tr>
				<tr>
					<td><input type="password" name="password" id="login-password"
						placeholder="비밀번호" tabindex="2" /></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="2"><input type="checkbox" name="saveId"
						id="saveId" <%=saveIdChecked ? "checked" : ""%> /> <label
						for="saveId">아이디 저장</label> &nbsp;&nbsp; <input type="button"
						value="회원가입"
						onclick="location.href='<%=request.getContextPath()%>/member/memberEnroll'" />
					</td>
				</tr>
			</table>
		</form>

		<%
			}
		%>







		<%--관리자인경우 직접 벤이 가능하도록 함. --%>
		<%
			if (memberLoggedIn != null && ("1".equals(memberLoggedIn.getMemAdmin()))) {
		%>
		<form action="<%=request.getContextPath()%>/member/memberIgnore"
			name="memberIgnoreFrm" method="post">
			<input type="text" name="ignoreId" id="ignoreMemIndex"
				placeholder="벤 대상자의 id를 입력하세요." /> <input type="text"
				name="ignoreReason" id="ignoreReasonIndex"
				placeholder="벤 사유를 입력하세요." /> <input type='submit' value="전송" />
		</form>
		<%
			}
		%>




		<%--관리자인경우 사업자 등록, 관리자 등록페이지로 이동이 가능하도록 함. --%>
		<%
			if (memberLoggedIn != null && ("1".equals(memberLoggedIn.getMemAdmin()))) {
		%>

		<button
			onclick="location.href='<%=request.getContextPath()%>/member/MemberApplyMemberView'">사업자
			등업 관리 페이지로 이동</button>
	
		<%
			}
		%>



		<!-- 	관리자인 경우 신고 삭제 관리 페이지로 이동. -->
		<%
			if (memberLoggedIn != null && "1".equals(memberLoggedIn.getMemAdmin())) {
		%>


		<button
			onclick="location.href='<%=request.getContextPath()%>/review/reviewRprtPrcss'">신고 게시글 확인</button>

		<%
			}
		%>
		
		
			<%
			if (memberLoggedIn != null && "1".equals(memberLoggedIn.getMemAdmin())) {
		%>


		<button
			onclick="location.href='<%=request.getContextPath()%>/member/memberAllCheck'">모든 사용자 조회</button>

		<%
			}
		%>
		
		
	
</body>


















</body>
</html>