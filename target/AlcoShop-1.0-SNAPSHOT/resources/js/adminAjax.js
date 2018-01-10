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