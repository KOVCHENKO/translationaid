package com.masterwork.controller;

import com.masterwork.service.TextProcessServiceImpl;
import com.masterwork.service.TranslationService;
import com.masterwork.service.intermediate.models.TranslatedWord;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class GlossaryController implements Serializable {

    private String textForRendering;
    private List<TranslatedWord> processedWords;

    private String chosenSecondWord, newSecondWord;

    @Inject
    TranslationService translationService;

    public String render() {
        processedWords = translationService.translatePairs(textForRendering);

        return "cg_sel_words";
    }


    public String getTextForRendering() {
        return textForRendering;
    }

    public void setTextForRendering(String textForRendering) {
        this.textForRendering = textForRendering;
    }

    public List<TranslatedWord> getProcessedWords() {
        return processedWords;
    }

    public void setProcessedWords(List<TranslatedWord> processedWords) {
        this.processedWords = processedWords;
    }

    public TranslationService getTranslationService() {
        return translationService;
    }

    public void setTranslationService(TranslationService translationService) {
        this.translationService = translationService;
    }

    public String getChosenSecondWord() {
        return chosenSecondWord;
    }

    public void setChosenSecondWord(String chosenSecondWord) {
        this.chosenSecondWord = chosenSecondWord;
    }

    public String getNewSecondWord() {
        return newSecondWord;
    }

    public void setNewSecondWord(String newSecondWord) {
        this.newSecondWord = newSecondWord;
    }
}
