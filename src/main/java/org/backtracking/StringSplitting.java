package org.backtracking;

import java.util.ArrayList;

/***
 * https://leetcode.com/problems/splitting-a-string-into-descending-consecutive-values/
 */
public class StringSplitting {
    ArrayList<ArrayList<String>> validSplit = new ArrayList<>();
    public static void main(String[] args) {
        StringSplitting s = new StringSplitting();
       // System.out.println(s.isValid(List.of("0","0","1")));
        System.out.println(s.splitString("001", ""));
        System.out.println(s.splitString("9089",""));
        System.out.println(s.splitString("987",""));

    }
    //001
    private boolean splitString(String s, String prev){
        if(!prev.isEmpty()){
            if(isValid(prev, s))
                return true;
        }
        for(int i = 1; i < s.length(); i++){
            String curr = s.substring(0, i);
            if(prev.isBlank()) {
                if (splitString(s.substring(i), curr))
                    return true;
            }
            else {
                if (isValid(prev, curr) && splitString(s.substring(i), curr))
                    return true;
            }
        }
        return false;
    }
    public boolean isValid(String f, String s){
        var fi = Integer.valueOf(f);
        var si = Integer.valueOf(s);
       // System.out.println(fi+ ":"+si);
        return fi - si == 1;
    }
}

// 1
// 1 2
