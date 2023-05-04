package org.course.basic_annotations_1.step6_bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        context.getBean(IRestaurantService.class).order("Pizza");
        context.getBean(IRestaurantService.class).order("Pizza");

//        System.out.println(context.getBean("menuorder1"));
    }

}
