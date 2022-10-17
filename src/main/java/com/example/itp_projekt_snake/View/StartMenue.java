/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *           Fachrichtung Informationstechnologie und Netzwerktechnik
 *----------------------------------------------------------------------------*/
/**
 * Kurzbeschreibung
 *
 * @author : Glavas Lea, Stockinger Annika, Muzdeka Jovana und Iris Stöcklmair
 * @date : 27.10.2022
 * @details In dieser Klasse werden die SteamOperationen angelegt
 */

package com.example.itp_projekt_snake.View;

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

public class StartMenue extends Application {
    /**
     * Erster Konstruktor der Klasse,
     * initialisiert alle Parameter.
     *
     * @param
     *
     * @return 	none
     */
    public void spielfeldAnzeigen() throws Exception {
        SpielfeldView view = new SpielfeldView();
        Stage pro = new Stage();
        view.start(pro);

    }
    /**
     * Erster Konstruktor der Klasse,
     * initialisiert alle Parameter.
     *
     * @param
     *
     * @return 	none
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
        MenuButton menuButton = new MenuButton("Levels");
        menuButton.getItems().addAll(new MenuItem("1.0x"), new MenuItem("1.5x"), new MenuItem("2.0x"));
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
                    spielfeldAnzeigen();
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
     * Erster Konstruktor der Klasse,
     * initialisiert alle Parameter.
     *
     * @param
     *
     * @return 	none
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

