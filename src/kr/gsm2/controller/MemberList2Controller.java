package kr.gsm2.controller;

import kr.gsm2.model.MemberDAO;
import kr.gsm2.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class MemberList2Controller {
    public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        MemberDAO dao = new MemberDAO();
        ArrayList<MemberVO> list = dao.list();

        req.setAttribute("list", list);
        String nextPage = "memberList2.jsp";
        return nextPage;
    }
}
