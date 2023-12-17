package org.example.dp;


public class PaintHouse {
    public static void main(String[] args) {
        var ph = new PaintHouse();
        var houses = new int[][]{{17, 2, 3},{16, 1, 3},{1,3,19}};
        var cost = ph.minCostDfs(houses, 0, -1);
        System.out.println(cost);
        cost = ph.minCostDp(houses);
        System.out.println(cost);
    }

    private int minCostDfs(int[][] arr, int idx, int prev){
        if(idx>= arr.length) return 0;
        var min = Integer.MAX_VALUE;
        int [] colors  = arr[idx];
        for(int i = 0; i< colors.length; i++){
            if(i == prev) continue;
            min = Integer.min(min, colors[i] + minCostDfs(arr, idx +1, i));
        }
        return min;
    }

    private int minCostDp(int [][] arr){
        int[][] d = new int[arr.length][arr[0].length];
        int lineMin = Integer.MAX_VALUE;
        for(int i = 0; i< arr[0].length; i++){
            d[0][i] = arr[0][i];
        }
        for(int i = 1; i< arr.length; i++){
            lineMin = Integer.MAX_VALUE;
            for(int j = 0; j< arr[0].length; j++) {
                int idx = minIndex(d[i - 1], j);
                d[i][j] = arr[i][j] + d[i - 1][idx];
                lineMin = Integer.min(lineMin, d[i][j]);
            }
        }
        return lineMin;
    }

    private int minIndex(int[] a, int excluding){
        int  min = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i < a.length; i++) {
            if(i == excluding) continue;
            if(a[i] < min){
                min = a[i];
                idx = i;
            }
        }
        return idx;
    }
}
