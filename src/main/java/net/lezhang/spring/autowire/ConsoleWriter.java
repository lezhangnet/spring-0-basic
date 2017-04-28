package net.lezhang.spring.autowire;

import org.springframework.stereotype.Component;

@Component
public class ConsoleWriter implements LogWriter {

    @Override
    public void log(String string) {
        System.out.println("logging to console: " + string);
        
    }

}
