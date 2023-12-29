package org.stack;

import java.util.Stack;

public class NextGreaterRight {
    public int [] nextGreater(int [] input){
        int [] ans = new int [input.length];
        Stack<Integer> stack  = new Stack<>();
        for(int i = input.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= input[i]) stack.pop();
            if(stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peek();

            stack.push(input[i]);
        }

        return ans;

    }
}
