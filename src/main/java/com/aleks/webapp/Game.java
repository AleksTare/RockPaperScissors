package com.aleks.webapp;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Game implements Serializable {

    private static final long serialVersionUID = 1715935052239888761L;
    private Player player1;
    private Player computer;
    private String pname;
    private String choice;
    private Results results = new Results();
    private int counter = 0;

    public Game(){
        player1 = new Player();
        computer = new Player("Computer");
    }

    public Game(String pname){
        player1 = new Player(pname);
        computer = new Player("Computer");
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getComputer() {
        return computer;
    }

    public void setComputer(Player computer) {
        this.computer = computer;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
        player1.setName(pname);
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
        player1.setC(Player.Choice.valueOf(choice));
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int validate(Player p1, Player p2){
        Player.Choice p1choice = p1.getC();
        Player.Choice p2choice = p2.getC();

        if(p1choice== Player.Choice.PAPER){
            switch (p2choice){
                case ROCK:
                    return 1;
                case PAPER:
                    return 0;
                case SCISSORS:
                    return 2;
            }
        }

        if(p1choice== Player.Choice.ROCK){
            switch (p2choice){
                case ROCK:
                    return 0;
                case PAPER:
                    return 2;
                case SCISSORS:
                    return 1;
            }
        }

        if(p1choice== Player.Choice.SCISSORS){
            switch (p2choice){
                case ROCK:
                    return 2;
                case PAPER:
                    return 1;
                case SCISSORS:
                    return 0;
            }
        }

        return -1;

    }

    public String addChoice(String choice){
            computer.randomizer();
            results.add(choice+" vs "+computer.getC());
            if(counter<4){
                counter++;
                return null;
            }else{
                counter = 0;
                return "viewresults";
            }
    }

}
