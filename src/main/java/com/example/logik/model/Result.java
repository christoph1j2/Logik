package com.example.logik.model;

public class Result {
    private int blackPins;
    private int whitePins;

    public Result(int blackPins, int whitePins) {
        this.blackPins = blackPins;
        this.whitePins = whitePins;
    }

    /**
     * Vraci pocet cernych koliku
     * @return pocet cernych koliku
     */
    public int getBlackPins() {
        return blackPins;
    }

    /**
     * Vraci pocet bilych koliku
     * @return pocet bilych koliku
     */
    public int getWhitePins() {
        return whitePins;
    }

    /**
     * Vraci retezec, ktery popisuje vysledek, napriklad "Result [black=3, white=2]"
     * @return retezec popisujici vysledek
     */
    @Override
    public String toString() {
        return "Result [black=" + blackPins + ", white=" + whitePins + "]";
    }
}
