package org.course.spring_container.step3_annotations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
class RestaurantService {

    private Cook cook;

    public RestaurantService(@Qualifier("slow") Cook cook) {
        this.cook = cook;
    }


    public void order(String food) {
        System.out.println("Заказано: " + food);
        cook.cook(food);
        System.out.println("Приятного аппетита!");
    }
}
