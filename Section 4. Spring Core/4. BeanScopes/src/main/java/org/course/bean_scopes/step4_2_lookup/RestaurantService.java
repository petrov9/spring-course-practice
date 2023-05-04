package org.course.bean_scopes.step4_2_lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
abstract class RestaurantService {

    public RestaurantService() {
        System.out.println("Создан ресторан под названием: " + this);
    }

    public void order(String food) {
        MenuOrder menuOrder = createOrder();
        System.out.println("MenuOrder class: " + menuOrder.getClass());
        menuOrder.cook(food);
    }

    @Lookup
    protected abstract MenuOrder createOrder();
}
