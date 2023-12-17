package org.simplepay;

import java.util.*;
import java.util.stream.IntStream;

public class BiddingTest {
    public static void main(String[] args) {
        whenIncrementalInitialBidAndNoBidIncreaseThenLastAgentWins("last agent bid highest");
        whenFixedInitialBidAndNoBidIncreaseThenLastAgentWins("all agents bid same");
        whenFixedInitialBidAndIncrementalBidIncreaseThenBidCLoseAfterMaxRounds("max bid round");

    }
    private static void whenIncrementalInitialBidAndNoBidIncreaseThenLastAgentWins(String testName){
        List<IAgentImpl> collect = IntStream.range(1, 5).mapToObj((int id) -> new IAgentImpl(id, id, 0)).toList();
        Bidding<IAgentImpl> b = new Bidding<>(collect);
        List<IAgentImpl> r = b.run();
        String msg =  r.size() == 1 ? "pass" : "fail";
        System.out.println(testName +":" + msg);
        msg =  r.get(0).id() == 4 ? "pass" : "fail";
        System.out.println(testName +":" + msg);
    }

    private static void whenFixedInitialBidAndNoBidIncreaseThenLastAgentWins(String testName){
        List<IAgentImpl> collect = IntStream.range(1, 5).mapToObj((int id) -> new IAgentImpl(id, 1, 0)).toList();
        Bidding<IAgentImpl> b = new Bidding<>(collect);
        List<IAgentImpl> r = b.run();
        String msg =  r.size() == collect.size() ? "pass" : "fail";
        System.out.println(testName +":" + msg);
    }

    private static void whenFixedInitialBidAndIncrementalBidIncreaseThenBidCLoseAfterMaxRounds(String testName){
        List<IAgentImpl> collect = IntStream.range(1, 5).mapToObj((int id) -> new IAgentImpl(id, id, 4)).toList();
        Bidding<IAgentImpl> b = new Bidding<>(collect);
        List<IAgentImpl> r = b.run();
        String msg =  r.size() == collect.size() ? "pass" : "fail";
        System.out.println(testName +":" + msg);
    }
}

class IAgentImpl implements IAgent  {
    int startingBid = 1;
    boolean firstBid = true;
    int id;
    int increaseBidBy;
    public IAgentImpl(int id, int startingBid, int bidIncrease) {
        this.startingBid = startingBid;
        this.id = id;
        this.increaseBidBy = bidIncrease;
    }

    public int getBidIncrease() {
        if(firstBid) {
            firstBid = false;
            return startingBid;
        }
        else {
            return increaseBidBy;
        }
    }

    public int id() {
        return this.id;
    }
}

