package kr.gsm.controller;

import kr.gsm.model.LBSMAP;
import kr.gsm.model.MapVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teamInsert.do")
public class TeamInsertController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String companyName = req.getParameter("companyName");
        double latitude = Double.parseDouble(req.getParameter("latitude"));
        double longitude = Double.parseDouble(req.getParameter("longitude"));

        MapVO vo = new MapVO(name, phone, companyName, latitude, longitude);
        LBSMAP dao = new LBSMAP();
        int cnt = dao.teamInsert(vo);
    }
}
