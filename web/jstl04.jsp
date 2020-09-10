<%@ page import="kr.gsm2.model.MemberVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    MemberVO vo = new MemberVO();
    vo.setBun(3220);
    vo.setName("최호승");
    vo.setTel("0");
    vo.setEmail("mw@gsm.hs.kr");
    ArrayList<MemberVO> list = new ArrayList<>();
    list.add(vo);
    list.add(vo);
    list.add(vo);

    request.setAttribute("list", list);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <td>번호</td>
            <td>이름</td>
            <td>전화</td>
            <td>이메일</td>
        </tr>
        <c:forEach var="vo" items="${list}">
            <tr>
                <td>${vo.bun}</td>
                <td>${vo.name}</td>
                <td>${vo.tel}</td>
                <td>${vo.email}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
