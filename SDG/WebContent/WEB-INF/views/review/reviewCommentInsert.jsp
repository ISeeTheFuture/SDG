<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="review.model.vo.Review"%>
    <%@page import="review.model.vo.ReviewComment"%>
    <%@page import="member.model.vo.Member"%>
    <%@page import="res.model.vo.Res"%>
    <%
    Res res = (Res)request.getAttribute("res");
    Review review = (Review)request.getAttribute("review");
    ReviewComment reviewComment = (ReviewComment)request.getAttribute("reviewComment");
    Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	<form action="<%=request.getContextPath() %>/review/reviewCommentInsert" method="post">
	<label for="memId">아이디</label>
	<input type="text"  name="memId" id="memId" value="<%=memberLoggedIn.getMemId() %>"  readonly><br>
	<br>
	
	<!-- <label for="memBusiNo">사업자 번호</label>
      <input type="text" name="memBusiNo" id="memBusiNo" placeholder="사업자 번호를 입력하세요." />
      <br> -->
      
     
     <label for="commentContent">내용</label>
      <input type="text" name="commentContent" id="commentContent" placeholder="내용을 입력하세요." />
      <br>
     
     
      
     <!--  <input type="hidden" name="memBusiAllow" id="memBusiAllow" value="N" /> -->
      <!--기본값 0으로  0일때 승인 거부 상태 , 관리자가 1로 update해야 승인됨 -->
      
      <input type='submit' value="전송" />
      <input type="reset" value="취소">
	
	</form>
</body>
</html>