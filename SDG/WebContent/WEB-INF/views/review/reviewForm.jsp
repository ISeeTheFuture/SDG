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
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
<title>사업자 정보 입력</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/review/reviewFormEnd" method="post">
	<label for="memId">아이디</label>
	<input type="text"  name="memId" id="memId" value="<%=memberLoggedIn.getMemId() %>"  readonly><br>
	<br>
	
	 <label for="memBusiNo">사업장 번호</label>
      <input type="text" name="spc_no" id="spc_no" placeholder="사업장 번호를 입력하세요." />
      <br> 
      
     <label for="reviewTitle">제목</label>
      <input type="text" name="reviewTitle" id="reviewTitle" placeholder="제목을 입력하세요." />
      <br>
     <label for="reviewContent">내용</label>
      <input type="text" name="reviewContent" id="reviewContent" placeholder="내용을 입력하세요." />
      <br>
     
      <label for="reviewStar">별점 입력</label>
      <select  name="reviewStar" id="reviewStar" maxlength="11" required>
		    <option value="5">5</option>
		    <option value="4">4</option>
		    <option value="3">3</option>
		    <option value="2">2</option>
		    <option value="1">1</option>
		</select>
      <br>
      
     <!--  <input type="hidden" name="memBusiAllow" id="memBusiAllow" value="N" /> -->
      <!--기본값 0으로  0일때 승인 거부 상태 , 관리자가 1로 update해야 승인됨 -->
      
      <input type='submit' value="전송" />
      <input type="reset" value="취소">
	
	</form>
	
	
</body>


</html>
