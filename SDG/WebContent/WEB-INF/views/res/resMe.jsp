<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
<div id="resContainer">
	<div class="row">
    	<div class="col-lg-4 mb-4">
			<iframe src="<%=request.getContextPath()%>/res/resUpdate" width='750' height='700' frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0></iframe>		
		</div>
	</div>
	<div class="row" id="resMeList">
	
	</div>
</div>

<div>

</div>

<script>
$(function(){
	$.ajax({
		url: "<%=request.getContextPath()%>/res/resMeEnd.do",
		type: "post",
        data: { 
            memberId: "<%=memberLoggedIn.getMemId()%>",
        },
		dataType: "json",
		success: function(data) {
			
				var resMeResult = "<div class='row'><div class='row'>";
				
				$.each(data, function(idx, d){ // 배열 요소당 한번씩 콜백함수를 호출
					var tmp = "<%=request.getContextPath()%>/upload/"+d.spcImgTitle;
					var act = "<%=request.getContextPath()%>/space/spaceView";
					resMeResult += "<p class='srchContent col-lg-4 mb-4' name='srchContent"+d.resNo+"'><div class='card h-100'><img class='card-img-top' src="+tmp+" alt='' width='700px' height='300px'>";
 					resMeResult += "<div class='card-body'><h4 class='card-title'>"+d.spcName+"</h4>";
					resMeResult += "<h5>"+d.spcPrice+"원/시간(인)</h5>";
					resMeResult += "<p class='card-text'>"+d.resTimeStart+"/"+d.resTimeEnd+"</p></div>";
					resMeResult += "<div class='card-footer'><small class='text-muted'>&#9733; &#9733; &#9733; &#9733; &#9734;</small>";
					resMeResult += "<input type='hidden' name='spcNo' class='spcNo' value="+d.spcNo+">";
					resMeResult += "<input type='hidden' name='spcTimeEnd' value="+d.resTimeEnd+">";
					resMeResult += "<input type='hidden' name='spcDetNo' class='spcDetNo' value="+d.spcDetNo+"></div></div></p>";	
			});
				resMeResult += "</div></div>";
			$("#resMeList").html(resMeResult);
		},
		error: (x,s,e) => {
			//x : xhr
			//s : testStatus
			//e : errorThrown
			console.log(x,s,e);
		}, complete: function(data) {
/* 			$(".srchContent").click(function(){
				var srchNo = $(this).attr('name')
				$("#"+srchNo+"").submit();
			}); */
		}
	});
});
</script>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>