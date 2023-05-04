package org.course.basic_annotations_2.step6_qualifier_annotations;

import lombok.SneakyThrows;

class FastCook implements Cook {

    @Override
    @SneakyThrows
    public void cook(String food) {
        System.out.println("Я быстрый повар");
        System.out.println("Начал готовить: " + food);
        Thread.sleep(100);
        System.out.println("Закончил готовить: " + food);
    }
}
