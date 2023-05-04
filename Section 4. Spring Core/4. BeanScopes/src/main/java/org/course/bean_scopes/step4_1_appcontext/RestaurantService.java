package org.course.bean_scopes.step4_1_appcontext;

    import org.springframework.beans.BeansException;
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.ApplicationContextAware;
    import org.springframework.stereotype.Component;

@Component
class RestaurantService implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public RestaurantService() {
        System.out.println("Создан ресторан под названием: " + this);
    }

    public void order(String food) {
        MenuOrder menuOrder = applicationContext.getBean(MenuOrder.class);
        System.out.println("MenuOrder class: " + menuOrder.getClass());
        menuOrder.cook(food);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
