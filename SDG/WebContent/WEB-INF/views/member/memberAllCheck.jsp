<%@page import="member.model.vo.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	List<Member> list = (List<Member>) request.getAttribute("list");
	
	Member memberLoggedIn = (Member) session.getAttribute("memberLoggedIn");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모든 유저 확인
</head>
<body>



	<table id="tbl-board">
		<tr>
			<th>번호</th>
			<th>주소</th>
			<th>이름</th>
			<th>전화번호</th>
	
		</tr>
		<%
			for (Member b : list) {
		%>
		<tr>
			<td><%=b.getMemId()%></td>
			<td><%=b.getMemAddr()%></td>
			<td><%=b.getMemName()%></td>
			<td><%=b.getMemPhone()%></td>
			<td><input type="button"
				
				value="사업자로 만들기"
				onclick="location.href='<%=request.getContextPath()%>/member/memberRolePermit?memberid=<%=b.getMemId()%>'"
				/></td>
					
		</tr>
		<%
			}
		%>
	</table>










</body>
</html>