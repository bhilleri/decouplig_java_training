package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name)
    {
        Logger fileLogger = new ContextualLogger(new FileLogger("../log.txt"), name);
        Logger consoleLogger = new ContextualLogger(new ConsoleLogger(), name);
        return new CompositeLogger(fileLogger, consoleLogger);
    }
}
