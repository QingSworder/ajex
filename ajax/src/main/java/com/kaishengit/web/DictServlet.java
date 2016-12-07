package com.kaishengit.web;

import com.kaishengit.util.HttpUtil;

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
@WebServlet("/dict")
public class DictServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("quary");
        String url =  "http://fanyi.youdao.com/openapi.do?keyfrom=kaishengit&key=1587754017&type=data&doctype=xml&version=1.1&q=" + query;
        //获取服务端返回的结果
        String result = HttpUtil.sendRequestWithString(url);

        //相应字符编码格式设置为UTF-8
        resp.setCharacterEncoding("UTF-8");
        //设置相应的MIME头
        resp.setContentType("text/xml;charSet=UTF-8");
        //将服务端返回的结果发送给前端
        PrintWriter out = resp.getWriter();
        out.print(result);
        out.flush();
        out.close();
    }
}
