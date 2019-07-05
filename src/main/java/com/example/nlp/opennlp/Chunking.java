package com.example.nlp.opennlp;

import com.example.nlp.ResourceUtil;
import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.chunker.ChunkerModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.SimpleTokenizer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Chunking {

    public static void main(String[] args) throws IOException {

        SimpleTokenizer tokenizer = SimpleTokenizer.INSTANCE;
        String sentence = "It is interesting to read books about the English.";
//        String[] tokens = tokenizer.tokenize("He reckons the current account deficit will narrow to only 8 billion.");

        String[] tokens = tokenizer.tokenize(sentence);

        InputStream inputStreamPOSTagger = new FileInputStream(ResourceUtil.getResource("opennlp/en-pos-maxent.bin").toFile());
        POSModel posModel = new POSModel(inputStreamPOSTagger);
        POSTaggerME posTagger = new POSTaggerME(posModel);
        String[] tags = posTagger.tag(tokens);

        InputStream inputStreamChunker = new FileInputStream(ResourceUtil.getResource("opennlp/en-chunker.bin").toFile());
        ChunkerModel chunkerModel = new ChunkerModel(inputStreamChunker);
        ChunkerME chunker = new ChunkerME(chunkerModel);
        String[] chunks = chunker.chunk(tokens, tags);

        Arrays.stream(tokens).forEach(System.out::println);
        Arrays.stream(tags).forEach(System.out::println);
        Arrays.stream(chunks).forEach(System.out::println);


    }
}
