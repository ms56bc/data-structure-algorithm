package org.example.traversal;

public class SnakeTraversal {
    public void printTraversal(int [][] input){
        int row = input.length;
        int col = input[0].length;

        int [][] visited = new int[row][col];
        int[] dirY = {1, -1};
        int i =0, j=0, k=0;
        int direction = 0;
        while(k < row * col){
            System.out.print(input[i][j]+":");
            visited[i][j] = 1;
            int nj = j + dirY[direction];
            if(isValid(i, nj, visited, row, col)){
                j = nj;
            } else {
                direction = ++direction % 2;
                i++;
            }
            k++;
        }
    }
    private  boolean isValid(int ni, int nj, int [][] visited, int row, int col){
        return ni >=0 && nj >=0 && ni< row && nj< col && visited[ni][nj] == 0;
    }
}
