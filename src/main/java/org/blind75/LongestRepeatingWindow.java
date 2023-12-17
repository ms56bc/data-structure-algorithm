package org.blind75;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingWindow {
    private Map<Character, Integer> freq;
    public static void main(String[] args) {
        var s = new LongestRepeatingWindow();
        var res = s.findWindow("ABCAC", 2); //"AAAAC" -> 4
        System.out.println(res);
        res = s.findWindow("", 2); //"AAAAC" -> 4
        System.out.println(res);

        res = s.findWindow("ABCA", 1); //"AAAAC" -> 4
        System.out.println(res);

        res = s.findWindow("ABCABCC", 2); //"AAAAC" -> 4
        System.out.println(res);

    }
    private int findWindow(String s, int k){
        this.freq = new HashMap<>();
        int i=0, j=0;
        String ans = "";
        while(j < s.length()){
            updateFreq(s.charAt(j), 1);
            if(isValidWindow(i, j, k)){
                ans = s.substring(i, j+1).length() > ans.length() ? s.substring(i, j+1): ans;
            } else {
                updateFreq(s.charAt(i), -1);
                i++;
            }
            j++;
        }
        return ans.length();
    }
    private boolean isValidWindow(int i, int j, int k){
        return (j - i +1) - maxFrequency() <= k;
    }

    private void updateFreq(char c, int f){
        this.freq.put(c, this.freq.getOrDefault(c, 0)+ f);
    }

    private int maxFrequency(){
        return freq.values()
                .stream()
                .max(Comparator.comparingInt(i -> i))
                .orElse(0);
    }

    // len(window) - len(max) <=k
}
