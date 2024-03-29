package com.aleks.webapp;

import com.aleks.webapp.interfaces.Player;
import com.aleks.webapp.model.*;
import com.aleks.webapp.model.player.ComputerPlayer;
import com.aleks.webapp.model.player.HumanPlayer;
import java.util.List;

public class Game {

    private Player player1;
    private Player player2;
    private Results results;
    private String newName;
    private String temporalResult;

    public Game(){
        player1 = new HumanPlayer();
        player2 = new ComputerPlayer();
        results = new Results();
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(HumanPlayer player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(ComputerPlayer player2) {
        this.player2 = player2;
    }

    public List<String> getResults() {
        return results.getResults();
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getTemporalResult() { return temporalResult; }

    public void setTemporalResult(String temporalResult) { this.temporalResult = temporalResult; }

    private static int evaluate(Player p1, Player p2){
        Choice p1choice = p1.getChoice();
        Choice p2choice = p2.getChoice();

        if (p1choice.equals(p2choice)){
            return 0;
        }
        int gameResult = p1choice.compareTo(p2choice);

        if (gameResult==2 || gameResult==-1)    return 1;
        if (gameResult==-2 || gameResult==1)    return 2;
        return gameResult;
    }

    public void addChoice(Choice choice){
            int p1 = player1.getWins();
            int p2 = player2.getWins();

            if(newName!=null && !newName.equals("")) player1.setName(newName);
            player1.setChoice(choice);

            ((ComputerPlayer) player2).randomizer();
            int res = evaluate(player1,player2);
            switch (res){
                case 1:
                    player1.setWins(++p1);
                    temporalResult = player1.getName()+" played "+player1.getChoice()+" vs "+player2.getChoice()+" played by "+player2.getName()+" | "+player1.getName()+" wins!";
                    break;
                case 2:
                    player2.setWins(++p2);
                    temporalResult = player1.getName()+" played "+player1.getChoice()+" vs "+player2.getChoice()+" played by "+player2.getName()+" | "+player2.getName()+" wins!";
                    break;
                case 0:
                    temporalResult = player1.getName()+" played "+player1.getChoice()+" vs "+player2.getChoice()+" played by "+player2.getName()+" | "+"It's a tie!!";
                    break;
            }

            results.add(temporalResult);
    }

    public String calculateWinner(){
        String winner;
        int p1 = player1.getWins();
        int p2 = player2.getWins();
        if(p1==p2) winner = " a tie!";
        else {
            if(p1>p2){
                winner = " won by "+ player1.getName();
            }else{
                winner = " won by "+ player2.getName();
            }
        }
        return winner;
    }

    public void simulate(){
        player1 = new ComputerPlayer("Computer 1");
        player1.setChoice(Choice.ROCK);
        player2.setName("Computer 2");
        for(int i = 0; i < 100; i++){
            addChoice(player1.getChoice());
        }
    }

}
