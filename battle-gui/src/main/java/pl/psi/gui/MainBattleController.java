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
        gridMap.add(new Label("NO WITAM!"),1,1);
    }
}
