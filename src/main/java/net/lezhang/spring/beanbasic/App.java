package net.lezhang.spring.beanbasic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import net.lezhang.spring.autowire.Logger;
import net.lezhang.spring.autowire.Logger2;
import net.lezhang.spring.autowire.Logger3;
import net.lezhang.spring.autowire.LoggerWithAutowire;
import net.lezhang.spring.autowire.LoggerWithComponent;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext context = new FileSystemXmlApplicationContext("myBeans.xml");
        Person person = (Person)context.getBean("person");
        person.speak();
        
        Person person1 = (Person)context.getBean("person1");
        person1.speak();
        
        // singleton as default scope
        Person person2 = (Person)context.getBean("person1");
        person2.speak();
        System.out.println("person2 == person1: " + (person2 == person1)); // should be true
        
        // using properties file
        person2 = (Person)context.getBean("person2");
        person2.speak();
        System.out.println("Fav Fruits: " + person2.getFavFruits());
        System.out.println("Friends: " + person2.getFriends());
        System.out.println("Fav Books: " + person2.getFavBooks());
        System.out.println("Relations: " + person2.getRelations());

        // using factory method
        Person person3 = (Person)context.getBean("person3");
        person3.speak();

        // using factory method with arguments
        Person person4 = (Person)context.getBean("person4");
        person4.speak();

        System.out.println("Testing SPEL...");
        Person person5 = (Person)context.getBean("person5");
        person5.speak();



        System.out.println("Testing autowire by type..." );
        Logger logger = (Logger)context.getBean("logger");
        logger.writeConsole("Hello console");
        logger.writeFile("Hello file");
        
        System.out.println("Testing autowire by name..." );
        Logger2 logger2 = (Logger2)context.getBean("logger2");
        logger2.writeConsole("Hello console");
        logger2.writeFile("Hello file");

        System.out.println("Testing autowire by constructor..." );
        Logger3 logger3 = (Logger3)context.getBean("logger3");
        logger3.writeConsole("Hello console");
        logger3.writeFile("Hello file");

        System.out.println("Testing autowire annotations..." );
        LoggerWithAutowire loggerWA = (LoggerWithAutowire)context.getBean("loggerWithAnnotation");
        loggerWA.writeConsole("Hello console");
        loggerWA.writeFile("Hello file");
        loggerWA.writeConsole2("Hello console2");
        loggerWA.writeConsole2Resource("Hello console2 with Resource");
        loggerWA.writeConsole2Inject("Hello console2 with Inject");

        System.out.println("Testing Component annotations..." );
        LoggerWithComponent loggerWC = (LoggerWithComponent)context.getBean("loggerWithComponent");
        loggerWC.writeConsole("Hello console");
        loggerWC.writeFile("Hello file");


        ((FileSystemXmlApplicationContext)context).close();



        // other ways to find bean config xml
        System.out.println("Testing other config source...");
        
        ApplicationContext context1 = new FileSystemXmlApplicationContext("src/main/java/net/lezhang/spring/beanbasic/config/myBeans1.xml");
        person = (Person)context1.getBean("person");
        person.speak();
        
        logger = (Logger)context1.getBean("logger");
        logger.writeConsole("Hello console");
        logger.writeFile("Hello file");
        
        ((FileSystemXmlApplicationContext)context1).close();

        ApplicationContext context2 = new ClassPathXmlApplicationContext("net/lezhang/spring/beanbasic/config/myBeans1.xml");
        person = (Person)context2.getBean("person");
        person.speak();
        ((ClassPathXmlApplicationContext)context2).close();
        
        System.out.println( "Shutting down..." );
    }
}
