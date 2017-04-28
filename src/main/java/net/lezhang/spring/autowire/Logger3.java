package net.lezhang.spring.autowire;

/**
 * autowire by constructor
 */
public class Logger3 {

    private ConsoleWriter consoleWriter;
    private FileWriter fileWriter;
    
    public Logger3(ConsoleWriter consoleWriter, FileWriter fileWriter) {
        this.consoleWriter = consoleWriter;
        this.fileWriter = fileWriter;
    }
    
    public void setConsoleWriter(ConsoleWriter consoleWriter) { this.consoleWriter = consoleWriter; }
    public void setFileWriter(FileWriter fileWriter) { this.fileWriter = fileWriter; }

    public void writeConsole(String string) {
        consoleWriter.log(string);
        
    }

    public void writeFile(String string) {
        fileWriter.log(string);
        
    }
}
