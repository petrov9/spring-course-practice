package org.course.bean_scopes.step3;

import org.springframework.stereotype.Component;

@Component
class RestaurantService {

    private MenuOrder menuOrder;

    public RestaurantService(MenuOrder menuOrder) {
        System.out.println("Создан ресторан под названием: " + this);
        this.menuOrder = menuOrder;
    }

    public void order(String food) {
        menuOrder.cook(food);
    }
}