package com.kaishengit.util;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by wtj008 on 2016/12/7.
 */
public class HttpUtil {
    public static String sendRequestWithString(String url) throws IOException {
        String result = null;
        //1.创建一个可以发出Http请求的客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2.创建一个get请求
        HttpGet httpGet = new HttpGet(url);
        //3.客户端执行get请求
        HttpResponse httpResponse = httpClient.execute(httpGet);
        //4.接收服务端执行结果状态码
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if(statusCode==200){
            //5.获取响应输入流
            InputStream inputStream = httpResponse.getEntity().getContent();
            //6.将响应输入流转换为UTF-8格式
           result = IOUtils.toString(inputStream,"UTF-8");

        } else {
            System.out.println("服务器异常"+statusCode);
        }
        return result;
    }

}
