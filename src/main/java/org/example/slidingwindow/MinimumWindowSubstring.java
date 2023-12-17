package org.example.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/***
 * th pp isow is power i m
 * pow j =10, i = 4
 */
public class MinimumWindowSubstring {
    public String calMinWindow(String input, String small){
        String min = null;
        Map<Character, Integer> currMap = new HashMap<>();
        Map<Character, Integer> freqSmall = new HashMap<>();
        for(char c: small.toCharArray()){
            freqSmall.put(c, freqSmall.getOrDefault(c, 0) +1);
        }


        for(int i=0, j=0; j < input.length(); j++){
            char currChar = input.charAt(j);
            currMap.put(currChar, currMap.getOrDefault(currChar, 0) + 1);

            if(hasString(currMap, freqSmall)){
                while(hasString(currMap, freqSmall)){
                    remove(currMap, input.charAt(i));
                    i++;
                }
                String currString = input.substring(i -1, j +1);
                min = min == null || min.length() > currString.length() ? currString : min;
            }
        }
        return min;
    }

    private boolean hasString(Map<Character, Integer> currString, Map<Character, Integer> small){
        for(char c: small.keySet()){
            int freq = currString.getOrDefault(c, 0);
            if(freq < small.get(c)) return false;
        }
        return true;
    }
    private void remove(Map<Character, Integer> currMap, char c){
        if(currMap.containsKey(c)){
            int freq = currMap.get(c);
            if(freq <= 1) currMap.remove(c);
            else currMap.put(c, freq -1);
        }
    }
}
