package me.peterg;

import java.util.HashMap;

public class Main {
    static HashMap<String, Player> players = new HashMap<>();

    public static void main(String[] args) {


    }

    private static void createPlayer() {
        players.put("Peter", new Player("Peter"));

    }

    //for (Player player : players.values())
}
