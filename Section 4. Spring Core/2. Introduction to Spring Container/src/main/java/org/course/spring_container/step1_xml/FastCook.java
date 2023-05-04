package org.course.spring_container.step1_xml;

import lombok.SneakyThrows;

class FastCook implements Cook {

    @Override
    @SneakyThrows
    public void cook(String food) {
        System.out.println("Начал готовить: " + food);
        Thread.sleep(1000);
        System.out.println("Закончил готовить: " + food);
    }
}
