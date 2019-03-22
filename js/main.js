function clicked(clicked) {
    $.ajax({
        type: "POST",
        url: "/",
        data: {answer:clicked},
        success: function (msg) {
            alert(msg);
        }
    });
}