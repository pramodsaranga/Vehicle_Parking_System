package controller;

import model.*;

import java.util.ArrayList;

public class DataListController {
    static ArrayList<Vehicle> VehicleList = new ArrayList();
    static ArrayList<Driver> DriverList = new ArrayList();

    static ArrayList<String> VehicleTypeList = new ArrayList();
    static ArrayList<Park> ParkingList = new ArrayList();
    static ArrayList<Delivery> DeliveryList = new ArrayList();

    static SlotNumber[] vanSlot ={new SlotNumber("null","1"),new SlotNumber("null","2"),new SlotNumber("null","3"),new SlotNumber("null","4"),new SlotNumber("null","12"),new SlotNumber("null","13")};
    static SlotNumber[] busSlot ={new SlotNumber("null","14")};
    static SlotNumber[] cargoLorrySlot = {new SlotNumber("null","5"),new SlotNumber("null","6"),new SlotNumber("null","7"),new SlotNumber("null","8"),new SlotNumber("null","9"),new SlotNumber("null","10"),new SlotNumber("null","11")};

    static ArrayList<DriverSearch> driverSearch = new ArrayList();


    static{
        VehicleTypeList.add("Bus");
        VehicleTypeList.add("Van");
        VehicleTypeList.add("Van");
        VehicleTypeList.add("Van");
        VehicleTypeList.add("Van");
        VehicleTypeList.add("Van");
        VehicleTypeList.add("Van");
        VehicleTypeList.add("Cargo Lorry");
        VehicleTypeList.add("Cargo Lorry");
        VehicleTypeList.add("Cargo Lorry");
        VehicleTypeList.add("Cargo Lorry");
        VehicleTypeList.add("Cargo Lorry");
        VehicleTypeList.add("Cargo Lorry");
        VehicleTypeList.add("Cargo Lorry");
    }
}
