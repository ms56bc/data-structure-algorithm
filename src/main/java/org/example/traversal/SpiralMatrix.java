package org.example.traversal;

public class SpiralMatrix {

    public void printTraversal(int [][] input){
        int row = input.length;
        int col = input[0].length;

        int [][] visited = new int[row][col];
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {1, 0, -1, 0};
        int i =0, j=0, k=0;
        int direction = 0;
        while(k < row * col){
            System.out.print(input[i][j]+":");
            visited[i][j] = 1;
            int ni = i + dirX[direction];
            int nj = j + dirY[direction];
            if(isValid(ni, nj, visited, row, col)){
                i = ni;
                j = nj;
            } else {
                direction = ++direction % 4;
                i = i + dirX[direction];
                j = j + dirY[direction];
            }
            k++;
        }
    }
    private  boolean isValid(int ni, int nj, int [][] visited, int row, int col){
        return ni >=0 && nj >=0 && ni< row && nj< col && visited[ni][nj] == 0;
    }
}
