<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="member.model.vo.Member"%>
    <%
    Member member = (Member)request.getAttribute("member");
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
	<form action="<%=request.getContextPath() %>/member/memberBusiEnd" method="post">
	<label for="memId">사업자 아이디</label>
	<input type="text"  name="memId" id="memId" value="<%=memberLoggedIn.getMemId() %>"  required><br>
	<br>
	
	<!-- <label for="memBusiNo">사업자 번호</label>
      <input type="text" name="memBusiNo" id="memBusiNo" placeholder="사업자 번호를 입력하세요." />
      <br> -->
      
     <label for="memBusiAddr">사업장 주소</label>
      <input type="text" name="memBusiAddr" id="memBusiAddr" placeholder="사업장 주소를 입력하세요." />
      <br>
      
      <label for="memBusiPhone">사업장 연락쳐</label>
      <input type="tel" placeholder="사업장 연락쳐를 입력하세요.(-없이)01012345678" name="memBusiPhone" id="memBusiPhone" maxlength="11" required><br>
      <br>
      
     <!--  <input type="hidden" name="memBusiAllow" id="memBusiAllow" value="N" /> -->
      <!--기본값 0으로  0일때 승인 거부 상태 , 관리자가 1로 update해야 승인됨 -->
      
      <input type='submit' value="전송" />
      <input type="reset" value="취소">
	
	</form>
</body>


</html>
