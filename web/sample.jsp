<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 주석 --%>
<%!
    public int twoHap() {
        int a = 100;
        int b = 300;
        return a + b;
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        int v = twoHap();
    %>
    <table border="1">
        <tr>
            <td>결과</td>
            <td><%=v%></td>
        </tr>
    </table>
</body>
</html>
