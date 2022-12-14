/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *           Fachrichtung Informationstechnologie und Netzwerktechnik
 *----------------------------------------------------------------------------*/
/**
 * Kurzbeschreibung
 *
 * @author : Glavas Lea, Stockinger Annika, Muzdeka Jovana und Iris Stöcklmair
 * @date : 27.10.2022
 * @details Diese Klasse ist eine Mischung aus View und Controller
 * (Aufgrund von autretenden Fehlern konnte es nicht in Controller und View geteilt werden)
 */

package com.example.itp_projekt_snake.View;

import com.example.itp_projekt_snake.Controller.EndMenueController;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;

import static com.example.itp_projekt_snake.View.StartMenue.geschw;
import static javafx.scene.paint.Color.BLACK;


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

    EndMenueController menue = new EndMenueController();

    public boolean pauseActive = false;
    public boolean ende;
    int aktuellePosition;
    int nurEinmal =0;

    /**
     * start(Stage primaryStage)
     * Start-Methode
     * handle() sorgt für rechts/links/oben/unten bewegung
     * Schlange wird gezeichent und Spielablauf gestartet
     * @param primaryStage   Stage worauf alles erzeugt wird
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
        schlange.anfangsSchlangeZeichnen();
        hintergrundMusik.start();
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(geschw), e -> spielAblauf(gc)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
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
                } else if (code == KeyCode.SPACE){
                    if(!pauseActive){
                        pauseActive = true;
                        hintergrundMusik.OFF();
                        timeline.stop();

                        gc.setFill(BLACK);
                        gc.setFont(new Font("Digital-7",100));
                        gc.fillText("Pause",800 / 3.5, 800 / 2);

                    } else{
                        timeline.play();
                        hintergrundMusik.ON();
                        pauseActive = false;
                    }

                }else if (code == KeyCode.ESCAPE){

                    try {
                       System.exit(0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }

    /**
     * spielAblauf(GraphicsContext gc)
     * Startet das spiel und prüft ob verloren ist wenn nicht
     * wird Hintergrund, Essen und Schlange angezeigt
     * rechts/links/oben/unten verwalted
     * Spielende und essen von Nahrung
     *
     * @param gc   Spieloberfläche
     *
     * @return 	none
     */
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
     * spielEnde()
     * Bedingungen für Ende (wenn Schlange nicht mehr auf Feld ist
     * oder schlange sich selbst berührt
     *
     * @return 	none
     */
    public void spielEnde() {
        if (schlange.schlangenKopf.x < 0 || schlange.schlangenKopf.y < 0 || schlange.schlangenKopf.x * quadratGroesse >= breite || schlange.schlangenKopf.y * quadratGroesse >= hoehe) {
            ende = true;
        }

        for (int i = 1; i < schlange.schlangenKoerper.size(); i++) {
            if (schlange.schlangenKopf.x == schlange.schlangenKoerper.get(i).getX() && schlange.schlangenKopf.getY() == schlange.schlangenKoerper.get(i).getY()) {
                ende = true;
                break;
            }
        }
    }

    /**
     * essen()
     * essen von Nahrung definiert
     *
     * @return 	none
     */
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