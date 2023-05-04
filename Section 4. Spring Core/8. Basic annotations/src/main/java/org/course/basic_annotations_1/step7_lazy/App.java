package org.course.basic_annotations_1.step7_lazy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class.getPackageName());

        context.getBean(RestaurantController.class).wantOrder("Pizza");
        context.getBean(RestaurantController.class).wantOrder("Salad");

    }

}
