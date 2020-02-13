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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/custom.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css">
<meta charset="UTF-8">
<title>초특가 송대관</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav">
	    	<li class="nav-item active">
	      	<a class="nav-link" href="#">Active</a>
		  	</li>
		    <li class="nav-item">
		      	<a class="nav-link" href="#">Link</a>
		    </li>
		    <li class="nav-item">
		      	<a class="nav-link" href="#">Link</a>
		    </li>
		    <% if(memberLoggedIn == null){ %>
		    <div class="signIn">
			    <li class="nav-item">
			      	<a class="nav-link" href="#myModal" data-toggle="modal">로그인</a>
			    </li>
		    </div>
		    <div class="signUp">
			    <li class="nav-item">
			      	<a class="nav-link" href="#">회원가입</a>
			    </li>
		    </div>
		    <%}else if(memberLoggedIn != null){ %>
		    <div class="memberInfo">
			    <li class="nav-item">
			      	<a class="nav-link" href="<%=request.getContextPath()%>/member/memberView?memberId=<%=memberLoggedIn.getMemId()%>">내 정보 보기</a>
			    </li>
		    </div>
		    <div class="signOut">
			    <li class="nav-item">
			      	<a class="nav-link" href="<%=request.getContextPath()%>/member/logout">로그 아웃</a>
			    </li>
		    </div>
		    <%} %>
		</ul>
	</nav>

		<div id="myModal" class="modal fade">
		<div class="modal-dialog modal-login">
			<div class="modal-content">
				<form action="<%=request.getContextPath()%>/member/login"
			id="loginFrm" method="POST" onsubmit="return loginValidate();">
					<div class="modal-header">				
						<h4 class="modal-title">Login</h4>
						<button type="button"  class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">				
						<div class="form-group">
							<label>Username</label>
							<input type="text" name="memberId" id="login-memberId" class="form-control" required="required" value="<%=saveIdChecked ? memberId : ""%>">
						</div>
						<div class="form-group">
							<div class="clearfix">
								<label>Password</label>
								<a href="#" class="pull-right text-muted"><small>Forgot?</small></a>
							</div>
							
							<input type="password"  name="password" id="login-password" class="form-control" required="required">
						</div>
					</div>
					<div class="modal-footer">
						<label class="checkbox-inline pull-left"><input type="checkbox" <%=saveIdChecked ? "checked" : ""%>> Remember me</label>
						<input type="submit" class="btn btn-primary pull-right" value="Login">
					</div>
				</form>
			</div>
		</div>
	</div> 