package org.course.spring_container.step3_annotations;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
class FastCook implements Cook {

    @Override
    @SneakyThrows
    public void cook(String food) {
        System.out.println("Я быстрый повар");
        System.out.println("Начал готовить: " + food);
        Thread.sleep(1000);
        System.out.println("Закончил готовить: " + food);
    }
}
