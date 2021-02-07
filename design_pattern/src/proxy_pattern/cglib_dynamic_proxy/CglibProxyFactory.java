package proxy_pattern.cglib_dynamic_proxy;

import net.sf.cglib.proxy.Enhancer;

public class CglibProxyFactory {

    public static Object getProxy(Class<?> clazz){

        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();

        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new DebugMethodInterceptor());

        // 创建代理类
        return enhancer.create();
    }
}
