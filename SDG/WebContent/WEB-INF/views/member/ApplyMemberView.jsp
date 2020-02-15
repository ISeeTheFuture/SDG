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
			<th>번호</th>
			<th>주소</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>신청허가</th>
			<%--첨부파일이 있는 경우, /images/file.png 표시 width:16px --%>

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
				onclick="<%=request.getContextPath()%>/member/memberRolePermit?memberid=<%=b.getMemId()%>"
				value="관리자로 만들기"></td>
		</tr>
		<%
			}
		%>
	</table>






</body>
</html>