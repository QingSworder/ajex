import com.google.gson.Gson;
import org.apache.commons.io.output.WriterOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet("/data.json")
public class JsonDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        //language=JSON
        User user = new User(1,"张三","中国");
        User  user1 = new User(2,"lebon","sanfra");
        User user2 = new User(3,"kebo","shengdiya3g");

        List<User> userList = Arrays.asList(user,user1,user2);
        String json = new Gson().toJson(userList);

        PrintWriter out = resp.getWriter();
        out.write(json);
        out.flush();
        out.close();
    }
}
