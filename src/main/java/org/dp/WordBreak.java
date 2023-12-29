package org.dp;

import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        var nas = wb.workBreak("leet", Set.of("leet", "code"));
        //System.out.println(nas);
        nas = wb.wordBreakDp("leetcodecode", Set.of("leet", "code"));
        System.out.println(nas);
    }

    private boolean workBreak(String word, Set<String> dict){
        System.out.println(word);
        if(word.isEmpty()) return true;
        for(int i= 0; i <= word.length(); i++){
            if(dict.contains(word.substring(0, i))){
                if(workBreak(word.substring(i), dict)) return true;
            }
        }
        return false;
    }

    private boolean wordBreakDp(String word, Set<String> dict){
        boolean dp[] = new boolean[word.length() + 1];
        dp[word.length()] = true;
        int prev = word.length();
        for(int i = word.length() -1 ; i >= 0; i--) {
            var c = word.substring(i, prev);
            if(dict.contains(c) && dp[i + c.length()]){
                dp[i] = true;
                prev = i;
            }
        }
        return dp[0];
    }
}
