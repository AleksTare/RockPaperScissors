package com.aleks.webapp;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Game implements Serializable {

    private static final long serialVersionUID = 1715935052239888761L;
    private ComputerPlayer player1;
    private ComputerPlayer player2;
    private String pname;
    private String choice;
    private Results results = new Results();
    private int counter = 0;

    public Game(){
        player1 = new ComputerPlayer();
        player2 = new ComputerPlayer("Computer");
    }

    public Game(String pname){
        player1 = new ComputerPlayer(pname);
        player2 = new ComputerPlayer("Computer");
    }

    public ComputerPlayer getPlayer1() {
        return player1;
    }

    public void setPlayer1(ComputerPlayer player1) {
        this.player1 = player1;
    }

    public ComputerPlayer getPlayer2() {
        return player2;
    }

    public void setPlayer2(ComputerPlayer player2) {
        this.player2 = player2;
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
        player1.setC(Choice.valueOf(choice));
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

    private static int evaluate(ComputerPlayer p1, ComputerPlayer p2){
        Choice p1choice = p1.getC();
        Choice p2choice = p2.getC();

        if (p1choice.equals(p2choice)){
            return 0;
        }
        int gameResult = p1choice.compareTo(p2choice);

        if (gameResult==2 || gameResult==-1)    return 1;
        if (gameResult==-2 || gameResult==1)    return 2;
        return gameResult;
    }

    public String addChoice(String choice){
            player1.setC(Choice.valueOf(choice));
            player2.randomizer();
            int res = evaluate(player1,player2);
            switch (res){
                case 1:
                    results.add(player1.getC()+" vs "+player2.getC()+"\n"+player1.getName()+" wins!");
                    break;
                case 2:
                    results.add(player1.getC()+" vs "+player2.getC()+"\n"+player2.getName()+" wins!");
                    break;
                case 0:
                    results.add(player1.getC()+" vs "+player2.getC()+" \n "+"It's a tie!!");
                    break;
            }
            if(counter<4){
                counter++;
                return null;
            }else{
                counter = 0;
                return "viewresults";
            }
    }

}
