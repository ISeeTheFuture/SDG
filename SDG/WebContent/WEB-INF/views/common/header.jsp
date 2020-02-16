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
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js" integrity="sha384-6khuMg9gaYr5AxOqhkVIODVIvm9ynTT5J4V1cfthmT+emCG6yVmEZsRHdxlotUnm" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/custom.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/galleria.css">
<link href="https://fonts.googleapis.com/css?family=Yeon+Sung&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Yeon+Sung&display=swap" rel="stylesheet">
<style>
td#logo{
color : white;
	
    font-size: 30px;
    font-family: 'Black Han Sans', sans-serif;
    
    position : relative;
    box-sizing:inherit;
    margin:0;
    padding: 0;
    border-radius: 0;
    bottom: 0px;
}
td#song{
color : rgb(80, 65, 163);
margin-bottom: 10px;
font-family: 'Black Han Sans', sans-serif;
font-size: 50px;
box-sizing:inherit;
position : relative;
margin:0;
    padding: 0;
    border-radius: 0;
}
p#cho{
    margin-top: 30px;
font-size: 10px;
/* font-family: 'Black Han Sans', sans-serif; */
position : relative;
box-sizing:inherit;
margin:0;
    padding: 0;
    border-radius: 0;
    top: 10px;
    left: 10px;
    color: gray;
}
</style>
<meta charset="UTF-8">
<title>초특가 송대관</title>
</head>


<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		 <ul class="navbar-nav">
  
	    	
            	<table>
       			 <tr>
            <td id="song">송</td>
            <td id="logo"><p id="cho">초!특가</p>대관<p></p></td>
       			 </tr>
    			</table>
	      
		  	
		    <li class="nav-item">
		      	<a class="nav-link" href="#">Link</a>
		    </li>
		    <li class="nav-item">
		      	<a class="nav-link" href="#">Link</a>
		    </li>
			<form action="<%=request.getContextPath()%>/space/spaceSrchList" method="GET">
			    <div class="search">
			    	<div class="container">
						<div class="input-group">
								<input type="text" name="spcSrch" id="spcSrch" class="form-control" placeholder="Search for...">
		     					<span class="input-group-btn">
		        					<button class="btn btn-search" type="submit"><i class="fa fa-search fa-fw"></i> Search</button>
		      					</span>
			    		</div>
			    	</div>
			    </div>
      		</form>
		    
		    <% if(memberLoggedIn == null){ %>
		    <div class="signIn">
			    <li class="nav-item">
			      	<a class="nav-link" href="#myModal" data-toggle="modal">로그인</a>
			    </li>
		    </div>
		    <div class="signUp">
			    <li class="nav-item">
			      	<a class="nav-link" href="<%=request.getContextPath() %>/member/memberEnroll">회원가입</a>
			    </li>
		    </div>
		    <%}else if(memberLoggedIn != null){ %>
		    
		       
      <%
    if (memberLoggedIn != null && ("1".equals(memberLoggedIn.getMemRole()))) {
 %>
		    
		    
		    <div class="spaceReg">
			    <li class="nav-item">
			      	<a class="nav-link" href="<%=request.getContextPath() %>/space/spaceTypeReg?memberId=<%=memberLoggedIn.getMemId()%>">공간 등록</a>
			    </li>
		    </div>
		    
		    <%} %>
		    
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
						<label class="checkbox-inline pull-left"><input type="checkbox" name="saveId" 
					  				   id="saveId" <%=saveIdChecked ? "checked" : ""%>> Remember me</label>
						<input type="submit" class="btn btn-primary pull-right" value="Login">
					</div>
				</form>
			</div>
		</div>
	</div> 