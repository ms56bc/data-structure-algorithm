package org.greedy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestStream {
    public static void main(String[] args) {
        int[] tree = {0, 1, 2, 3, 4, 5, 6, 7};
        int[] day =  {0, 1, 2, 0, 1, 2, 0, 0};
        Map<Integer, List<Train>> tst = IntStream.range(0, tree.length)
                .mapToObj(i -> new Train(tree[i], tree[i], day[i]))
                .collect(Collectors.groupingBy(train -> train.day, Collectors.toList()));
        System.out.printf("tst: %s\n", tst);
    }
}
class Train {
    int arr;
    int dept;
    int day;
    public Train(int arr, int dept, int day){
        this.arr = arr;
        this.dept = dept;
        this.day = day;
    }
}
