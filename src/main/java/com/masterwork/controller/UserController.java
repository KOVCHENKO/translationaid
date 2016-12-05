package com.masterwork.controller;

import com.masterwork.facade.UserFacade;
import com.masterwork.model.User;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class UserController implements Serializable {

    private String name, email, password, userType;
    int id;

    @Inject
    UserFacade userFacade;

    public String login() {
        String returnView = userFacade.checkLogin(email, password);

        return returnView;
    }

    public List<User> allUsers() {
        List<User> users = userFacade.getAllUsers();

        return users;
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
