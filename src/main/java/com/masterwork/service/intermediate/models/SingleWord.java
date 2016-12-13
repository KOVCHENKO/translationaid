package com.masterwork.service.intermediate.models;


public class SingleWord {

    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "SingleWord{" +
                "word='" + word + '\'' +
                '}';
    }

}
