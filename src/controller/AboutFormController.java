package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AboutFormController {
    public AnchorPane AboutContext;

    public void openLoginFormOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) AboutContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"))));
    }

    public void openHomeFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) AboutContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void openAboutFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AboutForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) AboutContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
