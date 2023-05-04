package org.course.bd;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("slow")
class SlowCook implements Cook {

    @Override
    @SneakyThrows
    public void cook(String food) {
        System.out.println("Я медленный повар");
        System.out.println("Начал готовить: " + food);
//        Thread.sleep(1000);
        System.out.println("Закончил готовить: " + food);
    }
}
