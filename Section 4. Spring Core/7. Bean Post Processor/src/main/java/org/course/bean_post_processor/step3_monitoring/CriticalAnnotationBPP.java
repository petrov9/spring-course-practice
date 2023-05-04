package org.course.bean_post_processor.step3_monitoring;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.reflections.ReflectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;



@Component
public class CriticalAnnotationBPP implements BeanPostProcessor, Ordered {

    private Map<String, Map<String, Integer>> criticalMethodsMap = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("execute critical bpp");


        Map<String, Integer> criticalMethods = ReflectionUtils.getMethods(bean.getClass(), method -> method.isAnnotationPresent(Critical.class))
            .stream().collect(Collectors.toMap(Method::getName, method -> method.getAnnotation(Critical.class).maxTime()));

        if (criticalMethods.isEmpty()) {
            return bean;
        } else {
            criticalMethodsMap.put(beanName, criticalMethods);
        }

        return bean;

    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (!criticalMethodsMap.containsKey(beanName)) {
            return bean;
        }

        Map<String, Integer> beanCriticalMethods = criticalMethodsMap.get(beanName);

        return Proxy.newProxyInstance(
            this.getClass().getClassLoader(),
            bean.getClass().getInterfaces(),
            (proxy, method, args) -> {

                if (beanCriticalMethods.containsKey(method.getName())) {
                    long start = System.currentTimeMillis();
                    Object invoke = method.invoke(bean, args);
                    long end = System.currentTimeMillis();

                    int maxExecuteTime = beanCriticalMethods.get(method.getName());

                    if (end - start > maxExecuteTime) {
                        System.out.println("метод: " + method.getName() + " выполнялся слишком долго: " + (end - start) + " ms, максимально допустимое время: " + maxExecuteTime + " ms");
                    }

                    return invoke;

                }

                Object invoke = method.invoke(bean, args);
                return invoke;

            }
        );

    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 3;
    }
}
