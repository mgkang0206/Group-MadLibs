package com.genassembly.dotdashdot.listexample;

/**
 * Created by Mauve3 on 7/7/16.
 */
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
