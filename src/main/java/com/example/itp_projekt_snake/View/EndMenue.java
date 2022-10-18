/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *           Fachrichtung Informationstechnologie und Netzwerktechnik
 *----------------------------------------------------------------------------*/
/**
 * Kurzbeschreibung
 *
 * @author : Glavas Lea, Stockinger Annika, Muzdeka Jovana und Iris Stöcklmair
 * @date : 27.10.2022
 * @details Diese Klasse ist die View
 */

package com.example.itp_projekt_snake.View;

import com.example.itp_projekt_snake.Controller.EndMenueController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EndMenue extends Application {
    EndMenueController ende = new EndMenueController();

    /**
     * Erster Konstruktor der Klasse,
     * initialisiert alle Parameter.
     *
     * @param
     *
     * @return none
     */
    private Parent erzeugeAnsicht() {
        Label label = new Label();
        label.setText("Verloren!");    //Welcome Text
        label.setPrefSize(200, 1500);
        label.setTranslateX(10);
        label.setTranslateY(-150);
        label.setFont(Font.font(19));

        StackPane root = new StackPane();
        int tileSize = 40;
        root.setPrefSize(30 * tileSize, 30 * tileSize);

        Button start = new Button("Try Again");
        start.setStyle("-fx-border-color: blue");       //design
        start.setStyle("-fx-color: green");            //design
        start.setTranslateX(16);
        start.setTranslateY(-120);
        start.setPrefSize(200, 100);

        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    ende.startMenuAnzeigen();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button beenden = new Button("Beenden");
        beenden.setStyle("-fx-border-color: blue");   //design
        beenden.setStyle("-fx-color: red");   //design
        beenden.setTranslateX(16);
        beenden.setTranslateY(-10);
        beenden.setPrefSize(200, 100);
        beenden.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {       //Spielende!
                System.exit(0);
            }
        });

        root.getChildren().add(start);   //zu root adden
        root.getChildren().add(beenden);    //zu root adden

        return root;
    }

    /**
     * Erster Konstruktor der Klasse,
     * initialisiert alle Parameter.
     *
     * @param
     * @return none
     */
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(erzeugeAnsicht());
        primaryStage.show();
        primaryStage.setTitle("Leider Verloren!");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setMaxHeight(500);
        primaryStage.setMaxWidth(600);
    }

    public static void main(String args[]) {
        launch(args);
    }
}

