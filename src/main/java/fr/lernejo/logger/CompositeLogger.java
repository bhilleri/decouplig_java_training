package fr.lernejo.logger;

import java.sql.PseudoColumnUsage;
import java.util.ArrayList;
import java.util.List;

public class CompositeLogger implements Logger {
    private List<Logger>loggers = new ArrayList<>();

    @Override
    public void log(String message) {
        this.loggers.forEach((Logger logger)->{
            logger.log(message);
        });
    }
    public CompositeLogger(Logger firstLogger, Logger secondLogger )
    {
        this.loggers.add(firstLogger);
        this.loggers.add(secondLogger);
    }
}
