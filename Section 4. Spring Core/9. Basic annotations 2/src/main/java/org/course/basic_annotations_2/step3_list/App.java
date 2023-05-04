package org.course.basic_annotations_2.step3_list;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class.getPackageName());

        context.getBean(IRestaurantService.class).order("Pizza");
        context.getBean(IRestaurantService.class).order("Pizza");

        System.out.println(context.getBean("menuOrder", MenuOrder.class));

    }

    @Bean
    public String apple() {
        return "apple";
    }

    @Bean
    public String banana() {
        return "banana";
    }

    @Bean
    public List<String> fruits() {
        return List.of("melon", "orange");
    }



}
