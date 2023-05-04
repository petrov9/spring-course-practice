package org.course.di.step2;

class Barista3 {

    CoffeeInstructions coffeeInstructions;

    public void makeCoffee() {
        System.out.println("Получил рецепт: " + coffeeInstructions.getInstructions());
        System.out.println("Готовлю " + coffeeInstructions.getCoffeeName());
    }
}
