package org.course.basic_annotations_1.step5_mvc;

import org.springframework.stereotype.Repository;

@Repository
public class RestaurantRepo {

    public void save(String food){
        System.out.println("Сохраняю заказ: " + food);
    }

}
