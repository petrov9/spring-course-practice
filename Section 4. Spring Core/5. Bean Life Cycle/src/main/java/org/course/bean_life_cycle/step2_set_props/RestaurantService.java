package org.course.bean_life_cycle.step2_set_props;


import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;

class RestaurantService {

    @Value("Макдональдс")
    private String restaurantName;

    private MenuOrder menuOrder;

    public RestaurantService(MenuOrder menuOrder) {
        System.out.println("Создан ресторан под названием: " + this);
        this.menuOrder = menuOrder;
        System.out.println("restaurantName: " + restaurantName);
    }

    public void order(String food) {
        System.out.println("MenuOrder class: " + menuOrder.getClass());
        menuOrder.cook(food);
    }

    @PostConstruct
    public void initWithAnnotation() {
        System.out.println("Init method by @PostConstruct, class: " + this.getClass());
        System.out.println("restaurantName: " + restaurantName);
    }


}