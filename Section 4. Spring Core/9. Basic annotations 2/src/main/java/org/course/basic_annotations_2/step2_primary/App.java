package org.course.basic_annotations_2.step2_primary;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

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
//    @Primary
    public String myStr1() {
        return "myBeanStr1";
    }

    @Bean
    public String myStr2() {
        return "myBeanStr2";
    }


}
