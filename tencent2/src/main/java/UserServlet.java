import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wtj008 on 2016/12/5.
 */
@WebServlet("/users.xml")
public class UserServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user1 = new User(001,"张三","湖北");
        User user2 = new User(002,"李四","天津");
        User user3 = new User(003,"杰西","河南");

        List<User> userList = Arrays.asList(user1,user2,user3);

        //设置响应的字符编码
        resp.setCharacterEncoding("UTF-8");
        //设置响应头
        resp.setContentType("text/xml;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.print("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
        out.print("<users>");
        for(User u:userList){
            out.print("<user id=\""+u.getId()+"\">");
            out.print("<name>"+u.getUsername()+"</name>");
            out.print("<address>"+u.getAddress()+"</address>");
            out.print("</user>");
        }
        out.print("</users>");
        out.flush();
        out.close();


    }
}
