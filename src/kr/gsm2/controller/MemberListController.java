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
import java.util.ArrayList;

@WebServlet("/list")
public class MemberListController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDAO dao = new MemberDAO();
        ArrayList<MemberVO> list = dao.list();

        req.setAttribute("list", list);
        RequestDispatcher rd = req.getRequestDispatcher("memberList2.jsp");
        rd.forward(req, resp);

    }
}
