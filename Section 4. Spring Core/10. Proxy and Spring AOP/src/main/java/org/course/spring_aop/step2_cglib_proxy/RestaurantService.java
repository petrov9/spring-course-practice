package org.course.spring_aop.step2_cglib_proxy;

import org.springframework.stereotype.Component;

@Component
class RestaurantService implements IRestaurantService {


    @Override
    public String order(String food) {
        System.out.println("Принят заказ: " + food);

        return "Ваш заказ готов";
    }


}
