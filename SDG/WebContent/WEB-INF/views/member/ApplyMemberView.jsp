<%@page import="java.util.List"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<Member> list = (List<Member>) request.getAttribute("list");
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

<table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">신청자 아이디</th>
      <th scope="col">신청자 주소</th>
      <th scope="col">신청자 전화번호</th>
      <th scope="col">사업자로 만들기</th>
      
    </tr>
  </thead>
  <tbody>
 
  <%
  int i =0;
			for (Member b : list) {
				i++;
		%>
    <tr>
      <th scope="row"><%=i %></th>
      <td><%=b.getMemId()%></td>
      <td><%=b.getMemAddr()%></td>
      <td><%=b.getMemName()%></td>
      <td><%=b.getMemPhone()%></td>
      
      <td><input type="button"
				
				value="사업자로 만들기"
				onclick="location.href='<%=request.getContextPath()%>/member/memberRolePermit?memberid=<%=b.getMemId()%>'"
				/></td>
    </tr>

    </tr>
    
    <%} %>
  </tbody>
</table>
</div>
</body>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</html>