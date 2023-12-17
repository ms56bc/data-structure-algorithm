package org.example.dp;

import java.util.HashMap;
import java.util.List;

public class MinimumCostForTickets {

    private int min = Integer.MAX_VALUE;
    private HashMap<Integer, Integer> dp;

    public static void main(String[] args) {
        MinimumCostForTickets m = new MinimumCostForTickets();
        m.minimumCost(new int[]{2, 7, 15}, new int[]{1, 2, 3});
        m.minimumCost(new int[]{2, 7, 15}, new int[]{1, 4, 6, 7, 8, 20});
    }

    private void minimumCost(int[] costs, int[] days) {
        min = Integer.MAX_VALUE;
        dp = new HashMap<>();
        System.out.println(dfs(costs, days, 0));
        System.out.println(dpSol(costs, days));
    }

    /*private void solveDP() {
        if (dp[])
    }*/

    private int dfs(int[] costs, int[] days, int i) {
        if (i == days.length) {
            return 0;
        }
        if (dp.containsKey(i)) return dp.get(i);

        int[] passDays = new int[]{1, 7, 30};
        dp.put(i, Integer.MAX_VALUE);
        for (int day = 0; day < passDays.length; day++) {
            int j = i;
            int daysCovered = days[j] + passDays[day];
            while (j < days.length && daysCovered > days[j]) j++;
            dp.put(i, Integer.min(dp.get(i), dfs(costs, days, j) + costs[day]));
        }
        return dp.get(i);
    }

    // when we reach at an index i, we need to substract the number of days covered by the pass from the current day,
    // to find out when was the last day we need to buy a ticket.
    // At every step we want to fin out what is the minimum value needed to buy a ticket.
    private int dpSol(int[] costs, int[] days) {
        int[] passDays = new int[]{1, 7, 30};
        dp = new HashMap<>();
        for (int i = 0; i < days.length; i++) {
            dp.put(i, Integer.MAX_VALUE);
            for (int day = 0; day < passDays.length; day++) {
                var daysCovered = days[i] - passDays[day];
                int j = i;
                while (j >= 0 && days[j] > daysCovered) j--;
                var c = costs[day] + dp.getOrDefault(j, 0);
                int min = Integer.min(dp.get(i), c);
                dp.put(i, min);
            }
        }
        return dp.getOrDefault(days.length - 1, 0);
    }
//1, 7 => 2,  7
// 1, 4, 6, 7, 8, 20
// 2, 3, 4, 7, 9, 11
// 7
}
