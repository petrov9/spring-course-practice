package org.course.bean_post_processor.step3_aop_order;

import java.util.List;
import javax.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
class RestaurantService implements IRestaurantService {


    private List<String> availableFood;

    private MenuOrder menuOrder;

    public RestaurantService(MenuOrder menuOrder, List<String> availableFood) {
        System.out.println("Создан ресторан под названием: " + this.hashCode());
        this.menuOrder = menuOrder;
        this.availableFood = availableFood;
    }

    public void order(String food) {

        if (availableFood.contains(food)) {
            menuOrder.cook(food);
        } else {
            System.out.println("Блюда " + food + " нет в меню");
        }

    }

    @SneakyThrows
    public void order2(String food) {

        Thread.sleep(100);

        if (availableFood.contains(food)) {
            menuOrder.cook(food);
        } else {
            System.out.println("Блюда " + food + " нет в меню");
        }

    }

    @PostConstruct
    public void myInit() {
        System.out.println("my init");
    }

}
