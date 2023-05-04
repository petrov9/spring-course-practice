package org.course.bean_factory_post_processor.step1_init_with_bfpp;

import java.util.Arrays;
import java.util.stream.Stream;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class InitMethodFactoryPostProcessor implements BeanFactoryPostProcessor {

    @SneakyThrows
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

        Arrays.asList(beanDefinitionNames).forEach(bd -> {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(bd);

            String beanClassName = beanDefinition.getBeanClassName();

            if (beanClassName == null || !beanClassName.startsWith("org.course.bean_factory_post_processor")) {
                return;
            }

            Class<?> beanClass = null;
            try {
                beanClass = Class.forName(beanClassName);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            if (beanClass.isAnnotationPresent(InitMethod.class)) {
                InitMethod annotation = beanClass.getAnnotation(InitMethod.class);
                String initMethodName = annotation.value();
                beanDefinition.setInitMethodName(initMethodName);

            }


        });

    }
}
