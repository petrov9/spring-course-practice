package org.course.bean_scopes.step1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.course.step1");

        // step 1
        context.getBean(RestaurantService.class);
        context.getBean(RestaurantService.class);
    }
}
