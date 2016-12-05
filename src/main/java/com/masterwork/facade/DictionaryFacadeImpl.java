package com.masterwork.facade;

import com.masterwork.model.Dictionary;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@ApplicationScoped
public class DictionaryFacadeImpl implements DictionaryFacade, Serializable {

    @PersistenceContext
    private EntityManager em;

    public List<Dictionary> getAllDicts() {
        Query q = em.createQuery("select d from Dictionary d");

        return q.getResultList();
    }

    public Dictionary findById(int id) {
        Dictionary dict = em.find(Dictionary.class, id);
        return dict;
    }
}
