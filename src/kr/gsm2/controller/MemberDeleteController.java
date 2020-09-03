package kr.gsm2.controller;

import kr.gsm2.model.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class MemberDeleteController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num = Integer.parseInt(req.getParameter("num"));

        MemberDAO dao = new MemberDAO();
        int cnt = dao.delete(num);
        if (cnt > 0) resp.sendRedirect("./list");
        else throw new ServletException();
    }
}
