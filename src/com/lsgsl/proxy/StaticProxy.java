package com.lsgsl.proxy;

import java.util.Random;

/**
 * Author : zh411325
 * YEAR   ：2021
 * 静态代理：代理的功能和被代理的对象是绑定的
 * 尽量避免使用继承，因为耦合度太高，如果对一个方法需要添加benchmark(性能监测)、日志功能、时间功能等的嵌套，
 *  需要的类很多，都需要继承被代理类
 */
public class StaticProxy {
    public static void main(String[] args) {
        new TankLogProxy(
                new TankTimeProxy(
                        new Tank()
                )).move();
    }
}

class TankTimeProxy implements Movable{
    Movable m;

    public TankTimeProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        m.move();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}

class TankLogProxy implements Movable{
    Movable m;

    public TankLogProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("开始添加日志");
        m.move();
        System.out.println("添加日志结束");
    }
}
