package org.course.bean_factory_post_processor.step1_init_with_bfpp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@InitMethod("myInit")
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

    public void myInit() {
        System.out.println("my init");
    }

}
