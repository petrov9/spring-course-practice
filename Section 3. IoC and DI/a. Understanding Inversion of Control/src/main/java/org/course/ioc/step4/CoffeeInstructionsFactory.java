package org.course.ioc.step4;

public class CoffeeInstructionsFactory {

    public static CoffeeInstructions createCoffeeInstructions(String coffeeName) {
        if (coffeeName.equals("Латте")) {
            return new LatteInstructions();
        } else if (coffeeName.equals("Эспрессо")) {
            return new EspressoInstructions();
        } else {
            throw new IllegalArgumentException("Неизвестный тип кофе");
        }
    }
}
