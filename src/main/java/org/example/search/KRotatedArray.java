package org.example.search;

/***
 * 7, 0, 1, 2, 3, 4, 5, 6,
 * 7, 8, 9, 10, 15, 1, 2, 3, 4
 */
public class KRotatedArray {
    public static void main(String[] args) {
        int input  []  = {7, 0, 1, 2, 3, 4, 5, 6};
        KRotatedArray k = new KRotatedArray();
        int m = 0;
        int n = input.length -1;
        int minIndex = k.findIndexMin(input, m, n);
        System.out.println(k.findIndexMin(input, minIndex, n));
    }

    private int findIndexMin(int [] input, int m, int n){
        while(m <= n){
            System.out.println(m+":"+n);
            int mid = m + (n - m)/2;
            int element = input[mid];
            if(isMinimum(element, mid, input)){
                return mid;
            }
            if(element > input[n]) m = mid + 1;
            else n = mid - 1;
        }
        return -1;
    }
    private boolean isMinimum(int element, int mid, int [] input){
        int right  = (mid +1)% input.length;
        int left = (input.length + mid -1) % input.length;
        return element < input[right] && element < input[left];
    }
}
