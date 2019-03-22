function clicked(clicked) {
    $.ajax({
        type: "POST",
        url: "/",
        data: {answer:clicked},
        success: function (msg) {
            title=msg.split("---")[0];
            html=msg.split("---")[1];
            $('.questionText').text(title);
            $('.questionMain').html(html);
        }
    });
}

function beanClicked(number) {
    for(i=1; i<7; i++){
        if (number>=i){
            $('#bean'+i).attr("src","img/beanOn.png");
        }else{
            $('#bean'+i).attr("src","img/beanOff.png");
        }
    }
    $('#stength').val(number);
}

function sendStrength() {
    answerval=$('#strength').val();
    $.ajax({
        type: "POST",
        url: "/",
        data: {answer:answerval},
        success: function (msg) {
            title=msg.split("---")[0];
            html=msg.split("---")[1];
            $('.questionText').text(title);
            $('.questionMain').html(html);
        }
    });
}

function selected(box) {
    if ($("#"+box).val()==="no") {
        ("#" + box).val("yes");
    }else{
        ("#" + box).val("no");
    }
}