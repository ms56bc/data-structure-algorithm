package org.gemini;

class Frame {
    private int throwCount = 0;
    private int countKnocked = 0;
    private int firstRound = 0;

    public Frame() {

    }

    void playRound(int knocked) {
        if (isClosed()) throw new RuntimeException("game is closed");
        throwCount++;
        if (throwCount == 1) firstRound = knocked;
        countKnocked = countKnocked + knocked;
    }

    public int getKnocked() {
        return this.countKnocked;
    }

    public boolean isClosed() {
        return countKnocked == 10 || throwCount == 2;
    }

    public boolean isSpare() {
        return countKnocked == 10 && throwCount == 2;
    }

    public boolean isStrike() {
        return countKnocked == 10 && throwCount == 1;
    }

    public int getFirst() {
        return this.firstRound;
    }
}
