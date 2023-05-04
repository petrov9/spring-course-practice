package org.course.spring_container.step2_config;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class App {

    public static void main(String[] args) {

//        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext();
//        context.refresh();

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("org.course.spring_container.step2_config");

        context.getBean(RestaurantService.class).order("Pizza");
    }
}
