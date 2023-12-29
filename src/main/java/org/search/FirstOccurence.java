package org.search;

import java.util.Arrays;

public class FirstOccurence {

    public static void main(String[] args) {
        FirstOccurence fo = new FirstOccurence();
        int [] input = {1, 2, 3, 3, 3, 4, 5};
        System.out.println(fo.index(input, 3));
    }
    private int index(int [] input, int element){
        return Arrays.binarySearch(input, element);
    }
}
