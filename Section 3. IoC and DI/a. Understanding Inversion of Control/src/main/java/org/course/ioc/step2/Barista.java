package org.course.ioc.step2;

class Barista {

    private LatteInstructions latteInstructions;

    // класс Barista получает объект LatteInstructions извне
    public Barista(LatteInstructions latteInstructions) {
        this.latteInstructions = latteInstructions;
    }

    public void makeCoffee() {
        System.out.println("Получил рецепт: " + latteInstructions.getInstructions());
        System.out.println("Готовлю " + latteInstructions.getCoffeeName());
    }
}
