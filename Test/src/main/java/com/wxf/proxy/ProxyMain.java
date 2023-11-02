package com.wxf.proxy;

/**
 * 动态代理测试
 *
 * @author Wxf
 * @since 2023-10-31 12:35:16
 **/
public class ProxyMain {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

//        System.out.println(testJDKProxy(userService));
        System.out.println(testCglibProxy(userService));

    }

    public static Object testCglibProxy(UserService userService){
        CglibDynamicProxy cglibDynamicProxy = new CglibDynamicProxy();
        return ((UserService) cglibDynamicProxy.getProxyInstance(userService)).getUsername();
    }


    public static Object testJDKProxy(UserService userService) {
        JdkDynamicProxy jdkDynamicProxy = new JdkDynamicProxy();
        return ((UserService) jdkDynamicProxy.getProxyInstance(userService)).getUsername();
    }
}
