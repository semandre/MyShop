
$('#ctgBtn').click(function () {
 var name = $('#cName').val();
 var category={
     name
 };
 console.log(category);
 $.ajax({
     url: '/saveCategory',
     type: 'POST',
     data: JSON.stringify(category),
     contentType:'application/json',
     success:function () {
         $('#cName').val('');
     }
 });

});


$('#cityNameBtn').click(function () {

    console.log('hello');
    let cityName=$('#cityName').val();
    let city={
        cityName
    };
    $.ajax({
        url:'/findByCityName',
        type:'POST',
        data: JSON.stringify(city),
        contentType:'application/json',
        success:function (data) {
            console.log(data);
        },
        error:function () {
            console.log('error');
        }

    });

});