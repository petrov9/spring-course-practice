package org.course.basic_annotations_1.step2_add_conf;

import org.springframework.stereotype.Component;

@Component
class RestaurantService implements IRestaurantService {


    private MenuOrder menuOrder;

    public RestaurantService(MenuOrder menuOrder) {
        System.out.println("Создан ресторан под названием: " + this.hashCode());
        this.menuOrder = menuOrder;
        System.out.println("");
    }

    public void order(String food) {
        System.out.println("MenuOrder class: " + menuOrder.getClass());
        menuOrder.cook(food);
    }



}
