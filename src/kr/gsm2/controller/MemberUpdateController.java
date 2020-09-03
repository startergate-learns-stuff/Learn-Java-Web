package kr.gsm2.controller;

import kr.gsm2.model.MemberDAO;
import kr.gsm2.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/update")
public class MemberUpdateController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int num = Integer.parseInt(req.getParameter("num"));
        String tel = req.getParameter("tel");
        String email = req.getParameter("email");
        String addr = req.getParameter("addr");

        MemberVO vo = new MemberVO();
        vo.setNum(num);
        vo.setTel(tel);
        vo.setEmail(email);
        vo.setAddr(addr);

        MemberDAO dao = new MemberDAO();
        int cnt = dao.update(vo);
        PrintWriter out = resp.getWriter();
        if (cnt > 0) {
            resp.sendRedirect("list");
        } else {
            out.println("failed");
        }
    }
}
