<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Андрій
  Date: 05.12.2017
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="alc" items="${alcogol}">
    <div>
        ${alc.name}
        ${alc.category}
        ${alc.price}
    </div>
</c:forEach>
</body>
</html>
