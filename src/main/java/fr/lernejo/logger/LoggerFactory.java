package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory {
    public static Logger getLogger(String name)
    {
        Logger fileLogger = new ContextualLogger(name, new FileLogger("../log.txt"));
        Predicate<String> condition = message -> message.contains("simulation");
        Logger consoleLogger = new ContextualLogger(name, new FilteredLogger(new ConsoleLogger(), condition));
        return new CompositeLogger(fileLogger, consoleLogger);
    }
}
