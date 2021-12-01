package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory {
    public static Logger getLogger(String name)
    {
        Logger fileLogger = new ContextualLogger(new FileLogger("../log.txt"), name);
        Predicate<String> condition = message -> message.contains("simulation");
        Logger consoleLogger = new ContextualLogger( new FilteredLogger(new ConsoleLogger(), condition), name);
        return new CompositeLogger(fileLogger, consoleLogger);
    }
}
