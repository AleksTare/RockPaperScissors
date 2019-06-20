package com.aleks.webapp;
import com.aleks.webapp.model.Choice;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Navigation implements Serializable {

    private static final long serialVersionUID = 1715935052239888761L;

    private Game game = new Game();
    private int counter = 0;
    private String choice;
    private String winner;

    public Navigation(){}

    public Game getGame() { return game; }

    public int getCounter() { return counter; }

    public String getChoice() { return choice; }

    public void setChoice(String choice) { this.choice = choice; }

    public String getWinner() { return winner; }

    public void setWinner(String winner) { this.winner = winner; }

    public String play(){
        return "input";
    }

    public String simulate(){
        game.simulate();
        winner = game.calculateWinner();
        return "viewresults";
    }

    public String newGame(){
        game = new Game();
        return "index";
    }

    public String submitChoice(){
        game.addChoice(Choice.valueOf(choice));
        if(counter<4){
            counter++;
            return null;
        }else{
            counter = 0;
            winner = game.calculateWinner();
            return "viewresults";
        }
    }

}
