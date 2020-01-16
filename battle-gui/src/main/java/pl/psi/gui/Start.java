package pl.psi.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Start extends Application {

    public Start() {
    }

    static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main-battle.fxml"));
            Scene scene = new Scene(root);

            primaryStage.setTitle("Heroes 3");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException aE) {
            aE.printStackTrace();
        }

        try {

            Stage stage = new Stage();
            Parent spells = FXMLLoader.load(getClass().getClassLoader().getResource("SpellWindow.fxml"));
            Scene spell_window = new Scene(spells);
            stage.setScene(spell_window);
            stage.setTitle("Spells");
            stage.setX(primaryStage.getX() + primaryStage.getWidth() + 10);
            stage.setY(primaryStage.getY());
            stage.show();

        }
        catch (IOException aE) {
            aE.printStackTrace();
        }

    }

}
