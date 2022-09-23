package controller;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import static controller.DataListController.ParkingList;

public class InParkingTableFormController {
    public TableView tblInParking;
    public TableColumn colVehicleType;
    public TableColumn colParkingSlot;
    public TableColumn colVehicleNumber;
    public TableColumn colParkedDate;

    public void initialize(){
        colVehicleNumber.setCellValueFactory(new PropertyValueFactory("selectVehicleNum"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory("selectVehicleType"));
        colParkingSlot.setCellValueFactory(new PropertyValueFactory("selectSlot"));
        colParkedDate.setCellValueFactory(new PropertyValueFactory("date"));

        tblInParking.setItems(FXCollections.observableArrayList(ParkingList));
    }
}
