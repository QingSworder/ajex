import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wtj008 on 2016/12/5.
 */
public class Test {
    public static void main(String[] args){

        User user = new User(1,"james","cakluo");
        User  user1 = new User(2,"lebon","sanfra");
        User user2 = new User(3,"kebo","shengdiya3g");

        List<User> userList = Arrays.asList(user,user1,user2);
        String json = new Gson().toJson(userList);

        System.out.println(json);

       /* for(User u:userList){
            System.out.println(u.getId()+"->"+u.getUsername()+"->"+u.getAddress());
        }*/


       /* List<String> names = Arrays.asList("jack","rose","sanpao");
        String json = new Gson().toJson(names);
        System.out.println(json);*/
       /* User user = new User(7,"张三","河南");
        String json = new Gson().toJson(user);
        System.out.println(json);*/


       /* CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost/save");

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("userName","jack"));
        params.add(new BasicNameValuePair("address","usa"));

        httpPost.setEntity(new UrlEncodedFormEntity(params));

        for(int i=0;i<5;i++){
            httpClient.execute(httpPost);
        }*/



       /* //1.创建一个可以发出http请求的客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2.创建一个get的请求方式
        HttpGet httpGet = new HttpGet("http://ww1.sinaimg.cn/mw690/824de770jw1epwcnivby6j20go0p00x4.jpg");
        //3.发出请求并接收服务端的相应
        HttpResponse httpResponse = httpClient.execute(httpGet);
        //4.获取服务端响应的状态吗
        int statusCode = httpResponse.getStatusLine().getStatusCode();

        if(statusCode==200){
            //5.获取相应的输入流
            InputStream inputStream = httpResponse.getEntity().getContent();
            OutputStream outputStream = new FileOutputStream("G:/x.jpg");
            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        }
        httpClient.close();
*/

      /*  //创建一个发出http请求的客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建一个get的请求方式
        HttpGet httpGet = new HttpGet("http://pingwest.com/feed/");
        //发出请求并接收服务端的响应
        HttpResponse httpResponse= httpClient.execute(httpGet);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if(statusCode==200){
            //获取相应的输入流
            InputStream inputStream = httpResponse.getEntity().getContent();
            String result = IOUtils.toString(inputStream,"UTF-8");
        }else{
            System.out.println("服务器异常"+statusCode);
        }*/
    }
}
