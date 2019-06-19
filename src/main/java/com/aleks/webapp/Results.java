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

    public String getAll(){
        StringBuilder sb = new StringBuilder();
        for (String s : results)
        {
            sb.append(s);
            sb.append("\n");
        }
        return  sb.toString();
    }

    public ArrayList<String> getResults() {
        return results;
    }

    public void setResults(ArrayList<String> results) {
        this.results = results;
    }
}
