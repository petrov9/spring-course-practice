package org.course.basic_annotations_2.step3_list;


import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
class MenuOrder {

    @PostConstruct
    public void init() {
        System.out.println("Создан заказ, id заказа " + this.hashCode());
    }

    public void cook(String food) {
        System.out.println("Заказ: " + this.hashCode());
        System.out.println("Начал готовить: " + food);
        System.out.println("Закончил готовить: " + food);
    }


}
