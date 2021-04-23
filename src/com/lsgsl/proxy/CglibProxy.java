package com.lsgsl.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Author : zh411325
 * YEAR   ：2021
 * CGLib(Code Generation Library) 比 Java 的 java.lang.reflect.Proxy 类更强的在于它不仅可以接管接口类的方法，还可以接管普通类的方法。
 *
 * CGLib 的底层是Java字节码操作框架 —— ASM。
 */
public class CglibProxy {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank01.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println(o.getClass().getSuperclass().getName());
                System.out.println("before");
                Object result = methodProxy.invokeSuper(o,objects);
                return result;
            }
        });

        Tank01 tank = (Tank01) enhancer.create();
        tank.move();
    }

}
