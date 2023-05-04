package org.course.ioc.step3;

class CoffeeShop {

    public static void main(String[] args) {
        CoffeeInstructions latteInstructions = new LatteInstructions();
        CoffeeInstructions espressoInstructions = new EspressoInstructions();

        Barista barista = new Barista(espressoInstructions);
        barista.makeCoffee();
    }
}
