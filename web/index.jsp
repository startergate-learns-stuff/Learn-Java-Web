<%--
  Created by IntelliJ IDEA.
  User: choi
  Date: 2020/05/28
  Time: 4:11 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    int sum = 0;
    for (int i = 1;i <= 10;i++) {
      sum += i;
    }
  %>
  <table border="1">
    <tr>
      <td>3220_최호승</td>
      <td><%=sum%></td>
    </tr>
  </table>
  </body>
</html>
