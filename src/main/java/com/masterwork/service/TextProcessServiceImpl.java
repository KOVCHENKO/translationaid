package com.masterwork.service;

import com.masterwork.service.intermediate.models.TextProcessedWord;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.util.CoreMap;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.io.StringReader;
import java.util.*;

@ApplicationScoped
public class TextProcessServiceImpl implements TextProcessService, Serializable {

    private ArrayList<String> tokenizedWords;
    private StanfordCoreNLP pipeline;
    private Properties props;

    private String[] defaultStopWords = {"i", "a", "about", "an",
            "are", "as", "at", "be", "by", "com", "for", "from", "how",
            "in", "is", "it", "of", "on", "or", "that", "the", "this",
            "to", "was", "what", "when", "where", "who", "will", "with", ",", "."};

    public ArrayList<String> tokenizer(String words) {
        tokenizedWords = new ArrayList<String>();

        PTBTokenizer ptb = new PTBTokenizer(new StringReader(words), new CoreLabelTokenFactory(), null);
        while (ptb.hasNext()) {
            tokenizedWords.add(ptb.next().toString());
        }

        return tokenizedWords;
    }

    public List<String> lemmatize(String words) {
        props = new Properties();
        props.put("annotators", "tokenize, ssplit, pos, lemma");
        pipeline = new StanfordCoreNLP(props);

        Annotation document = new Annotation(words);
        pipeline.annotate(document);

        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
        List<String> lemmas = new LinkedList();

        for (CoreMap sentence : sentences) {
            for (CoreLabel word : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                lemmas.add(word.get(CoreAnnotations.LemmaAnnotation.class));
            }
        }

        return lemmas;
    }
    /**
     * Лемматизация одного слова
     * @param word
     * @return
     */
    public String lemmatizeOneWord(String word) {

        StanfordCoreNLP pipeline = new StanfordCoreNLP(new Properties(){{
            setProperty("annotators", "tokenize, ssplit, pos, lemma");
        }});

        Annotation tokenAnnotation = new Annotation(word);
        pipeline.annotate(tokenAnnotation);  // necessary for the LemmaAnnotation to be set.
        List<CoreMap> list = tokenAnnotation.get(CoreAnnotations.SentencesAnnotation.class);
        String lemmatizedWord = list
                .get(0).get(CoreAnnotations.TokensAnnotation.class)
                .get(0).get(CoreAnnotations.LemmaAnnotation.class);

        return lemmatizedWord;
    }

    /**
     * Удаление стоп-слов
     * @param listForRemovalOfStopWords
     * @return
     */
    public List<String> stopWordsRemoval(List<String> listForRemovalOfStopWords) {

        HashSet stopWords = new HashSet();
        stopWords.addAll(Arrays.asList(defaultStopWords));

        ArrayList<String> tokens = new ArrayList<String>(listForRemovalOfStopWords);

        for (int i = 0; i < tokens.size(); i++) {
            if (stopWords.contains(tokens.get(i))) {
                tokens.remove(i);
            }
        }

        return tokens;
    }


    /**
     *
     * @param listToCountWords
     * Метод для подсчета количества слов, если они повторяются и удаления их из набора
     */
    public void countNumberOfWords(List<String> listToCountWords) {


    }


    /**
     * Объединенный метод лемматизации и удаления стоп слов
     */
    public List<TextProcessedWord> lemmatizeAndStopWordsRemoval(String processText) {

        List<String> processWords = this.lemmatize(processText);
        List<String> processedWords = this.stopWordsRemoval(processWords);

        List<String> processedWordsWithQuantity = new ArrayList<String>();
        List<TextProcessedWord> textProcessedWords = new ArrayList<TextProcessedWord>();

        Set<String> uniqueSet = new HashSet<String>(processedWords);
        for (String temp : uniqueSet) {
            textProcessedWords.add(new TextProcessedWord(temp, Collections.frequency(processedWords, temp)));

            processedWordsWithQuantity.add(temp + ": " + Collections.frequency(processedWords, temp));
            System.out.println(temp + ": " + Collections.frequency(processedWords, temp));

        }
        return textProcessedWords;
    }

}
