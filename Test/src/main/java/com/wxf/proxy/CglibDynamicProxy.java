package com.wxf.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib动态代理
 *
 * @author Wxf
 * @since 2023-10-31 12:40:45
 **/
public class CglibDynamicProxy implements MethodInterceptor {

    private Object target;

    public Object getProxyInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用前======" + method.getName());
        Object result = methodProxy.invokeSuper(target, args);
        System.out.println("调用后=======" + method.getName());
        return result;
    }
}
