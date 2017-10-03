package me.peterg;

import java.util.HashMap;

public class Main {
    static HashMap<String, Player> players = new HashMap<>();

    public static void main(String[] args) {


    }

    private static void createPlayer() {
        players.put("Peter", new Player("Peter"));

    }

    private static void showScores() {
        for (Player player : players.values()) {
            System.out.println(player.generateScore());
        }
    }
}
