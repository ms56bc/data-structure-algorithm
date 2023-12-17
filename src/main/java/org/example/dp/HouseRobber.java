package org.example.dp;

public class HouseRobber {
    record Pair(int dfs, int dp){}
    public static void main(String[] args) {
        var he = new HouseRobber();
        System.out.println(he.maxRobbed(new int[]{1, 2, 3, 1}));
        System.out.println(he.maxRobbed(new int[]{1, 2}));
        System.out.println(he.maxRobbed(new int[]{1, 2, 3, 4}));
    }

    public Pair maxRobbed(int[] houses){
        var dfs = maxRobbedDfs(houses, 0);
        var dp = maxRobbedDp(houses, new int[]{});
        return new Pair(dfs, dp);
    }

    private int maxRobbedDfs(int[] houses, int idx){
        if(idx >= houses.length) return 0;
        var x = houses[idx] + maxRobbedDfs(houses, idx + 2);
        var y = maxRobbedDfs(houses, idx + 1);
        return Integer.max(x, y);
    }
    private int maxRobbedDp(int[] houses, int [] dp){
        return 0;
    }

    private int maxRobberDfsLimited(int[] houses){
        int[] left = new int[houses.length -1];
        int[] right = new int[houses.length -1];
        int idx = 0;
        for(int h: houses){
            if(idx < houses.length - 2) left[idx] = houses[idx];
            if(idx >0) right[idx] = houses[idx];
            idx ++;
        }
        return Integer.max(maxRobbedDfs(left, 0), maxRobbedDfs(right, 1));
    }
}
