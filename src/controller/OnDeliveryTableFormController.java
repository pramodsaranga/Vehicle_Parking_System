package controller;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import static controller.DataListController.DeliveryList;

public class OnDeliveryTableFormController {
    public TableView tblOnDelivery;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colDriverName;
    public TableColumn colLeftDate;

    public void initialize(){
        colVehicleNumber.setCellValueFactory(new PropertyValueFactory("selectVehicleNumD"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory("selectVehicleTypeD"));
        colDriverName.setCellValueFactory(new PropertyValueFactory("selectDriver"));
        colLeftDate.setCellValueFactory(new PropertyValueFactory("selectDate"));

        tblOnDelivery.setItems(FXCollections.observableArrayList(DeliveryList));
    }
}
