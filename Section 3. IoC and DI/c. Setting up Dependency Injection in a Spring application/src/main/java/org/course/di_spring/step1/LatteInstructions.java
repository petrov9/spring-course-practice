package org.course.di_spring.step1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
class LatteInstructions implements CoffeeInstructions {

    @Override
    public String getInstructions() {
        return "берем молоко, кофе, сахар, варим";
    }

    @Override
    public String getCoffeeName() {
        return "Латте";
    }
}
