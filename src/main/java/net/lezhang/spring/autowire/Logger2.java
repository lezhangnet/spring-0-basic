package net.lezhang.spring.autowire;

/**
 * autowire by name
 * 
 */
public class Logger2 {

    private LogWriter consoleWriter;
    private LogWriter fileWriter;
    
    public void setConsoleWriter(LogWriter consoleWriter) { this.consoleWriter = consoleWriter; }
    public void setFileWriter(LogWriter fileWriter) { this.fileWriter = fileWriter; }

    public void writeConsole(String string) {
        consoleWriter.log(string);
        
    }

    public void writeFile(String string) {
        fileWriter.log(string);
        
    }

}
