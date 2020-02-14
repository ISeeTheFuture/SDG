<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
#preview {
	display: none;
}
</style>
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
<script>
	function validate() {
		let specialCharRegExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/gi;
		let spcName = $('#spcName').val();
		let regionNo = $('#region').val();
		let spcContent = $('#spcContent').val();
		let spcDetSize = $('#spcDetSize').val();
		let spcDetStorable = $('#spcDetStorable').val();
		let spcManMin = $('#spcManMin').val();
		let spcManMax = $('#spcManMax').val();
		let spcTimeMin = $('#spcTimeMin').val();
		let spcTimeMax = $('#spcTimeMax').val();
		let spcDateStart = $('#spcDateStart').val();
		let spcDateEnd = $('#spcDateEnd').val();
		let spcPrice = $('#spcPricePrice').val();
		let result = 1;
		

		if (specialCharRegExp.test(spcName)) {
			$("#spcName").css("border", "3px solid red");
			alert("공간명에는 특수문자를 제거해주세요");
			result = 0;
		} else if (spcName == "") {
			$("#spcName").css("border", "3px solid red");
			$("#spcName").val("공간명을 입력해주세요");
			result = 0;
		}

		if (regionNo == null) {
			$("#region").css("border", "3px solid red");
			result = 0;
		}

		if (spcContent == "") {
			$("#spcContent").css("border", "3px solid red");
			$('#spcContent').val("소개글 없음");
			result = 0;
		}

		if (spcDetSize == "") {
			$("#spcDetSize").css("border", "3px solid red");
			$('#spcDetSize').val(100);
			result = 0;
		}

		if (spcDetStorable == "") {
			$("#spcDetStorable").css("border", "3px solid red");
			$('#spcDetStorable').val(100);
			result = 0;
		}

		if (spcManMin == "") {
			$("#spcManMin").css("border", "3px solid red");
			$('#spcManMin').val(100);
			result = 0;
		}

		if (spcManMax == "") {
			$("#spcManMax").css("border", "3px solid red");
			$('#spcManMax').val(100);
			result = 0;
		}

		if (spcTimeMin == "") {
			$("#spcTimeMin").css("border", "3px solid red");
			$('#spcTimeMin').val(100);
			result = 0;
		}

		if (spcTimeMax == "") {
			$("#spcTimeMax").css("border", "3px solid red");
			$('#spcTimeMax').val(100);
			result = 0;
		}

		if (spcDateStart == "") {
			$("#spcDateStart").css("border", "3px solid red");
			$('#spcDateStart').val('2020-02-14');
			result = 0;
		}

		if (spcDateEnd == "") {
			$("#spcDateEnd").css("border", "3px solid red");
			$('#spcDateEnd').val('2020-02-15');
			result = 0;
		}

		if (spcPrice == "") {
			$("#spcPricePrice").css("border", "3px solid red");
			$("#spcPricePrice").val("10000");
			result = 0;
		}

		if (result == 0) {
			return false;
		}

		return true;
	}
</script>
<style>
.detinfo {
	font-size: 2em;
}

.divider-text {
	position: relative;
	text-align: center;
	margin-top: 15px;
	margin-bottom: 15px;
}

.divider-text span {
	padding: 7px;
	font-size: 12px;
	position: relative;
	z-index: 2;
}

.divider-text:after {
	content: "";
	position: absolute;
	width: 100%;
	border-bottom: 1px solid #ddd;
	top: 55%;
	left: 0;
	z-index: 1;
}

.input-group-text {
	min-width: 90px;
}

p.text-center {
	font-size: 2em;
}
</style>
</head>
<body>

	<%
		String cat = request.getParameter("cat");
		String memberId = request.getParameter("memberId");
	%>

	<link
		href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		rel="stylesheet" id="bootstrap-css">
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<!------ Include the above in your HEAD tag ---------->

	<link rel="stylesheet"
		href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">






	<div class="container">
		<br>
		<p class="text-center">세부정보 등록</p>
		<hr>
	</div>





	<div class="card bg-light">
		<article class="card-body mx-auto" style="max-width: 400px;">


			<form onsubmit="return validate();"
				action="<%=request.getContextPath()%>/space/spaceRegformEnd"
				method="POST" enctype="multipart/form-data">
				<input type="hidden" name="cat" value="<%=cat %>" /> <input
					type="hidden" name="memberId" value="<%=memberId %>" /> <input
					type="hidden" name="spcDay" value="mon"> <input
					type="hidden" name="spcDay" value="tue"> <input
					type="hidden" name="spcDay" value="wed"> <input
					type="hidden" name="spcDay" value="thu"> <input
					type="hidden" name="spcDay" value="fri"> <input
					type="hidden" name="spcDay" value="sat"> <input
					type="hidden" name="spcDay" value="sun"> <input
					type="hidden" name="spcDetHoliday" value="0" /> <input
					type="hidden" name="spcDetSharing" value="0" /> <input
					type="hidden" name="spcExcDate" id="spcExcDate" value="2020-02-12" />

				<input type="hidden" name="spcExcStart" id="spcExcStart" value="0" />

				<input type="hidden" name="spcExcEnd" id="spcExcEnd" value="0" />

				<input type="hidden" name="spcDetName" id="spcDetName" value="기본요금">

				<input type="hidden" name="spcPriceDay" value="mon" /> <input
					type="hidden" name="spcPriceDay" value="tue" /> <input
					type="hidden" name="spcPriceDay" value="wed" /> <input
					type="hidden" name="spcPriceDay" value="thu" /> <input
					type="hidden" name="spcPriceDay" value="fri" /> <input
					type="hidden" name="spcPriceDay" value="sat" /> <input
					type="hidden" name="spcPriceDay" value="sun" /> <input
					type="hidden" name="spcPricePer" value="1">

				<div id="preview"></div>
				<div class="form-group input-group">
					<div class="input-group-prepend">
						<br /> <br /> <span class="input-group-text">사진첨부</span> <br />
						<input type="file" name="spcImgFile" id="spcImgFile"
							accept=".jpg, .png" class="spcImgFile" multiple />
					</div>
				</div>
				<!-- form-group// -->



				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">지역</span>
					</div>
					<select name="region" id="region" class="custom-select">
						<option disabled selected value>지역</option>
						<option disabled>----------</option>
						<option value="1">서울특별시</option>
						<option value="2">경기도</option>
						<option value="3">인천광역시</option>
						<option value="4">세종특별시</option>
						<option value="5">충청북도</option>
						<option value="6">충청남도</option>
						<option value="7">강원도</option>
						<option value="8">대전광역시</option>
						<option value="9">대구광역시</option>
						<option value="10">경상북도</option>
						<option value="11">경상남도</option>
						<option value="12">부산광역시</option>
						<option value="13">울산광역시</option>
						<option value="14">전라북도</option>
						<option value="15">전라남도</option>
						<option value="16">광주광역시</option>
						<option value="17">제주도</option>
					</select>
				</div>
				<!-- form-group// -->

				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">공간명</span>
					</div>
					<input type="text" name="spcName" id="spcName" class="form-control" />
				</div>
				<!-- form-group// -->

				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">주소</span>
					</div>
					<input type="text" name="addr" id="addr" class="form-control" />
				</div>
				<!-- form-group// -->

				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">공간 소개</span>
					</div>
					<textarea name="spcContent" id="spcContent" class="form-control" /></textarea>
				</div>
				<!-- form-group// -->


				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">크기(m2)</span>
					</div>
					<input type="number" name="spcDetSize" id="spcDetSize"
						class="form-control" />
				</div>
				<!-- form-group// -->


				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">수용인원</span>
					</div>
					<input type="number" name="spcDetStorable" id="spcDetStorable"
						class="form-control" />
				</div>
				<!-- form-group// -->


				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">최소인원</span>
					</div>
					<input type="number" name="spcManMin" id="spcManMin" min="1"
						placeholder="1" class="form-control" />
				</div>
				<!-- form-group// -->


				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">최대인원</span>
					</div>
					<input type="number" name="spcManMax" id="spcManMax" min="1"
						placeholder="1" class="form-control" />
				</div>
				<!-- form-group// -->

				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">최소시간</span>
					</div>
					<input type="number" name="spcTimeMin" id="spcTimeMin" min="1"
						placeholder="1" class="form-control" />
				</div>


				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">최대시간</span>
					</div>
					<input type="number" name="spcTimeMax" id="spcTimeMax" min="1"
						placeholder="1" class="form-control" />
				</div>

				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">운영시작 날짜</span>
					</div>
					<input type="date" name="spcDateStart" id="spcDateStart"
						class="form-control" />
				</div>


				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">운영종료 날짜</span>
					</div>
					<input type="date" name="spcDateEnd" id="spcDateEnd"
						class="form-control" />
				</div>



				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">운영 시작 시간</span>
					</div>
					&nbsp;&nbsp; <span class="font-weight-bold indigo-text mr-2 mt-1">0</span>
					<input type="range" name="spcHourStart" id="spcHourStart" min="0"
						max="24" step="1" class="border-0" value="12"
						oninput="document.getElementById('value1').innerHTML=this.value;" />
					<span class="font-weight-bold indigo-text ml-2 mt-1" id="value1"></span>
				</div>


				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">운영 마감 시간</span>
					</div>
					&nbsp;&nbsp; <span class="font-weight-bold indigo-text mr-2 mt-1">0</span>
					<input type="range" name="spcHourEnd" id="spcHourEnd" min="0"
						max="24" step="1" class="border-0" value="12"
						oninput="document.getElementById('value2').innerHTML=this.value;" />
					<span class="font-weight-bold indigo-text ml-2 mt-1" id="value2"></span>
				</div>


				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">가격</span>
					</div>
					<input type="text" name="spcPricePrice" id="spcPricePrice"
						class="form-control" />
				</div>

				<div class="form-group">
					<button class="btn btn-primary btn-block">등록</button>
				</div>
			</form>
		</article>
	</div>











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
</body>
<script>
	$(document).ready(function() {
		// 태그에 onchange를 부여한다.
		$('#spcImgFile').change(function() {
			addPreview($(this)); //preview form 추가하기
		});
	});
	// image preview 기능 구현
	// input = file object[]
	function addPreview(input) {
		if (input[0].files) {
			//파일 선택이 여러개였을 시의 대응
			for (var fileIndex = 0; fileIndex < input[0].files.length; fileIndex++) {
				var file = input[0].files[fileIndex];
				var reader = new FileReader();
				reader.onload = function(img) {
					//div id="preview" 내에 동적코드추가.
					//이 부분을 수정해서 이미지 링크 외 파일명, 사이즈 등의 부가설명을 할 수 있을 것이다.
					$("#preview").append(
							"<img src=\"" + img.target.result + "\"\"/>");
					$("#preview").css("display", "block");
					$("img").css("width", "50px");
				};
				reader.readAsDataURL(file);
			}
		} else
			alert('invalid file input'); // 첨부클릭 후 취소시의 대응책은 세우지 않았다.
	}
</script>

</html>