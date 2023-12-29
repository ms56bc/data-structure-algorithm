package org.dp;

import java.util.HashMap;
import java.util.Map;

public class IntegerBreak {
    Map<Integer, Integer> cache;
    public static void main(String[] args) {
        var ib = new IntegerBreak();
        System.out.println(ib.maxMultiplicaiton(10));
        System.out.println(ib.internalMaxMultiplicationCached(10));
        System.out.println(ib.maxMultiplicationDp(10));
    }
    private int maxMultiplicationCached(int num, int n){
        if(n == 1) return 1;
        if(cache.containsKey(n)) return cache.get(n);
        // since the below looop will always breaking the integer n, we may not want to do it, hence
        int res = num == n ? 0 : n;
        for(int i = 1; i < n;i++){
            res = Integer.max(maxMultiplicationCached(num, i) * maxMultiplicationCached(num, n - i), res);
        }
        cache.put(num, res);
        return res;
    }
    private int internalMaxMultiplicationCached(int num){
        cache = new HashMap<>();
        return maxMultiplicationCached(num, num);
    }
    private int maxMultiplicaiton(int num){
        if(num == 0) return 1;
        int res = Integer.MIN_VALUE;
        for(int i = 1; i <= num;i++){
            res = Integer.max(i * maxMultiplicaiton(num - i), res);
        }
        return res;
    }

    private int maxMultiplicationDp(int num){
        cache = new HashMap<>();
        cache.put(1, 1);
        cache.put(2, 1);
        for(int i = 3; i <= num; i++){
            var res = i == num ? 0 : i;
            for(int j = 1; j < i; j++) {
                res = Integer.max( cache.get(j) * cache.get(i -j), res);
            }
            cache.put(i, res);
        }
        return cache.get(num);
    }
}
