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

package com.example.itp_projekt_snake.Controller;

import com.example.itp_projekt_snake.View.StartMenue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class EndMenueController {

    public EndMenueController() {
    }

    /**
     * Erster Konstruktor der Klasse,
     * initialisiert alle Parameter.
     *
     * @param
     * @return none
     */
    public void startMenuAnzeigen() throws Exception {
        StartMenue view = new StartMenue();
        Stage pro = new Stage();
        view.start(pro);
    }

    }

