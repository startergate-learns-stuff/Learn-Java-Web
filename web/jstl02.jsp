<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String[] f = {"사과", "바나나", "오렌지"};
    request.setAttribute("f", f);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="v" items="${f}">
    ${v}<br />
</c:forEach>
</body>
</html>
