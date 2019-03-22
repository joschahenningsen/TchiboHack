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
    if ($("#" + box).hasClass("no")) {
        $("#" + box).removeClass("no");
        $("#" + box).val("yes");
        $("#" + box).addClass("yes");
    }else{
        $("#" + box).removeClass("yes");
        $("#" + box).val("no");
        $("#" + box).addClass("no");
    }
}

function send(id) {
    if ($("#" + id).hasClass("yes")){
        $.ajax({
            type: "POST",
            url: "/",
            data: {answer:"yes"},
            success: function (msg) {
                title=msg.split("---")[0];
                html=msg.split("---")[1];
                $('.questionText').text(title);
                $('.questionMain').html(html);
            }
        });
    }else {
        $.ajax({
            type: "POST",
            url: "/",
            data: {answer:"no"},
            success: function (msg) {
                title=msg.split("---")[0];
                html=msg.split("---")[1];
                $('.questionText').text(title);
                $('.questionMain').html(html);
            }
        });
    }
}

function checkandsend() {
    res="";
    if ($("#decaf").hasClass("yes")){
        res+="decaf";
    }
    if ($("#fairtrade").hasClass("yes")){
        res+="fairtrade";
    }
    $.ajax({
        type: "POST",
        url: "/",
        data: {answer:res},
        success: function (msg) {
            title=msg.split("---")[0];
            html=msg.split("---")[1];
            $('.questionText').text(title);
            $('.questionMain').html(html);
        }
    });
}