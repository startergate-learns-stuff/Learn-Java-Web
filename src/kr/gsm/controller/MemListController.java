package kr.gsm.controller;

import com.google.gson.Gson;
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

@WebServlet("/memlist.me")
public class MemListController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDAO dao = new MemberDAO();
        List<MemberVO> members = dao.getAllList();
        Gson g = new Gson();
        String json = g.toJson(members);

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println(json);
    }
}
