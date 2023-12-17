package org.example.stack;

import java.util.Stack;

public class AreaHistogram {
    static class IndexValue{
        int value;
        int index;

        public IndexValue(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    public final int calcHistogram(int [] input){

        int maxArea = 0;
        int [] leftIndex = new int [input.length];
        Stack<IndexValue> s = new Stack<>();
        // left smaller
        for(int i=0; i< input.length; i++){
            while(!s.isEmpty() && s.peek().value >= input[i]) s.pop();

            if(s.isEmpty()) leftIndex[i] = -1;
            else leftIndex[i] = s.peek().index;

            s.push(new IndexValue(input[i], i));
        }

        s = new Stack<>();
        // right smaller
        for(int i= input.length - 1; i >=0; i--){
            while(!s.isEmpty() && s.peek().value >= input[i]) s.pop();

            int area;
            int rtIndex;

            if(s.isEmpty()) {
                rtIndex = input.length;
            }
            else {
                rtIndex = s.peek().index;
            }

            area = calcWidth(leftIndex[i], rtIndex) * input[i];
            System.out.println("local min"+area);
            maxArea = Integer.max(maxArea, area);
            s.push(new IndexValue(input[i], i));
        }

        return maxArea;
    }
    private int calcWidth(int lt, int rt){
        int width  = rt - lt - 1;
        System.out.println("width: "+width);
        return width;
    }
}
