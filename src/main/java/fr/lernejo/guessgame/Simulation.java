package fr.lernejo.guessgame;

import com.sun.jdi.Value;
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
            this.logger.log("valeur testé : " + testedValue + ", la valeur à trouver est plus grande");
            return false;
        }
        else
        {
            // testedValue > this.numberToGuess
            this.player.respond(true);
            this.logger.log("valeur testé : " + testedValue + ", la valeur à trouver est plus petite");
            return false;
        }
    }

    public long loopUntilPlayerSucceed(long limit) {
        boolean resultat = false;
        long timeInitial = System.currentTimeMillis();
        int turn = 0;
        while(resultat == false && turn < limit)
        {
            turn++;
            resultat = this.nextRound();
        }
        long duration =  System.currentTimeMillis() - timeInitial;
        int minute = (int)duration/1000/60;
        int second = (int)(duration/1000)%60;
        int millisecond = (int)(duration)%(1000);
        System.out.println((minute<10 ? "0"+minute : minute) + ":" + (second<10 ? "0" + second : second) + ":" + (millisecond >=100 ? millisecond : millisecond>=10? "0" + millisecond : "00" + millisecond));
        return duration;
    }
}
