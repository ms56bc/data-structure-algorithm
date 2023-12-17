package org.blind75;

import java.util.LinkedList;
import java.util.List;

public class MergeList {
    public static void main(String[] args) {

    }

    private List<Integer> mergeKList(List<List<Integer>> lists) {
        while (lists.size() != 1) {
            List<List<Integer>> merged = new LinkedList<>();
            for (int i = 0; i < lists.size(); i = i + 2) {
                List<Integer> l1 = lists.get(i);
                List<Integer> l2 = i + 1 < lists.size() ? lists.get(i + 1) : null;
                merged.add(merge(l1, l2));
            }
            lists = merged;
        }
        return lists.get(0);
    }

    private List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        if (l2 == null || l2.isEmpty()) return l1;
        if (l1 == null || l1.isEmpty()) return l2;
        List<Integer> merged = new LinkedList<>();
        while (!l2.isEmpty() && !l1.isEmpty()) {
            if (l2.get(0) <= l1.get(0)) {
                merged.add(l2.get(0));
                l2.remove(0);
            } else {
                merged.add(l1.get(0));
                l1.remove(0);
            }
        }
        if (!l1.isEmpty()) merged.addAll(l2);
        if (!l2.isEmpty()) merged.addAll(l1);
        return merged;
    }
}
