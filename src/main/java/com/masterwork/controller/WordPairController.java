package com.masterwork.controller;

import com.masterwork.facade.WordPairFacade;
import com.masterwork.model.WordPair;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class WordPairController implements Serializable {

    private String  wordPairOne, wordPairTwo;
    private int id, dictId;

    private WordPair wordPair;

    @Inject
    WordPairFacade wordPairFacade;

    public List<WordPair> allPairs() {
        List<WordPair> pairs = wordPairFacade.getAllPairs();

        return pairs;
    }

    public void save() {
//        WordPair wordPair = new WordPair(wordPairOne, wordPairTwo);
//        Car car = new Car(label, stateNumber, capacity);
        wordPairFacade.create(wordPairOne, wordPairTwo, dictId);
    }



    public String getWordPairOne() {
        return wordPairOne;
    }

    public void setWordPairOne(String wordPairOne) {
        this.wordPairOne = wordPairOne;
    }

    public String getWordPairTwo() {
        return wordPairTwo;
    }

    public void setWordPairTwo(String wordPairTwo) {
        this.wordPairTwo = wordPairTwo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDictId() {
        return dictId;
    }

    public void setDictId(int dictId) {
        this.dictId = dictId;
    }

    public WordPair getWordPair() {
        return wordPair;
    }

    public void setWordPair(WordPair wordPair) {
        this.wordPair = wordPair;
    }
}
