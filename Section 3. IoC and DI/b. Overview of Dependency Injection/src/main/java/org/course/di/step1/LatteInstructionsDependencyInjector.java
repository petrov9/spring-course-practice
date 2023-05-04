package org.course.di.step1;

class LatteInstructionsDependencyInjector implements CoffeeInstructionsDependencyInjector {

    @Override
    public Barista getBarista() {
        // 1. Создали зависимость для Barista
        CoffeeInstructions instructions = new LatteInstructions();
        // 2. Передали зависимость в Barista через конструктор
        Barista barista = new Barista(instructions);

        return barista;
    }
}
