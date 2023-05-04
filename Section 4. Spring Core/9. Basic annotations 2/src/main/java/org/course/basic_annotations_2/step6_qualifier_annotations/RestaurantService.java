package org.course.basic_annotations_2.step6_qualifier_annotations;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
class RestaurantService implements IRestaurantService {

    @Autowired
    @FastCookQualifier
    @CookQualifier
    private Cook cook;


    @PostConstruct
    public void init() {
        System.out.println("Создан ресторан под названием: " + this.hashCode());
    }

    public void order(String food) {
        cook.cook(food);
    }



}
