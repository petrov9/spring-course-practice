package org.course.basic_annotations_1.step4_component;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class.getPackageName());

        context.getBean(IRestaurantService.class).order("Pizza");
        context.getBean(IRestaurantService.class).order("Pizza");

        System.out.println(context.getBean("menuOrder", MenuOrder.class));

    }

}
