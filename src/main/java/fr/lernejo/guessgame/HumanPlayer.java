package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player{
    private Scanner scanner = new Scanner(System.in);
    private Logger logger = LoggerFactory.getLogger("player");
    @Override
    public long askNextGuess() {
        System.out.print("Entrer un nombre : ");
        long result = scanner.nextLong();
        return result;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater)
        {
            System.out.println("plus petit");
        }
        else
        {
            System.out.println("plus grand");
        }

    }
}
