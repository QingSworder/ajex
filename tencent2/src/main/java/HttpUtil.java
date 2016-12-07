import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wtj008 on 2016/12/6.
 */
public class HttpUtil {
    public static String sendHttpGetRequsetWithString(String url){
        //1.创建一个可以发出http请求的客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2.创建一个httpget请求
        HttpGet httpget = new HttpGet(url);
        //3.发出请求并接收服务端的相应
        HttpResponse httpResponse = null;
        try{
            httpResponse = httpClient.execute(httpget);
            InputStream inputStream = null;
            if(httpResponse.getStatusLine().getStatusCode()==200){
                inputStream = httpResponse.getEntity().getContent();

                String result = IOUtils.toString(inputStream,"UTF-8");
                httpClient.close();
                return result;
            }else {
                throw new RuntimeException("请求"+url+"异常"+httpResponse.getStatusLine().getStatusCode());
            }
        }catch (IOException ex){
            throw new RuntimeException("请求"+url+"异常");
        }
    }
}
