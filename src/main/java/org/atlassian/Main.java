package org.atlassian;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        MostPopularImpl mp = new MostPopularImpl();
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("AA", 1);
        treeMap.put("A", 2);
        treeMap.put("B", 3);
        treeMap.put("C", 4);
        treeMap.put("B", 5);
        System.out.println(treeMap.lastKey());
        mp.increasePopularity(1);
        mp.increasePopularity(1);

        System.out.println(mp.mostPopular());
        mp.increasePopularity(2);
        mp.increasePopularity(2);
        mp.increasePopularity(2);
        System.out.println(mp.mostPopular());
        mp.increasePopularity(1);
        mp.decreasePopularity(2);
        mp.decreasePopularity(2);
        System.out.println(mp.mostPopular());
    }
}

interface MostPopular {
    void increasePopularity(Integer contentId);

    Integer mostPopular();

    void decreasePopularity(Integer contentId);
}


// 7 ,7 8,8, 8, 8, 8
// 1, 2, 1,, 2 3, 2
// reverse value->Key map
//  -> 4
// 3 -> 10
// 3-> 8
//maxCount:  1,2,2, 3  -> 8, 2->, 7
// find value of id in main map
// search in reverse map
// delete value in reverse map and update new value in reverse map
// update new max
/*Sample execution:
        [
        popularityTracker.increasePopularity(7);
        popularityTracker.increasePopularity(7);
        popularityTracker.increasePopularity(8);
        popularityTracker.mostPopular();        // returns 7
        popularityTracker.increasePopularity(8);
        popularityTracker.increasePopularity(8);
        popularityTracker.mostPopular();        // returns 8
        popularityTracker.decreasePopularity(8);
        popularityTracker.decreasePopularity(8);
        popularityTracker.mostPopular();        // returns 7
        popularityTracker.decreasePopularity(7);
        popularityTracker.decreasePopularity(7);
        popularityTracker.decreasePopularity(8);
        popularityTracker.mostPopular();        // returns -1 since there is no content with popularity greater than 0
        ]
*/