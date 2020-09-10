<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="sum" value="10" />
<html>
<head>
    <title>Title</title>
</head>
<body>
sum=${sum}<br />
<c:if test="${sum % 2 == 0}">
    짝수입니다.<br />
</c:if>
<c:if test="${sum % 2 != 0}">
    홀수입니다.<br />
</c:if>
<c:forEach var="i" begin="1" end="5" step="1">
    ${i}<br />
</c:forEach>
<c:choose>
    <c:when test="${sum % 2 == 0}">
        짝수입니다.<br />
    </c:when>
    <c:when test="${sum % 2 != 0}">
        홀수입니다.<br />
    </c:when>
    <c:otherwise>
        난데모나이야
    </c:otherwise>
</c:choose>
</body>
</html>
