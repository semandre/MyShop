<%--
  Created by IntelliJ IDEA.
  User: Андрій
  Date: 06.12.2017
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Title</title>
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="/resources/vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">



    <!-- Custom styles for this template -->
    <link href="/resources/css/header.css" rel="stylesheet">
    <link href="/resources/css/slider.css" rel="stylesheet">
</head>
<body>

<div class="">

    <div class="row">
        <div class=" col-xs-4 col-sm-4">
            <div class="center">
                <button  class=" btn-start wd-150 hg-150" onclick="relocate1()">
                    <i class="fa fa-shopping-bag" aria-hidden="true"></i>
                </button>
            </div>
        </div>
        <div class=" col-xs-4 col-sm-4">
            <div class="center">
                <button  class=" btn-start wd-150 hg-150" onclick="relocate1()">
                    <i class="fa fa-shopping-bag" aria-hidden="true"></i>
                </button>
            </div>
        </div>
        <div class=" col-xs-4 col-sm-4">
            <div class="center">
                <button  class=" btn-start wd-150 hg-150" onclick="relocate1()">
                    <i class="fa fa-shopping-bag" aria-hidden="true"></i>
                </button>
            </div>
        </div>
    </div>

</div>


<script>
    function relocate1()
    {
        location.href = "/start";
    }
</script>
<script src="/resources/vendor/jquery/jquery.min.js"></script>
<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<%--<script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>--%>
<%--<script src="/resources/js/new-age.min.js"></script>--%>
<script src="/resources/js/slider.js"></script>
</body>
</html>
