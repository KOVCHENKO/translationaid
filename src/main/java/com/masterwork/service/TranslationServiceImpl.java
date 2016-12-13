package com.masterwork.service;

import com.masterwork.facade.WordPairFacade;
import com.masterwork.service.intermediate.models.SingleWord;
import com.masterwork.service.intermediate.models.TextProcessedWord;
import com.masterwork.service.intermediate.models.TranslatedWord;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TranslationServiceImpl implements TranslationService {

    private List<TranslatedWord> translatedWords;
    private List<TextProcessedWord> textProcessedWords;

    @Inject
    TextProcessService textProcessService;

    @Inject
    WordPairFacade wordPairFacade;

    @Inject
    TranslationWebService translationWebService;

    public List<TranslatedWord> translatePairs(String processText) {

        translatedWords = new ArrayList<TranslatedWord>();

        textProcessedWords = textProcessService.lemmatizeAndStopWordsRemoval(processText);


        for (TextProcessedWord textProcessedWord: textProcessedWords ) {
            String firstEquivalent = textProcessedWord.getWordName();
            List<String> translationsFromDB = wordPairFacade.getEquivalent(firstEquivalent);
            List<String> translationsFromWebService = translationWebService.translateViaWebService(firstEquivalent);

            List<String> translatedEquivalents = new ArrayList<String>();
            translatedEquivalents.addAll(translationsFromDB);
            translatedEquivalents.addAll(translationsFromWebService);


            TranslatedWord translatedWord = new TranslatedWord();

            List<SingleWord> singleWords = new ArrayList<SingleWord>();

            translatedWord.setWordName(textProcessedWord.getWordName());
            translatedWord.setCount(textProcessedWord.getCount());

//            if (translatedEquivalents.isEmpty()) {
//                translatedWord.setSecondWord(translatedWord.setBlank());
//            } else {
//                translatedWord.setSecondWord(translatedEquivalents);
//            }

            /**
             * Работа с отдельным словом, не получается в JSF проитерировать String
             */
            if (translatedEquivalents.isEmpty()) {
                translatedWord.setSecondSingleWord(translatedWord.setSingleWordBlank());
            } else {
                for (String translatedEquivalent : translatedEquivalents) {
                    SingleWord singleWord = new SingleWord();
                    singleWord.setWord(translatedEquivalent);
                    singleWords.add(singleWord);
                }
                translatedWord.setSecondSingleWord(singleWords);
            }

            System.out.println(translatedWord);
            translatedWords.add(translatedWord);
        }
        return translatedWords;
    }
}
