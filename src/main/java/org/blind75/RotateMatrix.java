package org.blind75;

public class RotateMatrix {
    public static void main(String[] args) {
        var rotateMatrix = new RotateMatrix();
        var matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    }
    private void rotate(int[][] matrix) {
        int n = matrix.length;
        int temp;
        for(int i = 0; i < n/2; i++){
            for(int j = i; j < n-i-1; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i]; // 0,0 -> 2,0
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1]; // 2,0 -> 2,2
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1]; // 2,2 -> 0,2
                matrix[j][n-i-1] = temp; // 0,2 -> 0,0
            }
        }
    }
}
