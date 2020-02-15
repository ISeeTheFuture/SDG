<%@page import="java.util.List"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<Member> list = (List<Member>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>




	<table id="tbl-board">
		<tr>
			<th>신청자 아이디</th>
			<th>/신청자 주소</th>
			<th>/신청자 이름</th>
			<th>/신청자 전화번호</th>
			
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