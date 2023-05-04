package org.course.bean_scopes.step4_4_function;

import java.util.function.Supplier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.course.step4_4_function");

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

    @Bean
    public Supplier<MenuOrder> beanFactory(){
        return () -> menuOrder();
    }

    @Bean
    @Scope("prototype")
    public MenuOrder menuOrder(){
        return new MenuOrder();
    }
}
