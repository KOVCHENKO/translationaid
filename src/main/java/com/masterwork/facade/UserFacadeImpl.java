package com.masterwork.facade;


import com.masterwork.model.User;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@ApplicationScoped
public class UserFacadeImpl implements UserFacade, Serializable{

    @PersistenceContext
    private EntityManager em;


    public List<User> getAllUsers() {
        Query q = em.createQuery("select u from User u");

        return q.getResultList();
    }

    public User finById(int id) {
        User user = em.find(User.class, id);
        return user;
    }



    public String checkLogin(String email, String password) {
        List<User> usersForCheck = this.getAllUsers();

        String returnString = null;


        for (User userForCheck : usersForCheck) {
            if (email.equals(userForCheck.getEmail()) & password.equals(userForCheck.getPassword())) {
                returnString = "user_pages/user_index_page";

                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().getSessionMap().put("user", userForCheck);

                break;
            } else {
                returnString = "index";
            }
        }
        return returnString;
    }

}
