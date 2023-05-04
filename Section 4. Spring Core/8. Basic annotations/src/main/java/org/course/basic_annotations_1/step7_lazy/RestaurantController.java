package org.course.basic_annotations_1.step7_lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    public void wantOrder(String food){
        restaurantService.order(food);
    }
}
