package org.course.bd;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

class App {

    public static void main(String[] args) throws Exception{

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("org.course.bd");
        context.getBean(RestaurantService.class).order("Pizza");

        BeanDefinition beanDefinition = ((GenericApplicationContext) context).getBeanDefinition("restaurantService");
        System.out.println(beanDefinition);
        System.out.println(beanDefinition.getClass());

        System.out.println("-----------------------");

        GenericBeanDefinition mySuperClassBeanDefinition = new GenericBeanDefinition();
        mySuperClassBeanDefinition.setBeanClassName(MySuperClass.class.getName());

        ConstructorArgumentValues constructorArgumentValues = new ConstructorArgumentValues();
        constructorArgumentValues.addIndexedArgumentValue(0, "valueWithConstructor");
        mySuperClassBeanDefinition.setConstructorArgumentValues(constructorArgumentValues);

        mySuperClassBeanDefinition.setPropertyValues(mySuperClassBeanDefinition.getPropertyValues().add("myProperty", "myValue"));

//        mySuperClassBeanDefinition.setInitMethodName("wantInitMethod");
//        mySuperClassBeanDefinition.setDestroyMethodName("wantDestroyMethod");
        mySuperClassBeanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);

        ((GenericApplicationContext) context).registerBeanDefinition("mySuperClass", mySuperClassBeanDefinition);

        System.out.println("contains bean? " + context.containsBean("mySuperClass"));
        context.getBean(MySuperClass.class).myMethod();

        mySuperClassBeanDefinition = (GenericBeanDefinition) ((GenericApplicationContext) context).getBeanDefinition("mySuperClass");
        System.out.println(mySuperClassBeanDefinition);

        //
        System.out.println(context.getBean(MySuperClass.class).toString());
//        System.out.println(context.getBean(MySuperClass.class).toString());


        context.close();

    }

    static class MySuperClass {

//        @Value("${my.property}")
        @Setter
        private String myProperty;

        @Autowired
        private FastCook fastCook;

        public MySuperClass() {
            System.out.println("MySuperClass()");
        }


        public MySuperClass(String value) {
            System.out.println("value in constructor:" + value);
        }

        public void myMethod() {
            System.out.println("MySuperClass.myMethod()");
            System.out.println("is fast cook null ? " + (fastCook == null));
            System.out.println("myProperty = " + myProperty);
        }

        public void wantInitMethod() {
            System.out.println("MySuperClass.wantInitMethod()");
        }

        public void wantDestroyMethod() {
            System.out.println("MySuperClass.wantDestroyMethod()");
        }
    }
}
