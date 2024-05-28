package kz.ori.javafxproj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Questionnaire");

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        String[][] questions = {
                {"What is the capital of France?", "Paris", "London", "Berlin"},
                {"What is 2 + 3?", "3", "4", "5"},
                {"Which planet is known as the Red Planet?", "Earth", "Mars", "Jupiter"},
                {"Who wrote 'To be, or not to be'?", "Shakespeare", "Dickens", "Hemingway"},
                {"What is the largest ocean on Earth?", "Atlantic", "Indian", "Pacific"}
        };

        for (String[] question : questions) {
            addQuestion(vbox, question[0], question[1], question[2], question[3]);
        }

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(event -> {
            System.out.println("Questionnaire submitted.");
        });

        vbox.getChildren().add(submitButton);

        Scene scene = new Scene(vbox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addQuestion(VBox vbox, String questionText, String option1, String option2, String option3) {
        Label questionLabel = new Label(questionText);

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton answer1 = new RadioButton(option1);
        answer1.setToggleGroup(toggleGroup);
        RadioButton answer2 = new RadioButton(option2);
        answer2.setToggleGroup(toggleGroup);
        RadioButton answer3 = new RadioButton(option3);
        answer3.setToggleGroup(toggleGroup);

        VBox questionBox = new VBox(5);
        questionBox.getChildren().addAll(questionLabel, answer1, answer2, answer3);

        vbox.getChildren().add(questionBox);
    }

    public static void main(String[] args) {
        launch(args);
    }
}