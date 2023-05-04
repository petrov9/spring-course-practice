package org.course.bean_life_cycle.step4_lifecycle;

import javax.annotation.PostConstruct;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            "org.course.bean_life_cycle.step4_lifecycle");

//        context.getBean(MyClass.class);
    }


    @Bean
    public MyClass myClass() {
        return new MyClass();
    }

    static class MyClass {

        public MyClass() {
            System.out.println("by constructor");
        }

        @PostConstruct
        public void init() {
                System.out.println("by @post construct1");
        }

        @PostConstruct
        public void init2() {
            System.out.println("by @post construct2");
        }
    }
}
