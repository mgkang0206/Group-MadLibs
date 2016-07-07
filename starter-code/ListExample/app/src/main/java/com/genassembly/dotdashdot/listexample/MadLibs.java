package com.genassembly.dotdashdot.listexample;

import java.util.Collections;

public class MadLibs {
    public int getWords() {
        return words;
    }

    public int getSpaces() {
        return spaces;
    }

    public String getGenre() {
        return genre;
    }

    private int words, spaces;
    private String genre;

    public MadLibs(String genre, int words, int spaces){
        this.genre = genre;
        this.words = words;
        this.spaces = spaces;
    }


}
