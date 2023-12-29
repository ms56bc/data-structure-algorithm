package org.dp;

import java.util.*;

public class LongestIncresingSubsequence {
    record Tuple(int l, int c){};
    public static void main(String[] args) {
        var ls = new LongestIncresingSubsequence();
        System.out.println(ls.findLis(new int[]{1, 3, 5, 4, 7}));

    }

    private Tuple findLis(int[] a){

        var dp = new HashMap<Integer, Tuple>();
        for(int i = a.length - 1; i >=0; i--){
            var max = new Tuple(1, 1);
            for(int j = i+1; j < a.length; j++){
                if(a[i] < a[j]) {
                    var curr = dp.get(j);
                    if(curr.l +1 > max.l) max = new Tuple(curr.l +1, curr.c);
                    else if(curr.l +1 == max.l) max = new Tuple(max.l, curr.c +1);
                }
            }
            dp.put(i, max);
        }
        return dp.getOrDefault(0, new Tuple(0, 0));
    }
}
