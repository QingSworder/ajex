package com.kaishengit.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wtj008 on 2016/12/7.
 */
@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        //url中含有中文字符
        name = new String(name.getBytes("ISO8859-1"),"UTF-8");
        //声明禁止浏览器缓存结果的响应头
        resp.setHeader("pragma","no-cache");
        resp.setHeader("cache-control","no-cache");
        resp.setHeader("expires","0");


        System.out.println("Hello,Ajax!!! ->"+name);

        PrintWriter out = resp.getWriter();
        out.print("Hello,World!!!");
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //提交的post表单中含有中文
        req.setCharacterEncoding("UTF-8");
        //响应给客户端的数据含有中文
        resp.setCharacterEncoding("UTF-8");
        //设置响应内容格式（纯字符串）
        resp.setContentType("text/plain;charSet=UTF-8");
        //1.拿到客户端传来的数据
        String name = req.getParameter("name");
        System.out.println(name);
        PrintWriter out = resp.getWriter();
        if("tom".equals(name)){
            out.print("不能用");
        }else {
            out.print("能用");
        }
        out.flush();
        out.close();

    }
}
