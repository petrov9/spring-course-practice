package org.course.bean_life_cycle.step3_aware;

    import javax.annotation.PostConstruct;
    import org.springframework.beans.BeansException;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.ApplicationContextAware;

class RestaurantService implements ApplicationContextAware {

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
        System.out.println("step3, Init method by @PostConstruct, class: " + this.getClass());
        System.out.println("restaurantName: " + restaurantName);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("step2, aware and restaurantName already set:" + restaurantName);
        System.out.println();
    }
}
