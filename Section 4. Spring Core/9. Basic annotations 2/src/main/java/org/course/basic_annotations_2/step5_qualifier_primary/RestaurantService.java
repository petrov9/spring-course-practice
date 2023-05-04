package org.course.basic_annotations_2.step5_qualifier_primary;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
class RestaurantService implements IRestaurantService {



    private Cook cook;

    public RestaurantService(@Qualifier("slow") Cook cook) {
        this.cook = cook;
    }

    @PostConstruct
    public void init() {
        System.out.println("Создан ресторан под названием: " + this.hashCode());
    }

    public void order(String food) {
        cook.cook(food);
    }



}
