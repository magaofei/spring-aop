package com.example.aspectj;

public aspect TxAspect {
    void around():call(void Hello.sayHello()) {
        System.out.println("start");
        proceed();
        System.out.println("end");
    }
}
