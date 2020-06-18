package kr.gsm.controller;

import kr.gsm.model.MemberDAO;
import kr.gsm.model.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/memcontent.do")
public class MemberContentController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        MemberDAO dao = new MemberDAO();
        MemberVO vo = dao.getById(id);
        req.setAttribute("vo", vo);
        RequestDispatcher rd = req.getRequestDispatcher("memberContent.jsp");
        rd.forward(req, resp);
    }
}
