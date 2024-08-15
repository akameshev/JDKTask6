package org.example;

import lombok.Data;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Data
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
        int winningDoor = random.nextInt(3); // Random door with the prize
        int chosenDoor = random.nextInt(3); // Contestant's initial choice

        // Simulate host opening a door that isn't the prize or the contestant's choice
        int revealedDoor;
        do {
            revealedDoor = random.nextInt(3);
        } while (revealedDoor == winningDoor || revealedDoor == chosenDoor);

        // Contestant switches to the remaining door
        int switchedDoor = 3 - chosenDoor - revealedDoor;

        // Return true if switching wins
        return switchedDoor == winningDoor;
    }

    public static void main(String[] args) {
        MontyHallSimulation simulation = new MontyHallSimulation();
        simulation.runSimulation();
    }
}
