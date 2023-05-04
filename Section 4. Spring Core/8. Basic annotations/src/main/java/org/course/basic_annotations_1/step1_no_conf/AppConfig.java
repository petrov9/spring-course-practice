package org.course.basic_annotations_1.step1_no_conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

//@Configuration
@ComponentScans({
    @ComponentScan("org.course.package1"),
    @ComponentScan("org.course.package2")
})
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
