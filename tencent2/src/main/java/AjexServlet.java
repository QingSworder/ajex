import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wtj008 on 2016/12/5.
 */
@WebServlet("/ajax")
public class AjexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        name = new String(name.getBytes("ISO8859-1"),"UTF-8");
        //声明禁止浏览器缓存结果的响应头
        resp.setHeader("pragma","no-cache");
        resp.setHeader("cache-control","no-cache");
        resp.setHeader("expires","0");
        System.out.println("hello ajex"+"->"+name);

        PrintWriter out = resp.getWriter();
        out.print("Hello,world");
        out.flush();
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //表单提交（post）含有中文
        req.setCharacterEncoding("UTF-8");
        //给客户端设置响应编码
        resp.setCharacterEncoding("UTF-8");
        //设置响应内容（纯字符串）
        resp.setContentType("text/plain;charSet=UTF-8");

        String name = req.getParameter("name");
        PrintWriter out = resp.getWriter();
        if("tom".equals(name)){
            System.out.println("账号被占用");
            out.print("不能用");
        }else{
            System.out.println("账号可以使用");
            out.print("能用");
            out.flush();
            out.close();
        }
    }
}
