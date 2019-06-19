package com.aleks.webapp;

public class Player {

    enum Choice {
        ROCK,PAPER,SCISSORS
    }

    private String name;
    private Choice c;

    public Player(){
    }

    public Player(String name){
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

    public void randomizer(){
        int rand = getRandomIntegerBetween(1,3);
        switch(rand) {
            case 1:
                c = Choice.ROCK;
                break;
            case 2:
                c = Choice.PAPER;
                break;
            default:
                c = Choice.SCISSORS;
        }
    }

    private static int getRandomIntegerBetween(int min, int max){
        return (int)(Math.random()*((max-min)+1))+min;
    }

}
