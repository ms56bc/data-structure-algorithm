package org.atlassian;

import java.util.*;
public class Winner {
    public static String[] winner(String[] arr, int n)
    {
        // add your code
        Map<String, Integer> f = new HashMap<>();
        int max = Integer.MIN_VALUE;
        String cand = null;
        for(String c: arr){
            f.put(c , f.getOrDefault(c, 0) +1);
        }
        for(String k: f.keySet()){
            int v = f.get(k);
            if(v >= max){
                if(v == max && cand != null){
                    cand = cand.compareTo(k) <= 0  ? cand : k;
                }
                else {
                    cand = k;
                }
                max = v;
            }
        }
        return new String[]{cand, String.valueOf(max)};
    }

    public static void main(String[] args) {
        String[] arr = {"john", "johnny", "jackie", "johnny", "john", "jackie", "jamie", "jamie", "john", "johnny", "jamie", "johnny", "john"};
        System.out.println(Arrays.toString(winner(arr, arr.length)));
    }
}
