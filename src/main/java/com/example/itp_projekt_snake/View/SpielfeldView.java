/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *           Fachrichtung Informationstechnologie und Netzwerktechnik
 *----------------------------------------------------------------------------*/
/**
 * Kurzbeschreibung
 *
 * @author : Glavas Lea, Stockinger Annika, Muzdeka Jovana und Iris Stöcklmair
 * @date : 27.10.2022
 * @details Diese Klasse ist eine Mischung aus View und Controlle( Aufgrund von Autretenden Fehlern auf ande
 */

package com.example.itp_projekt_snake.View;

import com.example.itp_projekt_snake.Model.HintergrundMusik;
import com.example.itp_projekt_snake.Model.Nahrung;
import com.example.itp_projekt_snake.Model.Schlange;
import com.example.itp_projekt_snake.Model.Spielfeld;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;

import static com.example.itp_projekt_snake.View.StartMenue.geschw;


public class SpielfeldView extends Application {

    public static final int breite = 800;
    public static final int hoehe = breite;
    public static final int reihen = 20;
    public static final int spalten = reihen;
    public static final int quadratGroesse = breite / reihen;

    public static final int rechts = 0;
    public static final int links = 1;
    public static final int oben = 2;
    public static final int unten = 3;

    public GraphicsContext gc;

    Spielfeld spiel = new Spielfeld();
    Schlange schlange = new Schlange();
    Nahrung nahrung = new Nahrung();
    HintergrundMusik hintergrundMusik = new HintergrundMusik();

    public boolean ende;
    int aktuellePosition;
    int nurEinmal =0;



    /**
     * Erster Konstruktor der Klasse,
     * initialisiert alle Parameter.
     *
     * @param
     *
     * @return 	none
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Snake");
        Group root = new Group();
        Canvas canvas = new Canvas(breite, hoehe);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        gc = canvas.getGraphicsContext2D();
        hintergrundMusik.start();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                KeyCode code = event.getCode();
                if (code == KeyCode.RIGHT || code == KeyCode.D) {
                    if (aktuellePosition != links) {
                        aktuellePosition = rechts;
                    }
                } else if (code == KeyCode.LEFT || code == KeyCode.A) {
                    if (aktuellePosition != rechts) {
                        aktuellePosition = links;
                    }
                } else if (code == KeyCode.UP || code == KeyCode.W) {
                    if (aktuellePosition != unten) {
                        aktuellePosition = oben;
                    }
                } else if (code == KeyCode.DOWN || code == KeyCode.S) {
                    if (aktuellePosition != oben) {
                        aktuellePosition = unten;
                    }
                }
            }
        });

        schlange.anfangsSchlangeZeichnen(gc);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(geschw), e -> spielAblauf(gc)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    /**
     * Erster Konstruktor der Klasse,
     * initialisiert alle Parameter.
     *
     * @param
     *
     * @return 	none
     */
    //Aufgrund von auftretenden fehlern in View
    void spielAblauf(GraphicsContext gc) {
        if (ende) {
           hintergrundMusik.stopRunning();
            EndMenue end = new EndMenue();
            if(nurEinmal <1){
                nurEinmal++;
                Stage pro = new Stage();
                end.start(pro);
            }else{
                return;
            }
        }

        spiel.hintergrundMitFarbe(gc);
        nahrung.drawFood(gc);
        schlange.schlangeZeichnen(gc);
        spiel.punkteAnzeigen(gc);
        schlange.beibehaltenSchlangenGroesse();

        switch (aktuellePosition) {
            case rechts:
                schlange.nachRechts();
                break;
            case links:
                schlange.nachLinks();
                break;
            case oben:
                schlange.nachOben();
                break;
            case unten:
                schlange.nachUnten();
                break;
        }
        spielEnde();
        essen();
    }

    /**
     * Erster Konstruktor der Klasse,
     * initialisiert alle Parameter.
     *
     * @param
     *
     * @return 	none
     */
    //Aufgrund von auftretenden fehlern in View
    public void spielEnde() {
        if (schlange.schlangenKopf.x < 0 || schlange.schlangenKopf.y < 0 || schlange.schlangenKopf.x * quadratGroesse >= breite || schlange.schlangenKopf.y * quadratGroesse >= hoehe) {
            ende = true;
        }

        //destroy itself
        for (int i = 1; i < schlange.schlangenKoerper.size(); i++) {
            if (schlange.schlangenKopf.x == schlange.schlangenKoerper.get(i).getX() && schlange.schlangenKopf.getY() == schlange.schlangenKoerper.get(i).getY()) {
                ende = true;
                break;
            }
        }
    }

    /**
     * Erster Konstruktor der Klasse,
     * initialisiert alle Parameter.
     *
     * @param
     *
     * @return 	none
     */
    //Aufgrund von auftretenden fehlern in View
    public void essen() {
        if (schlange.schlangenKopf.getX() == nahrung.essen_x && schlange.schlangenKopf.getY() == nahrung.essen_Y) {
            schlange.schlangenKoerper.add(new Point(-1, -1));
            nahrung.generateFood();
            spiel.punkte += 1;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}