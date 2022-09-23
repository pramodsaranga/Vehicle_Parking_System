package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Driver;

import java.io.IOException;
import java.net.URL;

import static controller.DataListController.DriverList;
import static controller.DataListController.VehicleList;

public class AddDriverFormController {
    public AnchorPane addDriverContext;
    public JFXTextField txtDriverName;
    public JFXTextField txtNic;
    public JFXTextField txtDrivingLicenseNo;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNo;

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ParkingDetailsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) addDriverContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void saveDriverOnAction(ActionEvent actionEvent) {
        try {
            /*int size = DriverList.size();
            System.out.println(size);*/
            Driver driver = new Driver(txtDriverName.getText(), (String) txtNic.getText(), txtDrivingLicenseNo.getText(), txtAddress.getText(), txtContactNo.getText());
            if (txtNic.getText().equals("")& txtDriverName.getText().equals("")) {
                new Alert(Alert.AlertType.CONFIRMATION, "Invalid Input ", ButtonType.OK).show();
            } else {
                if (DriverList.add(driver)) {
                    txtDriverName.clear();
                    txtNic.clear();
                    txtDrivingLicenseNo.clear();
                    txtAddress.clear();
                    txtContactNo.clear();
                    //initialize();
                    System.out.println(VehicleList.toString());
                    new Alert(Alert.AlertType.CONFIRMATION, "Vehicle details saved successfully", ButtonType.OK).show();
                }

            }

        } catch(NumberFormatException e){
            new Alert(Alert.AlertType.WARNING, "Please try again..!\n Fill all data Or Enter correct data format.. ", ButtonType.CLOSE).show();
        }
    }

    public void openHomeFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) addDriverContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void openAboutFormOnAction(ActionEvent actionEvent) {
    }

    public void openLoginFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) addDriverContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
