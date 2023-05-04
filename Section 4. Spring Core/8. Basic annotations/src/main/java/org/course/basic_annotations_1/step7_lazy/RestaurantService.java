package org.course.basic_annotations_1.step7_lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
class RestaurantService implements IRestaurantService {


    @Autowired
    private MenuOrder menuOrder;

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Autowired
    @Lazy
    private VeryOldRestaurantRepo veryOldRestaurantRepo;

    public RestaurantService() {
        System.out.println("Создан ресторан под названием: " + this.hashCode());
    }

    public void order(String food) {
        System.out.println("MenuOrder class: " + menuOrder.getClass());
        menuOrder.cook(food);

        boolean isOldStrategy = false;

        if (isOldStrategy) {
            veryOldRestaurantRepo.save(food);
        } else {
            restaurantRepo.save(food);
        }
    }



}
