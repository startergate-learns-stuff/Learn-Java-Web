package kr.gsm.controller;

import kr.gsm.model.MemberDAO;
import kr.gsm.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/memdelete.do")
public class MemberDeleteController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        MemberDAO dao = new MemberDAO();
        int cnt = dao.delete(id);

        if (cnt > 0) {
            resp.sendRedirect("list.do");
        } else {
            throw new ServletException("설정");
        }
    }
}
