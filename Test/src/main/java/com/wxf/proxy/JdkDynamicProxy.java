package com.wxf.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Wxf
 * @since 2023-10-31 12:23:34
 **/
public class JdkDynamicProxy implements InvocationHandler {

    private Object target;

    public Object getProxyInstance(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用前======" + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("调用后=======" + method.getName());
        return result;
    }
}
