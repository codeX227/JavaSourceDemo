package proxy_pattern.cglib_dynamic_proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 方法拦截器
 */
public class DebugMethodInterceptor implements MethodInterceptor {

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("before method " + method.getName());

        Object object = methodProxy.invokeSuper(o, objects);

        System.out.println("after method " + method.getName());

        return object;
    }
}
