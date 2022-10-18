package com.example.itp_projekt_snake.Controller;

import com.example.itp_projekt_snake.View.SpielfeldView;
import javafx.stage.Stage;

public class StarMenueController {

    public StarMenueController() {
    }

    public void spielfeldAnzeigen() throws Exception {
        SpielfeldView view = new SpielfeldView();
        Stage pro = new Stage();
        view.start(pro);
    }


}
