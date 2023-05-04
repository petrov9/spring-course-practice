package org.course.bean_post_processor.step1_post_construct_dynamic_proxy;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class RestaurantService implements IRestaurantService {

//    @Autowired
    private MenuOrder menuOrder;

    public RestaurantService(MenuOrder menuOrder) {
        System.out.println("Создан ресторан под названием: " /*+ this.hashCode()*/);
        System.out.println("класс: " + this.getClass());
        this.menuOrder = menuOrder;
    }

    public void order(String food) {
//        MenuOrder menuOrder = createOrder();
        System.out.println("MenuOrder class: " + menuOrder.getClass());
        menuOrder.cook(food);
    }

    @PostConstruct
    public void myInit() {
        System.out.println("my init");
    }

}
