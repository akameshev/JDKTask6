package org.example;

import lombok.Data;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class MontyHallSimulation {
    private final Random random = new Random();
    private final int totalGames = 1000;
    private final Map<Integer, Boolean> results = new HashMap<>();

    public void runSimulation() {
        int switchWins = 0;
        int stayWins = 0;

        for (int i = 1; i <= totalGames; i++) {
            boolean isWin = playGame();
            results.put(i, isWin);

            if (isWin) {
                switchWins++;
            } else {
                stayWins++;
            }
        }

        System.out.println("Total games played: " + totalGames);
        System.out.println("Wins after switching: " + switchWins);
        System.out.println("Wins without switching: " + stayWins);
    }

    private boolean playGame() {
        int winningDoor = random.nextInt(3); 
        int chosenDoor = random.nextInt(3);


        int revealedDoor;
        do {
            revealedDoor = random.nextInt(3);
        } while (revealedDoor == winningDoor || revealedDoor == chosenDoor);


        int switchedDoor = 3 - chosenDoor - revealedDoor;


        return switchedDoor == winningDoor;
    }

    public static void main(String[] args) {
        MontyHallSimulation simulation = new MontyHallSimulation();
        simulation.runSimulation();
    }
}
