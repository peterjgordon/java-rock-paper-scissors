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

    public void recordScore(boolean win) {
        if(win) {
            currentWins++;
        } else {
            currentLosses++;
        }
    }

    public String generateScore() {
        return getName() + " " + getCurrentWins() + ":" + getCurrentLosses() + " " + Math.round(generateRatio()) + '%';
    }

    public float generateRatio() {
        if (getCurrentWins() == 0 && getCurrentLosses() == 0) {
            return 0;
        } else {
            return getCurrentWins() / (getCurrentWins() + (float)getCurrentLosses()) * 100;
        }
    }


}
