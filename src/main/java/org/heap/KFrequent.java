package org.heap;

import java.util.*;

public class KFrequent {
    static class Store {
        int num;
        int freq;

        public Store(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    public static void main(String[] args) {
        KFrequent kf = new KFrequent();
        int a = Integer.MAX_VALUE;
        int b = 1 + (a - 1)/2;
        System.out.println(b);
        int [] x = {1, 1, 2, 2, 3, 3, 4, 4, 6};
        kf.find(x, 2);

    }
    private void find(int [] in, int k){
        Comparator<Store> cp = Comparator.comparing(s -> s.freq);
        PriorityQueue<Store> pq = new PriorityQueue<>(cp);
        Map<Integer, Integer> m = new HashMap<>();
        for(int n: in){
            m.put(n,  m.getOrDefault(n, 0) +1);
        }
        for(int key : m.keySet()){
            pq.offer(new Store(key, m.get(key)));
            if(pq.size() > k){
                pq.poll();
            }
        }
        pq.stream().map(i -> i.num).forEach(System.out::println);
    }
}
