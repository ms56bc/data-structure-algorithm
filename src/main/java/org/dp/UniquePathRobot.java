package org.dp;

public class UniquePathRobot {
    static long paths = 0;
    public static void main(String[] args) {
        int m = 3, n = 7;
        uniquePaths(m, n, 0, 0);
        System.out.println(UniquePathRobot.paths);
        System.out.println(UniquePathRobot.uniquePaths2(m -1, n -1));
        System.out.println(UniquePathRobot.uniquePathsDp(m, n));
    }
    private static void uniquePaths(int m, int n, int i, int j){
        if(i == m -1 &&  j == n -1){
            paths++;
            return;
        }
        if(i >= m || j >= n) return;
        uniquePaths(m, n, i+1, j);
        uniquePaths(m, n, i, j+1);
    }

    private static int uniquePaths2(int m, int n){
        if(m == 0 && n > 0) return 1;
        if(m > 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;
        if(m == 0 && n == 0) return 0;
        return uniquePaths2(m - 1, n) + uniquePaths2(m, n -1);
    }

    private static int uniquePathsDp(int m, int n){
        int[][] dp = new int[m][n];
        for(int i=0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int i=0; i < n; i++){
            dp[0][i] = 1;
        }
        for(int i =1; i < m; i++){
            for(int j=1; j < n;j++) {
                dp[i][j] =  dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
