package org.course.basic_annotations_2.step5_qualifier_primary;

import lombok.SneakyThrows;

class SlowCook implements Cook {

    @Override
    @SneakyThrows
    public void cook(String food) {
        System.out.println("Я медленный повар");
        System.out.println("Начал готовить: " + food);
        Thread.sleep(1000);
        System.out.println("Закончил готовить: " + food);
    }
}
