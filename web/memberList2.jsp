<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="kr.gsm2.model.*" %>
<%@ page import="java.util.ArrayList" %>
<%
    ArrayList<MemberVO> list = (ArrayList<MemberVO>) request.getAttribute("list");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    - 회원 리스트 -
    <table border="1">
        <tr>
            <td>번호</td>
            <td>학번</td>
            <td>이름</td>
            <td>전화번호</td>
            <td>이메일</td>
            <td>주소</td>
            <td>삭제</td>
        </tr>
        <% for (MemberVO vo : list) { %>
        <tr>
            <td><%=vo.getNum()%></td>
            <td><a href="./content?num=<%=vo.getNum()%>"><%=vo.getBun()%></a></td>
            <td><%=vo.getName()%></td>
            <td><%=vo.getTel()%></td>
            <td><%=vo.getEmail()%></td>
            <td><%=vo.getAddr()%></td>
            <td><input type="button" value="삭제" onclick="memdel(<%=vo.getNum()%>)"></td>
        </tr>
        <% } %>
        <tr>
            <td colspan="7" style="text-align: right">
                <input type="button" value="회원가입" onclick="memform()">
            </td>
        </tr>
    </table>
    <script>
        function memform() {
            location.href = './member2.html'
        }

        function memdel(num) {
            location.href = './delete/?id=' + num
        }
    </script>
</body>
</html>
