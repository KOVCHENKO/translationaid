package com.masterwork.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class WordPair implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String semanticUnitOne;
    private String semanticUnitTwo;
    private int rating;

    private int counter;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dictionary_id")
    private Dictionary dictionary;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public WordPair() {
    }

    public WordPair(String semanticUnitOne, String semanticUnitTwo, int rating, int counter, Dictionary dictionary, User user) {
        this.semanticUnitOne = semanticUnitOne;
        this.semanticUnitTwo = semanticUnitTwo;
        this.rating = rating;
        this.counter = counter;
        this.dictionary = dictionary;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSemanticUnitOne() {
        return semanticUnitOne;
    }

    public void setSemanticUnitOne(String semanticUnitOne) {
        this.semanticUnitOne = semanticUnitOne;
    }

    public String getSemanticUnitTwo() {
        return semanticUnitTwo;
    }

    public void setSemanticUnitTwo(String semanticUnitTwo) {
        this.semanticUnitTwo = semanticUnitTwo;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "WordPair{" +
                "id=" + id +
                ", semanticUnitOne='" + semanticUnitOne + '\'' +
                ", semanticUnitTwo='" + semanticUnitTwo + '\'' +
                ", rating=" + rating +
                ", dictionary=" + dictionary +
                '}';
    }
}
