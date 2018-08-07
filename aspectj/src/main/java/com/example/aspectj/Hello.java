package com.example.aspectj;

public class Hello {

    public Hello() {

    }

    public void sayHello() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Hello h = new Hello();
        h.sayHello();
    }
}
