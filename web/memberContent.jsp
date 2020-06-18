<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="kr.gsm.model.*" %>
<%
    MemberVO vo = (MemberVO) request.getAttribute("vo");
%>
<html>
<head>
    <title>Title</title>
    <script>
        const goList = _ => {
            location.href = "/list.do";
        };
    </script>
</head>
<body>
    <h1>회원 정보 보기 (3220_최호승)</h1>
    <form action="memupdate.do">
        <input type="hidden" name="id" value="<%=vo.getId()%>">
        <table border="1">
            <tr>
                <td>ID</td>
                <td><%=vo.getId()%></td>
            </tr>
            <tr>
                <td>PWD</td>
                <td><input type="text" name="pwd" value="<%=vo.getPwd()%>"></td>
            </tr>
            <tr>
                <td>AGE</td>
                <td><input type="number" name="age" value="<%=vo.getAge()%>"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center">
                    <input type="submit" value="수정">
                    <input type="reset" value="취소">
                    <input type="button" value="리스트" onclick="goList()">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
