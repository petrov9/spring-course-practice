package org.course.basic_annotations_1.step3_import;

import org.springframework.context.annotation.Bean;


public class AppConfig2 {

    @Bean
    public IRestaurantService restaurantService() {
        System.out.println("вызван метод restaurantService()");
        return new RestaurantService();
    }

}
