package org.course.bean_scopes.step3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.course.step3");

        // step 1
//        context.getBean(RestaurantService.class);
//        context.getBean(RestaurantService.class);

        // step 2
//        context.getBean(MenuOrder.class);
//        context.getBean(MenuOrder.class);

        //step3
        context.getBean(RestaurantService.class).order("Pizza");
        context.getBean(RestaurantService.class).order("Pizza");
    }
}
