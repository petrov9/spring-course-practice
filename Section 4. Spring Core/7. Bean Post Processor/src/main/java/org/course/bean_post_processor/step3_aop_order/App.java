package org.course.bean_post_processor.step3_aop_order;

import java.util.List;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class.getPackageName());

        context.getBean(IRestaurantService.class).order("Pizza");
        context.getBean(IRestaurantService.class).order2("Pizza");
    }

    @Bean
    public List<String> availableFood(){
        return List.of("Pizza", "Burger", "Steak");
    }

    @Bean
    public BeanPostProcessor vegetarianFood() {
        return new VegetarianFoodBPP(List.of("Salad", "Soup"));
    }

}
