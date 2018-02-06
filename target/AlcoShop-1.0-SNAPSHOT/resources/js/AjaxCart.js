var modal = $('#modal');
var btn=$('#cartBtn');
btn.click(function () {
    modal.css("display","block");
    modal.modal("show");
});
$(document).click(function (e) {
    if (e==modal){
        modal.css("display","none");
    }

});

$('#closeBtn').click(function () {
    modal.css("display","none");
    modal.modal("hide");
});


