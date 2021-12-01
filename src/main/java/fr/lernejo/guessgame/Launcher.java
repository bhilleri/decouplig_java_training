package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String args[]){
        Simulation simulation = new Simulation(new HumanPlayer());
        SecureRandom random = new SecureRandom();
        long Number = random.nextInt(100);
        simulation.initialize(Number);
        simulation.loopUntilPlayerSucceed();
    }
}
