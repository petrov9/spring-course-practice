package org.course.bean_scopes.step1;

import org.springframework.stereotype.Component;

@Component
class RestaurantService {

    public RestaurantService() {
        System.out.println("Создан ресторан под названием: " + this);
    }
}
