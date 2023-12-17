package org.blind75;

public class ClimbStairs {
    public static void main(String[] args) {
        var s = new ClimbStairs();
        var a = s.climbStairs(3);
        System.out.println(s.climbStairsDp(3) == s.climbStairs(3));
        System.out.println(s.climbStairsDp(5) == s.climbStairs(5));
    }
    private int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        return climbStairs(n-1) + climbStairs(n-2);
    }
// 111, 2,1, 1, 2
    private int climbStairsDp(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
