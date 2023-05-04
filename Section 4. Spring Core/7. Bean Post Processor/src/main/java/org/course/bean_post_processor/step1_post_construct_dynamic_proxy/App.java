package org.course.bean_post_processor.step1_post_construct_dynamic_proxy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class.getPackageName());

        context.getBean(IRestaurantService.class).order("Pizza");
    }

}
