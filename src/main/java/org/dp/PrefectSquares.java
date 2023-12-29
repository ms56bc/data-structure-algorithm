package org.dp;

public class PrefectSquares {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(new PrefectSquares().prefectSquares(12));
        System.out.println(new PrefectSquares().prefectSquares(13));

        System.out.println(new PrefectSquares().prefectSquareDp(1));
        System.out.println(new PrefectSquares().prefectSquareDp(0));
        System.out.println(new PrefectSquares().prefectSquareDp(13));
    }
    int prefectSquares(int n){
        if(n == 1) return 1;
        if(n < 1) return 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= Math.sqrt(n); i++){
            ans = Integer.min(ans, prefectSquares(n - (i * i)) +1);
        }
        return ans;
    }

    int prefectSquareDp(int n){
        int[] dp = new int[n+1];
        for(int i =1; i <=n ; i++){
            int ans = Integer.MAX_VALUE;
            for(int j = 1; j <= Math.sqrt(i); j++){
                int idx = Math.max(i - (j * j), 0);
                ans = Math.min(ans, 1 + dp[idx]);
            }
            dp[i] = ans;
        }
        return dp[n];
    }
}
