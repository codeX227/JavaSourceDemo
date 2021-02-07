package proxy_pattern.jdk_dynamic_proxy;

public class Main {

    public static void main(String[] args) {

        SmsService proxy = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());

        proxy.send("java");
    }
}
