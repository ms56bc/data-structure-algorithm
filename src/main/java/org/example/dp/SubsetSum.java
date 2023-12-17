package org.example.dp;


import java.util.*;

public class SubsetSum {
    static List<List<Integer>> subsets = new LinkedList<>();
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 1};
        int maxSum = 5;
        Arrays.sort(input);
        SubsetSum.findSubset(input, maxSum, new LinkedList<>(), 0);
        subsets.forEach(s-> {
            s.forEach(e -> System.out.print(e+":"));
            System.out.println("");
        });
       // System.out.println(SubsetSum.topDown(input, maxSum));
    }

    private static void findSubset(int[] input, int remainingSum, List<Integer> currSubsets, int currIndex) {
        if(remainingSum < 0) return;
        else if(remainingSum  == 0) subsets.add(new LinkedList<>(currSubsets));
        else for(int i = currIndex; i < input.length; i++){
            int currItem = input[i];
            if(i > currIndex && Objects.equals(currItem, input[i - 1])){
                continue;
            }
            currSubsets.add(currItem);
            findSubset(input, remainingSum - currItem, currSubsets, i);
            currSubsets.remove(currSubsets.size() -1);
        }
    }

    private static boolean topDown(int[] input, int max){
        int rows = input.length +1;
        int cols = max +1;
        boolean[][] dp = new boolean [rows][cols];
        for (int i = 0; i < rows; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < rows; i++) {
            int currElem = input[i -1];
            for (int j = 0; j < cols; j++) {
                if(j >= currElem){
                    dp[i][j] = dp[i -1][j - currElem] || dp[i -1][j];
                } else {
                    dp[i][j] = dp[i -1][j];
                }
            }
        }
        return dp[rows -1][cols -1];
    }
}
