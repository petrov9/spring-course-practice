package org.course.basic_annotations_1.step2_add_conf;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        context.getBean(IRestaurantService.class).order("Pizza");
        context.getBean(IRestaurantService.class).order("Pizza");
    }

}
