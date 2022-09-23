package model;

public class Park {
    private String selectVehicleNum;
    private String selectVehicleType;
    private String selectSlot;
    private String date;



    public Park() {
    }

    public Park(String selectVehicleNum, String selectVehicleType, String selectSlot, String date) {
        this.selectVehicleNum = selectVehicleNum;
        this.selectVehicleType = selectVehicleType;
        this.selectSlot = selectSlot;
        this.date = date;
    }

    public String getSelectVehicleNum() {
        return selectVehicleNum;
    }

    public void setSelectVehicleNum(String selectVehicleNum) {
        this.selectVehicleNum = selectVehicleNum;
    }

    public String getSelectVehicleType() {
        return selectVehicleType;
    }

    public void setSelectVehicleType(String selectVehicleType) {
        this.selectVehicleType = selectVehicleType;
    }

    public String getSelectSlot() {
        return selectSlot;
    }

    public void setSelectSlot(String selectSlot) {
        this.selectSlot = selectSlot;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
