package org.course.basic_annotations_1.step6_bean;

import javax.annotation.PostConstruct;
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

    @PostConstruct
    public void init1(){
        System.out.println("init1");
    }

    public void init2(){
        System.out.println("init2");
    }


}
