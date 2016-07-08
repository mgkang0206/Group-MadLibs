package com.genassembly.dotdashdot.listexample;

import java.util.ArrayList;
import java.util.Collections;

public class MadLibs {


    private int words, spaces;
    private String genre;



    private ArrayList<String> madLib;



    public MadLibs(String genre, int words, int spaces){
        this.genre = genre;

        this.words = words;
        this.spaces = spaces;
    }
    public MadLibs(String genre, ArrayList<String> madLib){
        this.genre = genre;
        this.madLib = madLib;
        this.words = this.getWords();
        this.spaces = this.getSpaces();

    }
    public ArrayList<String> getMadLib() {
        return madLib;
    }
    public int getWords() {
        return words;
    }

    public int getSpaces() {
        return spaces;
    }

    public String getGenre() {
        return genre;
    }

}
