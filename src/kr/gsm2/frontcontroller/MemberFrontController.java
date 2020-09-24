package kr.gsm2.frontcontroller;

import kr.gsm2.controller.MemberInsert2Controller;
import kr.gsm2.controller.MemberList2Controller;
import kr.gsm2.model.MemberDAO;
import kr.gsm2.model.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MemberFrontController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqUrl = req.getRequestURI();
        String cpath = req.getContextPath();
        String cmd = reqUrl.substring(cpath.length());
        System.out.println(cmd);
        resp.setContentType("text/html;charset=utf-8");
        if (cmd.equals("/list.do")) {
            MemberList2Controller pojo = new MemberList2Controller();
            String nextPage = pojo.requestHandler(req, resp);
            RequestDispatcher rd = req.getRequestDispatcher(nextPage);
            rd.forward(req, resp);
        } else if (cmd.equals("/insert.do")) {
            MemberInsert2Controller pojo = new MemberInsert2Controller();
            String nextPage = pojo.requestHandler(req, resp);
            PrintWriter out = resp.getWriter();
            if (nextPage != null) {
                resp.sendRedirect(nextPage);
            } else {
                out.println("failed");
            }
        } else if (cmd.equals("/delete.do")) {
            int num = Integer.parseInt(req.getParameter("num"));

            MemberDAO dao = new MemberDAO();
            int cnt = dao.delete(num);
            if (cnt > 0) resp.sendRedirect("./list");
            else throw new ServletException();
        } else if (cmd.equals("/content.do")) {
            int num = Integer.parseInt(req.getParameter("num"));
            MemberDAO dao = new MemberDAO();
            MemberVO vo = dao.content(num);
            req.setAttribute("vo", vo);
            RequestDispatcher rd = req.getRequestDispatcher("member/content.jsp");
            rd.forward(req, resp);
        }
    }
}
