package org.example.backtracking;


public class WordSearch {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] visited;
    String word;
    char[][] board;
    int m;
    int n;

    public WordSearch(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.visited = new int[board.length][board[0].length];
        this.m = board.length;
        this.n = board[0].length;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'a', 'b', 'c'},
                {'b', 'e', 'f'},
                {'g', 'h', 'i'}
        };
        String word = "abehg";
        WordSearch ws = new WordSearch(board, word);
        System.out.println(ws.dfs(0, 0, 0));
    }


    private boolean dfs(int i, int j, int index) {
        if (index == word.length()) return true;
        if (!isValid(i, j) || visited[i][j] == 1 || board[i][j] != word.charAt(index)) return false;
        boolean res = false;
        visited[i][j] = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            res = res || dfs(x, y, index + 1);
        }
        visited[i][j] = 1;
        return res;
    }


    private boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
