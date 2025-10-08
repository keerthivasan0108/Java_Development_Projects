package com.example.spring_ex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello world!");
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld obj = (HelloWorld) context.getBean("HelloWorld");
        System.out.println(obj.getMessage());   
    }

    
}
