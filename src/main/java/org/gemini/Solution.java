package org.gemini;


import java.io.*;
import java.util.*;


public class Solution {

    // @Test
    public void testFoo() {
        Game knockDown = new Game(10);
        knockDown.play(3);
        assert knockDown.score() == 3;
        knockDown.play(7);
        assert knockDown.score() == 10;
    }

    // @Test
    public void testSpare() {

        Game knockDown = new Game(10);
        knockDown.play(3);
        knockDown.play(7);
        assert knockDown.score() == 10;

        knockDown.play(4);
        knockDown.play(5);
        //10 +4 + 9
        assert knockDown.score() == 23;
    }

    // @Test
    public void testStrike() {
        System.out.println("Starting strke: ");
        Game knockDown = new Game(10);
        knockDown.play(10);

        knockDown.play(10);

        knockDown.play(4);
        knockDown.play(6);

        knockDown.play(10);
        // 10 + 20 + 20 + 24
        System.out.print("this is score" + knockDown.score());
        System.out.println(knockDown.score() == 10 + 20 + 20 + 24);
    }

    // @Test(expected = RuntimeException.class)
    public void testFail() {
        Game knockDown = new Game(10);
        knockDown.play(3);
        assert knockDown.score() == 3;
        knockDown.play(8);
    }

    public static void main(String[] args) {
        var s = new Solution();
        //s.testFoo();
        //s.testSpare();
        s.testStrike();
        //s.testFail();

    }
}

// 1 round -> 2, 8 + (3)
// 2 round -> 3, 7 + (5)
// 3 round -> 5, 5
// ..
// 10 round -> 6, 4 <- this one is lost (no more rounds)

// 1 round 10 -> 10 + 10 + 6
// 2 round 10 -> 10 + 6 +2 -> strike
// 9 round 10 -> 10 + 10 -> strike
// 10 round 10

//getScore() ->