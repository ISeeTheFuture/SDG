<%@page import="member.model.vo.MemberBusi"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	Member memberLoggedIn = (Member) session.getAttribute("memberLoggedIn");
	MemberBusi memberBusiIn = (MemberBusi) session.getAttribute("memberBusiIn");
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
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js" integrity="sha384-6khuMg9gaYr5AxOqhkVIODVIvm9ynTT5J4V1cfthmT+emCG6yVmEZsRHdxlotUnm" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
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

	</div>