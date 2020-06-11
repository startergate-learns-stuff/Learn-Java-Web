package kr.gsm.controller;

import kr.gsm.model.MemberDAO;
import kr.gsm.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/list.do")
public class MemberListController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDAO dao = new MemberDAO();
        List<MemberVO> list = dao.getAllList();

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>회원 목록 리스트</h1>");
        out.println("<table border=\"1\">");
        out.println("<tr>");
        out.println("<td>ID</td>");
        out.println("<td>PWD</td>");
        out.println("<td>AGE</td>");
        out.println("</tr>");
        for (MemberVO member: list) {
            if (member.getId().equals("최호승")) out.println("<tr style=\"background-color: orange\">");
            else out.println("<tr>");
            out.println("<td>" + member.getId() + "</td>");
            out.println("<td>" + member.getPwd() + "</td>");
            out.println("<td>" + member.getAge() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
