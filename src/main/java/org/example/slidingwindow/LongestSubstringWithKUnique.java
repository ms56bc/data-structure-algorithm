package org.example.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUnique {

    public final String calcLongest(String s, int k){
        String ans = null;
        String currString;
        Map<Character, Integer> unique = new HashMap<>();
        for(int i=0, j=0; j < s.length(); j++){
            char c = s.charAt(j);
            currString = s.substring(i, j+1);
            unique.put(c, unique.getOrDefault(c, 0) +1);

            if(unique.keySet().size() == k){
                ans = ans == null || currString.length() >= ans.length()? currString: ans;
            }

            if(unique.keySet().size() >= k){
                while(unique.keySet().size() >= k){
                    remove(unique, s.charAt(i));
                    i++;
                }
            }
        }
        return ans;
    }

    private void remove(Map<Character, Integer> unique, char r){
        Integer freq = unique.get(r);
        if(freq !=  null) {
            if (freq <= 1) unique.remove(r);
            else unique.put(r, freq - 1);
        }
    }
}
