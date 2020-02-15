<%@page import="review.model.vo.ReviewReport"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
	List<ReviewReport> list = (List<ReviewReport>) request.getAttribute("list");
  
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
			<th>신고 번호</th>
			<th>신고 글 번호</th>
			<th>신고 이유</th>
			<th>신고 시간</th>
		</tr>
		<%
			for (ReviewReport b : list) {
				System.out.println(b.getReviewNo());
		%>
		
		<tr>
			<td><%=b.getReviewReportNo()%></td>
			<td><%=b.getReviewNo()%></td>
			<td><%=b.getReviewReportReason()%></td>
			<td><%=b.getReviewReportDate()%></td>
		</tr>
		
		<tr>
		
		
		
		</tr>
		<%
			}
		%>
	</table>






</body>
</html>