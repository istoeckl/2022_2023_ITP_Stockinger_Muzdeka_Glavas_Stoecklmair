package com.example.itp_projekt_snake.View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class StartMenue extends Application {


    public void ShowSpielfeld() {
        SpielfeldView view = new SpielfeldView();
        Stage pro = new Stage();
        view.start(pro);

    }

    private Parent createConetent() {

        Label label = new Label();
        label.setText("Wilkommen bei Snake!");    //Welcome Text
        label.setPrefSize(200, 1500);
        label.setTranslateX(10);
        label.setTranslateY(-150);
        label.setFont(Font.font(19));


        StackPane root = new StackPane();
        int tileSize = 40;
        root.setPrefSize(30 * tileSize, 30 * tileSize);


//Auswahl Levels
        MenuButton menuButton = new MenuButton("Levels");
        menuButton.getItems().addAll(new MenuItem("1.0x"), new MenuItem("1.5x"), new MenuItem("2.0x"));
        menuButton.setTranslateX(10);
        menuButton.setTranslateY(-200);

        root.getChildren().add(label);
        root.getChildren().add(menuButton);


        Button start = new Button("Start");
        start.setStyle("-fx-border-color: blue");       //design
        start.setStyle("-fx-color: green");            //design
        start.setTranslateX(10);
        start.setTranslateY(-500);
        start.setPrefSize(200, 100);
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ShowSpielfeld();
            }
        });


        Button exit = new Button("Exit");
        exit.setStyle("-fx-border-color: blue");   //design
        exit.setStyle("-fx-color: red");   //design
        exit.setTranslateX(10);
        exit.setTranslateY(-390);
        exit.setPrefSize(200, 100);
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {       //Spielende!
                System.exit(0);
            }
        });

        root.getChildren().add(start);   //zu root adden
        root.getChildren().add(exit);    //zu root adden

        return root;
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(createConetent());
        primaryStage.show();
        primaryStage.setTitle("Snake");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String args[]) {
        launch(args);

    }
}

