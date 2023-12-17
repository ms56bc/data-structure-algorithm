package org.example.recursion;

import java.util.Arrays;
import java.util.List;

public class Sort {
    /*public int [] sort(int [] input, int m, int n){
            if(m == 0 || n == input.length -1) return input;
            int [] left = sort(input, m , (m +n)/2);
            int [] right = sort(input, (m +n)/2 +1, n);

            return merge(left, right);
    }*/

    private void insert(int input [], int indexLast,  int element){
        if(indexLast == 0 || input[indexLast - 1] <= element) input[indexLast] = element;
        insert(input, --indexLast, element);
    }

    public static void main(String[] args) {
        int [] input = {1, 2, 4, 0};
        Sort s = new Sort();
        s.insert(input, input.length -1, 3);
        Arrays.stream(input).forEach(System.out::println);
    }

    private void swap(int [] input, int m, int n){
        int d = input[m];
        input[m] = input[n];
        input[n] = d;
    }
}
