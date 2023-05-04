package org.course.bean_scopes.step4_5_custom_scope;

import java.util.function.Supplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
class App {

    public static void main(String[] args) throws Exception{
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("org.course.bean_scopes.step4_5_custom_scope");
        context.getBeanFactory().registerScope("myScope", new MyScope());


        context.getBean(RestaurantService.class).order("Pizza");
        context.getBean(RestaurantService.class).order("Pizza");
        Thread.sleep(6000);
        context.getBean(RestaurantService.class).order("Pizza");
        context.getBean(RestaurantService.class).order("Pizza");
    }

    @Bean
    public Supplier<MenuOrder> beanFactory(){
        return () -> menuOrder();
    }

    @Bean
    @Scope("myScope")
    public MenuOrder menuOrder(){
        return new MenuOrder();
    }
}
