package com.example.nlp.opennlp;

import com.example.nlp.ResourceUtil;
import opennlp.tools.lemmatizer.DictionaryLemmatizer;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Example1 {

    public static void main(String[] args) throws IOException {

        // Tokenizerの設定
        InputStream modelIn = new FileInputStream(ResourceUtil.getResource("opennlp/en-token.bin").toFile());
        TokenizerModel model = new TokenizerModel(modelIn);
        Tokenizer tokenizer = new TokenizerME(model);

        String message = "By building a sense of one word’s proximity to other similar words, which do not necessarily contain the same letters, we have moved beyond hard tokens to a smoother and more general sense of meaning.";
        String[] morphemes = tokenizer.tokenize(message);

        System.out.println("分かち書き");
        System.out.println(Arrays.asList(morphemes));


        // Part-of-speech Taggerの設定
        InputStream posModelIn = new FileInputStream(ResourceUtil.getResource("opennlp/en-pos-maxent.bin").toFile());
        POSModel posModel = new POSModel(posModelIn);
        POSTaggerME posTagger = new POSTaggerME(posModel);

        // 分かち書きしたデータを用いる
        String[] tags = posTagger.tag(morphemes);
        System.out.println("品詞分解");
        System.out.println(Arrays.asList(tags));


        // Lemmatizerの設定
        InputStream dictLemmatizer = new FileInputStream(ResourceUtil.getResource("opennlp/en-lemmatizer.dict.txt").toFile());
        DictionaryLemmatizer lemmatizer = new DictionaryLemmatizer(dictLemmatizer);

        // 分かち書きしたデータ、品詞データを用いる
        String[] lemmas = lemmatizer.lemmatize(morphemes, tags);
        System.out.println("単語の原形化");
        System.out.println(Arrays.asList(lemmas));


    }

}