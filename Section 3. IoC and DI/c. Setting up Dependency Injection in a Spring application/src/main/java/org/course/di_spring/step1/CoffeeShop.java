package org.course.di_spring.step1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class CoffeeShop {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.course.di_spring.step1");
        context.refresh();

        Barista barista = context.getBean(Barista.class);
        barista.makeCoffee();
    }
}
