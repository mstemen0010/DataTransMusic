/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wms.EPubToMusic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author 173510
 */
public class CommonWords {

    final static String[] COMMON_WORDS_LIST = {"the", "i", "and", "a", "of", "to", "that", "was", "had", "in", "my", "her",
        "she", "he", "his", "with", "but", "for", "me", "as", "on", "you", "it", "at", "not", "could", "from", "into", "which", "the",
        "have", "all", "an", "Then", "up", "is", "or", "She", "so", "like", "be", "no", "before", "looked", "by", "what",
        "would", "when", "did", "knew", "were", "about", "me", "one", "very", "through", "how", "we", "upon", "out",
        "himself", "herself", "him", "it", "there", "here", "this", "then"
    };
    final static Stack<String> COMMON_WORDS_STACK = new Stack<String>();

    /**
     * @author Matt Stemen
     */
    public CommonWords() {
        CommonWords.addCommonWords();
    }

     /**
    * @author mstemen
    * @return Common words as a stacks
    * 
    **/
    public static Stack<String> showCommonWords() {
        CommonWords.addCommonWords();
        return COMMON_WORDS_STACK;
    }
 /**
    * @author mstemen
    *
    * 
    **/
    protected static void addCommonWords() {
        COMMON_WORDS_STACK.addAll(new ArrayList<>(Arrays.asList(COMMON_WORDS_LIST)));
    }

     /**
    * @author mstemen
    *
    * 
    * @return size of CommonWordList
    **/
    public static int getCommonWordsSize() {
        return COMMON_WORDS_LIST.length;
    }

    /**
     * 
     * @param comparStack
     * @return 
     */
    public static int compareToStack(Stack<String> comparStack) {
        int count = comparStack.size();
        Stack<String> test = comparStack;
        test.removeAll(COMMON_WORDS_STACK);
        return count - test.size();
    }

     /**
    * @author mstemen
    *
    * @param candidateStack
    * @return product/difference
    * 
    **/
    public static Stack<String> getDiffStack(Stack<String> candidateStack) {
        candidateStack.removeAll(COMMON_WORDS_STACK);
        return candidateStack;
    }

}