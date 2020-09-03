package kr.gsm2.controller;

import kr.gsm2.model.MemberDAO;
import kr.gsm2.model.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/content")
public class MemberContentController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num = Integer.parseInt(req.getParameter("num"));

        MemberDAO dao = new MemberDAO();
        MemberVO vo = dao.content(num);
        req.setAttribute("vo", vo);
        RequestDispatcher rd = req.getRequestDispatcher("member/content.jsp");
        rd.forward(req, resp);
    }
}
