package proxy_pattern.static_proxy;

/**
 * 代理类
 * 代理 SmsServiceImpl
 */
public class SmsProxy implements SmsService{

    private final SmsService smsService;

    public SmsProxy(SmsService smsService){
        this.smsService = smsService;
    }

    @Override
    public String send(String message) {

        System.out.println("before method send()");
        smsService.send(message);
        System.out.println("after method send()");

        return null;
    }
}
