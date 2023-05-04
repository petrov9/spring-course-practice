package org.course.basic_annotations_2.step3_list;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class RestaurantService implements IRestaurantService {



    private MenuOrder menuOrder;

    public RestaurantService(MenuOrder menuOrder) {
        this.menuOrder = menuOrder;
    }

    @PostConstruct
    public void init() {
        System.out.println("Создан ресторан под названием: " + this.hashCode());
    }

    public void order(String food) {
        System.out.println("MenuOrder class: " + menuOrder.getClass());
        menuOrder.cook(food);
    }



}
