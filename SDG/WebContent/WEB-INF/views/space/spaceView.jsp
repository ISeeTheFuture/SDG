<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
<script src="<%=request.getContextPath()%>/galleria/galleria.min.js"></script>

<div id="spcTitle">
	<h1><%=request.getAttribute("spcTitle")%></h1>
	<h4><%=request.getAttribute("spcLoc")%> / <%=request.getAttribute("spcType")%></h4>
</div>
<div id="spcSide">
	<h3><%=request.getAttribute("spcText")%></h3>
	<h4>공간유형 : <%=request.getAttribute("spcType")%></h4>
	<h4>공간주소 : <%=request.getAttribute("spcAddr")%></h4>
	<h4>예약시간 : 최소 <%=request.getAttribute("spcTimeMin")%> ~ 최대 <%=request.getAttribute("spcTimeMax")%></h4>
	<h4>예약인원 : 최소 <%=request.getAttribute("spcManMin")%> ~ 최대 <%=request.getAttribute("spcManMax")%></h4>
	<h4>가격 : <%=request.getAttribute("spcPrice")%>원/시간(인)</h4>
</div>


<div id="divGall" class="galleria">

</div>
<script>
(function() {
    Galleria.loadTheme('<%=request.getContextPath()%>/galleria/themes/twelve/galleria.twelve.min.js');
    Galleria.run('.galleria');
}());

var imgArr = new Array();
var imgTitles = <%=request.getAttribute("spcImgs")%>;
var imgSplit = imgTitles.split("''");
for(var i in imgSplit){
	var imgTag = "<img src=<%=request.getContextPath()%>/upload/"+imgSplit[i]+">";
	$("#divGall").append(imgTag);
}

</script>

<br />
<br />
<br />
<br />
<br />
<br />
<br />
<p>--------------------------------------------------------------------------------------------------------</p>
<iframe src="<%=request.getContextPath()%>/res/resView?spcNo=<%=request.getParameter("spcNo")%>" width='1200' height='1000' scrolling='auto'></iframe>



