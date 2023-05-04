package org.course.di.step2;

class Barista1 {

    private CoffeeInstructions coffeeInstructions;
    public Barista1(CoffeeInstructions coffeeInstructions) {
        this.coffeeInstructions = coffeeInstructions;
    }


    public void makeCoffee() {
        System.out.println("Получил рецепт: " + coffeeInstructions.getInstructions());
        System.out.println("Готовлю " + coffeeInstructions.getCoffeeName());
    }
}
