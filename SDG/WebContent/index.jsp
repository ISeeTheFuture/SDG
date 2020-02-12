<%@page import="member.model.vo.Member"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
   <%
	Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");
	// /mvc/index.jsp => memberLoggedIn = null;
	// /mvc/member/login => memberLoggedIn = member객체
			
			
	//쿠키확인
	Cookie[] cookies = request.getCookies();
	boolean saveIdChecked = false;
	String memberId = "";
	
	if(cookies != null){
		//System.out.println("cookies@header.jsp");
		//System.out.println("===================================");
		for(Cookie c : cookies){
			String name = c.getName();
			String value = c.getValue();
			//System.out.println(name + " = " + value);
			
			if("saveId".equals(name)){
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
	<nav>
		<form action="<%=request.getContextPath() %>/space/spaceTypeReg" method="GET">
			<button id="spaceReg">공간 등록</button>
		</form>
	</nav>
			
		<div class="login-container">
			<%  if(memberLoggedIn != null){ %>
				<%--로그인한 경우 --%>
				<table id="logged-in">
					<tr>
						<td><%=memberLoggedIn.getMemName() %>님, 안녕하세요.</td>
					</tr>				
					<tr>
						<td>
							<button 
								onclick="location.href='<%=request.getContextPath()%>/member/memberView?memberId=<%=memberLoggedIn.getMemId()%>'">내정보보기</button>
							<button onclick="location.href='<%=request.getContextPath()%>/member/logout'">로그아웃</button>						
						</td>
					</tr>
				</table>
			<%  } else{ %>
				<%--로그인하지 않은 경우 --%>
				<form action="<%=request.getContextPath() %>/member/login" 
					  id="loginFrm"
					  method="POST"
					  onsubmit="return loginValidate();">
					  <table>
					  	<tr>
					  		<td><input type="text" name="memberId" 
					  				   id="login-memberId" 
					  				   placeholder="아이디"
					  				   value="<%=saveIdChecked?memberId:"" %>" 
					  				   tabindex="1"/></td>
					  		<td><input type="submit" value="로그인" 
					  				   tabindex="3"/></td>
					  	</tr>
					  	<tr>
					  		<td><input type="password" name="password" 
					  				   id="login-password"
					  				   placeholder="비밀번호" 
					  				   tabindex="2"/></td>
					  		<td></td>
					  	</tr>
					  	<tr>
					  		<td colspan="2">
					  			<input type="checkbox" name="saveId" 
					  				   id="saveId" <%=saveIdChecked?"checked":"" %>/>
					  			<label for="saveId">아이디 저장</label>
					  			&nbsp;&nbsp;
					  			<input type="button" 
					  				   value="회원가입"
					  				   onclick="location.href='<%=request.getContextPath() %>/member/memberEnroll'" />
					  		</td>
					  	</tr>
					  </table>
				</form>
			
			<%  }%>
	
			</div>
	
	
				<ul class="main-nav">
					
					<li><a href="<%=request.getContextPath()%>/board/boardList">이용후기</a></li>
					
				</ul>
	
		<form action="<%=request.getContextPath()%>/space/spacePrice" method="GET">
			<button id="spacePriceReg">사업장 요금</button>
		</form>

		<form action="<%=request.getContextPath()%>/space/spaceTimeTable" method="GET">
			<button id="spaceReg">사업자 운영스케쥴</button>
		</form>
		<form action="<%=request.getContextPath()%>/space/spaceTimeExp" method="GET">
			<button id="spaceExp">사업자 예외스케쥴</button>
		</form>
		<form action="<%=request.getContextPath()%>/space/UpdateSpacePrice" method="GET">
			<button id="spaceExp">사업자 요금 수정</button>
		</form>


		<li><a href="<%=request.getContextPath()%>/board/boardList">이용후기</a></li>
		<li><a href="<%=request.getContextPath()%>/board/boardForm">이용후기작성</a></li>
		<li><a href="<%=request.getContextPath()%>/res/resView">예약</a></li>
		<li><a href="<%=request.getContextPath()%>/res/resUpdate">예약수정하기</a></li>

<br><br><br>
		<form action="<%=request.getContextPath()%>/member/memberBusi" method="GET">
			<button id="memberBusi">사업자 정보 입력</button>
		</form>
		<br>
		<form action="<%=request.getContextPath()%>/review/reviewRpt" method="GET">
			<button id="reviewRpt">게시물신고</button>
		</form>
<<<<<<< HEAD
		<% if(memberLoggedIn != null){ %>
	<input type="button" value="이용후기 작성" id="btn-add"
		   onclick="location.href='<%=request.getContextPath() %>/review/reviewForm'" />
	<% } %>
		<form action="<%=request.getContextPath()%>/review/reviewList" method="GET">
			<button id="reviewRpt">게시물 보기</button>
		</form>
=======
>>>>>>> branch 'master' of https://github.com/ISeeTheFuture/SDG.git
		

				
			

</body>
</html>