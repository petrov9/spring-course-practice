package org.course.spring_container.step3_annotations;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("slow")
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
