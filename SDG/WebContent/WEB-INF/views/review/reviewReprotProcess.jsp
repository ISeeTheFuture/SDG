<%@page import="review.model.vo.ReviewReport"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
	List<ReviewReport> list = (List<ReviewReport>) request.getAttribute("list");
  
    %>
<!DOCTYPE html>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>


#heightweightkwj{
height:1024px;
weight:768px;
no-repeat fixed;
background-repeat: no-repeat; 



background-image      : url("<%=request.getContextPath() %>/images/index-back.png");
 background-size: cover;
}
</style>
</head>
<body>
<div id="heightweightkwj">
<%-- 

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
	</table> --%>



		<table class="table table-striped table-dark">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">신고 번호</th>
					<th scope="col">신고 글번호</th>
					<th scope="col">신고 사유</th>
					<th scope="col">신고 시간</th>

				</tr>
			</thead>
			<tbody>

				<%
					int i = 0;
					for (ReviewReport b : list) {
						i++;
				%>
				<tr>
					<th scope="row"><%=i%></th>
					<td><%=b.getReviewReportNo()%></td>
					<td><%=b.getReviewNo()%></td>
					<td><%=b.getReviewReportReason()%></td>
					<td><%=b.getReviewReportDate()%></td>

					<td><input type="button" value="글 삭제 하기"
						onclick="location.href='<%=request.getContextPath()%>/review/reviewDelete?reviewNo=<%=b.getReviewNo()%>'" /></td>
				</tr>

				</tr>

				<%
					}
				%>
</tbody>


</table>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>