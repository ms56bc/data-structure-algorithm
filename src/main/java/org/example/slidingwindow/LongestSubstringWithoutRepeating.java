package org.example.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/***
 * abcdabefc
 * abcd
 * a
 */
public class LongestSubstringWithoutRepeating {
    public String calc(String input){
        if(input == null) return null;
        if(input.length() == 1) return input;
        String longest = null;
        Set<Character> currentSet = new HashSet<>();
        for(int i=0, j=0; j < input.length(); j++){
            char currChar = input.charAt(j);
            if(currentSet.contains(currChar)){
                String currString = input.substring(i, j);
                longest = longest == null || longest.length() < currString.length()? currString: longest;
                while(currentSet.contains(currChar)){
                    currentSet.remove(input.charAt(i));
                    i++;
                }
            }
            currentSet.add(currChar);
        }
        return longest;
    }
}
