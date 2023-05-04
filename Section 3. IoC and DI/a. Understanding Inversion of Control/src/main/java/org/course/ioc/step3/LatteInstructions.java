package org.course.ioc.step3;

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
