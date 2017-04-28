package net.lezhang.spring.autowire;

import org.springframework.stereotype.Component;

@Component("fileWriter")
public class FileWriter implements LogWriter {

    @Override
    public void log(String string) {
        System.out.println("logging to file: " + string);

    }

}
