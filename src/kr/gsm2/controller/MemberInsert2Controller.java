package kr.gsm2.controller;

import kr.gsm2.model.MemberDAO;
import kr.gsm2.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MemberInsert2Controller {
    public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int bun = Integer.parseInt(req.getParameter("bun"));
        String name = req.getParameter("name");
        String tel = req.getParameter("tel");
        String email = req.getParameter("email");
        String addr = req.getParameter("addr");

        MemberVO vo = new MemberVO(0, bun, name, tel, email, addr);

        MemberDAO dao = new MemberDAO();
        int cnt = dao.insert(vo);
        String nextPage = null;
        if (cnt > 0) {
            nextPage = "list.do";
        }
        return nextPage;
    }
}
