package org.course.bean_life_cycle.step1_init_with_bfpp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class.getPackageName());

        context.getBean(RestaurantService.class).order("Pizza");
        context.getBean(RestaurantService.class).order("Pizza");

        System.out.println("Initialization is finished, closing context");
        context.close();
    }

    @Bean(initMethod = "initWithCustom", destroyMethod = "destroyWithCustom")
    public RestaurantService restaurantService() {
        return new RestaurantService(menuOrder());
    }

    @Bean(initMethod = "initWithCustom", destroyMethod = "destroyWithCustom")
    @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public MenuOrder menuOrder() {
        return new MenuOrder();
    }
}
