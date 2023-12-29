package org.stack;

import java.util.Stack;

/***
 * 4,2, 3, 1, 0 7, 3
 * 2,1, 1, 0, 3, -1   s 0, 1, 2
 */
public class NextSmallerRight {
    public int [] nextSmaller(int [] input){
        Stack<Integer> stack = new Stack<>();
        int [] ans = new int[input.length];
        for(int i = input.length -1; i >=0; i--){
            while(!stack.isEmpty() && input[i] <= stack.peek()) stack.pop();
            if(stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peek();
            stack.push(input[i]);
        }
        return ans;
    }
}
