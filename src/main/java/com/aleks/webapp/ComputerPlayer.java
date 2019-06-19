package com.aleks.webapp;

public class ComputerPlayer implements Player {

    private String name;
    private Choice c;
    private int wins;

    public ComputerPlayer(){}

    public ComputerPlayer(String name){
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

    public void randomizer(){
        double rand = getRandomInteger();
        double a = 0.33;
        double b = 0.66;
        if(rand<(a)) c = Choice.ROCK;
        if(rand<(b) && rand>(a)) c = Choice.PAPER;
        if(rand>(b)) c = Choice.SCISSORS;
    }

    private static double getRandomInteger(){
        double a = Math.random();
        return  a;
    }

}
