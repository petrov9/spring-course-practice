package org.course.basic_annotations_1.step5_mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class RestaurantService implements IRestaurantService {


    @Autowired
    private MenuOrder menuOrder;

    @Autowired
    private RestaurantRepo restaurantRepo;

    public RestaurantService() {
        System.out.println("Создан ресторан под названием: " + this.hashCode());
    }

    public void order(String food) {
        System.out.println("MenuOrder class: " + menuOrder.getClass());
        menuOrder.cook(food);
        restaurantRepo.save(food);
    }



}
