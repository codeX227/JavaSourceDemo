package proxy_pattern.jdk_dynamic_proxy;

import java.lang.reflect.Proxy;

public class JdkProxyFactory {

    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new DebugInvocationHandler(target));
    }
}
