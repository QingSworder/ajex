import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wtj008 on 2016/12/6.
 */
@WebServlet("/rss.xml")
public class RssServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "http://baidu.com";
        String result = HttpUtil.sendHttpGetRequsetWithString(url);

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/xml;Charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.write(result);
        out.flush();
        out.close();
    }
}
