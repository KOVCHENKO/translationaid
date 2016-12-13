package com.masterwork.facade;


import com.masterwork.model.WordPair;

import java.util.List;

public interface WordPairFacade {

    List<WordPair> getAllPairs();

    void create(String wordPairOne, String wordPairTwo, int dictId);

    /**
     * to get the equivalents of words
     * @param firstEquivalent
     * @return
     */
    List<String>getEquivalent(String firstEquivalent);
}
