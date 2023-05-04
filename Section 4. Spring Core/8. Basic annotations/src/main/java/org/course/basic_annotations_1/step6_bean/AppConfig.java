package org.course.basic_annotations_1.step6_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
public class AppConfig {

    @Bean
    @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public MenuOrder menuOrder1() {
        System.out.println("вызван метод menuOrder()");
        return new MenuOrder();
    }

    @Bean(initMethod = "init2")
    public RestaurantService restaurantService() {
        System.out.println("вызван метод restaurantService()");

        MenuOrder menuOrder = menuOrder1();
        return new RestaurantService(menuOrder);
    }

}
