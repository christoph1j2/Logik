package com.example.logik.model;

import java.util.ArrayList;
import java.util.Random;

public class LogikModel {
    private Random rd = new Random();
    ArrayList<Color> solution = new ArrayList<Color>();
    //ArrayList<Color> guess = new ArrayList<Color>();

    private void generateSolution() {
        while(solution.size() < 5) {
            Color newColor = Color.values()[rd.nextInt(Color.values().length)];
            solution.add(newColor);
        }
        System.out.println(solution);
    }

    public Result evaluateGuess(ArrayList<Color> guess) {
        int blackPins = 0;
        int whitePins = 0;

        for (int i = 0; i < guess.size(); i++) {
            if (guess.get(i).equals(solution.get(i))) blackPins++;
            else if (guess.contains(solution.get(i))) whitePins++;
        }

        return new Result(blackPins, whitePins);
    }

    public LogikModel() {
        generateSolution();
    }
}
