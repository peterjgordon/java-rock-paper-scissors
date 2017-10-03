package me.peterg;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<String, Player> players = new HashMap<>();
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        while(true) {
            System.out.println("=== Rock, paper, scissors ===");
            System.out.println("1. Register Player");
            System.out.println("2. Play");
            System.out.println("3. View scores");
            System.out.println("4. Exit");
            System.out.println("=============================");

            System.out.print("Enter a number: ");
            int input = scanner.nextInt();
            scanner.nextLine(); // ignore the newline after the previous int

            switch (input) {
                case 1:
                    createPlayer();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid menu selection.");
                    break;
            }
        }
    }

    private static void createPlayer() {
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        if(players.containsKey(name)) {
            System.out.println("Sorry, this name is already taken.");
        } else {
            players.put(name, new Player(name));
            System.out.println("New player '" + name + "' created!");
        }
    }

    private static void showScores() {
        for (Player player : players.values()) {
            System.out.println(player.generateScore());
        }
    }
}
