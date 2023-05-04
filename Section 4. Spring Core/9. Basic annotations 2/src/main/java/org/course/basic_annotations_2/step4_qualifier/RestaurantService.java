package org.course.basic_annotations_2.step4_qualifier;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class RestaurantService implements IRestaurantService {


    private Cook cook;

    public RestaurantService(Cook cook) {
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
