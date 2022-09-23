package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardFormController {
    public AnchorPane DashBoardFormContext;

    public void openLoginFormOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) DashBoardFormContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"))));

    }

    public void openHomeFormOnAction(ActionEvent actionEvent) {
    }

    public void openAboutFormOnAction(ActionEvent actionEvent) {
    }
}
