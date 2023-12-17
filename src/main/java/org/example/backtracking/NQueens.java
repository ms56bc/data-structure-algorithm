package org.example.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class NQueens {
    int[][] board;
    int m;
    int n;
    int k;
    int[][] dir = {{-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
    int[] cols;
    Set<Integer> rTDig;
    Set<Integer> lTDig;

    public NQueens(int[][] board, int m, int n, int k) {
        this.board = board;
        this.m = m;
        this.n = n;
        this.k = k;
        this.cols = new int[n];
        this.rTDig = new HashSet<>();
        this.lTDig = new HashSet<>();
    }

    public static void main(String[] args) {
        var size = 4;
        var nq = new NQueens(new int[size][size], size, size, size);
        var placed = nq.place(size, 0);
        System.out.println(placed);
        for (int[] row : nq.board)
            System.out.println(Arrays.toString(row));
    }

    private boolean place(int k, int i) {
        if (k == 0) return true;
        if (i == m) return false;
        for (int j = 0; j < n; j++) {
            if (isSafe(i, j)) {
                add(i, j);
                if (place(k - 1, i + 1)) return true;
                remove(i, j);
            }
        }
        return false;
    }
    private void add(int i, int j){
        board[i][j] = 1;
        cols[j] = 1;
        rTDig.add(i + j);
        lTDig.add(i -j);
    }

    private void remove(int i, int j){
        board[i][j] = 0;
        cols[j] = 0;
        rTDig.remove(i + j);
        lTDig.remove(i -j);
    }
    private boolean isSafe(int i, int j) {
        System.out.println(i + ":" + j);
        if (!isValid(i, j)) return false;
        if (cols[j] == 1) return false;
        if(rTDig.contains(i + j)) return false;
        if(lTDig.contains(i - j)) return false;
        return true;
    }

    private boolean isValid(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
