package com.masterwork.service;


import com.masterwork.service.intermediate.models.TextProcessedWord;

import java.util.ArrayList;
import java.util.List;


public interface TextProcessService {

    /**
     * Stanford токенизатор для текста
     * @param words
     * @return
     */
    public ArrayList<String> tokenizer(String words);

    /**
     * Stanford NLP лемматизатор для текста
     * @param words
     * @return
     */
    public List<String> lemmatize(String words);

    /**
     * Объединенный метод для лемматизации и удаления стоп слов
     * @param processText
     * @return
     */
    public List<TextProcessedWord> lemmatizeAndStopWordsRemoval(String processText);

    /**
     *
     * @param listToCountWords
     * Метод для подсчета количества слов, если они повторяются и удаления их из набора
     */
    public void countNumberOfWords(List<String> listToCountWords);

    /**
     * Лемматизация одного слова
     * @param word
     * @return
     */
    public String lemmatizeOneWord(String word);

}
