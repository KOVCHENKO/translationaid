package com.masterwork.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Dictionary implements Serializable{

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String comment;

    @OneToMany(mappedBy = "dictionary", cascade = CascadeType.ALL,fetch= FetchType.EAGER, targetEntity = WordPair.class)
    private List<WordPair> wordPairs = new ArrayList<WordPair>();

    public Dictionary() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<WordPair> getWordPairs() {
        return wordPairs;
    }

    public void setWordPairs(List<WordPair> wordPairs) {
        this.wordPairs = wordPairs;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", wordPairs=" + wordPairs +
                '}';
    }
}
