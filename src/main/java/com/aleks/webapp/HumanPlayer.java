package com.aleks.webapp;

public class HumanPlayer implements Player {

    private String name;
    private Choice c;
    private int wins;

    public HumanPlayer(){}

    public HumanPlayer(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Choice getC() {
        return c;
    }

    public void setC(Choice c) {
        this.c = c;
    }

    public int getWins() { return wins; }

    public void setWins(int wins) { this.wins = wins; }
}
