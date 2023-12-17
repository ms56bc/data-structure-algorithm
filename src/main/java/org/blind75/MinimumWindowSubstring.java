package org.blind75;

import java.util.*;

public class MinimumWindowSubstring {
    Map<Character, Integer> set  = new HashMap<Character, Integer>();
    int have = 0, need = 3;
    public static void main(String[] args) {
        var s = new MinimumWindowSubstring();
        System.out.println(Character.isLetterOrDigit('a'));
        System.out.println(Character.isLetterOrDigit(' '));
        System.out.println(Character.isLetterOrDigit('A'));
        System.out.println(Character.isLetterOrDigit('1'));
        var res = s.findString("ADOBECODEBANC", "ABC"); //"AAAAC" -> 4
        System.out.println(res);
    }

    private String findString(String b, String s) {

        for(char c :s.toCharArray()){
            set.put(c, 0);
        }
        int i =0, j=0;
        String minString = "ADOBECODEBANC";
        while(j < b.length()){
            if(isValidWindow(b, j)){
                System.out.println(j+""+i);
                minString = b.substring(i, j+1).length() < minString.length() ? b.substring(i, j+1): minString;
                moveLeftPointer(b, i);
                i++;
                while(i < j && !set.containsKey(b.charAt(i))){
                    moveLeftPointer(b, i);
                    i++;
                }
            }
            j++;
        }
        return minString;
    }

    private void moveLeftPointer(String b, int i) {
        Integer cnt = set.computeIfPresent(b.charAt(i), (k, v) -> v -1);
        if(cnt != null && cnt <1) have--;
    }

    private boolean isValidWindow(String b, int j){
        var cnt = set.computeIfPresent(b.charAt(j), (k, v) -> v+1);
        if(cnt != null && cnt == 1) have++;
        return have == 3;
    }
}
