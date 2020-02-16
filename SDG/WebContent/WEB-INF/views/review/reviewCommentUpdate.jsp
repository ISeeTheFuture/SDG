<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="review.model.vo.ReviewComment"%>
    <%@page import="member.model.vo.Member"%>
    <%@ include file="/WEB-INF/views/common/header.jsp" %>    

    
    <%
    ReviewComment review = (ReviewComment)request.getAttribute("reviewComment");
    System.out.println(review);
    %>
<script>
function reviewCommentValidate(){
	var content = $("[name=content]").val();
	//console.log(content.length)
	if(content.trim().length==0){
		alert("내용을 입력하세요");
		return false;
	}
	return true;
}
function reviewView(){
	history.go(-1);
}
</script>
<section id="board-container">

<form action="<%=request.getContextPath() %>/review/reviewCommentUpdateEnd" 
	  method="post" 
	  >
  <input type="hidden" name="commentNo" value="<%=review.getCommentNo() %>" />
  <table id="tbl-board-view">
	<tr>
		<th>작성자</th>
		<td>
			<input type="text" name="memId" value="<%=review.getMemId()%>" readonly/>
		</td>
	</tr>
	<tr>
		<th>내 용</th>
		<td><input type="text" name="commentContent" value="<%=review.getCommentContent()%>" required></td>
	</tr>
	
	
		<input type="submit" value="수정하기" onclick="return reviewValidate();">
			<input type="button" value="취소" onclick="reviewView();">
</form>

</section>