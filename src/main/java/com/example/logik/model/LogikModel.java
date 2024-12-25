package com.example.logik.model;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class LogikModel {
    private Random rd = new Random();
    ArrayList<Colors> solution = new ArrayList<Colors>();
    //ArrayList<Color> guess = new ArrayList<Color>();

    private void generateSolution() {
        while(solution.size() < 5) {
            Colors newColor = Colors.values()[rd.nextInt(Colors.values().length)];
            solution.add(newColor);
        }
        System.out.println(solution);
    }

    public ArrayList<Colors> getSolution() {
        return solution;
    }

    public int maxGuesses() {
        return 10;
    }

    public Result evaluateGuess(ArrayList<Colors> guess) {
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
