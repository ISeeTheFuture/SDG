
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%
	boolean isUsable = (boolean)request.getAttribute("isUsable");
	String memberId = request.getParameter("memberId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디중복검사</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
<style>
div#checkid-container{text-align:center; padding-top:50px;}
span#duplicated{color:red; font-weight:bold;}
</style>
</head>
<body>
    <div id="checkid-container">
    <% if(isUsable){ %>
     	
     	<p>[ <span><%=memberId %></span> ]는 사용가능합니다. </p>
     	<button onclick="setMemberId();">닫기</button>
     	
    <% } else { %>
    
     	<p>[ <span id="duplicated"><%=memberId %></span> ]는 이미 사용 중입니다. </p>
     	<br />
     	<form action="<%=request.getContextPath()%>/member/checkIdDuplicate"
     		  method="POST"
     		  onsubmit="return idValidate();">
     		<input type="text" name="memberId" id="memberId" 
     			   placeholder="아이디를 입력하세요." />
     		&nbsp;&nbsp;
     		<button type="submit">중복검사</button>
     	</form>
    <% } %>
    </div>
    <script>
    function setMemberId(){
    	//부모창의 memberEnrollFrm에 접근
    	//부모창의 window객체를 가리킨다.
    	let frm = opener.document.memberEnrollFrm;
    	frm.memberId.value = "<%=memberId%>";
    	frm.idValid.value = 1;
    	
    	self.close();
    	
    }
    
    function idValidate(){
    	let memberId = $("#memberId").val().trim();
    	if(memberId.length < 4){
    		alert("아이디는 4글자 이상 가능합니다.");
    		return false;
    	}
    	
    	return true;
    }
    
    
    </script>
</body>
</html>
