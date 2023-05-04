package org.course.bean_post_processor.step3_monitoring;

import java.util.List;
import javax.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class RestaurantService implements IRestaurantService {


    @Autowired
    private List<String> availableFood;

    private MenuOrder menuOrder;

    public RestaurantService(MenuOrder menuOrder) {
        System.out.println("Создан ресторан под названием: " + this.hashCode());
        this.menuOrder = menuOrder;
//        this.availableFood = availableFood;
    }

    @Critical(maxTime = 1)
    public void order(String food) {

        if (availableFood.contains(food)) {
            menuOrder.cook(food);
        } else {
            System.out.println("Блюда " + food + " нет в меню");
        }

    }

    @Critical(maxTime = 10)
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
