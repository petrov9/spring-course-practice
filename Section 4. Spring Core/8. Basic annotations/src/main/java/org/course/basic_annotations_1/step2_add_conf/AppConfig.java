package org.course.basic_annotations_1.step2_add_conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
public class AppConfig {

    @Bean
    @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public MenuOrder menuOrder() {
        System.out.println("вызван метод menuOrder()");
        return new MenuOrder();
    }

    @Bean
    public IRestaurantService restaurantService() {
        System.out.println("вызван метод restaurantService()");

        MenuOrder menuOrder = menuOrder();
        return new RestaurantService(menuOrder);
    }

}
