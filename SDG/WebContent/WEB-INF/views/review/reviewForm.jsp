<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    

<script>
  function reviewValidate(){
	//내용을 작성하지 않은 경우에 대한 유효성 검사하세요.
	//공백만 작성한 경우도 폼이 제출되어서는 안됨.

	return true;
}
</script>
<section id="review-container">
<h2>게시판 작성</h2>
<form action="<%=request.getContextPath() %>/review/reviewFormEnd" 
	  method="post"
	  enctype="multipart/form-data">
	<table id="tbl-board-view">
	<tr>
		<th>제 목</th>
		<td><input type="text" id="reviewTitle" name="reviewTitle" required></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>
			<input type="text" id="memberId" name="memberId" value="작성자" readonly/>
		</td>
	</tr>
	<tr>
		<th>내 용</th>
		<td><textarea rows="5" cols="40" id="reviewContent" name="reviewContent"></textarea></td>
	</tr>
	
	<tr>
		<th>별점</th>
		<td><input type="text" id="reviewStar" name="reviewStar" ></td>
	</tr>
	<tr>
		<th colspan="2">
			<input type="submit" value="등록하기" onclick="return boardValidate();">
		</th>
	</tr>
</table>
</form>
</section>
