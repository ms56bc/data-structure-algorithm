package org.blind75;

import java.util.Stack;

public class TimeToBuyStock {
    public static void main(String[] args) {
        TimeToBuyStock t = new TimeToBuyStock();
        System.out.println(t.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(t.maxProfit(new int[]{7, 2, 5, 1, 6, 7, 0, 8}));

        System.out.println(t.maxProfitPointers(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(t.maxProfitPointers(new int[]{7, 2, 5, 1, 6, 7, 0, 8}));

    }

    int maxProfit(int[] prices){
        int min = 0;
        int max = 0;
        Stack<Integer> s = new Stack<>();
        s.push(prices[0]);
        for(int i = 0; i< prices.length; i++){
            if(s.peek() > prices[i]){
                s.push(prices[i]);
                continue;
            }
            max = Integer.max(max, prices[i] - s.peek());
        }
        return max;
    }

    int maxProfitPointers(int[] prices){
        int min = 0;
        int max = 1;
        int profit = prices[max] - prices[min];
        for(int i = 1; i< prices.length; i++){
            if(prices[i] < prices[min]){
                min = i;
            }
            if(prices[i] > prices[max] && i > min){
                max = i;
            }
            profit = Integer.max(profit, prices[max] - prices[min]);
        }
        return profit;
    }

}
