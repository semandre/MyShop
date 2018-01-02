
function addToCart(ident) {

    $('#cart').empty();

        $.ajax({
            url: '/add/' + ident,
            type: "GET",

        error:function () {
            alert("error");
        }


    });
};


