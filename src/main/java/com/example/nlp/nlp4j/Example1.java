package com.example.nlp.nlp4j;


import edu.emory.mathcs.nlp.common.util.Joiner;
import edu.emory.mathcs.nlp.common.util.StringUtils;
import edu.emory.mathcs.nlp.component.morph.MorphAnalyzer;
import edu.emory.mathcs.nlp.component.morph.english.EnglishMorphAnalyzer;
import edu.emory.mathcs.nlp.component.tokenizer.EnglishTokenizer;
import edu.emory.mathcs.nlp.component.tokenizer.Tokenizer;
import edu.emory.mathcs.nlp.component.tokenizer.token.Token;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Example1 {

    public static void main(String[] args) throws IOException {
        Tokenizer tokenizer = new EnglishTokenizer();
        String message = "By building a sense of one word’s proximity to other similar words, which do not necessarily contain the same letters, we have moved beyond hard tokens to a smoother and more general sense of meaning.";
        InputStream in = IOUtils.toInputStream(message, "UTF-8");

        List<List<Token>> tokensList = tokenizer.segmentize(in);

        tokensList.forEach(t -> {
                    //System.out.println(Joiner.join(t, "|"));
                    t.forEach(s -> System.out.println(ToStringBuilder.reflectionToString(s, ToStringStyle.DEFAULT_STYLE)));
                }
        );
        in.close();


//        MorphAnalyzer lemmatizer = new EnglishMorphAnalyzer();
//        String lemma;
//
//        tokensList.forEach(t ->
//                lemma = lemmatizer.lemmatize(StringUtils.toSimplifiedForm(t[0]), t[1]);
//        );
//
//        for (String[] token : tokens) {
//            assertEquals(token[2], lemma);
//        }
    }
}