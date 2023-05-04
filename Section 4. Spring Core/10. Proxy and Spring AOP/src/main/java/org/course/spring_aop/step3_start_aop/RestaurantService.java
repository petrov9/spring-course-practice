package org.course.spring_aop.step3_start_aop;

import javax.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class RestaurantService implements IRestaurantService {


    @Autowired(required = false)
    private MenuOrder menuOrder;


    @PostConstruct
    public void init() {
        System.out.println("Создан ресторан под названием: " + this.hashCode());
    }

    @Critical(maxTime = 10)
    @SneakyThrows
    @Override
    public String order(String food) {

//        Thread.sleep(1500);

        menuOrder.cook(food);
        return "Ваш заказ готов";
    }



}
