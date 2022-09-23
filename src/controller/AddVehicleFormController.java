package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Park;
import model.SlotNumber;
import model.Vehicle;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import static controller.DataListController.*;

public class AddVehicleFormController {
    public AnchorPane addVehicleContext;
    public ComboBox <String>cmbVehicleType;
    public JFXTextField txtVehicleNumber;
    public JFXTextField txtMaximumWeight;
    public JFXTextField txtNoOfPassengers;
    public void initialize() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        for (String temp1 : VehicleTypeList
        ) {
            obList.add(temp1);
        }
        cmbVehicleType.setItems(obList);
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ParkingDetailsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) addVehicleContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    static int countBus=0;
    static int countVan=0;
    static int countLorry=0;
    public int searchAvailabilityBus(){
        for (Vehicle v : VehicleList) {
            if(v.getVehicleType().equals("Bus")){
                countBus++;
            }
        }
        return countBus;
    }
    public int searchAvailabilityVan(){
        for (Vehicle v : VehicleList) {
            if(v.getVehicleType().equals("Van")){
                countVan++;
            }
        }
        return countVan;
    }
    public int searchAvailabilityLorry(){
        for (Vehicle v : VehicleList) {
            if(v.getVehicleType().equals("Cargo Lorry")){
                countLorry++;
            }
        }
        return countLorry;
    }

    public void saveVehicleOnAction(ActionEvent actionEvent) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm aa");
        Date date = new Date();
        String dateAndTime = formatter.format(date);
        try {
            if (!txtVehicleNumber.getText().equals("") && !txtMaximumWeight.getText().equals("") && !txtNoOfPassengers.getText().equals("") && !cmbVehicleType.getSelectionModel().getSelectedItem().equals("null")) {
                Vehicle vehicle = new Vehicle(txtVehicleNumber.getText(), (txtMaximumWeight.getText()), (txtNoOfPassengers.getText()), cmbVehicleType.getSelectionModel().getSelectedItem());
                VehicleTypeList.remove(cmbVehicleType.getSelectionModel().getSelectedItem());
                try {
                    if (cmbVehicleType.getSelectionModel().getSelectedItem().equals("Van")) {
                        int vanCount = searchAvailabilityVan();
                        if (vanCount < 6) {
                            if (VehicleList.add(vehicle)) {
                                if (cmbVehicleType.getSelectionModel().getSelectedItem().equals("Van")) {
                                    for (SlotNumber s : vanSlot) {
                                        if (s.getVehicleNumber().equals("null")) {
                                            s.setVehicleNumber(txtVehicleNumber.getText());

                                            Park parkedVehicle1 = new Park(txtVehicleNumber.getText(), cmbVehicleType.getSelectionModel().getSelectedItem(), s.getSlotNumber(), "(newly Added) " + dateAndTime);
                                            ParkingList.add(parkedVehicle1);
                                            countVan =0;
                                            break;
                                        }
                                    }
                                }
                                txtVehicleNumber.clear();
                                txtMaximumWeight.clear();
                                txtNoOfPassengers.clear();
                                cmbVehicleType.getItems().clear();
                                initialize();
                                new Alert(Alert.AlertType.CONFIRMATION, "Add successfully", ButtonType.OK).show();
                            }
                        } else {
                            new Alert(Alert.AlertType.WARNING, "You can't Add..Van Parking is full... ", ButtonType.OK).show();
                        }
                    }
                    if (cmbVehicleType.getSelectionModel().getSelectedItem().equals("Bus")) {
                        int busCount = searchAvailabilityBus();
                        if (busCount == 0) {
                            if (VehicleList.add(vehicle)) {
                                if (cmbVehicleType.getSelectionModel().getSelectedItem().equals("Bus")) {
                                    for (SlotNumber s : busSlot) {
                                        if (s.getVehicleNumber().equals("null")) {
                                            s.setVehicleNumber(txtVehicleNumber.getText());

                                            Park parkedVehicle2 = new Park(txtVehicleNumber.getText(), cmbVehicleType.getSelectionModel().getSelectedItem(), s.getSlotNumber(), "(newly Added) " + dateAndTime);
                                            ParkingList.add(parkedVehicle2);
                                            break;
                                        }
                                    }
                                }
                                txtVehicleNumber.clear();
                                txtMaximumWeight.clear();
                                txtNoOfPassengers.clear();
                                cmbVehicleType.getItems().clear();
                                initialize();
                                new Alert(Alert.AlertType.CONFIRMATION, "Vehicle Details Saved", ButtonType.OK).show();
                            }
                        } else {
                            new Alert(Alert.AlertType.WARNING, "You can't Add..Bus Parking is full... ", ButtonType.OK).show();
                        }
                    }
                    if (cmbVehicleType.getSelectionModel().getSelectedItem().equals("Cargo Lorry")) {
                        int lorryCount = searchAvailabilityLorry();
                        if (lorryCount < 7) {
                            if (VehicleList.add(vehicle)) {
                                if (cmbVehicleType.getSelectionModel().getSelectedItem().equals("Cargo Lorry")) {
                                    for (SlotNumber s : cargoLorrySlot) {
                                        if (s.getVehicleNumber().equals("null")) {
                                            s.setVehicleNumber(txtVehicleNumber.getText());
                                            Park parkedVehicle3 = new Park(txtVehicleNumber.getText(), cmbVehicleType.getSelectionModel().getSelectedItem(), s.getSlotNumber(), "(newly Added) " + dateAndTime);
                                            ParkingList.add(parkedVehicle3);
                                            countLorry=0;
                                            break;
                                        }
                                    }
                                }
                                txtVehicleNumber.clear();
                                txtMaximumWeight.clear();
                                txtNoOfPassengers.clear();
                                cmbVehicleType.getItems().clear();
                                initialize();
                                new Alert(Alert.AlertType.CONFIRMATION, "Vehicle Add successfully..", ButtonType.OK).show();
                            }
                        }else{
                            new Alert(Alert.AlertType.WARNING, "You can't Add..Cargo Lorry Parking is full... ", ButtonType.OK).show();
                        }
                    }
                } catch (Exception e) {}
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "please Try again.", ButtonType.OK).show();


            }
        } catch (Exception e) {


            new Alert(Alert.AlertType.CONFIRMATION, "Please try again..", ButtonType.OK).show();
        }
    }
}
