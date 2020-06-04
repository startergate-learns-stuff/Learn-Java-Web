import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sh.do")
public class Shopping extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("3220 최호승");
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += (i % 2 == 0) ? i : 0;
        }
        writer.println(sum);
    }
}
