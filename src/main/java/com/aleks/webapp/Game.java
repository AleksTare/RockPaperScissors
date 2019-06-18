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

    public Game(){
        player1 = new Player();
        computer = new Player();
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
}
