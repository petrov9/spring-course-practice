package org.course.spring_container.step2_config;

import lombok.SneakyThrows;

class SlowCook implements Cook {

    @Override
    @SneakyThrows
    public void cook(String food) {
        System.out.println("Я медленный повар");
        System.out.println("Начал готовить: " + food);
        Thread.sleep(5000);
        System.out.println("Закончил готовить: " + food);
    }
}
