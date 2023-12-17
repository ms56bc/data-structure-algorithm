package org.blind75;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        var longestSubstringWithoutRepeating = new LongestSubstringWithoutRepeating();
        System.out.println(longestSubstringWithoutRepeating.lengthOfLongestSubstring("abcdefabcbbcdaz"));
        System.out.println(longestSubstringWithoutRepeating.lengthOfLongestSubstring(""));
    }
    private int lengthOfLongestSubstring(String s) {
        int[] map = new int[26];
        int start = 0, end = 0, d = 0;
        while(end < s.length()){
            char curr = s.charAt(end);
            if(map[indexForChar(curr)] == 1){
                d = Integer.max(end - start, d);
                while(map[indexForChar(curr)] == 1){
                    map[indexForChar(s.charAt(start))] = 0;
                    start++;
                }
            }
            map[indexForChar(curr)] = 1;
            end++;
        }
        d = Integer.max(end - start, d);
        return d;
    }

    private int indexForChar(char c){
        return c - 'a';
    }
}
//header ->  x-correlation-id
