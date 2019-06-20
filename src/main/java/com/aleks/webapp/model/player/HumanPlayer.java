package com.aleks.webapp.model.player;

import com.aleks.webapp.interfaces.Player;
import com.aleks.webapp.model.Choice;

public class HumanPlayer implements Player {

    private String name;
    private Choice c;
    private int wins;

    public HumanPlayer(){
        this.name = "Unknown Player";
    }

    public HumanPlayer(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Choice getChoice() {
        return c;
    }

    public void setChoice(Choice c) {
        this.c = c;
    }

    public int getWins() { return wins; }

    public void setWins(int wins) { this.wins = wins; }
}
