package com.kaishengit;

import com.google.gson.Gson;
import com.kaishengit.util.User;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wtj008 on 2016/12/7.
 */
public class Test {
    public static void main(String[] args) throws IOException{

        User user = new User(1,"jack","American");
        User user1 = new User(2,"james","骑士");
        User user2 = new User(3,"kobe","lake");

        List<User> userList =  Arrays.asList(user,user1,user2);
        String json = new Gson().toJson(userList);
        System.out.println(json);




       /* User user = new User(1,"李四","北京");
        String json = new Gson().toJson(user);
        System.out.println(json);*/




       /* //1.创建一个可以发出HTTP请求的客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2.创建一个post请求
        HttpPost httpPost = new HttpPost("http://localhost/save");

        //3.创建一个List
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("userName","jack"));
        params.add(new BasicNameValuePair("address","usa"));

        httpPost.setEntity(new UrlEncodedFormEntity(params));
        for(int i=0;i<5;i++){
            httpClient.execute(httpPost);
        }*/







       /* //1.创建一个可以发出HTTP请求的客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2.创建一个get请求
        HttpGet httpGet = new HttpGet("http://ww1.sinaimg.cn/mw690/824de770jw1epwcnivby6j20go0p00x4.jpg");
        //3.执行get请求并接受服务端响应
        HttpResponse httpResponse = httpClient.execute(httpGet);
        //4.获取HTTP相应的状态码
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if(statusCode==200){
            //5.获取服务端响应的输入流
            InputStream inputStream = httpResponse.getEntity().getContent();
            //6.将输入流写到输出流
            OutputStream outputStream = new FileOutputStream("F:/xx.jpg");
            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        }else {
            System.out.println("服务器异常"+statusCode);
        }
        httpClient.close();*/









        /*//1.创建了一个可以发出请求的客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2.创建一个get请求方式
        HttpGet httpGet = new HttpGet("http://www.kaishengit.com");
        //3.发出请求并接受服务端的响应
        HttpResponse response = httpClient.execute(httpGet);

        //4.获取HTTP响应的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        if(statusCode==200){
            //5.获取响应输入流
            InputStream inputStream = response.getEntity().getContent();
            //6.将响应输入流转换为"UTF-8"格式
            String result = IOUtils.toString(inputStream,"UTF-8");
            //7.关闭响应输入流
            inputStream.close();
            System.out.println(result);
        }else {
            System.out.println("服务器异常:"+statusCode);
        }
        httpClient.close();*/
    }
}
