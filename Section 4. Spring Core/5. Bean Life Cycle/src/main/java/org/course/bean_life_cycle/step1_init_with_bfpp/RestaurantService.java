package org.course.bean_life_cycle.step1_init_with_bfpp;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

class RestaurantService implements InitializingBean, DisposableBean {

    private MenuOrder menuOrder;

    public RestaurantService(MenuOrder menuOrder) {
        System.out.println("Создан ресторан под названием: " + this);
        this.menuOrder = menuOrder;
    }

    public void order(String food) {
//        MenuOrder menuOrder = createOrder();
        System.out.println("MenuOrder class: " + menuOrder.getClass());
        menuOrder.cook(food);
    }

    @PostConstruct
    public void initWithAnnotation() {
        System.out.println("Init method by @PostConstruct, class: " + this.getClass());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Init method by afterPropertiesSet(), class: " + this.getClass());
    }

    public void initWithCustom() {
        System.out.println("Init method by @Bean(initMethod='initWithCustom'), class: " + this.getClass());
    }


    @PreDestroy
    public void destroyWithAnnotation() {
        System.out.println("Destroy method by @PreDestroy, class: " + this.getClass());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy method by DisposableBean, class: " + this.getClass());
    }

    public void destroyWithCustom() {
        System.out.println("Destroy method by @Bean(destroyMethod='destroyWithCustom'), class: " + this.getClass());
    }

}
