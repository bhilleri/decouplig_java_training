package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player{
    private Logger logger = LoggerFactory.getLogger("player");
    private long Max = Long.MAX_VALUE;
    private long Min = 0;
    private long testedValue = 0;
    @Override
    public long askNextGuess() {
        testedValue = ((Max - Min) /2)+Min;
        this.logger.log("Test de " + testedValue);
        return testedValue;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater)
        {
            this.Max = testedValue;
        }
        else
        {
            this.Min = testedValue;
        }
    }
}
