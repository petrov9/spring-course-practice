package org.course.bean_scopes.step2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
class MenuOrder {

    public MenuOrder() {
        System.out.println("Создан заказ, id заказа " + this.hashCode());
    }
}
