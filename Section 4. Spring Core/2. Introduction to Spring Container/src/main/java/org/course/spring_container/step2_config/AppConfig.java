package org.course.spring_container.step2_config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// и пример без конфигурации
class AppConfig {

    @Bean
    public RestaurantService restaurantService() {
        return new RestaurantService(cook());
    }

    @Bean
    public Cook cook() {
        System.out.println("Creating a new cook");
        return new SlowCook();
    }
}
