package com.example.logik.controller;

import com.example.logik.model.LogikModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Arrays;

public class LogikController {
    @FXML private Label heading;
    @FXML private VBox vbox;
    @FXML private GridPane g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10;

    private LogikModel logikModel;
    private GridPane[] guessGridPanes;
    private GridPane[] evalutateGridPanes;
    @FXML
    void initialize() {
        logikModel = new LogikModel();

        guessGridPanes = new GridPane[] { g1, g2, g3, g4, g5, g6, g7, g8, g9, g10 };
        evalutateGridPanes = new GridPane[] { e1, e2, e3, e4, e5, e6, e7, e8, e9, e10 };

        ArrayList<Circle> guessCircles = new ArrayList<>();
        for (GridPane g : guessGridPanes) {
            for(int i = 0; i < 5; i++) {
                Circle circle = new Circle(10, Color.WHITE);
                circle.setStroke(Color.BLACK);
                g.add(circle, i, 0);
                guessCircles.add(circle);
            }
        }

        ArrayList<Circle> evaluateCircles = new ArrayList<>();
        for (GridPane g : evalutateGridPanes) {
            for(int i = 0; i < 5; i++) {
                Circle circle = new Circle(10, Color.WHITE);
                circle.setStroke(Color.BLACK);
                circle.setVisible(false);
                g.add(circle, i, 0);
                evaluateCircles.add(circle);
            }
        }

    }

    @FXML
    private void handleCircleClick() {}

    @FXML
    private void handleGuess(){}

    @FXML
    private void handleReset(){}

    @FXML
    private void handleShowResults(){}
}