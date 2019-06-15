package com.example.nlp.kuromoji;

import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import com.example.nlp.ResourceUtil;

import java.io.IOException;
import java.util.List;

public class ExampleUserDic {

    public static void main(String[] args) throws IOException {

//        {
//            String input = "金融機関の業務を支援する装置であって、当該金融機関の外部の機関が管理する分析対象主体に係る属性情報を取得する取得部と、前記取得部により取得された属性情報と、パラメータと、にもとづいて、分析対象主体に対する当該金融機関の業務内容を決定するための分析対象主体のスコアを決定するスコア決定部と、前記スコア決定部により決定された分析対象主体のスコアと、基準値と、にもとづいて、分析対象主体に対する当該金融機関の業務を支援するための情報を生成する支援情報生成部と、を備え、前記パラメータは、分析対象主体の属性情報が、当該金融機関の業務を支援するための情報に影響を与える度合いを示す情報であって、前記当該機関によって予め設定された数値で構成され、前記分析対象主体のスコアは、基準値を調整するための値で構成されることを特徴とする情報処理装置。";
//            Tokenizer.Builder builder = new Tokenizer.Builder();
//            Tokenizer tokenizer = builder.userDictionary(ResourceUtil.getResource("user_dic.csv").toAbsolutePath().toString()).build();
//            List<Token> tokens = tokenizer.tokenize(input);
//            tokens
//                    .stream()
//                    .map(e -> e.getSurface() + " " + e.getAllFeatures())
//                    .forEach(System.out::println);
//
//        }

//        {
//
//            String parseWord = "日本経済新聞でモバゲーの記事を読んだ";
//            List<Token> tokenNormal = parse(parseWord);
//            tokenNormal
//                    .stream()
//                    .map(e -> e.getSurface() + " " + e.getAllFeatures())
//                    .forEach(System.out::println);
//        }

        {

            String parseWord = "The Apache HTTP Server Project is an effort to develop and maintain an open-source HTTP server for modern operating systems including UNIX and Windows. ";
            List<Token> tokenNormal = parse(parseWord);
            tokenNormal
                    .stream()
                    .map(e -> e.getSurface() + " " + e.getAllFeatures())
                    .forEach(System.out::println);
        }

    }

    private static List<Token> parse(final String text){
        Tokenizer.Builder builder = new Tokenizer.Builder();

        // ノーマルモード
        Tokenizer normal = builder.build();
        List<Token> tokenNormal = normal.tokenize(text);
        return tokenNormal;

    }

}
