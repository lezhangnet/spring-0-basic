package net.lezhang.spring.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoggerWithComponent {

    @Autowired
    private ConsoleWriter consoleWriter;
    @Autowired
    private FileWriter fileWriter;
    
    private String someProperty;
    
    public void setConsoleWriter(ConsoleWriter consoleWriter) { this.consoleWriter = consoleWriter; }
    public void setFileWriter(FileWriter fileWriter) { this.fileWriter = fileWriter; }

    @Autowired
    public void setSomeProperty(@Value("valuevaluevalue: #{textGenerator.text}") String s) {
        this.someProperty = s;
    }

    public void writeConsole(String string) {
        System.out.println("in component logger class");
        System.out.println("the property: " + someProperty);
        consoleWriter.log(string);
        
    }

    public void writeFile(String string) {
        fileWriter.log(string);
        
    }
}
