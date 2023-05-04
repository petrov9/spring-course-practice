package org.course.basic_annotations_2.step1_autowired;

import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class RestaurantService implements IRestaurantService {


    @Autowired(required = false)
    private MenuOrder menuOrder;


    @PostConstruct
    public void init() {
        System.out.println("Создан ресторан под названием: " + this.hashCode());
        System.out.println(menuOrder);
    }

    public void order(String food) {
        System.out.println("MenuOrder class: " + menuOrder.getClass());
        menuOrder.cook(food);
    }



}
