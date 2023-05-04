package org.course.bean_scopes.step4_4_function;

import java.util.function.Supplier;
import org.springframework.stereotype.Component;

@Component
class RestaurantService {

    private Supplier<MenuOrder> beanFactory;

    public RestaurantService(Supplier<MenuOrder> beanFactory) {
        System.out.println("Создан ресторан под названием: " + this);
        this.beanFactory = beanFactory;
    }

    public void order(String food) {
        MenuOrder menuOrder = beanFactory.get();
        System.out.println("MenuOrder class: " + menuOrder.getClass());
        menuOrder.cook(food);
    }
}
