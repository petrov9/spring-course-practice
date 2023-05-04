package org.course.basic_annotations_1.step3_import;

import org.springframework.beans.factory.annotation.Autowired;

class RestaurantService implements IRestaurantService {


    @Autowired
    private MenuOrder menuOrder;

    public RestaurantService() {
        System.out.println("Создан ресторан под названием: " + this.hashCode());
    }

    public void order(String food) {
        System.out.println("MenuOrder class: " + menuOrder.getClass());
        menuOrder.cook(food);
    }



}
