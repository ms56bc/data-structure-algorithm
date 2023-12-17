package org.simplepay;

import java.util.*;
import java.util.stream.Collectors;

interface IAgent {
    public int getBidIncrease();
    public int id();
}

class Bidding<E extends IAgent> {
    private List<E> agents;
    private long maxBid;
    private int maxRounds;
    private boolean isProcessFinished = false;
    private final Map<Integer, Long> agentBids;
    record Test (String name, String type){
        public Test {
            if(name == null)
                throw new IllegalArgumentException("");
        }
    }
    public Bidding(List<E> agents) {
        this.agents = agents;
        this.agentBids = new HashMap<>();
        this.maxBid = Long.MIN_VALUE;
        this.maxRounds = 5;
    }

    public Bidding(List<E> agents, int maxRounds) {
        this.agents = agents;
        this.agentBids = new HashMap<>();
        this.maxBid = Long.MIN_VALUE;
        this.maxRounds = maxRounds;
    }

    // Returns the agents that are left at the end of the bidding process
    public List<E> run() {
        int currentRound = 0;
        new Test("", "");
        while (!isProcessFinished && currentRound < maxRounds) {
            currentRound++;
            this.agents = runRound();
        }
        return agents;
    }

    private List<E> runRound() {
        List<E> agentsRemainingInBidding = new ArrayList<>();
        for (E agent : agents) {
            if (isProcessFinished) {
                agentsRemainingInBidding.add(agent);
            } else {
                long lastRoundBid = agentBids.getOrDefault(agent.id(), 0L);
                if (lastRoundBid == maxBid) {
                    isProcessFinished = true;
                    agentsRemainingInBidding.add(agent);
                } else {
                    long nextBid = lastRoundBid + agent.getBidIncrease();
                    if (nextBid >= maxBid) {
                        maxBid = nextBid;
                        agentsRemainingInBidding.add(agent);
                        agentBids.put(agent.id(), nextBid);
                    }
                }
            }
        }
        return agentsRemainingInBidding;
    }
}