package com.example.logik;

import com.example.logik.model.LogikModel;
import com.example.logik.model.Colors;
import com.example.logik.model.Result;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("GameView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Logik!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

//        LogikModel model = new LogikModel();
//
//        ArrayList<Colors> guess = new ArrayList<>();
//        guess.add(Colors.RED);
//        guess.add(Colors.BLUE);
//        guess.add(Colors.GREEN);
//        guess.add(Colors.YELLOW);
//        guess.add(Colors.PURPLE);
//
//        Result result = model.evaluateGuess(guess);
//
//        System.out.println(result);
    }
}