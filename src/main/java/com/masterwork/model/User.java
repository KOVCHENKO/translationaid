package com.masterwork.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String email;
    private String password;

    private String userType;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch= FetchType.EAGER, targetEntity = WordPair.class)
    private List<WordPair> wordPairs = new ArrayList<WordPair>();

    public User(int id, String name, String email, String password, String userType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
