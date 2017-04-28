package net.lezhang.spring.beanbasic;

public class PersonFactory {
    public Person getInstance(int id) {
        System.out.println("Creating person using factory class and arguments");
        return new Person(id, "FactoryBornWithArguments");
    }

}
