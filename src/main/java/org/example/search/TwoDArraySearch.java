package org.example.search;

import java.util.Arrays;

public class TwoDArraySearch {
    public static void main(String[] args) {
        TwoDArraySearch t = new TwoDArraySearch();
        int  [][] a = { {10, 20, 30, 40},
                        {15, 25, 35, 45},
                        {27, 29, 37, 48},
                        {32, 33, 39, 50}
        };
        System.out.println(Arrays.stream(t.findIndex(a, 31)).mapToObj(String::valueOf).reduce("", (b1, b2) -> b1 + b2));
    }

    int[] findIndex(int [][] arr, int element){
        if(arr.length == 0) return new int []{-1, -1};

        if(arr.length == 1) return new int []{0, Arrays.binarySearch(arr[0], element)};

        int m = arr.length;
        int n = arr[0].length;
        int i = 0;
        int j = n - 1;
        while(isIndexValid(i , j, m, n)){
            int curr = arr[i][j];
            if(curr == element) return new int []{i , j};
            if(curr > element) j--;
            else i++;
        }

        return new int[]{-1, -1};
    }

    boolean isIndexValid(int i, int j, int m, int n){
        return i >=0 && j >=0 && i < m && i < n;
    }
}
