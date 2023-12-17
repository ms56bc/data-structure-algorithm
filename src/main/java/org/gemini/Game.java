package org.gemini;

import java.util.LinkedList;
import java.util.List;

class Game {
    List<Frame> frames;
    Frame currFrame;
    int maxFrames;

    public Game(int maxFrames) {
        //
        this.frames = new LinkedList<Frame>();
        this.currFrame = new Frame();
        this.frames.add(currFrame);
        this.maxFrames = maxFrames;
    }

    void play(int knocked) {
        if (frames.size() > maxFrames) new RuntimeException("max frames exceed");
        if (currFrame.isClosed())
            startNextRound();

        currFrame.playRound(knocked);
    }

    private void startNextRound() {
        var newFrame = new Frame();
        frames.add(newFrame);
        currFrame = newFrame;
    }

    int score() {
        int score = 0;
        for (int i = frames.size() - 1; i >= 0; i--) {
            var f = frames.get(i);
            int b = 0;
            int currScore;
            if (f.isSpare()) b += calculateBonusSpare(i, frames.size());
            if (f.isStrike()) b += calculateBonusStrike(i, frames.size());
            currScore = f.getKnocked() + b;
            score += currScore;
        }
        return score;
    }

    //simplify the below method
    int calculateBonusStrike(int idx, int n) {
        int b = 0;
        if (idx + 1 < n) {
            var next = frames.get(idx + 1);
            b += next.getKnocked();
            if (next.isStrike() && idx + 2 < n) {
                next = frames.get(idx + 2);
                b += next.getFirst();
            }
        }
        return b;
    }

    int calculateBonusSpare(int idx, int n) {
        int b = 0;
        if (idx + 1 < n) {
            var next = frames.get(idx + 1);
            b += next.getFirst();
        }
        return b;
    }
}