<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
	String loc = (String)request.getAttribute("loc");
	String script = (String)request.getAttribute("script");
	
%>
<script>
	alert("<%=msg%>");
	
	//스크립트 입력이 있는 경우에만 script출력
	<%= script!=null?script:""%>
	
	location.href = "<%=request.getContextPath() + loc%>";
</script>