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