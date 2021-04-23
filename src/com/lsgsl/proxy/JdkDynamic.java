package com.lsgsl.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author : zh411325
 * YEAR   ：2021
 * 动态代理：分离代理行为和被代理对象
 *         可以使代理行为被复用
 */
public class JdkDynamic {

    public static void main(String[] args) {
        Tank tank = new Tank();

        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");

        //refletion 通过二进制字节码分析类的属性和行为
        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("method " + method.getName()+ "-----start");
                        Object o = method.invoke(tank,args);
                        System.out.println("method " + method.getName()+ "-----end");
                        return 0;
                    }
                });
        m.move();
    }

}
