package org.blind75;

public class RobotWays {
    public static void main(String[] args) {
        var a = new RobotWays();
        System.out.println(a.ways(3, 7));
    }
    private int ways(int m, int n){
        int[][] dp = new int[m][n+1];

        for(int i = m -1; i >= 0 ; i--)
            dp[i][n] = 0;

        for(int i = n; i >= 0 ; i--)
            dp[m-1][i] = 1;



        for(int i = m-2; i >= 0 ; i--){
            for(int j= n-1; j >=0; j--){
                dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }
        return dp[0][0];
    }
}
