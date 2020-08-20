import kr.gsm.MyUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hs.do")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyUtil util = new MyUtil();
        int sum = util.hap();

        req.setAttribute("data", sum);

        RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
        rd.forward(req, resp);
    }
}
