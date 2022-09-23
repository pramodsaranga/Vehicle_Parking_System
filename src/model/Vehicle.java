package model;

public class Vehicle {
    private String vehicleNum;
    private String weight;
    private String passenger;
    private String vehicleType;

    public Vehicle() {
    }

    public Vehicle(String vehicleNum, String weight, String passenger, String vehicleType) {
        this.setVehicleNum(vehicleNum);
        this.setWeight(weight);
        this.setPassenger(passenger);
        this.setVehicleType(vehicleType);
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
