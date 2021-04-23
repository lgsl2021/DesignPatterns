package com.lsgsl.proxy;

import java.util.Random;

/**
 * Author : zh411325
 * YEAR   ：2021
 */

// 被代理的类
public class Tank implements Movable{
    @Override
    public void move() {
        System.out.println("Tank moving....");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Tank01{
    public void move() {
        System.out.println("Tank01 moving....");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
