package org.blind75;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    private int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        var s = new CoinChange();
        var a = s.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(a);
        a = s.coinChange(new int[]{2}, 3);
        System.out.println(a);
        a = s.coinChange(new int[]{2}, 0);
        System.out.println(a);
        a = s.coinChange(new int[]{1}, 1);
        System.out.println(a);
        a = s.coinChange(new int[]{1}, 2);
        System.out.println(a);
        System.out.println("======================");
        a = s.coinChangeDp(new int[]{1, 2, 5}, 11);
        System.out.println(a);
        a = s.coinChangeDp(new int[]{2}, 3);
        System.out.println(a);
        a = s.coinChangeDp(new int[]{2}, 0);
        System.out.println(a);
        a = s.coinChangeDp(new int[]{1}, 1);
        System.out.println(a);
        a = s.coinChangeDp(new int[]{1}, 2);
        System.out.println(a);
    }

    private int coinChange(int[] coins, int amount) {
        min = Integer.MAX_VALUE;
        coinChangeDfs(coins, amount, 0, 0);
        return min == Integer.MAX_VALUE ? -1 : min;

    }

    private void coinChangeDfs(int[] coins, int amount, int idx, int d) {
        if (amount == 0) {
            min = Integer.min(d, min);
        }
        if (idx >= coins.length || amount <= 0) {
            return;
        }
        coinChangeDfs(coins, amount - coins[idx], idx, d + 1);
        coinChangeDfs(coins, amount, idx + 1, d);

    }

    private int coinChangeDp(int[] coins, int amount) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        dp.put(1, 1);
        for (int i = 1; i <= amount; i++) {
            int minWays = Integer.MAX_VALUE;
            for (int c : coins) {
                if (c <= i) {
                    int currWays = 1 + dp.getOrDefault(i - c, Integer.MAX_VALUE);
                    minWays = Integer.min(currWays, minWays);
                }
            }
            dp.put(i, minWays);
        }
        return dp.getOrDefault(amount, -1);
    }
}
