package org.example.dp;


/***
 * the dfs version has a trick about how to avoid choosing the same coin again and again
 * eg: 1, 2, 2 =5, and 2, 1, 2 = 5, so we can manke sure if we choosen 2 we dont go back to one again
 */
public class CoinChange {

    private int sol = 0;
    public static void main(String[] args) {
        CoinChange c = new CoinChange();

        System.out.println(c.coinChangeDfs(new int[]{1, 2, 5}, 5, 0));
        System.out.println(c.coinChange(new int[]{1, 2, 5}, 5));
        System.out.println("----");
        System.out.println(c.coinChangeDfs(new int[]{2}, 3, 0));
        System.out.println(c.coinChange(new int[]{2}, 3));
        System.out.println("----");
        System.out.println(c.coinChangeDfs(new int[]{1}, 0, 0));
        System.out.println(c.coinChange(new int[]{1}, 0));
        System.out.println("----");
        System.out.println(c.coinChangeDfs(new int[]{1}, 1, 0));
        System.out.println(c.coinChange(new int[]{1}, 1));
        System.out.println("----");
        System.out.println(c.coinChangeDfs(new int[]{1}, 2, 0));
        System.out.println(c.coinChange(new int[]{1}, 2));
    }

    private int coinChange(int[] coins, int amount) {
        return coinChangeDp(coins, amount, new int[amount + 1][coins.length]);
    }

    // dp is storing the way to change the amount,  //F(I, J) = F(A - C, J) + F(A, J-1)
    // which is the number of ways when the current column is taken and when it is not taken.
    private int coinChangeDp(int[] coins, int amount, int[][] dp) {
        //F(I, J) = F(A - C, J) + F(A, J-1)
        for (int i = 0; i <= amount; i++)
            dp[i][0] = 1;
        for (int i = 0; i < coins.length; i++)
            dp[0][i] = 1;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int w = 0;
                if(i - coins[j] >= 0)
                    w += dp[i - coins[j]][j];
                if(j-1 >= 0)
                    w += dp[i][j - 1];
                dp[i][j] = w;
            }
        }
        return dp[amount][coins.length -1];
    }

    private int coinChangeDfs(int[] coins, int amount, int i) {
        if (amount == 0) return 1;
        if (amount < 0) return 0;
        if(i >= coins.length) return 0;

        var x = coinChangeDfs(coins, amount - coins[i], i);
        var y = coinChangeDfs(coins, amount, i +1);
        return x + y;
    }
}
