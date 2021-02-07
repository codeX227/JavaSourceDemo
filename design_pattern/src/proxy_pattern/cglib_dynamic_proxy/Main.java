package proxy_pattern.cglib_dynamic_proxy;

public class Main {

    public static void main(String[] args) {

        SmsService proxy = (SmsService) CglibProxyFactory.getProxy(SmsService.class);

        proxy.send("java");

    }
}
