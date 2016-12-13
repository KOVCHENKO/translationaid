package com.masterwork.service.intermediate.models;

/**
 * This class is used for keeping the entities of pre-productioned
 * words without translation, just natural language processed
 */
public class TextProcessedWord {

    private String wordName;
    private int count;

    public TextProcessedWord(String wordName, int count) {
        this.wordName = wordName;
        this.count = count;
    }

    public TextProcessedWord() {
    }

    public String getWordName() {
        return wordName;
    }

    public void setWordName(String wordName) {
        this.wordName = wordName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "TextProcessedWord{" +
                "wordName='" + wordName + '\'' +
                ", count=" + count +
                '}';
    }
}
