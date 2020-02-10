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
            username: 'testid',
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
        

        if (new Date(eventData.start).setDate(0) <= (new Date()).setDate(+1)) {
        	alert('현재부터 24시간 후부터 예약 가능합니다.');
        	return false;
        }
        

        if (eventData.title === '') {
            alert('일정명은 필수입니다.');
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
        
        //create element (form)
        var form = document.createElement('form');
        //set attribute (form)
        form.name = 'newForm';
        form.method = 'post';
        form.action = '/SDG/res/resInsert';
//        form.target = '_blank'; // 이건 새창
        
        //create element (input)
        var input1 = document.createElement('input');
        var input2 = document.createElement('input');
        var input3 = document.createElement('input');
        var input4 = document.createElement('input');
        var input5 = document.createElement('input');
        
        //set attribute (input)
        input1.setAttribute("type", "text");
        input1.setAttribute("name", "memberId");
        input1.setAttribute("value", eventData.title);
        input2.setAttribute("type", "text");
        input2.setAttribute("name", "resMany");
        input2.setAttribute("value", eventData.resMany);        
        input3.setAttribute("type", "text");
        input3.setAttribute("name", "startTime");
        input3.setAttribute("value", eventData.start);
        input4.setAttribute("type", "text");
        input4.setAttribute("name", "endTime");
        input4.setAttribute("value", eventData.end);
        input5.setAttribute("type", "text");
        input5.setAttribute("name", "resContent");
        input5.setAttribute("value", eventData.description);
        
        
        
        //append input (to form)
        form.appendChild(input1);
        form.appendChild(input2);
        form.appendChild(input3);
        form.appendChild(input4);
        form.appendChild(input5);
        
        //append form (to body)
        document.body.appendChild(form);

        // submit form
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