package org.stack;

import java.util.Arrays;
import java.util.Stack;

/*** find less than or equal to on the left including itself
 * 100, 80, 60, 70, 60, 75, 85
 * 1, 1, 1, 2, 1, 4, 6
 */
public class StockSpanProblem {
    static class Store{
        public int value;
        public int index;

        public Store(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    public static void main(String[] args) {
        StockSpanProblem sp = new StockSpanProblem();
        int [] input = {100, 80, 60, 70, 60, 75, 85};
        Arrays.stream(sp.solve(input)).forEach(System.out::println);
    }

    private int [] solve(int [] input){
        Stack<Store> s = new Stack<>();
        int [] output = new int [input.length];
        for(int j = 0; j < input.length; j++){
            while(!s.isEmpty() && s.peek().value <= input[j]){
                s.pop();
            }
            output[j] = s.isEmpty() ? 1 : j - s.peek().index;
            Store st  = new Store(input[j], j);
            s.push(st);
        }
        return output;
    }
}
