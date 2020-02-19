<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="review.model.vo.Review"%>
    <%
    //Review review = (Review)request.getAttribute("reviewOriNo");
    int a =   Integer.parseInt(request.getParameter("reviewNo"));
System.out.println(a);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
<title>이용후기 신고</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/review/reviewRptEnd" method="post">
	
	
	
	<label for="reviewNo">신고대상글번호  </label>
	
		<td><input type="text" name="reviewNo" id="reviewNo"
						value="<%=a %>"
			 readonly	/></td>
	
	<br>
	
	
	
	<label for="reviewReportReason">신고 사유</label>
      <input type="text" name="reviewReportReason" id="reviewReportReason" placeholder="신고사유를 입력하세요." />
      <br>
            
 
      
      <input type='submit' value="전송" />
      <input type="reset" value="취소">
	
	</form>
</body>
</html>