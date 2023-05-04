package org.course.bean_scopes.step4_4_function;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

//@Component
//@Scope(value = "prototype")
class MenuOrder {

    public MenuOrder() {
        System.out.println("Создан заказ, id заказа " + this.hashCode());
    }

    public void cook(String food) {
        System.out.println("Начал готовить: " + food);
        System.out.println("Закончил готовить: " + food);
    }
}
