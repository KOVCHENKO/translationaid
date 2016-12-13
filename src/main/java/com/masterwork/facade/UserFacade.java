package com.masterwork.facade;


import com.masterwork.model.User;

import java.util.List;


public interface UserFacade {
    String checkLogin(String email, String password);

    List getAllUsers();

    User finById(int id);

}
