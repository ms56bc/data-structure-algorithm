package org.example.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        LongestPalindromeSubstring l = new LongestPalindromeSubstring();
        System.out.println(l.longestPalindrome("abcdc"));
        System.out.println(l.longestPalindrome("abccba"));
        System.out.println(l.longestPalindrome("aabcd"));
    }
    public String longestPalindrome(String s){
        String ans = null;
        String maxString = null;
        for(int i = 0; i < s.length(); i++){
            for(int j = i+1; j <= s.length(); j++){
                String curr = s.substring(i, j);
                //System.out.println(curr);
                if(isPalindrome(curr)){
                    maxString = maxString != null && maxString.length()> curr.length()? maxString: curr;
                }
            }
        }
        return maxString;
    }
    boolean isPalindrome(String s){
        int i=0;
        int j= s.length() -1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }


}
