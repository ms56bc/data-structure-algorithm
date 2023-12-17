package org.atlassian.test;

// fixed size snake
// 4 direction
// when snake hits boundary wall game over. do not worry about colliding itself
public class Main {
    int [][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1,0}};
    int [][] board;
    Snake snake;

    public Main() {
        this.board = new int [10][10];
        this.snake = new Snake();
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.playGame(new Index(0,0));
    }
    public boolean isMoveValid(Index headSnake) {
            return headSnake.i >= 0 && headSnake.j >= 0 && headSnake.i < board.length && headSnake.j < board[0].length;
    }

    public void playGame(Index nextIndex){
        Index nextDirection;
        while (true){
            int dir = getDirectionFromUser();
            nextDirection =  nextIndex(dir, snake.getHead());
            if(!isMoveValid(nextDirection)){
                // print of boar
                break;
            }
            snake.moveSnake(nextDirection);
            System.out.println("current bora");
        }
        System.out.println("print current board");
    }

    private Index nextIndex(int dir, Index snakeHead){
        int i = snakeHead.i + direction[dir][0];
        int j = snakeHead.j + direction[dir][1];
        return new Index(i, j);
    }

    public int getDirectionFromUser(){
        return 0;
    }

}

class Snake {
    Index [] snakeIndexes;
    int head = 0;
    public Snake() {
        this.snakeIndexes = new Index [5];
        for (int i = 0; i < 5; i++) {
            this.snakeIndexes[i] = new Index(0, 0);
        }
    }

    public Index getHead(){
        return snakeIndexes[head];
    }

    public void moveSnake(Index nextHead){
        for (int i = snakeIndexes.length -1; i > 0 ; i--) {
            snakeIndexes[i]  = snakeIndexes[i -1];
        }
        snakeIndexes[0] = nextHead;
    }
}

class Index {
    int i;
    int j;

    public Index(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
