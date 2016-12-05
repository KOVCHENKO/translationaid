package com.masterwork.facade;

import com.masterwork.model.Dictionary;
import com.masterwork.model.User;
import com.masterwork.model.WordPair;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class WordPairFacadeImpl implements WordPairFacade, Serializable {

    @PersistenceContext
    private EntityManager em;

    @Inject
    DictionaryFacade dictionaryFacade;

    @Inject
    UserFacade userFacade;


    public List<WordPair> getAllPairs() {
        Query q = em.createQuery("select p from WordPair p");

        return q.getResultList();
    }

    @Transactional
    public void create(String wordPairOne, String wordPairTwo, int dictId) {
        Dictionary d = dictionaryFacade.findById(dictId);

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        User u = (User) sessionMap.get("user");

        WordPair wordPair = new WordPair(wordPairOne, wordPairTwo, 0, 0, d, u);
//        em.merge(u);

        em.merge(wordPair);
//        em.flush();
    }
}
