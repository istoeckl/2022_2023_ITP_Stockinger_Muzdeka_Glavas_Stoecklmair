/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *           Fachrichtung Informationstechnologie und Netzwerktechnik
 *----------------------------------------------------------------------------*/
/**
 * Kurzbeschreibung
 *
 * @author : Glavas Lea, Stockinger Annika, Muzdeka Jovana und Iris Stöcklmair
 * @date : 27.10.2022
 * @details Diese Klasse ist die View vom Startmenue
 * Hier werden die Buttons erstellt und Angezeigt
 */

package com.example.itp_projekt_snake.View;

import com.example.itp_projekt_snake.Controller.StarMenueController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Objects;

public class StartMenue extends Application {
    public static int geschw = 180;
    StarMenueController startme = new StarMenueController();

    /**
     * erzeugeAnsicht()
     * Hier wird die ganze Ansicht erzeugt und angezeigt (Buttons, MenueButton)
     *
     * @return Parent
     */
    private Parent erzeugeAnsicht() {
        Label label = new Label();
        label.setText("Wilkommen bei Snake!");    //Welcome Text
        label.setPrefSize(200, 1500);
        label.setTranslateX(10);
        label.setTranslateY(-200);
        label.setFont(Font.font(19));

        StackPane root = new StackPane();
        int tileSize = 40;
        root.setPrefSize(30 * tileSize, 30 * tileSize);

//Auswahl Levels
        MenuItem menuItem1 = new MenuItem("Einfach");
        MenuItem menuItem2 = new MenuItem("Normel");
        MenuItem menuItem3 = new MenuItem("Schwer");
        MenuButton menuButton = new MenuButton("Optionen:", null, menuItem1, menuItem2, menuItem3);
        menuItem2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                geschw = 130;
            }
        });

        menuItem3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                geschw = 65;
            }
        });

        menuButton.setTranslateX(10);
        menuButton.setTranslateY(100);
        root.getChildren().add(label);
        root.getChildren().add(menuButton);

        Button start = new Button("Start");
        start.setStyle("-fx-border-color: blue");       //design
        start.setStyle("-fx-color: green");            //design
        start.setTranslateX(10);
        start.setTranslateY(-100);
        start.setPrefSize(200, 100);
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                startme.spielfeldAnzeigen();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button exit = new Button("Beenden");
        exit.setStyle("-fx-border-color: blue");   //design
        exit.setStyle("-fx-color: red");   //design
        exit.setTranslateX(10);
        exit.setTranslateY(0);
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

    /**
     * start(Stage primaryStage)
     * Start-Methode
     *
     * @param primaryStage   Stage worauf alles erzeugt wird
     *
     * @return none
     */
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(erzeugeAnsicht());
        primaryStage.show();
        primaryStage.setTitle("Das Snake-Spiel!");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setMaxHeight(600);
        primaryStage.setMaxWidth(600);
    }

    public static void main(String args[]) {
        launch(args);
    }
}

