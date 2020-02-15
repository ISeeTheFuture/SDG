<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
<script src="<%=request.getContextPath()%>/galleria/galleria.min.js"></script>

<div class="galleria">
    <img src="<%=request.getContextPath()%>/upload/20200213_163826391_916.jpg">
    <img src="<%=request.getContextPath()%>/upload/20200213_164308713_5.png">
    <img src="<%=request.getContextPath()%>/upload/20200213_164015917_422.png">
</div>
<script>
(function() {
    Galleria.loadTheme('<%=request.getContextPath()%>/galleria/themes/twelve/galleria.twelve.min.js');
    Galleria.run('.galleria');
}());
</script>

<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<p>--------------------------------------------------------------------------------------------------------</p>
<iframe src="<%=request.getContextPath()%>/res/resView?spcNo=<%=request.getParameter("spcNo")%>" width='1200' height='1000' scrolling='auto'></iframe>



