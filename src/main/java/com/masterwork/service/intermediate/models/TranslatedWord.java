package com.masterwork.service.intermediate.models;

import java.util.ArrayList;
import java.util.List;

/**
 * This entity keeps word and translated equivalents
 * due to the fact that it can keep more than one equivalent
 * also it keeps information about vocabulary
 */
public class TranslatedWord extends TextProcessedWord {

    private List<SingleWord> secondSingleWord;

    private List<String> secondWord;

    public TranslatedWord(String wordName, int count) {
        super(wordName, count);
    }

    public TranslatedWord(String wordName, int count, List<SingleWord> secondSingleWord) {
        super(wordName, count);
        this.secondSingleWord = secondSingleWord;
    }

    public TranslatedWord() {
    }

    /**
     * If there is no translation in database
     * fill the second word as blank item
     * @return
     */
//    public List<String> setBlank() {
//        String blank = "There is no translation here";
//        secondWord = new ArrayList<String>();
//        secondWord.add(blank);
//
//        return secondWord;
//    }

    /**
     * The same thing as above but
     * with object and not a String
     * @return
     */
    public List<SingleWord> setSingleWordBlank() {
        SingleWord singleWord = new SingleWord();
        singleWord.setWord("There is no translation here");
        secondSingleWord = new ArrayList<SingleWord>();
        secondSingleWord.add(singleWord);

        return secondSingleWord ;
    }



    public List<String> getSecondWord() {
        return secondWord;
    }

    public void setSecondWord(List<String> secondWord) {
        this.secondWord = secondWord;
    }

    public List<SingleWord> getSecondSingleWord() {
        return secondSingleWord;
    }

    public void setSecondSingleWord(List<SingleWord> secondSingleWord) {
        this.secondSingleWord = secondSingleWord;
    }

    @Override
    public String toString() {
        return "TranslatedWord{" +
                "secondWord=" + secondWord +
                '}';
    }
}
