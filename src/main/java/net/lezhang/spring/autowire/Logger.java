package net.lezhang.spring.autowire;

public class Logger {
    // the two writers should be autowired
    private ConsoleWriter consoleWriter;
    private FileWriter fileWriter;
    
    public void setConsoleWriter(ConsoleWriter consoleWriter) { this.consoleWriter = consoleWriter; }
    public void setFileWriter(FileWriter fileWriter) { this.fileWriter = fileWriter; }

    public void writeConsole(String string) {
        consoleWriter.log(string);
        
    }

    public void writeFile(String string) {
        fileWriter.log(string);
        
    }
}
