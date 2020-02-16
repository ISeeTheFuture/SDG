<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
<script src="https://cdn.bootpay.co.kr/js/bootpay-3.0.2.min.js" type="application/javascript"></script>
	
	<form action="<%=request.getContextPath()%>/res/resForm" method="post">		
		<input type="hidden" id="resGroupNo" name="resGroupNo" value="1" readonly/>
		<input type="hidden" id="spcNo" name="spcNo" value="<%=request.getAttribute("spcNo")%>" readonly/>
		<label for="memberId">아이디</label>
		<input type="text" id="memberId" name="memberId" value="<%=request.getAttribute("memberId")%>" readonly/>
		<br />
		<label for="resMany">인원</label>
		<input type="number" id="resMany" name="resMany" value="<%=request.getAttribute("resMany")%>" min="<%=request.getAttribute("spcManMin")%>" max="<%=request.getAttribute("spcManMax")%>"/>
		<br />
		<label for="resName">신청자명</label>
		<input type="text" id="resName" name="resName" value="<%=memberLoggedIn.getMemName()%>"/>
		<br />
		<label for="resPhone">연락처</label>
		<input type="text" id="resPhone" name="resPhone" value="<%=memberLoggedIn.getMemPhone()%>"/>
		<br />
		<label for="resEmail">이메일</label>
		<input type="text" id="resEmail" name="resEmail" value="<%=memberLoggedIn.getMemEmail()%>"/>
		<br />
		<label for="resAddr">주소</label>
		<input type="text" id="resAddr" name="resAddr" value="<%=memberLoggedIn.getMemAddr()%>"/>
		<br />
		<label for="resStartDate">시작날짜</label>
		<input type="date" id="resStartDate" name="resStartDate" value="<%=request.getAttribute("resStartDate")%>"/>
		<label for="resStartTime">시작시간</label>
		<select name="resStartTime" id="resStartTime">
			<option value="00">00시</option>
			<option value="01">01시</option>
			<option value="02">02시</option>
			<option value="03">03시</option>
			<option value="04">04시</option>
			<option value="05">05시</option>
			<option value="06">06시</option>
			<option value="07">07시</option>
			<option value="08">08시</option>
			<option value="09">09시</option>
			<option value="10">10시</option>
			<option value="11">11시</option>
			<option value="12">12시</option>
			<option value="13">13시</option>
			<option value="14">14시</option>
			<option value="15">15시</option>
			<option value="16">16시</option>
			<option value="17">17시</option>
			<option value="18">18시</option>
			<option value="19">19시</option>
			<option value="20">20시</option>
			<option value="21">21시</option>
			<option value="22">22시</option>
			<option value="23">23시</option>
		</select>
		<br />
		<label for="resEndDate">종료시간</label>
		<input type="date" id="resEndDate" name="resEndDate" value="<%=request.getAttribute("resEndDate")%>"/>
		<label for="resEndTime">종료시간</label>
		<select name="resEndTime" id="resEndTime">
			<option value="00">00시</option>
			<option value="01">01시</option>
			<option value="02">02시</option>
			<option value="03">03시</option>
			<option value="04">04시</option>
			<option value="05">05시</option>
			<option value="06">06시</option>
			<option value="07">07시</option>
			<option value="08">08시</option>
			<option value="09">09시</option>
			<option value="10">10시</option>
			<option value="11">11시</option>
			<option value="12">12시</option>
			<option value="13">13시</option>
			<option value="14">14시</option>
			<option value="15">15시</option>
			<option value="16">16시</option>
			<option value="17">17시</option>
			<option value="18">18시</option>
			<option value="19">19시</option>
			<option value="20">20시</option>
			<option value="21">21시</option>
			<option value="22">22시</option>
			<option value="23">23시</option>
		</select>
		<br />
		<label for="resContent">요청사항</label>
		<textarea name="resContent" id="resContent" cols="30" rows="10" ><%=request.getAttribute("resContent")%></textarea>
		<br />

		<hr />
		
		<hr />
		<input type="button" id="payReq" value="결제하기" onclick="return BootPay.request();"/>
	</form>


<script>
$("#resStartTime").val("<%=request.getAttribute("resStartTime")%>").attr("selected", "selected");
$("#resEndTime").val("<%=request.getAttribute("resEndTime")%>").attr("selected", "selected");

var startDate = new Date($("#resStartDate").val());
var startTime = startDate.setHours(startDate.getHours()+$("#resStartTime").val());
var endDate = new Date($("#resEndDate").val());
var endTime = endDate.setHours(endDate.getHours()+$("#resEndTime").val());
var diffTime = (endTime-startTime)/(60*60*1000);
var finalPrice = diffTime * $("#resMany").val() * <%=request.getAttribute("spcPrice")%>;

$("#payReq").click(function(){
	if($("#resMany").val() < <%=request.getAttribute("spcManMin")%>){
    	alert('예약인원이 최소치 <%=request.getAttribute("spcManMin")%>명에 미달합니다.');
    	return false;
	} else if($("#resMany").val() > <%=request.getAttribute("spcManMax")%>){
    	alert('예약인원이 최대치 <%=request.getAttribute("spcManMax")%>명을 초과합니다.');
    	return false;
	} else if($("#resMany").val()==null){
    	alert("예약인원을 입력하세요");
    	return false;
	}
	

	if(diffTime<0){
		alert('예약 종료일이 시작일보다 빠를 수 없습니다.');
		return false;
	} else if(diffTime<1){
		alert('최소 1시간 이상 예약해 주세요');
		return false;
	} else if(diffTime < <%=request.getAttribute("spcTimeMin")%>){
		alert('예약시간이 최소치 <%=request.getAttribute("spcTimeMax")%> 시간에 미달합니다.')
		return false;
	} else if(diffTime > <%=request.getAttribute("spcTimeMax")%>){
		alert('예약시간이 최대치 <%=request.getAttribute("spcTimeMax")%> 시간을 초과합니다.')
		return false;
	}
	

	
	BootPay.request({
		price: finalPrice, //실제 결제되는 가격
		application_id: "5e483dd95ade160029432138",
		name: $("#resName").val(), //결제창에서 보여질 이름
		pg: '',
		method: '', //결제수단, 입력하지 않으면 결제수단 선택부터 화면이 시작합니다.
		show_agree_window: 0, // 부트페이 정보 동의 창 보이기 여부
		items: [
			{
				item_name: '<%=request.getAttribute("spcTitle")%>', //상품명
				qty: diffTime * $("#resMany").val(), //수량
				unique: '<%=request.getAttribute("spcNo")%>', //해당 상품을 구분짓는 primary key
				price: '<%=request.getAttribute("spcPrice")%>', //상품 단가
				cat1: '<%=request.getAttribute("spcLoc")%>', // 대표 상품의 카테고리 상, 50글자 이내
				cat2: '<%=request.getAttribute("spcType")%>', // 대표 상품의 카테고리 중, 50글자 이내
			}
		],
		user_info: {
			username: $("#resName").val(),
			email: $("#resEmail").val(),
			addr: $("#resAddr").val(),
			phone: $("#resPhone").val()
		},
		order_id: new Date()+""+Math.random()*100, //고유 주문번호로, 생성하신 값을 보내주셔야 합니다.
		params: {callback1: '그대로 콜백받을 변수 1', callback2: '그대로 콜백받을 변수 2', customvar1234: '변수명도 마음대로'},
		account_expire_at: new Date(new Date().getDate()+3), // 가상계좌 입금기간 제한 ( yyyy-mm-dd 포멧으로 입력해주세요. 가상계좌만 적용됩니다. )
		extra: {
		    start_at: '', // 정기 결제 시작일 - 시작일을 지정하지 않으면 그 날 당일로부터 결제가 가능한 Billing key 지급
			end_at: '', // 정기결제 만료일 -  기간 없음 - 무제한
	        vbank_result: 1, // 가상계좌 사용시 사용, 가상계좌 결과창을 볼지(1), 말지(0), 미설정시 봄(1)
	        quota: '0' // 결제금액이 5만원 이상시 할부개월 허용범위를 설정할 수 있음, [0(일시불), 2개월, 3개월] 허용, 미설정시 12개월까지 허용
		}
	}).error(function (data) {
		//결제 진행시 에러가 발생하면 수행됩니다.
		console.log(data);
		return false
	}).cancel(function (data) {
		console.log(data);
		return false
	}).ready(function (data) {
		// 가상계좌 입금 계좌번호가 발급되면 호출되는 함수입니다.
		console.log(data);
	}).confirm(function (data) {
		//결제가 실행되기 전에 수행되며, 주로 재고를 확인하는 로직이 들어갑니다.
		//주의 - 카드 수기결제일 경우 이 부분이 실행되지 않습니다.
		console.log(data);
		var enable = true; // 재고 수량 관리 로직 혹은 다른 처리
		if (enable) {
			BootPay.transactionConfirm(data); // 조건이 맞으면 승인 처리를 한다.
		} else {
			BootPay.removePaymentWindow(); // 조건이 맞지 않으면 결제 창을 닫고 결제를 승인하지 않는다.
		}
	}).close(function (data) {
	    // 결제창이 닫힐때 수행됩니다. (성공,실패,취소에 상관없이 모두 수행됨)
	    console.log(data);
	}).done(function (data) {
		//결제가 정상적으로 완료되면 수행됩니다
		//비즈니스 로직을 수행하기 전에 결제 유효성 검증을 하시길 추천합니다.
		return true
		console.log(data);
	});
})


</script>