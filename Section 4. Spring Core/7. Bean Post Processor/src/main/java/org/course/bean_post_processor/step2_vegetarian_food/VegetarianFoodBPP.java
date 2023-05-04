package org.course.bean_post_processor.step2_vegetarian_food;

import java.lang.reflect.Field;
import java.util.List;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.NonNull;


public class VegetarianFoodBPP implements BeanPostProcessor {

    private List<String> vegetarianFood;

    public VegetarianFoodBPP(@NonNull List<String> vegetarianFood) {
        this.vegetarianFood = vegetarianFood;
    }

    @Override
    @SneakyThrows
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof IRestaurantService) {

            Field field = bean.getClass().getDeclaredField("availableFood");
            field.setAccessible(true);
            field.set(bean, vegetarianFood);

        }

        return bean;

    }
}
