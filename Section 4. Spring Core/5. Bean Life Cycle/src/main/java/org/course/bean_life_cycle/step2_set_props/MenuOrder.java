package org.course.bean_life_cycle.step2_set_props;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

class MenuOrder implements InitializingBean, DisposableBean {

    public MenuOrder() {
        System.out.println("Создан заказ, id заказа " + this.hashCode());
    }

    public void cook(String food) {
        System.out.println("Начал готовить: " + food);
        System.out.println("Закончил готовить: " + food);
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
