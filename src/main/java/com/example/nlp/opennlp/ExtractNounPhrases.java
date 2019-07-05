package com.example.nlp.opennlp;

import com.example.nlp.ResourceUtil;
import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class ExtractNounPhrases {

    //
    // static String sentence = "Who is the author of The Call of the Wild?";
    static String sentence = "It is interesting to read books about the English.";

    static Set<String> nounPhrases = new HashSet<>();

    public static void main(String[] args) {

        InputStream modelInParse = null;
        try {
            //load chunking model
            modelInParse = new FileInputStream(ResourceUtil.getResource("opennlp/en-parser-chunking.bin").toFile()); //from http://opennlp.sourceforge.net/models-1.5/
            ParserModel model = new ParserModel(modelInParse);

            //create parse tree
            Parser parser = ParserFactory.create(model);
            Parse[] topParses = ParserTool.parseLine(sentence, parser, 1);

            //call subroutine to extract noun phrases
            for (Parse p : topParses)
                getNounPhrases(p);

            //print noun phrases
            for (String s : nounPhrases)
                System.out.println(s);

            //The Call
            //the Wild?
            //The Call of the Wild? //punctuation remains on the end of sentence
            //the author of The Call of the Wild?
            //the author
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (modelInParse != null) {
                try {
                    modelInParse.close();
                } catch (IOException e) {
                }
            }
        }
    }

    //recursively loop through tree, extracting noun phrases
    public static void getNounPhrases(Parse p) {

        if (p.getType().equals("NP")) { //NP=noun phrase
            nounPhrases.add(p.getCoveredText());
        }
        for (Parse child : p.getChildren())
            getNounPhrases(child);
    }
}
