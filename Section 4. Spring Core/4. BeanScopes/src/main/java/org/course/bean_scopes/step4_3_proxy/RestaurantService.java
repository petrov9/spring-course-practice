package org.course.bean_scopes.step4_3_proxy;

import org.springframework.stereotype.Component;

@Component
class RestaurantService {

    private MenuOrder menuOrder;

    public RestaurantService(MenuOrder menuOrder) {
        System.out.println("Создан ресторан под названием: " + this);
        this.menuOrder = menuOrder;
    }

    public void order(String food) {
//        MenuOrder menuOrder = createOrder();
        System.out.println("MenuOrder class: " + menuOrder.getClass());
        menuOrder.cook(food);
    }
}
