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

}
