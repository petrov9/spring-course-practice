package org.course.ioc.step4;

class CoffeeShop {

    public static void main(String[] args) {
        // Наш код все еще сам создает объекты
        CoffeeInstructions coffeeInstructions = CoffeeInstructionsFactory.createCoffeeInstructions("Эспрессо");
        Barista barista = new Barista(coffeeInstructions);
        barista.makeCoffee();
    }
}
