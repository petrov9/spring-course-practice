package org.course.ioc.step4;

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
