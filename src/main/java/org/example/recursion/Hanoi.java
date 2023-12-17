package org.example.recursion;

import java.util.*;

public class Hanoi {
    record Tuple3(int n, int from, int to){
        public int aux(){
            return 6- (from + to);
        }
    }
    Map<Tuple3, List<String>> dp;

    public Hanoi(int n) {
        this.dp = new HashMap<>();
    }

    public List<String> toh(int N, int from, int to, int aux) {
        if(N == 0) return List.of();
        if(N == 1){
            return List.of(move(N, from, to));
        }
        List<String> s = new LinkedList<>();
        var key = new Tuple3(N -1, from, aux);
        if(dp.containsKey(key)){
            s.addAll(dp.get(key));
        } else {
            List<String> s1 = toh(N - 1, from, aux, to);
            dp.put(key, s1);
            s.addAll(s1);
        }
        s.add(move(N, from, to));

        key = new Tuple3(N -1, aux, to);
        if(dp.containsKey(key)){
            s.addAll(dp.get(key));
        }else {
            List<String> s1 = toh(N - 1, aux, to, from);
            dp.put(key, s1);
            s.addAll(s1);
        }
        return s;
    }

    String move(int n, int f, int t){
        return String.format("move disk %s from rod %s to rod %s", n, f,t);
    }

    public static void main(String[] args) {
        int n = 100;
        ArrayList<String> s = new ArrayList<>();
        s.remove(0);
        Hanoi h = new Hanoi(n);

        h.toh(n, 1, 3, 2).forEach(System.out::println);
    }
}

