package org.course.bd;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
class RestaurantService {

    private Cook cook;

    public RestaurantService(@Qualifier("slow") Cook cook) {
        this.cook = cook;
    }

    @PostConstruct
    public void init() {
        System.out.println("Вызван метод init()");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Вызван метод destroy()");
    }


    public void order(String food) {
        System.out.println("Заказано: " + food);
        cook.cook(food);
        System.out.println("Приятного аппетита!");
    }
}
