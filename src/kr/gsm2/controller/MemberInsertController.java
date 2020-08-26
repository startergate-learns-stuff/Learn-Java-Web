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

@WebServlet("/member")
public class MemberInsertController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int bun = Integer.parseInt(req.getParameter("bun"));
        String name = req.getParameter("name");
        String tel = req.getParameter("tel");
        String email = req.getParameter("email");
        String addr = req.getParameter("addr");

        MemberVO vo = new MemberVO(bun, name, tel, email, addr);

        MemberDAO dao = new MemberDAO();
        int cnt = dao.insert(vo);
        PrintWriter out = resp.getWriter();
        if (cnt > 0) {
            out.println("success");
        } else {
            out.println("failed");
        }
    }
}
