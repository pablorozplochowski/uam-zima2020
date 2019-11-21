package pl.psi.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class MainBattleController {

    @FXML
    GridPane gridMap;
    @FXML
    Button passButton;


    @FXML
    private void initialize() {
        for (int i = 0; i < 15 ; i++) {
            for (int j = 0; j < 10; j++) {
                gridMap.add(new MapTile("X"),i,j);
            }
        }
    }
}
