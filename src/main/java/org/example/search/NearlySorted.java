package org.example.search;

/***
 * 1,2,3,4,5
 * 1,3,2,5,4   4
 */
public class NearlySorted {
    public static void main(String[] args) {
        int input  []  = {1};
        NearlySorted ns = new NearlySorted();
        int index = ns.findIndex(input, 0, input.length -1, 1);
        System.out.println(index);
    }
    private int findIndex(int [] input, int m, int n, int s){
        while(m <=n){

            int mid = m + (n - m)/2;
            int element = input[mid];
            if(input[mid] == s) return mid;
            if(input[mid] > s){
                if(mid +1 < input.length && input[mid+1] == s) return mid +1;
                n  = mid -1;
            } else {
                if(mid -1 >= 0  && input[mid-1] == s) return mid - 1;
                m = mid + 1;
            }

        }
        return -1;
    }

}
