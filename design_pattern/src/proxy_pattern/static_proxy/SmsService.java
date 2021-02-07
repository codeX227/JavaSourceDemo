package proxy_pattern.static_proxy;

/**
 * 发送短信的接口
 */
public interface SmsService {

    String send(String message);
}
