package org.dp;

public class StepsTaken {

    int[] dp;

    public StepsTaken() {
        //
    }

    public static void main(String[] args) {
        StepsTaken s = new StepsTaken();
        System.out.println(s.climbStairs(4));
        System.out.println(s.climbStairs(2));
        System.out.println(s.climbStairs(1));
        System.out.println(s.climbStairs(3));
    }
    private int climbStairs(int n) {
        this.dp = new int [n+1];
        //return dfs(n);

        return dfsReverse(0, n);
    }

    private int dfs(int n){
        if(n == 0) return 1;
        if (n <=0) return 0;
        if(dp[n] != 0) return dp[n];
        dp[n] = dfs(n-1) + dfs(n-2);
        return dp[n];
    }

    private int dfsReverse(int n, int steps){
        if(n == steps) return 1;
        if (n > steps) return 0;
        if(dp[n] != 0) return dp[n];
        dp[n] = dfsReverse(n + 1, steps) + dfsReverse(n + 2, steps);
        return dp[n];
    }
}
