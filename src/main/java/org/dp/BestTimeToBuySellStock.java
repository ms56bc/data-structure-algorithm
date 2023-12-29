package org.dp;

import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuySellStock {
    record Tuple(int idx, boolean isBuying){}
    private Map<Tuple, Integer> cache;
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 0, 2};
        var bs = new BestTimeToBuySellStock();
        //System.out.println(new BestTimeToBuySellStock().maxProfit(a));
        System.out.println(bs.maxProfitDfsCache(a));
        a = new int[]{1, 2, 3, 7};
        System.out.println(bs.maxProfitDfsCache(a));
    }
    private int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0;

        return max;
    }

    private int maxProfitDfs(int[] prices, int idx, boolean isBuying){
        if(prices.length <= idx) return 0;
        if(isBuying){
            return Integer.max(maxProfitDfs(prices, idx+1, false) - prices[idx], maxProfitDfs(prices, idx+1, true));
        }
        else {
            var p1 = maxProfitDfs(prices, idx +2, true) + prices[idx];
            var p2 = maxProfitDfs(prices, idx +1, false);
            return Integer.max(p1, p2);
        }
    }

    private int maxProfitDfsCache(int[]prices){
        this.cache = new HashMap<>();
        return internalMaxProfitDfsCached(prices, 0, true);
    }
    private int internalMaxProfitDfsCached(int[] prices, int idx, boolean isBuying){
        if(prices.length <= idx) return 0;
        var tuple = new Tuple(idx, isBuying);
        var ans = 0;
        if(cache.containsKey(tuple)) return cache.get(tuple);
        if(isBuying){
            ans = Integer.max(internalMaxProfitDfsCached(prices, idx+1, false) - prices[idx], internalMaxProfitDfsCached(prices, idx+1, true));
        }
        else {
            var p1 = internalMaxProfitDfsCached(prices, idx +2, true) + prices[idx];
            var p2 = internalMaxProfitDfsCached(prices, idx +1, false);
            ans = Integer.max(p1, p2);
        }
        cache.put(tuple, ans);
        return ans;
    }
}
