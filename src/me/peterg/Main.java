package me.peterg;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<String, Player> players = new HashMap<>();
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        while (true) {
            clearConsole();

            System.out.println("=== Rock, paper, scissors ===");
            System.out.println("1. Register Player");
            System.out.println("2. Play");
            System.out.println("3. View scores");
            System.out.println("4. Exit");
            System.out.println("=============================");

            System.out.print("Enter a number: ");
            while(!scanner.hasNextInt()) if(scanner.hasNext()) scanner.nextLine();
            int input = scanner.nextInt();
            scanner.nextLine(); // ignore the newline after the previous int

            clearConsole();

            switch (input) {
                case 1:
                    createPlayer();
                    break;
                case 2:
                    startGame();
                    break;
                case 3:
                    showScores();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid menu selection.");
                    break;
            }
            System.out.print("\nPress enter to return to main menu...");
            scanner.nextLine();
        }
    }

    private static void createPlayer() {
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        if (players.containsKey(name)) {
            System.out.println("Sorry, this name is already taken.");
        } else {
            players.put(name, new Player(name));
            System.out.println("New player '" + name + "' created!");
        }
    }

    private static void startGame() {
        if (players.size() < 2) {
            System.out.println("You can't play until you register two players.");
            return;
        }
        String playerOneName = null;
        while (!players.containsKey(playerOneName)) {
            if (playerOneName != null) System.out.println("No player with that name exists!");
            System.out.print("Enter Player 1's name: ");
            playerOneName = scanner.nextLine();
        }
        String playerTwoName = null;
        while (!players.containsKey(playerTwoName)) {
            if (playerTwoName != null) System.out.println("No player with that name exists!");
            System.out.print("Enter Player 2's name: ");
            playerTwoName = scanner.nextLine();
        }
        Player playerOne = players.get(playerOneName);
        Player playerTwo = players.get(playerTwoName);
        Game game = new Game(playerOne, playerTwo);
        game.play();
    }

    private static void showScores() {
        for (Player player : players.values()) {
            System.out.println(player.generateScore());
        }
    }

    public static void clearConsole() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("\n");
        }
    }
}
