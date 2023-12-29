package org.dp;

import java.util.HashMap;

// how many ways to get target sum from given array of numbers if we can either add or subtract
public class TargetSum {
    record Pair(int i, int target){}
    // mainly we are storing the number of ways to get target sum from index i,
    // since its is dfs the base case is storing all the elements and reaching the sum given in the question.
    private HashMap<Pair, Integer> dp;
    public TargetSum() {

    }

    public static void main(String[] args) {
        TargetSum t = new TargetSum();
        System.out.println(t.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 5));

        System.out.println(t.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, -3));

        System.out.println(t.findTargetSumWays(new int[]{1, 1}, 3));
    }
    private int findTargetSumWays(int[] nums, int sum) {
        this.dp = new HashMap<>();
        int x = _findTargetSumWays(nums, 0, 0, sum);
        return x;
        //return dp.get(new Pair(nums.length -1, sum));
    }


    private int _findTargetSumWays(int[] nums ,int target, int i, int sum) {
        if(i == nums.length){
            return target == sum ? 1 : 0;
        }
        Pair key = new Pair(i, target);
        if(dp.containsKey(key)) return dp.get(key);
        int add = _findTargetSumWays(nums, target + nums[i], i + 1, sum);
        int sub = _findTargetSumWays( nums,target - nums[i], i + 1, sum);
        dp.put(key, add + sub);
        return dp.get(key);
    }
}
