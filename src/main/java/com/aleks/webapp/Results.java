package com.aleks.webapp;

import java.util.ArrayList;

public class Results {

    private ArrayList<String> results;

    public Results(){
        results = new ArrayList<String>();
    }

    public void add(String result){
        results.add(result);
    }

    public String fetch(int id){
        return results.get(id);
    }

    public String[] getAll(){
        String[] newResults = new String[results.size()];
        newResults = results.toArray(newResults);
        return newResults;
    }

}
