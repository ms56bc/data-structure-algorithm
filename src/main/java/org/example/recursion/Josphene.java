package org.example.recursion;

import java.util.stream.IntStream;

public class Josphene {
    public static void main(String[] args) {
        String input = IntStream.range(1, 3).mapToObj(String::valueOf).reduce("", String::concat);
        Josphene js = new Josphene();
        System.out.println(input);
        System.out.println(js.solve(0, 6, input));
    }
    private int solve(int n, int k, String s){
        if(s.length() == 1) return Integer.parseInt(s);
        int indexToBeKilled = n + k > s.length() ? (n + k) % s.length(): n+k;

        String ss = indexToBeKilled == 0 ? s.substring(indexToBeKilled): s.substring(0, indexToBeKilled) + s.substring(indexToBeKilled);
        System.out.println(indexToBeKilled + ":   "+ss);
        return solve(indexToBeKilled +1, k, ss);
    }
}

