package com.ironhack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JavaKeyWordsTest {
    @Test
    @DisplayName("Test basic Functionality contains One Keyword")
    public void testContainsOneKeyword(){
        List<String> test_string=new ArrayList<String>(){{
            add("hola string break");
            add("synchronized together more");
            add("boolean more fun");
        }};

        for(String str_test:test_string) {
            assertTrue(JavaKeyWords.javaKeyWords(str_test));
        }
    }

    @Test
    @DisplayName("Test basic Functionality contains Multiple Keyword")
    public void testContainsMultipleKeyword(){
        List<String> test_string=new ArrayList<String>(){{
            add("hola string break break");
            add("synchronized together more synchronized");
            add("synchronized boolean more");
        }};

        for(String str_test:test_string) {
            assertTrue(JavaKeyWords.javaKeyWords(str_test));
        }
    }

    @Test
    @DisplayName("Test basic Functionality contains NO Keyword")
    public void testContainsNoKeyword(){
        List<String> test_string=new ArrayList<String>(){{
            add("hola no cat dog");
            add("together more ");
            add("is not more is enough");
        }};

        for(String str_test:test_string) {
            assertFalse(JavaKeyWords.javaKeyWords(str_test));
        }
    }
    @Test
    @DisplayName("Test empty String")
    public void testEmptyString(){
        assertFalse(JavaKeyWords.javaKeyWords(""));
    }
    @Test
    @DisplayName("Test Incomplete Keyword break bre")
    public void testIncompleteKeyword(){
        List<String> test_string=new ArrayList<String>(){{
            add("hola string brea");
            add("synchronize together more");
            add("boolan more fun");
            add("boolan");
            add("bool");
            add("boolea");
        }};

        for(String str_test:test_string) {
            assertFalse(JavaKeyWords.javaKeyWords(str_test));
        }
    }
    @Test
    @DisplayName("Test is a Keyword break")
    public void testIsAKeyword(){
        List<String> test_string=new ArrayList<String>(){{
            add("break");
            add("synchronized");
            add("boolean");
            add("protected");
            add("enum");
            add("volatile");
        }};

        for(String str_test:test_string) {
            assertTrue(JavaKeyWords.javaKeyWords(str_test));
        }
    }

    @Test
    @DisplayName("Test Complete Keyword plus additional chars break-> breaker")
    public void testCompleteKeywordAdditionalChars(){
        List<String> test_string=new ArrayList<String>(){{
            add("breaker");
            add("synchronizeder");
            add("booleanas");
            add("protectedq");
            add("enumw");
            add("volatilew");
        }};

        for(String str_test:test_string) {
            assertFalse(JavaKeyWords.javaKeyWords(str_test));
        }
    }
    @Test
    @DisplayName("Test No Case Sensitive")
    public void testCaseInsensitive(){
        List<String> test_string=new ArrayList<String>(){{
            add("BREAK");
            add("Synchronized");
            add("booleaN");
            add("protectED");
        }};

        for(String str_test:test_string) {
            assertTrue(JavaKeyWords.javaKeyWords(str_test));
        }
    }
    @Test
    @DisplayName("Test Special Chars")
    public void testContainsSpecialChars(){
        List<String> test_string=new ArrayList<String>(){{
            add("abstract!");
            add("All continue**");
            add("?boolean");
        }};

        for(String str_test:test_string) {
            assertTrue(JavaKeyWords.javaKeyWords(str_test));
        }
    }
}
