package org.course.di_spring.step1;

import org.springframework.stereotype.Component;

@Component
class EspressoInstructions implements CoffeeInstructions {

    @Override
    public String getInstructions() {
        return "берем кофе, сахар, варим";
    }

    @Override
    public String getCoffeeName() {
        return "Эспрессо";
    }
}
