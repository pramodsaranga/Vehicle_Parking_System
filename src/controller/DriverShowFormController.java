package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.*;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static controller.DataListController.*;

public class DriverShowFormController {
    public AnchorPane driverShowContext;
    public ComboBox <String>cmbVehicle;
    public ComboBox<String> cmbDriver;
    public Label lblVehicleType;
    public TextField txtDate;
    public Label lblSlot;
    public TextField txtType;
    public JFXButton btnParkVehicle;
    public JFXButton btnOnDelivery;
    String vehicleNumber;

    public void setDisable(String vehicleNumber){
        for (Park p : ParkingList) {
            if (p.getSelectVehicleNum().equals(vehicleNumber)) {
                cmbDriver.setDisable(false);
                btnParkVehicle.setDisable(true);
                btnOnDelivery.setDisable(false);

                break;
            }else{
                for (DriverSearch s :driverSearch) {
                    if(cmbVehicle.getSelectionModel().getSelectedItem().equals(s.getVehicleNumber())){
                        cmbDriver.setValue(s.getDriverName());
                        cmbDriver.setDisable(true);
                        break;
                    }
                }
                btnParkVehicle.setDisable(false);
                btnOnDelivery.setDisable(true);
            }
        }
    }

    public void initialize(){
            //----------------------Set Date & time--------------------------------------------------------------
            try {
                new Timer(1000, e -> {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss aa");
                    String time = simpleDateFormat.format(new Date());
                    String date = new SimpleDateFormat("MMM/dd/YYYY", Locale.ENGLISH).format(new Date());
                    txtDate.setText(date);
                    txtType.setText(time);
                }).start();
            } catch (Exception exception) {
            }
//------------set Vehicle Number Combo Box---------------------------------------------------------------
            cmbVehicle.getItems().clear();
            for (Vehicle v: VehicleList) {
                cmbVehicle.getItems().add(v.getVehicleNum());
            }
//-------------set Driver name Combo Box-----------------------------------------------------------------------
            cmbDriver.getItems().clear();
            for (Driver d: DriverList) {
                cmbDriver.getItems().add(d.getDriverName());
            }
//-------------------------------Move slot in Parking----------------------------------------------------------

        cmbVehicle.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                for (Vehicle v : VehicleList) {
                    if (newValue.equals(v.getVehicleNum())) {
                        lblVehicleType.setText(" " + v.getVehicleType());
                        vehicleNumber = v.getVehicleNum();
                        if (ParkingList.size() == 0) {
                            btnParkVehicle.setDisable(false);
                            btnOnDelivery.setDisable(true);
                            for (DriverSearch s : driverSearch) {
                                if (cmbVehicle.getSelectionModel().getSelectedItem().equals(s.getVehicleNumber())) {
                                    cmbDriver.setValue(s.getDriverName());
                                    cmbDriver.setDisable(true);
                                    break;
                                }
                            }
                        } else {
                            setDisable((String) newValue);
                        }
                    }
                }
            } catch (Exception ex) {
            }
        });
        }


    public void parkVehicleOnAction(ActionEvent actionEvent) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm aa");
        Date date = new Date();
        String dateAndTime = formatter.format(date);
        for (Delivery d : DeliveryList) {
            if(d.getSelectVehicleNumD().equalsIgnoreCase(cmbVehicle.getSelectionModel().getSelectedItem())){
                DeliveryList.remove(d);

                if(lblVehicleType.getText().equalsIgnoreCase(" Van")){
                    for (SlotNumber s : vanSlot) {
                        if(s.getVehicleNumber().equalsIgnoreCase("null")) {
                            String slotNumber = s.getSlotNumber();
                            lblSlot.setText(slotNumber);
                            Park inParking1 = new Park(cmbVehicle.getSelectionModel().getSelectedItem(),lblVehicleType.getText(),slotNumber,dateAndTime);
                            ParkingList.add(inParking1);
                            s.setVehicleNumber(cmbVehicle.getSelectionModel().getSelectedItem());
                            break;
                        }
                    }
                }
                if(lblVehicleType.getText().equalsIgnoreCase(" Bus")){
                    for (SlotNumber s : busSlot) {
                        if(s.getVehicleNumber().equalsIgnoreCase("null")) {
                            String slotNumber = s.getSlotNumber();
                            lblSlot.setText(slotNumber);

                            Park inParking1 = new Park(cmbVehicle.getSelectionModel().getSelectedItem(),lblVehicleType.getText(),slotNumber,dateAndTime);
                            ParkingList.add(inParking1);

                            s.setVehicleNumber(cmbVehicle.getSelectionModel().getSelectedItem());
                            break;
                        }
                    }
                }

                if(lblVehicleType.getText().equalsIgnoreCase(" Cargo Lorry")){
                    for (SlotNumber s : cargoLorrySlot) {
                        if(s.getVehicleNumber().equalsIgnoreCase("null")) {
                            String slotNumber = s.getSlotNumber();
                            lblSlot.setText(slotNumber);

                            Park inParking1 = new Park(cmbVehicle.getSelectionModel().getSelectedItem(),lblVehicleType.getText(),slotNumber,dateAndTime);
                            ParkingList.add(inParking1);

                            s.setVehicleNumber(cmbVehicle.getSelectionModel().getSelectedItem());
                            break;
                        }
                    }
                }
                new Alert(Alert.AlertType.CONFIRMATION, "You Can Park now", ButtonType.OK).show();
            }
        }
        for (DriverSearch d : driverSearch) {
            if(cmbVehicle.getSelectionModel().getSelectedItem().equals(d.getVehicleNumber())){
                driverSearch.remove(d);
                break;
            }
        }
    }

    public void OnDeliveryShiftOnAction(ActionEvent actionEvent) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm aa");
            Date date = new Date();
            String dateAndTime = formatter.format(date);
            if (!cmbVehicle.getSelectionModel().getSelectedItem().equals("null") && !cmbDriver.getSelectionModel().getSelectedItem().equals("null")) {
                for (Park p : ParkingList) {
                    if (p.getSelectVehicleNum().equalsIgnoreCase(cmbVehicle.getSelectionModel().getSelectedItem())) {
                        ParkingList.remove(p);
                        Delivery onDelivery1 = new Delivery(cmbVehicle.getSelectionModel().getSelectedItem(), lblVehicleType.getText(), cmbDriver.getSelectionModel().getSelectedItem(), dateAndTime);
                        DeliveryList.add(onDelivery1);
                        DriverSearch driverSearch1 = new DriverSearch(cmbVehicle.getSelectionModel().getSelectedItem(), cmbDriver.getSelectionModel().getSelectedItem());
                        driverSearch.add(driverSearch1);
                        if (lblVehicleType.getText().equalsIgnoreCase(" Van")) {
                            for (SlotNumber s : vanSlot) {
                                if (cmbVehicle.getSelectionModel().getSelectedItem().equalsIgnoreCase(s.getVehicleNumber())) {
                                    s.setVehicleNumber("null");
                                }
                            }
                        }
                        if (lblVehicleType.getText().equalsIgnoreCase(" Bus")) {
                            for (SlotNumber s : busSlot) {
                                if (cmbVehicle.getSelectionModel().getSelectedItem().equalsIgnoreCase(s.getVehicleNumber())) {
                                    s.setVehicleNumber("null");
                                }
                            }
                        }
                        if (lblVehicleType.getText().equalsIgnoreCase(" Cargo Lorry")) {
                            for (SlotNumber s : cargoLorrySlot) {
                                if (cmbVehicle.getSelectionModel().getSelectedItem().equalsIgnoreCase(s.getVehicleNumber())) {
                                    s.setVehicleNumber("null");
                                }
                            }
                        }

                        URL resource = getClass().getResource("../view/DriverShowForm.fxml");
                        Parent load = FXMLLoader.load(resource);
                        driverShowContext.getChildren().clear();
                        driverShowContext.getChildren().add(load);
                        new Alert(Alert.AlertType.CONFIRMATION, "You can Deliver now..", ButtonType.OK).show();

                    }
                }
            } else {
                new Alert(Alert.AlertType.WARNING, "Please fill all fields and try again...", ButtonType.CLOSE).show();
            }


        }catch (Exception e){}
    }

    public void openLoginFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) driverShowContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void openHomeFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) driverShowContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void openAboutFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AboutForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) driverShowContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
