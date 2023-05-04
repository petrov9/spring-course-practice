package org.course.spring_container.step2_config;

class RestaurantService {

    private Cook cook;

    public RestaurantService(Cook cook) {
        this.cook = cook;
    }


    public void order(String food) {
        System.out.println("Заказано: " + food);
        cook.cook(food);
        System.out.println("Приятного аппетита!");
    }
}
