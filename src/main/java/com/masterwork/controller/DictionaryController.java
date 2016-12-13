package com.masterwork.controller;

import com.masterwork.facade.DictionaryFacade;
import com.masterwork.model.Dictionary;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class DictionaryController implements Serializable {

    private String name;

    @Inject
    DictionaryFacade dictionaryFacade;


    public List<Dictionary> allDicts() {
        List<Dictionary> dicts = dictionaryFacade.getAllDicts();

        return dicts;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
