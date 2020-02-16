<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="review.model.vo.Review"%>
    <%@page import="member.model.vo.Member"%>
    <%@ include file="/WEB-INF/views/common/header.jsp" %>    

    
    <%
    Review review = (Review)request.getAttribute("review");
    System.out.println(review);
    %>
<script>
function reviewValidate(){
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

<form action="<%=request.getContextPath() %>/review/reviewUpdateEnd" 
	  method="post" 
	  >
  <input type="hidden" name="reviewNo" value="<%=review.getReviewNo() %>" />
  <table id="tbl-board-view">
	<tr>
		<th>제 목</th>
		<td><input type="text" name="reviewTitle" value="<%=review.getReviewTitle()%>" required></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>
			<input type="text" name="memId" value="<%=review.getMemId()%>" readonly/>
		</td>
	</tr>
	
	<tr>
		<th>내 용</th>
		<td><textarea rows="5" cols="50" name="reviewContent"><%=review.getReviewContent() %></textarea></td>
	</tr>
	<tr>
		<th colspan="2">
			
		</th>
	</tr>
	
</table>
<label for="reviewStar">별점</label>
      <select  name="reviewStar" id="reviewStar" maxlength="11" required>
		    <option value="5">5</option>
		    <option value="4">4</option>
		    <option value="3">3</option>
		    <option value="2">2</option>
		    <option value="1">1</option>
		</select>
		<input type="submit" value="수정하기" onclick="return reviewValidate();">
			<input type="button" value="취소" onclick="reviewView();">
</form>

</section>