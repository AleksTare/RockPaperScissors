package com.aleks.webapp.interfaces;

import com.aleks.webapp.model.Choice;

public interface Player {

    public String getName();
    public void setName(String name);
    public Choice getChoice();
    public void setChoice(Choice choice);
    public int getWins();
    public void setWins(int wins);

}
