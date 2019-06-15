package com.example.nlp.kuromoji;

import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;

import java.util.List;

public class Example2 {

    public static void main(String[] args) {
        String input = "一風堂のラーメンが食べたい";

        Tokenizer tokenizer = new Tokenizer();
        List<Token> tokens = tokenizer.tokenize(input);
        tokens.stream()
                .map(e -> e.getSurface()+ " "+ e.getAllFeatures())
                .forEach(System.out::println);

    }

}
