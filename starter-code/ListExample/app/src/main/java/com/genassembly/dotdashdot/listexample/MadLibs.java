package com.genassembly.dotdashdot.listexample;

import java.util.ArrayList;
import java.util.Collections;

public class MadLibs {


    private int words, spaces;
    private String genre;
    private ArrayList<String> madLib;
    static int wordCount=0;

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
        return this.words;
    }
    public int getWordsCount(ArrayList<String> madLib){
        for(int i=0; i<=madLib.size(); i+=2){
            String s = madLib.get(i);
            char ch[]= new char[s.length()];      //in string especially we have to mention the () after length
            for(i=0;i<s.length();i++)
            {
                ch[i]= s.charAt(i);
                if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )
                    wordCount++;
            }
        }

        return wordCount;
    }

    public int getSpaces() {
        return spaces;
    }
    public int getSpaces(ArrayList<String> madLib){
        spaces = madLib.size()/2;
        return spaces;
    }

    public String getGenre() {
        return genre;
    }


}
