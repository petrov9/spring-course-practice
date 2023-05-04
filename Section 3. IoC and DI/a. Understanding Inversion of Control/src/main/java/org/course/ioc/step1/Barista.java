package org.course.ioc.step1;

class Barista {

    // класс Barista сам создает объект LatteInstructions
    private LatteInstructions latteInstructions = new LatteInstructions();

    public void makeCoffee() {
        System.out.println("Получил рецепт: " + latteInstructions.getInstructions());
        System.out.println("Готовлю " + latteInstructions.getCoffeeName());
    }
}
