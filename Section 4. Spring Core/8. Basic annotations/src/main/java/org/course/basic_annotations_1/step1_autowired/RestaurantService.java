package org.course.basic_annotations_1.step1_autowired;

import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class RestaurantService implements IRestaurantService {

    @Value("super puper")
    private String name1;

    @Value("${restaurant.name:default_name}")
    private String name2;

    @Value("#{{'a': 1, 'b': 2}}")
    private Map<String, Integer> map;


    @Autowired
    private MenuOrder menuOrder;

    @PostConstruct
    public void init() {
        System.out.println("Создан ресторан под названием: " + name2);
        System.out.println("map: " + map);
    }

    public void order(String food) {
        System.out.println("MenuOrder class: " + menuOrder.getClass());
        menuOrder.cook(food);
    }



}
