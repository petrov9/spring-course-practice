package org.course.di.step1;

class EspressoInstructionsDependencyInjector implements CoffeeInstructionsDependencyInjector {

    @Override
    public Barista getBarista() {
        // 1. Создали зависимость для Barista
        CoffeeInstructions instructions = new EspressoInstructions();
        // 2. Передали зависимость в Barista через конструктор
        Barista barista = new Barista(instructions);

        return barista;
    }
}
