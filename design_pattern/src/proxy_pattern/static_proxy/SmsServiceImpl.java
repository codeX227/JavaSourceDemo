package proxy_pattern.static_proxy;

/**
 * 被代理的类
 * 实现发送短信的接口
 */
public class SmsServiceImpl implements SmsService{
    @Override
    public String send(String message) {
        System.out.println("send message: " + message);
        return message;
    }
}
