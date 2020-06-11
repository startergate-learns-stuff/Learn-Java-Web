<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*" %>
<%@page import="kr.gsm.model.*" %>
<%
    List<MemberVO> list = (List<MemberVO>) request.getAttribute("list");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>3220_최호승_회원리스트_출력</h1>
    <table border="1">
        <tr>
            <td>ID</td>
            <td>PWD</td>
            <td>AGE</td>
        </tr>
        <% for (MemberVO vo : list) {
            if (vo.getId().equals("최호승")) {%>
            <tr style="background-color: aquamarine">
            <% } else { %>
            <tr>
            <% } %>
                <td><%=vo.getId()%></td>
                <td><%=vo.getPwd()%></td>
                <td><%=vo.getAge()%></td>
                <td><a href="memdelete.do?id=<%=vo.getId()%>">삭제</a></td>
            </tr>
        <% } %>
        <tr>
            <td colspan="3" style="text-align: right">
                <a href="member.html">회원가입</a>
            </td>
        </tr>
    </table>
</body>
</html>
