package kr.gsm.controller;

import kr.gsm.model.LBSMAP;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/mapSearch.do")
public class MapSearchController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String address = req.getParameter("address");
        LBSMAP dao = new LBSMAP();
        try {
            String json = dao.getMaps(address);
            resp.setContentType("text/json;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
