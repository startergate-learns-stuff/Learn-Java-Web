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

@WebServlet("/meminsert.me")
public class MemInsertController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        int age = Integer.parseInt(req.getParameter("age"));

        MemberVO vo = new MemberVO(id, pwd, age);

        MemberDAO dao = new MemberDAO();
        int cnt = dao.insert(vo);

        PrintWriter out = resp.getWriter();
        if (cnt > 0) {
            out.println("OK");
        } else {
            out.println("no u");
        }
    }
}
