package util;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;
import java.util.Random;

public class PhonePatt {

    public String phonePattNum(String phone){
        StringBuffer sb = new StringBuffer();
//        上成验证码随机数
        Random ran = new Random();
        for(int i = 0 ; i < 6 ; i ++ ){
            sb.append(ran.nextInt(9));
        }
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://gbk.api.smschinese.cn");
        post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
        NameValuePair[] data ={ new NameValuePair("Uid", "aaccdd"),new NameValuePair("Key", "d41d8cd98f00b204e980"),new NameValuePair("smsMob",phone),new NameValuePair("smsText","验证码："+sb.toString())};
        post.setRequestBody(data);

        try {
            client.executeMethod(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:"+statusCode);
        for(Header h : headers)
        {
            System.out.println(h.toString());
        }
        String result = null;
        try {
            result = new String(post.getResponseBodyAsString().getBytes("gbk"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result); //打印返回消息状态

        post.releaseConnection();
        return sb.toString();
    }
}
