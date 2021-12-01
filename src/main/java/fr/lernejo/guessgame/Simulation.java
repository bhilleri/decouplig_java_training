package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long testedValue = player.askNextGuess();
        if(testedValue == this.numberToGuess)
        {
            this.logger.log("Résultat trouvé");
            return true;
        }
        else if(testedValue < this.numberToGuess){
            this.player.respond(false);
            this.logger.log("plus grand");
            return false;
        }
        else
        {
            // testedValue > this.numberToGuess
            this.player.respond(true);
            this.logger.log("plus petit");
            return false;
        }
    }

    public void loopUntilPlayerSucceed() {
        boolean resultat = false;
        while(resultat == false)
        {
            resultat = this.nextRound();
        }
    }
}
