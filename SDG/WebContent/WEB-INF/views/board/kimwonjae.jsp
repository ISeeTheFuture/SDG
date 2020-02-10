<%@page import="member.model.vo.Member"%>
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









		
				
			
			
	<%  if(memberLoggedIn != null){ %>
	<form>
	<input type="button"   value="포인트업 서블릿 확인용"   onclick="location.href='<%=request.getContextPath() %>/member/memberPointUp?memberId=<%=memberLoggedIn.getMemId()%>'" />
					  				   
					  				   	<input type="hidden" name="memberPoint" value="<%=memberLoggedIn!=null?memberLoggedIn.getMemPoint():""%>"/>

<%
		}
	%>

	</form>
	
	
	
		<%--관리자인경우 벤이 가능하도록 함. --%>
	<%
		if (memberLoggedIn != null && ("1".equals(memberLoggedIn.getMemAdmin()))) {
	%>
	<form action="<%=request.getContextPath()%>/member/memberIgnore"
		name="memberIgnoreFrm" method="post">
		<input type="text" name="ignoreId" id="ignoreMemIndex" placeholder="벤 대상자의 id를 입력하세요." />
		<input type="text" name="ignoreReason" id="ignoreReasonIndex" placeholder="벤 사유를 입력하세요." />
		<input type='submit' value="전송" />
	</form>
	<%
		}
	%>
	



	<%--관리자인경우 사업자 등록, 관리자 등록이 가능하도록 함. --%>
	<%
		if (memberLoggedIn != null && ("1".equals(memberLoggedIn.getMemAdmin()))) {
	%>
	<form action="<%=request.getContextPath()%>/member/memberRole"
		name="memberRoleUpFrm" method="post">
		<input type="text" name="RoleId" id="RoleUP_ID" placeholder="사업자 등록 대상자의 id를 입력하세요." />
		<input type='submit' value="전송" />
	</form>
	<%
		}
	%>
				





















</body>
</html>