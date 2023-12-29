package org.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    static List<String> result = new java.util.ArrayList<>();
    public static void main(String[] args) {
        PalindromePartitioning p = new PalindromePartitioning();
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        String s = "geeks";

        int ind = 0;

        // Store the partition at current iteration
        ArrayList<String> curr = new ArrayList<>();

        // calling funtion to get partition
        //p.partition(res, s, ind, curr);
        //partitionSubstring("abac").forEach(System.out::println);
        result.forEach(System.out::println);
    }

    /***
     * this implementation is wrong because this will search for all the possible combinations, whereas we are only intrested in
     * substring of the give string and not the combination of the string. substring is formed by taking the consecutive characters.
     * failing test  case is "aba" which will return "a, b, a, aba, aa" but the expected result is "a, b, a, aba"
     * @param word
     * @param index
     * @param currWord
     */
    private static void partition(String word, int index, String currWord){
        if(word.length() == index){
            if(isPalindrome(currWord))
                result.add(currWord);
            return;
        }
        System.out.println("index:" + index + " currWord:" + currWord+  " word:" + word.charAt(index));
        partition(word, index + 1, currWord + word.charAt(index));
        partition(word, index+1, currWord);
    }

    private static List<String> partitionSubstring(String word){
        List<String> result = new ArrayList<>();
        for(int l = 1 ; l < word.length(); l++){
            for(int i = 0; i+l < word.length(); i++){
                String s = word.substring(i, i + l);
                if(isPalindrome(s)){
                    result.add(s);
                }
            }
        }
        return result;
    }

    private static boolean isPalindrome(String word){
        int i = 0;
        int j = word.length() -1;
        while(i < j){
            if(word.charAt(i) != word.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
