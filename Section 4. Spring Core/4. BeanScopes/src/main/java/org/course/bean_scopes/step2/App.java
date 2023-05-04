package org.course.bean_scopes.step2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.course.step2");

        // step 1
//        context.getBean(RestaurantService.class);
//        context.getBean(RestaurantService.class);

        // step 2
        context.getBean(MenuOrder.class);
        context.getBean(MenuOrder.class);
    }
}
