package com.masterwork.facade;


import com.masterwork.model.WordPair;

import java.util.List;

public interface WordPairFacade {

    List<WordPair> getAllPairs();

    void create(String wordPairOne, String wordPairTwo, int dictId);
}
