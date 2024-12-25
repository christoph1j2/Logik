package com.example.logik.model;

public class Result {
    private int blackPins;
    private int whitePins;

    public Result(int blackPins, int whitePins) {
        this.blackPins = blackPins;
        this.whitePins = whitePins;
    }

    public int getBlackPins() {
        return blackPins;
    }

    public int getWhitePins() {
        return whitePins;
    }

    @Override
    public String toString() {
        return "Result [black=" + blackPins + ", white=" + whitePins + "]";
    }
}
