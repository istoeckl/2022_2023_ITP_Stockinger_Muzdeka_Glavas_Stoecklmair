/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *           Fachrichtung Informationstechnologie und Netzwerktechnik
 *----------------------------------------------------------------------------*/
/**
 * Kurzbeschreibung
 *
 * @author : Glavas Lea, Stockinger Annika, Muzdeka Jovana und Iris Stöcklmair
 * @date : 27.10.2022
 * @details Diese Klasse ist das Model für die Schlange
 */

package com.example.itp_projekt_snake.Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.itp_projekt_snake.View.SpielfeldView.quadratGroesse;
import static com.example.itp_projekt_snake.View.SpielfeldView.reihen;


public class Schlange {
    public List<Point> schlangenKoerper = new ArrayList();
    public Point schlangenKopf;

    /**
     * Schlange()
     * Konstruktor
     *
     * @return 	none
     */
    public Schlange() {}

    /**
     * anfangsSchlangeZeichnen(GraphicsContext gc)
     * Zeichnet die Schlange am Anfang (Startpunkt)
     * @param gc   Hintergrund
     *
     * @return 	none
     */
    public void anfangsSchlangeZeichnen(){
        for (int i = 0; i < 3; i++) {

            schlangenKoerper.add(new Point(5, reihen / 2));
        }
        schlangenKopf = schlangenKoerper.get(0);
    }

    /**
     * schlangeZeichnen(GraphicsContext gc)
     * Zeichnet die ganze Schlange (Farbe, Größe)
     * @param gc   Hintergrund
     *
     * @return 	none
     */
    public void schlangeZeichnen(GraphicsContext gc) {
        schlangenKopf = schlangenKoerper.get(0);
        gc.setFill(Color.web("000000"));
        gc.fillRoundRect(schlangenKopf.getX() * quadratGroesse, schlangenKopf.getY() * quadratGroesse, quadratGroesse - 1, quadratGroesse - 1, 35, 35);

        for (int i = 1; i < schlangenKoerper.size(); i++) {
            gc.fillRoundRect(schlangenKoerper.get(i).getX() * quadratGroesse, schlangenKoerper.get(i).getY() * quadratGroesse, quadratGroesse - 1,
                    quadratGroesse - 1, 20, 20);
        }
    }

    /**
     * beibehaltenSchlangenGroesse()
     * Die Schlange belibt bei ihrer Größe wenn sie nichts isst.
     *
     * @return 	none
     */
    // Shclange wird nicht immer größer sondern bleibt solange sioe nichts isst
    public void beibehaltenSchlangenGroesse(){
        for (int i = schlangenKoerper.size() - 1; i >= 1; i--) {
            schlangenKoerper.get(i).x = schlangenKoerper.get(i - 1).x;
            schlangenKoerper.get(i).y = schlangenKoerper.get(i - 1).y;
        }
    }

    /**
     * nachRechts()
     * SchlangenKopfkoordinate x wird erhöht
     * = Bewegung nach rechts
     *
     * @return 	none
     */
    public void nachRechts() {
        schlangenKopf.x++;
    }

    /**
     * nachLinks()
     * SchlangenKopfkoordinate x wird erniedrigt
     * = Bewegung nach links
     *
     * @return 	none
     */
    public void nachLinks() {
        schlangenKopf.x--;
    }

    /**
     * nachOben()
     * SchlangenKopfkoordinate y wird erniedrigt
     * = Bewegung nach oben
     *
     * @return 	none
     */
    public void nachOben() {
        schlangenKopf.y--;
    }

    /**
     * nachUnten()
     * SchlangenKopfkoordinate y wird erhöht
     * = Bewegung nach unten
     *
     * @return 	none
     */
    public void nachUnten() {
        schlangenKopf.y++;
    }

}
