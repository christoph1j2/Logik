package com.example.logik.controller;

import com.example.logik.model.LogikModel;
import com.example.logik.model.Colors;
import com.example.logik.model.Result;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class LogikController {
    @FXML private Label heading;
    @FXML private Button showResultButton;
    @FXML private Button resetButton;
    @FXML private Button guessButton;
    @FXML private GridPane g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10;
    @FXML private Circle s1, s2, s3, s4, s5, c1, c2, c3, c4, c5;

    private LogikModel logikModel;
    private int[] selectedColorIndexes = new int[5];
    private GridPane[] guessGridPanes;
    private GridPane[] evaluateGridPanes;
    private Circle[] guessCircles;
    private Circle[] solutionCircles;
    private ArrayList<Color> solutionColors = new ArrayList<>();
    private int resultClickCount;
    private int guessCount;
    @FXML
    void initialize() {
        heading.setText("Logik");
        logikModel = new LogikModel();

        resultClickCount = 0;
        guessCount = 0;

        guessGridPanes = new GridPane[] { g1, g2, g3, g4, g5, g6, g7, g8, g9, g10 };
        evaluateGridPanes = new GridPane[] { e1, e2, e3, e4, e5, e6, e7, e8, e9, e10 };
        guessCircles = new Circle[] { c1, c2, c3, c4, c5 };
        solutionCircles = new Circle[] { s1, s2, s3, s4, s5 };

        ArrayList<Circle> guessedCircles = new ArrayList<>();
        for (GridPane g : guessGridPanes) {
            for(int i = 0; i < 5; i++) {
                Circle circle = new Circle(10, Color.WHITE);
                circle.setStroke(Color.BLACK);
                g.add(circle, i, 0);
                guessedCircles.add(circle);
            }
        }

        ArrayList<Circle> evaluateCircles = new ArrayList<>();
        for (GridPane g : evaluateGridPanes) {
            for(int i = 0; i < 5; i++) {
                Circle circle = new Circle(10, Color.WHITE);
                circle.setStroke(Color.BLACK);
                circle.setVisible(false);
                g.add(circle, i, 0);
                evaluateCircles.add(circle);
            }
        }

        for (int i = 0; i < logikModel.getSolution().size(); i++) {
            solutionColors.add(Color.valueOf((logikModel.getSolution().get(i)).toString()));
            System.out.println(solutionColors.get(i));
        }

    }

    @FXML
    protected void handleCircleClick(MouseEvent mouseEvent) {
        Circle circle = (Circle) mouseEvent.getSource();
        for (int i = 0; i < guessCircles.length; i++) {
            if (circle == guessCircles[i]) {
                selectedColorIndexes[i] = (selectedColorIndexes[i] + 1) % Colors.values().length;
                circle.setFill(Color.valueOf(Colors.values()[selectedColorIndexes[i]].toString()));
                break;
            }
        }
    }

    @FXML
    protected void handleGuess(){
        int maxGuesses = logikModel.maxGuesses();
        while (guessCount < maxGuesses) {
            try {
                guessCount++;
                ArrayList<Colors> guess = new ArrayList<>();
                int i = 0;
                for (Circle circle : guessCircles) {
                    if (circle.getFill() == Color.WHITE){
                        heading.setText("Používej jen validní barvy! Resetni hru.");
                        showResultButton.setDisable(true);
                        guessButton.setDisable(true);
                        break;
                    }
                    Color fillColor = (Color) circle.getFill();
                    Colors colorEnum = getColorEnum(fillColor);
                    guess.add(colorEnum);
                    Circle c = (Circle) guessGridPanes[10 - guessCount].getChildren().get(i);
                    c.setFill(fillColor);
                    i++;
                }
                Result result = logikModel.evaluateGuess(guess);
                int black = result.getBlackPins();
                int white = result.getWhitePins();

                System.out.println(result);

                int circleIndex = 0;
                for (int j = 0; j < black; j++) {
                    Circle f = (Circle) evaluateGridPanes[10 - guessCount].getChildren().get(circleIndex);
                    f.setVisible(true);
                    f.setStroke(Color.BLACK);
                    f.setFill(Color.BLACK);
                    circleIndex++;
                }
                for (int j = 0; j < white; j++) {
                    Circle f = (Circle) evaluateGridPanes[10 - guessCount].getChildren().get(circleIndex);
                    f.setVisible(true);
                    f.setStroke(Color.BLACK);
                    f.setFill(Color.WHITE);
                    circleIndex++;
                }

                if (black == 5) {
                    heading.setText("Vyhrál jsi!");
                    showResultButton.setDisable(true);
                    guessButton.setDisable(true);
                    handleShowResults();
                }

                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
        if (guessCount == maxGuesses) {
            heading.setText("Prohrál jsi!");
            showResultButton.setDisable(true);
            guessButton.setDisable(true);
            handleShowResults();
        }
    }

    @FXML
    protected void handleReset(){
        heading.setText("Logik");
        logikModel = new LogikModel();
        resultClickCount = 0;
        guessCount = 0;

        guessButton.setDisable(false);
        showResultButton.setDisable(false);
        resetButton.setDisable(false);

        for (Circle circle : guessCircles) {
            circle.setFill(Color.WHITE);
        }

        for (GridPane g : guessGridPanes) {
            for (int i = 0; i < 5; i++) {
                Circle circle = (Circle) g.getChildren().get(i);
                circle.setFill(Color.WHITE);
            }
        }

        for (GridPane g : evaluateGridPanes) {
            for(int i = 0; i < 5; i++) {
                Circle circle = (Circle) g.getChildren().get(i);
                circle.setFill(Color.WHITE);
                circle.setVisible(false);
            }
        }

        solutionColors.clear();
        for (int i = 0; i < logikModel.getSolution().size(); i++) {
            solutionColors.add(Color.valueOf((logikModel.getSolution().get(i)).toString()));
            System.out.println(solutionColors.get(i));
        }
        for (int i = 0; i < logikModel.getSolution().size(); i++) {
            solutionCircles[i].setFill(Color.WHITE);
            guessCircles[i].setFill(Color.WHITE);
        }
    }

    @FXML
    protected void handleShowResults() {
        ArrayList<Colors> solution = logikModel.getSolution();
        resultClickCount++;
        if (resultClickCount % 2 == 1) {
            for (int i = 0; i < solution.size(); i++) {
                solutionCircles[i].setFill(Color.valueOf(solution.get(i).toString()));
            }
        }
        else if (resultClickCount % 2 == 0) {
            for (int i = 0; i < solution.size(); i++) {
                solutionCircles[i].setFill(Color.WHITE);
            }
        }
    }

    private Colors getColorEnum(Color color) {
        if (color.equals(Color.RED)) return Colors.RED;
        if (color.equals(Color.BLUE)) return Colors.BLUE;
        if (color.equals(Color.GREEN)) return Colors.GREEN;
        if (color.equals(Color.YELLOW)) return Colors.YELLOW;
        if (color.equals(Color.PURPLE)) return Colors.PURPLE;
        if (color.equals(Color.CYAN)) return Colors.CYAN;
        if (color.equals(Color.ORANGE)) return Colors.ORANGE;
        if (color.equals(Color.PINK)) return Colors.PINK;
        throw new IllegalArgumentException("Unknown color: " + color);
    }

}