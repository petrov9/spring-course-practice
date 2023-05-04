package org.course.basic_annotations_1.step7_lazy;

import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Deprecated
public class VeryOldRestaurantRepo {

    public VeryOldRestaurantRepo() {
        System.out.println("Создан репозиторий VeryOldRestaurantRepo");
    }

    @PostConstruct
    public void init() {
        System.out.println("Инициализация репозитория VeryOldRestaurantRepo");
    }

    public void save(String food){
        System.out.println("Класс @Deprecated, используйте RestaurantRepo");
        System.out.println("Сохраняю заказ на перфокарту: " + food);
    }

}
