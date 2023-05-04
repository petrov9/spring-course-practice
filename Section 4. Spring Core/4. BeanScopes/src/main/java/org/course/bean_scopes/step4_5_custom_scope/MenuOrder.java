package org.course.bean_scopes.step4_5_custom_scope;

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
