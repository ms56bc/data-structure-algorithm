package org.example;

import org.example.slidingwindow.*;
import org.example.stack.AreaHistogram;
import org.example.stack.NextGreaterRight;
import org.example.traversal.SnakeTraversal;
import org.example.traversal.SpiralMatrix;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    record TestP(String name, BigDecimal amount) {
        public static TestP create(String name){
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("error message");
            }
            return new TestP(name.trim(), BigDecimal.valueOf(100));
        }
    }
    public static void main(String[] args) {
        Comparator<TestP> c = Comparator.comparing(TestP::name);
        PriorityQueue<Main.TestP> pq = new PriorityQueue<>(c);
        checkORdering(pq);
        pq = new PriorityQueue<>(c.reversed());
        checkORdering(pq);

    }
    private static void checkORdering(PriorityQueue<Main.TestP> pq){
        pq.offer(TestP.create("na"));
        pq.offer(TestP.create("nv"));
        pq.offer(TestP.create("nd"));
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}