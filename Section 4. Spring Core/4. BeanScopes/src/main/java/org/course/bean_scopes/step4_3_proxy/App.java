package org.course.bean_scopes.step4_3_proxy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.course.step4_3_proxy");

        // step 1
//        context.getBean(RestaurantService.class);
//        context.getBean(RestaurantService.class);

        // step 2
//        context.getBean(MenuOrder.class);
//        context.getBean(MenuOrder.class);

        //step3
//        context.getBean(RestaurantService.class).order("Pizza");
//        context.getBean(RestaurantService.class).order("Pizza");

        //step4.2 lookup
        context.getBean(RestaurantService.class).order("Pizza");
        context.getBean(RestaurantService.class).order("Pizza");
    }
}
