package com.company;

public class MyInterfaceImplementation implements HelloInterface, GoodbyeInterface {
    @Override
    public void printHello() {
        System.out.println(" Greeting is " + Hello);
    }
    @Override
    public void printGoodbye(){
        System.out.println(" Greeting is " + Goodbye);
    }

}
