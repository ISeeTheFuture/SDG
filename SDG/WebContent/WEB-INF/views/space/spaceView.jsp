<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>


  <!-- Page Content -->
<div class="container">
	<div class="row">

      <!-- Post Content Column -->
      	<div class="col-lg-8">

        <!-- Title -->
	        <h1 class="mt-4"><%=request.getAttribute("spcTitle")%></h1>
	
	        <!-- subTitle -->
	        <p class="lead"><%=request.getAttribute("spcLoc")%> / <%=request.getAttribute("spcType")%></p>
	
	        <hr>
	
	        <!-- Preview Image -->
			<iframe src="<%=request.getContextPath()%>/space/Galleria?spcImgs=<%=request.getAttribute("spcImgs")%>" width='720' height='440' frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0></iframe>
	        <hr>
		<div id="resContainer">
			<iframe src="<%=request.getContextPath()%>/res/resView?spcNo=<%=request.getParameter("spcNo")%>" width='750' height='700' frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0></iframe>		
		</div>
        <!-- Post Content -->
        <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ducimus, vero, obcaecati, aut, error quam sapiente nemo saepe quibusdam sit excepturi nam quia corporis eligendi eos magni recusandae laborum minus inventore?</p>

        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ut, tenetur natus doloremque laborum quos iste ipsum rerum obcaecati impedit odit illo dolorum ab tempora nihil dicta earum fugiat. Temporibus, voluptatibus.</p>

        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eos, doloribus, dolorem iusto blanditiis unde eius illum consequuntur neque dicta incidunt ullam ea hic porro optio ratione repellat perspiciatis. Enim, iure!</p>

        <blockquote class="blockquote">
	        <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
	        <footer class="blockquote-footer">Someone famous in
	          <cite title="Source Title">Source Title</cite>
	        </footer>
        </blockquote>

        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Error, nostrum, aliquid, animi, ut quas placeat totam sunt tempora commodi nihil ullam alias modi dicta saepe minima ab quo voluptatem obcaecati?</p>

        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Harum, dolor quis. Sunt, ut, explicabo, aliquam tenetur ratione tempore quidem voluptates cupiditate voluptas illo saepe quaerat numquam recusandae? Qui, necessitatibus, est!</p>

        <hr>

		<hr />
		
		<div id="resContainer">
			<iframe src="<%=request.getContextPath()%>/review/reviewList?spcNo=<%=request.getParameter("spcNo")%>" width='900' height='700' frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=auto vspace=0></iframe>		
		</div>



        <div class="media mb-4">
        	<div class="media-body">
       	
       		</div>
		</div>

</div>

      <!-- Sidebar Widgets Column -->
      <div class="col-md-4">

        <!-- Side Widget -->
        <div class="card my-4">
          <h5 class="card-header">간략 정보</h5>
          <div class="card-body">
            	<h5><%=request.getAttribute("spcText")%></h3>
				<hr />
				<h4>공간유형 : <%=request.getAttribute("spcType")%></h4>
				<hr />
				<h5>공간주소 : <%=request.getAttribute("spcAddr")%></h4>
				<hr />
				<h5>예약시간 : 최소 <%=request.getAttribute("spcTimeMin")%>시간 ~ 최대 <%=request.getAttribute("spcTimeMax")%>시간</h4>
				<h5>예약인원 : 최소 <%=request.getAttribute("spcManMin")%>명 ~ 최대 <%=request.getAttribute("spcManMax")%>명</h4>
				<hr />
				<h4>가격 : <%=request.getAttribute("spcPrice")%>원/시간(인)</h4>
				<span class="input-group-btn">
                	<button id="resBtn" class="btn btn-secondary btn-lg" type="button">예약하기</button>
              </span>
          </div>
        </div>

      </div>

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->
  
  <script>
  	$("#resContainer").slideUp(0);
  	$("#resBtn").click(function(){
  		if(<%=memberLoggedIn==null%>){
	  		alert("로그인이 필요합니다");
			return false;
  		}
		$("#resContainer").slideDown();
		return true;	
  	});
  	window.name = "parentFrame"
  </script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>