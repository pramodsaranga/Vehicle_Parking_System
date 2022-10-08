package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginFormController {
    public AnchorPane loginContext;
    public TextField txtUserName;
    public PasswordField txtPassword;

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
            URL resource = getClass().getResource("../view/DashBoardForm.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) loginContext.getScene().getWindow();
            window.setScene(new Scene(load));
    }

    public void openParkingDetailsForm(ActionEvent actionEvent) throws IOException {
        if (txtUserName.getText().equalsIgnoreCase("Driver") && txtPassword.getText().equals("1998")) {
            URL resource = getClass().getResource("../view/DriverShowForm.fxml");
            Parent load =FXMLLoader.load(resource);
            loginContext.getChildren().clear();
            loginContext.getChildren().add(load);
        } else if(txtUserName.getText().equalsIgnoreCase("Admin") && txtPassword.getText().equals("2021")){
            URL resource = getClass().getResource("../view/ParkingDetailsForm.fxml");
            Parent load = FXMLLoader.load(resource);
            loginContext.getChildren().clear();
            loginContext.getChildren().add(load);
        }
    }
    public void openLoginFormOnAction(ActionEvent actionEvent) {
    }

    public void openAboutFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AboutForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) loginContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
