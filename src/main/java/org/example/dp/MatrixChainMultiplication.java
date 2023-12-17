package org.example.dp;

public class MatrixChainMultiplication {


    public static void main(String[] args) {
        int arr[] = {};
        solve(arr, 1, arr.length -1);
    }

    private static int solve(int arr[], int i , int j){
        if(i >= j) return 0;
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = solve(arr, i, k) + solve(arr, k+1, j) + arr[i -1] * k * arr[j];
            min = Integer.min(temp, min);
        }
        return min;
    }
}
