package kr.gsm.controller;

import kr.gsm.model.MyUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/tot.do")
public class TotalController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int su1 = Integer.parseInt(req.getParameter("su1"));
        int su2 = Integer.parseInt(req.getParameter("su2"));

        MyUtil my = new MyUtil();
        int result = my.count(su1, su2);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println(su1 + "~" + su2 + "<br>");
        writer.println("3220_최호승: " + result);
        writer.println("</body>");
        writer.println("</html>");
    }
}
