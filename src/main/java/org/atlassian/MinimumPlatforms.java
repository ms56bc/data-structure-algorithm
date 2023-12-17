package org.atlassian;

import java.math.BigInteger;
import java.util.PriorityQueue;

public class MinimumPlatforms {
    static class Train implements Comparable<Train>{
        int a;
        int d;
        public Train(int a , int d){
            this.a = a;
            this.d = d;
        }
        public int compareTo(Train that){
            return Integer.compare(this.d, that.d);
        }
    }
    static long power(int N,int R)
    {
        //Your code here
        //int mod =1000000007;
        int mod = 11;
        if(R==0){
            return 1;
        }
        long  ans = power(N,R/2)%mod;
        if(R%2 == 0){
            return (ans * ans)%mod;
        }
        return N*((ans*ans)%mod)%mod;
    }
    public static int findMinPlatforms(int[] arr, int[] dep) {
        PriorityQueue<Train> q = new PriorityQueue<>();
        int m = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            while(!q.isEmpty() && q.peek().d < arr[i]){
                q.poll();
            }
            q.offer(new Train(arr[i], dep[i]));
            m = Integer.max(m, q.size());
        }

        return m;
    }

    public static void main(String[] args) {
        int[] arrivals = {900, 940, 950, 1100, 1500, 1800};
        int[] departures = {910, 1200, 1120, 1130, 1900, 2000};
        //0900 0940 0950 1100 1500 1800
        //0910 1200 1120 1130 1900 2000
        var p = power(2, 9);
        System.out.println(p);
        //int minPlatforms = findMinPlatforms(arrivals, departures);
        //System.out.println("Minimum platforms required: " + minPlatforms);
    }
}

