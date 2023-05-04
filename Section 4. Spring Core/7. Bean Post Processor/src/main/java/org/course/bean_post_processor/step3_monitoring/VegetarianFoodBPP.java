package org.course.bean_post_processor.step3_monitoring;

import java.lang.reflect.Field;
import java.util.List;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;


//@Component
public class VegetarianFoodBPP implements BeanPostProcessor, PriorityOrdered {

    private List<String> vegetarianFood;

    public VegetarianFoodBPP() {
        this.vegetarianFood = List.of("Salad", "Soup");
    }

    @Override
    @SneakyThrows
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("execute vegetarian bpp");

        if (bean instanceof IRestaurantService) {

            Field field = bean.getClass().getDeclaredField("availableFood");
            field.setAccessible(true);
            field.set(bean, vegetarianFood);

        }

        return bean;

    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 2;
    }
}
