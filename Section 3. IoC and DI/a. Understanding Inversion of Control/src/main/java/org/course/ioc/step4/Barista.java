package org.course.ioc.step4;

class Barista {

    private CoffeeInstructions coffeeInstructions;

    public Barista(CoffeeInstructions coffeeInstructions) {
        this.coffeeInstructions = coffeeInstructions;
    }

    public void makeCoffee() {
        System.out.println("Получил рецепт: " + coffeeInstructions.getInstructions());
        System.out.println("Готовлю " + coffeeInstructions.getCoffeeName());
    }
}
