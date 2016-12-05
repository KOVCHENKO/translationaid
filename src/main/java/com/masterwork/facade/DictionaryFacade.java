package com.masterwork.facade;

import com.masterwork.model.Dictionary;

import java.util.List;


public interface DictionaryFacade {

    List<Dictionary> getAllDicts();

    Dictionary findById(int id);

}
