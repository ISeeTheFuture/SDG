<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="review.model.vo.Review"%>
    <%
    Review review = (Review)request.getAttribute("reviewOriNo");
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
	
	
	
	<label for="reviewNo">원본글번호 hidden </label>
	<%-- <input type="hidden"  name="reviewNo" id="reviewNo" value="<%=review.getReviewOriNo() %>"  required> --%>
	<br>
	
	<label for="reviewReportReason">신고 사유</label>
      <input type="text" name="reviewReportReason" id="reviewReportReason" placeholder="신고사유를 입력하세요." />
      <br>
            
      <input type="hidden" name="reviewReportDate" id="reviewReportDate" value="0" />
      <!--기본값 0으로  0일때 승인 거부 상태 , 관리자가 1로 update해야 승인됨 -->
      
      <input type='submit' value="전송" />
      <input type="reset" value="취소">
	
	</form>
</body>
</html>