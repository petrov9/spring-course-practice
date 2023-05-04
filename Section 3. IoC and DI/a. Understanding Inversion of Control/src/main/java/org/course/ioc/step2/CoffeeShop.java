package org.course.ioc.step2;

class CoffeeShop {

    public static void main(String[] args) {
        LatteInstructions latteInstructions = new LatteInstructions();
        Barista barista = new Barista(latteInstructions);
        barista.makeCoffee();
    }
}
