var eventModal = $('#eventModal');

var modalTitle = $('.modal-title');
var editAllDay = $('#edit-allDay');
var editTitle = $('#edit-title');
var editStart = $('#edit-start');
var editEnd = $('#edit-end');
var editType = $('#edit-type');
var editResMany = $('#edit-resMany');
var editColor = $('#edit-color');
var editDesc = $('#edit-desc');
var spcTimeMin = $('#spcTimeMin');
var spcTimeMax = $('#spcTimeMax');
var spcManMin = $('#spcManMin');
var spcManMax = $('#spcManMax');


var editResManyLabel = $('#edit-resMany-label');
var editDescLabel = $('#edit-desc-label');

var addBtnContainer = $('.modalBtnContainer-addEvent');
var modifyBtnContainer = $('.modalBtnContainer-modifyEvent');
var viewBtnContainer = $('.modalBtnContainer-viewEvent');



/* ****************
 *  새로운 일정 생성
 * ************** */
var newEvent = function (start, end, eventType) {

    $("#contextMenu").hide(); //메뉴 숨김

    modalTitle.html('예약하기');
    editStart.val(start);
    editEnd.val(end);
    editType.val(eventType).prop("selected", true);

    // 닫기버튼 보여주기
    addBtnContainer.show();
    modifyBtnContainer.hide();
    viewBtnContainer.hide();
    eventModal.modal('show');

    //  메뉴 보여주기
    editResMany.show();
    editResManyLabel.show();
    editDesc.show();
    editDescLabel.show();
    
    
    
    /******** 임시 RAMDON ID - 실제 DB 연동시 삭제 **********/
    var eventId = 1 + Math.floor(Math.random() * 1000);
    /******** 임시 RAMDON ID - 실제 DB 연동시 삭제 **********/

    //새로운 일정 예약버튼 클릭
    $('#save-event').unbind();
    $('#save-event').on('click', function () {

        var eventData = {
            _id: eventId,
            title: editTitle.val(),
            start: editStart.val(),
            end: editEnd.val(),
            description: editDesc.val(),
            type: editType.val(),
            resMany: editResMany.val(),
            username: editTitle.val(),
            backgroundColor: editColor.val(),
            textColor: '#ffffff',
            allDay: false
        };

        
        if (eventData.start > eventData.end) {
            alert('끝나는 날짜가 앞설 수 없습니다.');
            console.log(eventData.start);
            console.log(new Date());
            return false;
        }
 
        if(new Date(eventData.start).getMinutes() !== 0 || new Date(eventData.end).getMinutes() !== 0 || eventData.start == eventData.end){
        	alert('예약은 1시간 단위만 가능합니다.');
        	return false;
        }
        if (new Date(eventData.start) <= new Date(new Date().setDate(new Date().getDate() + 1))) {        	
        	alert('현재부터 24시간 후부터 예약 가능합니다.');
        	return false;
        }
        
        var hourDiff = (new Date(eventData.end)-new Date(eventData.start))/(60*60*1000);
        if(hourDiff < spcTimeMin.val()){
        	alert("예약시간이 최소치 "+spcTimeMin.val()+"시간에 미달합니다.");
        	return false;
        }else if(hourDiff > spcTimeMax.val()){
        	alert("예약시간이 최대치 "+spcTimeMax.val()+"시간을 초과하였습니다.");
        	return false;
        }
        if(editResMany.val()-spcManMin.val() < 0){
        	alert("예약인원이 최소치 "+spcManMin.val()+"명에 미달합니다.");
        	return false;
        }else if(editResMany.val()-spcManMax.val() > 0){
        	alert("예약인원이 최대치 "+spcManMax.val()+"명을 초과하였습니다.");
        	return false;
        }
        

        if (eventData.title === '') {
            alert('잘못된 접근입니다.');
            return false;
        }

        var realEndDay;

        if (editAllDay.is(':checked')) {
            eventData.start = moment(eventData.start).format('YYYY-MM-DD');
            //render시 날짜표기수정
            eventData.end = moment(eventData.end).add(1, 'days').format('YYYY-MM-DD');
            //DB에 넣을때(선택)
            realEndDay = moment(eventData.end).format('YYYY-MM-DD');

            eventData.allDay = true;
        }

        $("#calendar").fullCalendar('renderEvent', eventData, true);
        eventModal.find('input, textarea').val('');
        editAllDay.prop('checked', false);
        eventModal.modal('hide');

        //새로운 예약 저장 페이지로 이동
        
        //폼 태그 생성
        var form = document.createElement('form');
        //폼 속성 set attribute
        form.name = 'newForm';
        form.method = 'post';
        form.action = getContextPath()+'/res/resInsert';
        form.target = 'parentFrame';        
        //input 태그 생성
        var input1 = document.createElement('input');
        var input2 = document.createElement('input');
        var input3 = document.createElement('input');
        var input4 = document.createElement('input');
        var input5 = document.createElement('input');
        var input6 = document.createElement('input');
        //input태그에 set attribute
        input1.setAttribute("type", "hidden");
        input1.setAttribute("name", "memberId");
        input1.setAttribute("value", eventData.title);
        input2.setAttribute("type", "hidden");
        input2.setAttribute("name", "resMany");
        input2.setAttribute("value", eventData.resMany);        
        input3.setAttribute("type", "hidden");
        input3.setAttribute("name", "startTime");
        input3.setAttribute("value", eventData.start);
        input4.setAttribute("type", "hidden");
        input4.setAttribute("name", "endTime");
        input4.setAttribute("value", eventData.end);
        input5.setAttribute("type", "hidden");
        input5.setAttribute("name", "resContent");
        input5.setAttribute("value", eventData.description);
        input6.setAttribute("type", "hidden");
        input6.setAttribute("name", "spcNo");
        input6.setAttribute("value", spcNo);
        //완성된 input 태그를 form에 append
        form.appendChild(input1);
        form.appendChild(input2);
        form.appendChild(input3);
        form.appendChild(input4);
        form.appendChild(input5);
        form.appendChild(input6);
        //form 태그
        document.body.appendChild(form);
        // form 제출
        form.submit();
        
        
//        $.ajax({
//            type: "get",
//            url: "",
//            data: {
//                //.....
//            },
//            success: function (response) {
//                //DB연동시 중복이벤트 방지를 위한
//                //$('#calendar').fullCalendar('removeEvents');
//                //$('#calendar').fullCalendar('refetchEvents');
//            }
//        });
    });
};