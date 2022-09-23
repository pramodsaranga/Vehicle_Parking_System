package model;

public class Delivery {
    private String selectVehicleNumD;
    private String selectVehicleTypeD;
    private String selectDriver;
    private String selectDate;

    public Delivery() {
    }

    public Delivery(String selectVehicleNumD, String selectVehicleTypeD, String selectDriver, String selectDate) {
        this.selectVehicleNumD = selectVehicleNumD;
        this.selectVehicleTypeD = selectVehicleTypeD;
        this.selectDriver = selectDriver;
        this.selectDate = selectDate;
    }

    public String getSelectVehicleNumD() {
        return selectVehicleNumD;
    }

    public void setSelectVehicleNumD(String selectVehicleNumD) {
        this.selectVehicleNumD = selectVehicleNumD;
    }

    public String getSelectVehicleTypeD() {
        return selectVehicleTypeD;
    }

    public void setSelectVehicleTypeD(String selectVehicleTypeD) {
        this.selectVehicleTypeD = selectVehicleTypeD;
    }

    public String getSelectDriver() {
        return selectDriver;
    }

    public void setSelectDriver(String selectDriver) {
        this.selectDriver = selectDriver;
    }

    public String getSelectDate() {
        return selectDate;
    }

    public void setSelectDate(String selectDate) {
        this.selectDate = selectDate;
    }
}
