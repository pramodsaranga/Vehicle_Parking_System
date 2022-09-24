package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class ParkingDetailsFormController {
    public AnchorPane parkingDetailsContext;
    private static ArrayList<String> SelectList=new ArrayList<>();

    static {
        SelectList.add("In Parking");
        SelectList.add("On Delivery");
    }

    public ComboBox cmbSelect;
    public AnchorPane lodeContext;

    public void initialize() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        for (String temp1 : SelectList
        ) {
            obList.add(temp1);
        }
        cmbSelect.setItems(obList);
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DriverShowForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) parkingDetailsContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void openAddVehicleForm(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddVehicleForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) parkingDetailsContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void openAddDriverForm(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddDriverForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) parkingDetailsContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void selectOnAction(ActionEvent actionEvent) throws IOException {
        if(cmbSelect.getValue().equals("In Parking")){
            URL resource = getClass().getResource("../view/InParkingTableForm.fxml");
            Parent load = FXMLLoader.load(resource);
            lodeContext.getChildren().clear();
            lodeContext.getChildren().add(load);
        }else if(cmbSelect.getValue().equals("On Delivery")){
            URL resource = getClass().getResource("../view/OnDeliveryTableForm.fxml");
            Parent load = FXMLLoader.load(resource);
            lodeContext.getChildren().clear();
            lodeContext.getChildren().add(load);
        }
    }

    public void openLoginFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) parkingDetailsContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void openHomeFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) parkingDetailsContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void openAboutFormOnAction(ActionEvent actionEvent) {
    }
}
