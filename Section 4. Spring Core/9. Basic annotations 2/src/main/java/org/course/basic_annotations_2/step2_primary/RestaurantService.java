package org.course.basic_annotations_2.step2_primary;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class RestaurantService implements IRestaurantService {

    @Autowired
    private String name;


    private MenuOrder menuOrder;

    public RestaurantService(MenuOrder menuOrder) {
        this.menuOrder = menuOrder;
    }

    @PostConstruct
    public void init() {
        System.out.println("Создан ресторан под названием: " + this.hashCode());
        System.out.println("name: " + name);
    }

    public void order(String food) {
        System.out.println("MenuOrder class: " + menuOrder.getClass());
        menuOrder.cook(food);
    }



}
