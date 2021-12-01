package fr.lernejo.logger;

import java.util.function.Predicate;

public class FilteredLogger implements Logger{
    Predicate<String> condition;
    Logger delegate;
    @Override
    public void log(String message) {
        if(condition.test(message))
        {
            this.delegate.log(message);
        }
    }
    public FilteredLogger(Logger delegate, Predicate<String> condition) {
        this.condition = condition;
        this.delegate = delegate;
    }
}
