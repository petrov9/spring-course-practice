package org.course.di.step2;

class CoffeeShop {

    public static void main(String[] args) {

        // Создали класс который будет создавать и внедрять зависимости
        CoffeeInstructionsDependencyInjector injector = new LatteInstructionsDependencyInjector();
        // Получаем Barista с уже созданной зависимостью
        Barista1 barista = injector.getBarista();
        barista.makeCoffee();
    }
}
