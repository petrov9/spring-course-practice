package org.course.bean_scopes.step4_5_custom_scope;

import java.util.function.Supplier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
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
