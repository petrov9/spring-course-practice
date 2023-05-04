package org.course.basic_annotations_1.step3_import;


import javax.annotation.PostConstruct;

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
