<!doctype html>
<html>
    <head>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js"></script>
        <script src="<%=request.getContextPath()%>/galleria/galleria.min.js"></script>
        <style>
		    .galleria{ width: 700px; height: 400px; background: #000 }
		</style>
    </head>
    <body>
		<div id="divGall" class="galleria">
			
        </div>
        
    <script>
        (function() {
            Galleria.loadTheme('<%=request.getContextPath()%>/galleria/themes/twelve/galleria.twelve.min.js');
            Galleria.run('.galleria');
        }());
        var imgArr = new Array();
        var imgTitles = <%=request.getParameter("spcImgs")%>;
        var imgSplit = imgTitles.split("''");
        for(var i in imgSplit){
        	var imgTag = "<img src=<%=request.getContextPath()%>/upload/"+imgSplit[i]+">";
        	$("#divGall").append(imgTag);
        }
    </script>
    </body>
</html>