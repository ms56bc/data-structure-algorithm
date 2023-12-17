package org.example.dp;

public class KnapSack {
    static int maxValue = Integer.MIN_VALUE;
    static int[][] dp;
    static int x = 0;
    public static void main(String[] args) {
        int[] wt = {2, 4, 4, 4};
        int[] vl = {1, 4, 5, 7};
        int maxWt = 14;
        dp = new int[maxWt + 1][wt.length + 1];
        maxValue = KnapSack.minWeight(wt, vl, 3, maxWt);
        System.out.println(maxValue);
        maxValue = KnapSack.minTop(wt, vl, maxWt);
        System.out.println(maxValue);
        System.out.println(x);
    }

    static int minWeight(int[] wt, int[] vl, int i, int rmWt) {
        x++;
        if (i == -1 || rmWt == 0) {
            return 0;
        }
        if (dp[rmWt][i] != 0) return dp[rmWt][i];
        int v1 = 0;
        int v2;
        if (rmWt - wt[i] >= 0) {
            v1 = vl[i] + minWeight(wt, vl, i - 1, rmWt - wt[i]);
        }
        v2 = minWeight(wt, vl, i - 1, rmWt);
        int ans = Integer.max(v1, v2);
        dp[rmWt][i] = ans;
        return ans;
    }

    static int minTop(int[] w, int[] v, int maxWt) {
        dp = new int[w.length + 1][maxWt + 1];
        for (int i = 1; i <= w.length; i++) {
            for (int j = 1; j <= maxWt; j++) {
                int index = i - 1;
                int maxValueWithoutCurr = dp[i-1][j];
                int maxValueWithCurr = 0;
                if (w[index] <= j) {
                    maxValueWithCurr = v[index] + dp[i -1][j - w[index]];
                }
                dp[i][j] = Integer.max(maxValueWithoutCurr, maxValueWithCurr);
            }
        }
        return dp[w.length][maxWt];
    }
}