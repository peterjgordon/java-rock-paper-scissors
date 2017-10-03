package me.peterg;

import java.util.Scanner;

public class Game {
    private Player[] players;
    private int[] playerMoves;
    private Scanner scanner;

    public int PAPER = 1, ROCK = 2, SCISSORS = 3;

    public int parseChoice(String choice) {
        switch (choice.toUpperCase()) {
            case "PAPER":
                return 1;
            case "ROCK":
                return 2;
            case "SCISSORS":
                return 3;
            default:
                return 0;
        }
    }

    public String parseMove(int move) {
        switch (move) {
            case 1:
                return "PAPER";
            case 2:
                return "ROCK";
            case 3:
                return "SCISSORS";
            default:
                return "";
        }
    }

    public Game(Player playerOne, Player playerTwo) {
        scanner = new Scanner(System.in);
        players = new Player[]{playerOne, playerTwo};
    }

    public void play() {
        playerMoves = new int[2];

        System.out.println("The game begins... [" + players[0].getName() + " vs " + players[1].getName() + "]\n");

        for (int i = 0; i < 2; i++) {
            System.out.println("It's " + players[i].getName() + "'s turn to make a move!");
            System.out.println("[" + players[(i + 1) % 2].getName() + ", don't look at the screen]\n");
            System.out.print("Enter your move: ");
            playerMoves[i] = parseChoice(scanner.nextLine());

            Main.clearConsole();
        }

        finish();
    }

    public void finish() {
        int result = playerMoves[0] - playerMoves[1];
        switch (result) {
            case -1:
            case 2:
                System.out.println("PLAYER 1 WINS!");
                System.out.println("(" + parseMove(playerMoves[0]).toLowerCase() + " beats " + parseMove(playerMoves[1]).toLowerCase() + ")");
                break;
            case 0:
                System.out.println("DRAW! You both chose " + parseMove(playerMoves[0]).toLowerCase() + "!");
                System.out.print("Press enter to begin the rematch.");
                scanner.nextLine();
                play();
                break;
            case 1:
            case -2:
                System.out.println("PLAYER 2 WINS!");
                System.out.println("(" + parseMove(playerMoves[1]).toLowerCase() + " beats " + parseMove(playerMoves[0]).toLowerCase() + ")");
                break;
        }

    }
}
