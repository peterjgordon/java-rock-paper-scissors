package me.peterg;

public class Player {
    private String name;
    private int currentWins;
    private int currentLosses;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int currentWins, int currentLosses) {
        this.name = name;
        this.currentWins = currentWins;
        this.currentLosses = currentLosses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentWins() {
        return currentWins;
    }

    public void setCurrentWins(int currentWins) {
        this.currentWins = currentWins;
    }

    public int getCurrentLosses() {
        return currentLosses;
    }

    public void setCurrentLosses(int currentLosses) {
        this.currentLosses = currentLosses;
    }
}
