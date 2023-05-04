package org.course.bean_post_processor.step2_vegetarian_food;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
class MenuOrder {

    public MenuOrder() {
        System.out.println("Создан заказ, id заказа " + this.hashCode());
    }

    public void cook(String food) {
        System.out.println("Начал готовить: " + food);
        System.out.println("Закончил готовить: " + food);
    }


    public void init() {
        System.out.println("my init");
    }

}
