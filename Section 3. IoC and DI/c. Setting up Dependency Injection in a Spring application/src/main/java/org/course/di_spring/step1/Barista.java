package org.course.di_spring.step1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class Barista {

    // Внедрение зависимости через поле
    @Autowired
    private CoffeeInstructions coffeeInstructions;

    // Внедрение зависимости через конструктор
    /*public Barista(CoffeeInstructions coffeeInstructions) {
        this.coffeeInstructions = coffeeInstructions;
    }*/

    // Внедрение зависимости через сеттер
//    @Autowired
//    public void blabla(CoffeeInstructions coffeeInstructions) {
//        this.coffeeInstructions = coffeeInstructions;
//    }

    public void makeCoffee() {
        System.out.println("Получил рецепт: " + coffeeInstructions.getInstructions());
        System.out.println("Готовлю " + coffeeInstructions.getCoffeeName());
    }
}
