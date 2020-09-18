<%@ page import="kr.gsm2.model.MemberVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    - 상세 보기 -
    <form action="/update">
        <input type="hidden" name="num" value="${vo.getNum()}">
        <table border="1">
            <tr>
                <td>번호</td>
                <td>${vo.getNum()}</td>
            </tr>
            <tr>
                <td>학번</td>
                <td>${vo.getBun()}</td>
            </tr>
            <tr>
                <td>이름</td>
                <td>${vo.getName()}</td>
            </tr>
            <tr>
                <td>전화번호</td>
                <td><input type="text" name="tel" value="${vo.getTel()}"></td>
            </tr>
            <tr>
                <td>이메일</td>
                <td><input type="text" name="email" value="${vo.getEmail()}"></td>
            </tr>
            <tr>
                <td>주소</td>
                <td><input type="text" name="addr" size="50" value="${vo.getAddr()}"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center">
                    <input type="submit" value="수정">
                    <input type="button" value="리스트" onclick="location.href = '/list'">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
