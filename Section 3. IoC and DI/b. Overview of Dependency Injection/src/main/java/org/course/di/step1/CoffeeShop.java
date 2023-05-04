package org.course.di.step1;

class CoffeeShop {

    public static void main(String[] args) {

        // Создали класс который будет создавать и внедрять зависимости
        CoffeeInstructionsDependencyInjector injector = new EspressoInstructionsDependencyInjector();
        // Получаем Barista с уже созданной зависимостью
        Barista barista = injector.getBarista();
        barista.makeCoffee();
    }
}
