package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String args[]){

        switch(args[0])
        {
            case "-interactive":
                Launcher.LaunchInteractive();
                break;
            case "-auto":
                Launcher.LaunchAuto(Long.parseLong(args[1]));
                break;
            default:
                System.out.println("Entrer -interactive pour tenter de deviner un nombre aléatoire");
                System.out.println("Entrer -auto nombre pour tenter de deviner le nombre défini");
                break;
        }
    }

    public static void LaunchInteractive(){
        Simulation simulation = new Simulation(new HumanPlayer());
        SecureRandom random = new SecureRandom();
        long Number = random.nextInt(100);
        simulation.initialize(Number);
        simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
    }

    public static void LaunchAuto(long number){
        Simulation simulation = new Simulation(new ComputerPlayer());
        simulation.initialize(number);
        simulation.loopUntilPlayerSucceed(1000);
    }
}
