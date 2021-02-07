package proxy_pattern.cglib_dynamic_proxy;

/**
 * 被代理类
 *
 */
public class SmsService {

    public String send(String message){

        System.out.println("send message:" + message);

        return message;
    }
}
