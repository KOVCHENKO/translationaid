package com.masterwork.service;


import com.masterwork.service.intermediate.models.TranslatedWord;

import java.util.List;

public interface TranslationService {

    List<TranslatedWord> translatePairs(String processText);

}
