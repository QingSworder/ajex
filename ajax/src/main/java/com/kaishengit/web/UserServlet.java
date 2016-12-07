package com.kaishengit.web;


import com.kaishengit.util.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wtj008 on 2016/12/7.
 */
@WebServlet("/users.xml")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(1,"张三","石家庄");
        User user1 = new User(2,"李四","湖北");
        User user2 = new User(3,"王五","南京");

        List<User> userList = Arrays.asList(user,user1,user2);
        //1.设置响应的字符编码
        resp.setCharacterEncoding("UTF-8");
        //2.设置响应头的MIME type
        resp.setContentType("text/xml;charSet=UTF-8");

        PrintWriter out = resp.getWriter();
        out.print("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
        out.print("<users>");
        for(User u:userList){
            out.print("<user id=\""+u.getId()+"\">");
            out.print("<name>"+u.getName()+"</name>");
            out.print("<address>"+u.getAddress()+"</address>");
            out.print("</user>");
        }
        out.print("</users>");
        out.flush();
        out.close();
    }
}
