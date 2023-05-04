package org.course.di.step2;

class LatteInstructionsDependencyInjector implements CoffeeInstructionsDependencyInjector {

    @Override
    public Barista1 getBarista() {
        CoffeeInstructions instructions = new LatteInstructions();

        // Внедрение зависимости через конструктор
        Barista1 barista1 = new Barista1(instructions);

        // Внедрение зависимости через сеттер
        Barista2 barista2 = new Barista2();
        barista2.setCoffeeInstructions(instructions);

        // Внедрение зависимости через поле
        Barista3 barista3 = new Barista3();
        barista3.coffeeInstructions = instructions;

        return barista1;
    }
}
