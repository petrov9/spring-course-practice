package org.course.ioc.step3;

class Barista {

    private CoffeeInstructions coffeeInstructions;

    //  Класс больше не зависит от конкретного типа рецепта
    public Barista(CoffeeInstructions coffeeInstructions) {
        this.coffeeInstructions = coffeeInstructions;
    }

    public void makeCoffee() {
        System.out.println("Получил рецепт: " + coffeeInstructions.getInstructions());
        System.out.println("Готовлю " + coffeeInstructions.getCoffeeName());
    }
}
