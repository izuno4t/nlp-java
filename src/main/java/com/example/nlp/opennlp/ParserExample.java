package com.example.nlp.opennlp;

import com.example.nlp.ResourceUtil;
import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.lemmatizer.DictionaryLemmatizer;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ParserExample {

    public static void main(String[] args) throws IOException {

        //Loading parser model
        InputStream inputStream = new FileInputStream(ResourceUtil.getResource("opennlp/en-parser-chunking.bin").toFile());
        ParserModel model = new ParserModel(inputStream);

        //Creating a parser
        Parser parser = ParserFactory.create(model);

        //Parsing the sentence
        String sentence = "By building a sense of one word’s proximity to other similar words, which do not necessarily contain the same letters, we have moved beyond hard tokens to a smoother and more general sense of meaning.";
        Parse[] topParses = ParserTool.parseLine(sentence, parser, 1);

        for (Parse p : topParses)
            p.show();


    }

}