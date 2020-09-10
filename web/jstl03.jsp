<%@ page import="kr.gsm2.model.MemberVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    MemberVO vo = new MemberVO();
    vo.setBun(1003);
    vo.setName("정민우");
    vo.setTel("0");
    vo.setEmail("mw@gsm.hs.kr");
    request.setAttribute("vo", vo);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
${vo.bun}, ${vo.name}, ${vo.tel}, ${vo.email}
</body>
</html>
