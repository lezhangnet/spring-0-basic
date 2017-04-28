package net.lezhang.spring.autowire;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class LoggerWithAutowire {

    @Autowired
    @Qualifier("console1")
    private ConsoleWriter consoleWriter;
    private FileWriter fileWriter;
    
    @Autowired
    @Qualifier("console2")
    private ConsoleWriter consoleWriter2;

    @Resource(name="consoleWriter2")
    private ConsoleWriter consoleWriter2UsingResource;
    
    @Inject
    @Named(value="consoleWriter2")
    private ConsoleWriter consoleWriter2UsingInject;
    
    // note the set method is no longer required as @Autowired is in place
    //public void setConsoleWriter(ConsoleWriter consoleWriter) { this.consoleWriter = consoleWriter; }

    @Autowired(required=false) // nullable
    public void setFileWriter(FileWriter fileWriter) { this.fileWriter = fileWriter; }

    
    
    
    public void writeConsole(String string) {
        consoleWriter.log(string);
        
    }

    public void writeFile(String string) {
        if(fileWriter!=null)
            fileWriter.log(string);
        
    }

    public void writeConsole2(String string) {
        consoleWriter2.log(string);
        
    }

    public void writeConsole2Resource(String string) {
        consoleWriter2UsingResource.log(string);
        
    }
    
    public void writeConsole2Inject(String string) {
        consoleWriter2UsingInject.log(string);
        
    }

    
    @PostConstruct
    public void initLogger() {
        System.out.println("initing logger...");
    }
    
    @PreDestroy
    public void destroyLogger() {
        System.out.println("destroying logger...");
    }
}
