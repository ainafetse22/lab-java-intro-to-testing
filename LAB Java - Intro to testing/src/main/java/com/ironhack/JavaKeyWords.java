package com.ironhack;

import java.util.Objects;

public class JavaKeyWords {
    private static final String[] listOfKeywords = {"abstract", "continue", "for", "new", "switch", "assert",
            "default", "goto", "package", "synchronized", "boolean", "do", "if", "private",
            "this", "break", "double", "implements", "protected", "throw", "byte", "else",
            "import", "public", "throws", "case", "enum", "instanceof", "return", "transient",
            "catch", "extends", "int", "short", "try", "char", "final", "interface", "static",
            "void", "class", "finally", "long", "strictfp", "volatile", "const", "float", "native",
            "super", "while"};

    public static boolean javaKeyWords(String input_string) {
        String[] input_as_list = input_string.split(" ");
        for(String forbidden_word:listOfKeywords){
            for(String input_word:input_as_list){
                if(Objects.equals(input_word.toLowerCase().replaceAll("[^a-zA-Z0-9]", ""), forbidden_word)){
                    return true;
                }

            }
        }
        return false;
    }
}
